package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.local_coupan.databinding.ActivityShareBinding;

public class Share_activity extends AppCompatActivity {
    ActivityShareBinding binding;

    static final String logTag = "ActivitySwipeDetector";
    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgShareBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        binding.lloutDirectShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_direct_share = new Intent(Share_activity.this, Direct_share_Activity.class);
                get_direct_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_direct_share);
            }
        });

        binding.lloutMessageGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_market = new Intent(Share_activity.this, select_market_group_activity.class);
                get_market.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                get_market.putExtra("navigate", "target_message");
                get_market.putExtra("type", "3");
                startActivity(get_market);
            }
        });
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
    }
}