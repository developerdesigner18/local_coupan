
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectLocationMethodBinding;

public class select_location_method extends AppCompatActivity {

    ActivitySelectLocationMethodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLocationMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String method = sh.getString("method", "");

            Log.d("method", "onCreate: " + method);

            if (method.equalsIgnoreCase("Geofence")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (method.equalsIgnoreCase("Journey Time")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else {
                Log.d("method", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutGeofence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_location_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    location_method("Geofence");
                }
            });
            binding.lloutJourneyTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_location_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    location_method("Journey Time");
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            String method = sh.getString("method", "");

            Log.d("method", "onCreate: " + method);

            if (method.equalsIgnoreCase("Geofence")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (method.equalsIgnoreCase("Journey Time")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else {
                Log.d("method", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutGeofence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_location_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    editlocation_method("Geofence");
                }
            });
            binding.lloutJourneyTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_location_method.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    editlocation_method("Journey Time");
                }
            });
        }
    }

    public void location_method(String method_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_location_method.this, Target_activity.class);
                get_deal.putExtra("type", "1");
                myEdit.putString("method", method_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
    public void editlocation_method(String method_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_location_method.this, Target_activity.class);
                get_deal.putExtra("type", "2");
                myEdit.putString("method", method_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
}