package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.example.local_coupan.databinding.ActivityCouponVerifyBinding;

import java.util.Locale;

public class coupon_verify_activity extends AppCompatActivity {
    ActivityCouponVerifyBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String title = sh.getString("coupon_title", "");
        String message = sh.getString("message", "");
        String coupon_image = sh.getString("coupon_image", "");
        String brand = sh.getString("brand", "");
        String product = sh.getString("product", "");
        String expiry_date = sh.getString("expiry_date", "");
        String description = sh.getString("description", "");
        String deal = sh.getString("deal", "");
        String remainingPrice = sh.getString("remainingPrice", "");
        String expiry_count_down = sh.getString("expiry_count_down", "");
        String percentage_saving = sh.getString("percentage_saving", "");

        String text = "<font color=#858585>"+deal+" "+"</font> <font color=#1E1E1E>"+remainingPrice+"</font>";
        binding.deal.setText(Html.fromHtml(text));

        binding.titleCouponName.setText(title);
        binding.textDescription.setText(percentage_saving + "% off " + title);
        binding.brand.setText(brand);
        binding.txtProduct.setText(product);
//        binding.deal.setText(deal12);
        binding.date.setText(expiry_date);
        binding.expiryCountdown.setText(expiry_count_down);


        String capital = String.valueOf(title.charAt(0)).toUpperCase(Locale.ROOT);
        binding.couponCapital.setText(capital);

        binding.btnRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_scan = new Intent(coupon_verify_activity.this, Scanner_activity.class);
                get_scan.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_scan);
            }
        });
    }
}