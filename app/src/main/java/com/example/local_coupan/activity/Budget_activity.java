package com.example.local_coupan.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityBudgetBinding;
import com.example.local_coupan.model.refund.Refund;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Budget_activity extends AppCompatActivity {

    ActivityBudgetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBudgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String title_from_main = sh.getString("title", "");
        String coupon_id = sh.getString("coupon_id", "");
        String userid = sh.getString("userid", "");
        String remainingBudget1 = sh.getString("remainingBudget1", "");
//        Double remaining_budget = Double.valueOf(Integer.parseInt(remainingBudget1));
        boolean status = sh.getBoolean("status", true);

        binding.remainingValue.setFocusable(false);

        binding.remainingValue.setText(remainingBudget1);
        binding.refundValue.setText(remainingBudget1);

        if (status) {
            binding.btnRefund.setVisibility(View.GONE);
            binding.edtRefundprice.setFocusable(false);

        } else {

//            binding.btnRefund.setVisibility(View.INVISIBLE);
            binding.btnRefund.setVisibility(View.VISIBLE);
            binding.edtRefundprice.setText(remainingBudget1);
        }
        if (remainingBudget1.equals("0.0")) {
            binding.btnRefund.setVisibility(View.GONE);
        }

        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String budget = binding.edtPrice.getText().toString();

                if (!binding.edtPrice.getText().toString().isEmpty()) {

                    Intent get_pay = new Intent(Budget_activity.this, Payment_method.class);
                    get_pay.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    myEdit.putString("title_from_main", title_from_main);
                    myEdit.putString("budget", budget);
                    myEdit.putString("budget_coupon_id", coupon_id);
                    myEdit.putString("budget_userid", userid);
                    myEdit.apply();

                    get_pay.putExtra("flag", "top_up");

                    startActivity(get_pay);

                } else {
                    Toast.makeText(Budget_activity.this, "Please Enter Price in text Field", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.imgBudgetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.btnRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String refund_value = binding.edtRefundprice.getText().toString();

                if (refund_value.equals("")) {
                    Toast.makeText(Budget_activity.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
                    binding.edtRefundprice.setError("Please Enter Value");
                } else {
                    SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                    String remainingBudget1 = sh.getString("remainingBudget1", "");

                    double final_refund = Double.parseDouble((refund_value));
                    double remaining_budget = Double.parseDouble(remainingBudget1);

                    if (remaining_budget >= final_refund) {
                        refund_dialog();
                    } else {
                        Toast.makeText(Budget_activity.this, "Your Refund Value is GreaterThan Remaining Budget", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void refund_dialog() {

        String refund_value = binding.edtRefundprice.getText().toString();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        double final_refund = Double.parseDouble((refund_value));

        String coupon_id = sh.getString("coupon_id", "");
        String userid = sh.getString("userid", "");

        AlertDialog.Builder popupBuilder = new AlertDialog.Builder(this);
        popupBuilder.setTitle("You have selected to \n refund " + final_refund + " USD");
        popupBuilder.setMessage("This value will be refunded to your \n your register Payment method");
        popupBuilder.setNegativeButton(android.R.string.cancel, null);
        popupBuilder.setPositiveButton(R.string.Refund, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                get_refund(coupon_id, userid, final_refund);
            }
        }).create().show();
    }

    public void get_refund(String coupon_id, String userid, Double final_refund) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.90.77.44:8000/payment/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("couponID", coupon_id);
            paramObject.put("userID", userid);
            paramObject.put("budget", final_refund);

            Log.d("devi123", "onCreate: " + paramObject);
            Call<Refund> userCall = apiInterface.get_refund_coupon(String.valueOf(paramObject));

            userCall.enqueue(new Callback<Refund>() {
                @Override
                public void onResponse(Call<Refund> call, Response<Refund> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());

                    if (response.code() == 200) {

                        assert response.body() != null;

                        Boolean success = response.body().getSuccess();
                        String message = response.body().getMessage();
                        Log.d("success123", "onResponse: " + success);
//                        binding.txtRefundMessage.setText(message);

                        Toast.makeText(Budget_activity.this, "" + message, Toast.LENGTH_LONG).show();
                        Intent get_payment = new Intent(Budget_activity.this, Payment_method.class);
                        get_payment.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        get_payment.putExtra("flag", "refund");
                        startActivity(get_payment);

                    } else {

                        Toast.makeText(Budget_activity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<Refund> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}