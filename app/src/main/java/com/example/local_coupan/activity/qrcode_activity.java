package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.local_coupan.databinding.ActivityQrcodeBinding;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class qrcode_activity extends AppCompatActivity {
    ActivityQrcodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQrcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String get_qrcode = pref.getString("qrcode_image", "");
        String title = pref.getString("title", "");
        String coupon_id = pref.getString("coupon_id", "");

        binding.title.setText(title);
        binding.offerid.setText(coupon_id);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        binding.btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        URL url = null;
        try {
            url = new URL(get_qrcode);
            Log.d("qrcode12", "onResponse: " + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Picasso.get().load(String.valueOf(url)).into(binding.qrcode);
    }
}