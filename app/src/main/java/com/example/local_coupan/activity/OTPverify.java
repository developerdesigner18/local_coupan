
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityOtpverifyBinding;
import com.example.local_coupan.model.qrcode_scan.ScanQr;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class OTPverify extends AppCompatActivity {
    ActivityOtpverifyBinding binding;

    private long timeleftinmillisecond = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpverifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        binding.imgBudgetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        int OTP = sh.getInt("OTP", 0);
        int otp_verify_done = OTP;

        binding.lloutresendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000) {

                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {

                        NumberFormat f = new DecimalFormat("00");

                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;

                        binding.txtresendOtp.setText(f.format(min) + ":" + f.format(sec));

                    }

                    @SuppressLint("SetTextI18n")
                    public void onFinish() {

                        binding.txtresendOtp.setText("00:00");

                        Toast.makeText(OTPverify.this, "" + otp_verify_done, Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });

        binding.lloutrecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(30000, 1000) {

                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {

                        NumberFormat f = new DecimalFormat("00");

                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;

                        binding.txtcallerTime.setText(f.format(min) + ":" + f.format(sec));

                    }

                    @SuppressLint("SetTextI18n")
                    public void onFinish() {

                        binding.txtcallerTime.setText("00:00");
                        Toast.makeText(OTPverify.this, "" + otp_verify_done, Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });

        String ids = sh.getString("ids", "");

        Log.d("get_id_from_scanner", "onCreate: " + ids);
        Log.d("get_otp", "onCreate: " + OTP);

//        binding.otp.setText(String.valueOf(OTP));

        binding.otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.otp1.getText().toString().length() == 1) {
                    binding.otp2.requestFocus();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.otp2.getText().toString().length() == 1) {
                    binding.otp3.requestFocus();
                }
                if (count == 0) {
                    binding.otp1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.otp3.getText().toString().length() == 1) {
                    binding.otp4.requestFocus();
                }
                if (count == 0) {
                    binding.otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.btnOtpSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!binding.otp1.getText().toString().isEmpty() &&
                        !binding.otp2.getText().toString().isEmpty() &&
                        !binding.otp3.getText().toString().isEmpty() &&
                        !binding.otp4.getText().toString().isEmpty()) {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String user_otp1 = binding.otp1.getText().toString();
                            String user_otp2 = binding.otp2.getText().toString();
                            String user_otp3 = binding.otp3.getText().toString();
                            String user_otp4 = binding.otp4.getText().toString();

                            String otp_verify = user_otp1 + user_otp2 + user_otp3 + user_otp4;

                            int final_otp = Integer.parseInt(otp_verify);
                            Log.d("otp_done", "run: " + otp_verify);

                            get_qrcode_verify(ids, final_otp);

                        }
                    }, 0);
                }
            }
        });

        binding.otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 0) {
                    binding.otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void get_qrcode_verify(String id, int OTPQRcode) {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.90.77.44:8000/coupon/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("id", id);
            paramObject.put("OTPQRCode", OTPQRcode);

            Log.d("devi123", "onCreate: " + paramObject);

            Call<ScanQr> userCall = apiInterface.get_scan(String.valueOf(paramObject));
            userCall.enqueue(new Callback<ScanQr>() {
                @Override
                public void onResponse(Call<ScanQr> call, Response<ScanQr> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());

                    if (response.body().getSuccess()) {

                        Log.d("OTP_Code", "onResponse: " + response.body().getSuccess());

                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = pref.edit();
                        String coupon_title = response.body().getData().getCouponTitle();
                        String coupon_image = (String) response.body().getData().getCouponImage();
                        String brand = response.body().getData().getBrand();
                        String product = response.body().getData().getProduct();
                        String expiry_date = response.body().getData().getExpiryDate();
                        String description = response.body().getData().getDescription();
                        String deal = response.body().getData().getDealValue();
                        String remainingPrice = response.body().getData().getRemainingPrice();
                        String expiry_count_down = response.body().getData().getExpiryCountDown();
                        String percentage_saving = String.valueOf(response.body().getData().getPercentageSaving());

                        String message = response.body().getMessage();

                        String ex_date = expiry_date.substring(0, 10);
//                        String month = expiry_date.substring(5, 7);


                        String[] expiry_time = expiry_date.split("T");
                        String date = expiry_time[0];
                        String final_time = expiry_time[1];
                        String time = final_time.substring(0, 5);

                        String[] date1 = date.split("-");

                        String dd = date1[2];
                        String mm = date1[1];
                        int mm1 = Integer.parseInt(mm);
                        String yy = date1[0];

                        String month_name = "null";

                        switch (mm1) {
                            case 1:
                                month_name = "Jan";
                                break;
                            case 2:
                                month_name = "Feb";
                                break;
                            case 3:
                                month_name = "Mar";
                                break;
                            case 4:
                                month_name = "Apr";
                                break;
                            case 5:
                                month_name = "May";
                                break;
                            case 6:
                                month_name = "Jun";
                                break;
                            case 7:
                                month_name = "Jul";
                                break;
                            case 8:
                                month_name = "Aug";
                                break;
                            case 9:
                                month_name = "Sep";
                                break;
                            case 10:
                                month_name = "Oct";
                                break;
                            case 11:
                                month_name = "Nav";
                                break;
                            case 12:
                                month_name = "Dec";
                                break;
                            default:
                        }

                        String final_date = dd + " " + month_name + " " + yy;

                        myEdit.putString("coupon_title", coupon_title);
                        myEdit.putString("message", message);
                        myEdit.putString("coupon_image", coupon_image);
                        myEdit.putString("brand", brand);
                        myEdit.putString("product", product);
                        myEdit.putString("expiry_date", final_date);
                        myEdit.putString("description", description);
                        myEdit.putString("deal", deal);
                        myEdit.putString("remainingPrice", remainingPrice);
                        myEdit.putString("expiry_count_down", expiry_count_down);
                        myEdit.putString("percentage_saving", percentage_saving);
                        myEdit.apply();

                        Intent get_OTP = new Intent(OTPverify.this, coupon_verify_activity.class);
                        get_OTP.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(get_OTP);
                    } else if (!response.body().getSuccess()) {

                        alert_message(response.body().getMessage());
//                        Toast.makeText(OTPverify.this, "" + response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ScanQr> call, Throwable t) {
                    Toast.makeText(OTPverify.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);

                }
            });

        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }

    public void alert_message(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Share Message")
                .setMessage(message)
                .setCancelable(false)
                .setNeutralButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent get_scanner = new Intent(OTPverify.this, Scanner_activity.class);
                        get_scanner.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(get_scanner);
                    }
                }).create().show();
    }
}