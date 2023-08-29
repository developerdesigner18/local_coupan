
package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityStatisticsBinding;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public class Statistics_activity extends AppCompatActivity {

    ActivityStatisticsBinding binding;


    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String unit_price1 = sh.getString("unit_price1", "");
        float spend_to_date = sh.getFloat("spend_to_date", 0);
        String remainingBudget1 = sh.getString("remainingBudget1", "");
        String currency1 = sh.getString("currency1", "");
        int deliveries = sh.getInt("deliveries", 0);
        String scannedRedemptions = sh.getString("scannedRedemptions", "");

        float scan = Float.parseFloat(scannedRedemptions);
        binding.redemption.setText(String.valueOf(Math.round(scan)));

        double unit_price = Double.parseDouble(unit_price1);
        double remainingBudget = Double.parseDouble(remainingBudget1);

//        binding.unitPrice.setText(Double.toString(unit_price));
        binding.spendToDste.setText(Float.toString(spend_to_date));
        binding.remainingBudget.setText(Double.toString(remainingBudget));
        binding.deliveries.setText(Integer.toString(deliveries));

        Log.d("statistics_data", "onCreate: " + spend_to_date + " " + deliveries + " " + scannedRedemptions + " " + unit_price + " " + remainingBudget);

        binding.imgStatisticBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent get_main = new Intent(Statistics_activity.this, MainActivity.class);
//                get_main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(get_main);
//                finish();
                onBackPressed();
            }
        });
    }
}