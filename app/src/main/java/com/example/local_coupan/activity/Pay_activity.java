package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityPayBinding;

public class Pay_activity extends AppCompatActivity {
    ActivityPayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgPayBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_budget = new Intent(Pay_activity.this, Budget_activity.class);
                get_budget.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_budget);
                finish();
            }
        });

        binding.cardPayCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_main = new Intent(Pay_activity.this, MainActivity.class);
                get_main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_main);
            }
        });
    }
}