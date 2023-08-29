package com.example.local_coupan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.databinding.ActivityCouponShareBinding;
import com.example.local_coupan.model.play_pause.PlayPause;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class coupon_share extends AppCompatActivity {
    ActivityCouponShareBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponShareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String scannedRedemptions = sh.getString("scanned_redemption", "");
        Log.d("scannedRedemptions", "onCreate: " + scannedRedemptions);
        int deliveries = sh.getInt("deliveries", 0);

        String del = String.valueOf(deliveries);

        binding.deliveries.setText(del);
        float scan = Float.parseFloat(scannedRedemptions);
        Log.d("scanned_redemption", "onCreate: " + scan);
        binding.scanned.setText(String.valueOf(Math.round(scan)));

        Boolean status = sh.getBoolean("status", true);

        if (status.equals(true)) {
            binding.truePercentage1.setVisibility(View.VISIBLE);
        } else if (status.equals(false)) {
            binding.truePercentage2.setVisibility(View.VISIBLE);
        }
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        String share_name = pref.getString("share_name","");
        binding.userName.setText(share_name);

        binding.imgBackCouponList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        binding.lloutLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.truePercentage1.setVisibility(View.VISIBLE);
                binding.truePercentage2.setVisibility(View.GONE);

                String id = sh.getString("id1", "");
                Log.d("coupon_id", "onCreate: " + id);
                change_status(id);
            }
        });

        binding.lloutPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.truePercentage2.setVisibility(View.VISIBLE);
                binding.truePercentage1.setVisibility(View.GONE);

                String id = sh.getString("id1", "");
                Log.d("coupon_id", "onCreate: " + id);
                change_status(id);
            }
        });
    }

    public void change_status(String id) {
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
            Log.d("devi123", "onCrea    te: " + paramObject);
            Call<PlayPause> userCall = apiInterface.get_play_pause_status(String.valueOf(paramObject));
            userCall.enqueue(new Callback<PlayPause>() {
                @Override
                public void onResponse(Call<PlayPause> call, Response<PlayPause> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());
//                    Toast.makeText(coupon_share.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                    if (response.code() == 200) {

                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = pref.edit();
                        boolean status1 = response.body().getData().getPlayPauseStatus();
                        Log.d("123123123", "onResponse: " + status1);

                        myEdit.putBoolean("status",status1);
                        myEdit.apply();

                        Intent i = new Intent(coupon_share.this, coupon_share.class);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(i);
                        overridePendingTransition(0, 0);

//                        Toast.makeText(coupon_share.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(coupon_share.this, "An Error Occurred", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<PlayPause> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }

}