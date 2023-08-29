package com.example.local_coupan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.databinding.ActivityPaymentMethodBinding;
import com.example.local_coupan.model.PaymentModel;
import com.example.local_coupan.preferences2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.prefs.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Payment_method extends AppCompatActivity {
    ActivityPaymentMethodBinding binding;

    preferences2 preferences;
    public static String BASE_URL_PAYMENT1 = "http://54.90.77.44:8000/payment/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBackPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (getIntent().getStringExtra("flag").equals("top_up")) {

            String title_from_main = sh.getString("title_from_main", "");
            String budget_coupon_id = sh.getString("budget_coupon_id", "");
            String budget_userid = sh.getString("budget_userid", "");
            String budget = sh.getString("budget", "");
            Float final_bug = Float.valueOf(budget);
            Log.d("final_id_title", "onCreate: " + title_from_main + budget);

            binding.lloutPayPal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Payment_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    payment_navigate(budget_userid, final_bug, title_from_main, budget_coupon_id, "topup");

                }
            });
        }

        else if (getIntent().getStringExtra("flag").equals("payment")) {

            binding.lloutPayPal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = pref.edit();


//                    String ids = preferences.get(Payment_method.this, preferences.KEY_ID);

                    String uid = pref.getString("pay_uid",  "");
                    String pay_getid = pref.getString("pay_getid", "");
                    String pay_titel = pref.getString("pay_titel", "");
                    Float pay_budget = pref.getFloat("pay_budget", 0);

                    Log.d("coupon_payment", "onClick: " + "user id :- "+uid + " coupon id:- " + pay_getid + "coupon_title:- " + pay_titel + " coupon_budget :- "  + pay_budget);

                    Toast.makeText(Payment_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    payment_navigate(uid, pay_budget, pay_titel, pay_getid, "payment");
                }
            });
        }
        else if (getIntent().getStringExtra("flag").equals("refund")){

        }
    }

    private void payment_navigate(String userId, Float budget, String couponTitle, String couponID, String type) {
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("userId", userId);
            paramObject.put("budget", budget);
            paramObject.put("couponTitle", couponTitle);
            paramObject.put("couponID", couponID);
            paramObject.put("type", type);

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();

            myEdit.putString("payment_type",type);
            myEdit.apply();

            Log.d("viru3", "logindata: " + paramObject);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_PAYMENT1)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            Call<PaymentModel> userCall = apiInterface.get_payment_link(paramObject.toString());
            userCall.enqueue(new Callback<PaymentModel>() {
                public void onResponse(@NonNull Call<PaymentModel> call, Response<PaymentModel> response) {

                    Log.d("viru5", "onResponse: errorbody : " + response.errorBody());
                    Log.d("viru5", "onResponse: body : " + response.body());
                    Log.d("viru5", "onResponse: " + response.raw());

                    if (response.code() != 200) {
                        Toast.makeText(Payment_method.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();

                    } else {

                        if (response.isSuccessful()) {
                            Log.d("viru1222", "onResponse: " + response.raw());
                            assert response.body() != null;
                            Log.d("viru_link", "onResponse: " + response.body().getData() + " " + response.body().getName());
                            String link = response.body().getData();
                            Intent intent = new Intent(Payment_method.this, Web_activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("payment_url", link);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<PaymentModel> call, @NonNull Throwable t) {
                    Log.d("viru11", "onFailure: " + t);
                    Toast.makeText(Payment_method.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            });

            Log.d("viru7", "logindata: ");
        } catch (JSONException e) {
            Log.d("stacetrace", "payment_navigate: " + e);
            e.printStackTrace();
        }
    }
}