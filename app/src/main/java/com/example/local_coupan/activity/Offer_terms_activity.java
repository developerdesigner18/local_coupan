package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.local_coupan.databinding.ActivityOfferTermsBinding;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class Offer_terms_activity extends AppCompatActivity {
    ActivityOfferTermsBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOfferTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String terms_date = sh.getString("terms_date", "");
//        String image = getIntent().getStringExtra("image");
        String terms = sh.getString("terms", "");
        String id = sh.getString("id", "");
        String CouponImage = sh.getString("CouponImage", "");

//        binding.couponId.setText(id);
        binding.txtTermss123.setText(terms);

//        String[] date = terms_date.split("/");
//        String dd = date[0];
//        String mm = date[1];
//        String yy = date[2];
//
//        int mm1 = Integer.parseInt(mm);
//
//        String month_name = "null";
//
//        switch (mm1) {
//            case 1:
//                month_name = "January";
//                break;
//            case 2:
//                month_name = "February";
//                break;
//            case 3:
//                month_name = "March";
//                break;
//            case 4:
//                month_name = "April";
//                break;
//            case 5:
//                month_name = "May";
//                break;
//            case 6:
//                month_name = "June";
//                break;
//            case 7:
//                month_name = "July";
//                break;
//            case 8:
//                month_name = "August";
//                break;
//            case 9:
//                month_name = "September";
//                break;
//            case 10:
//                month_name = "October";
//                break;
//            case 11:
//                month_name = "November";
//                break;
//            case 12:
//                month_name = "December";
//                break;
//            default:
//        }
//
//        binding.txtTermsDate.setText(dd + " " + month_name + " " + yy);
        binding.txtTermsDate.setText(terms_date);

//        URL url = null;
//        try {
//            url = new URL(CouponImage);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Picasso.get().load(String.valueOf(url)).into(binding.imageView3);

        binding.imgOfferTermsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                Offer_terms_activity.super.onBackPressed();
            }
        });

//        binding.yucallTerms.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent get_yucall = new Intent(Offer_terms_activity.this, Yucall_terms_activity.class);
//                get_yucall.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(get_yucall);
//            }
//        });
    }}