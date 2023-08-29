
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectGeofenceUnitsBinding;

public class select_geofence_units extends AppCompatActivity {
    ActivitySelectGeofenceUnitsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGeofenceUnitsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String units = sh.getString("units", "");

            Log.d("units", "onCreate: " + units);

            if (units.equalsIgnoreCase("Kilometers")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Miles")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Meters")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Feet")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            binding.lloutKilometers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    geofence_units("Kilometers");
                }
            });
            binding.lloutMiles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    geofence_units("Miles");
                }
            });

            binding.lloutMeters.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    geofence_units("Meters");
                }
            });
            binding.lloutFeet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    geofence_units("Feet");
                }
            });
        } else if (getIntent().getStringExtra("type").equals("2")) {
            String units = sh.getString("units", "");

            Log.d("units", "onCreate: " + units);

            if (units.equalsIgnoreCase("Kilometers")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Miles")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Meters")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (units.equalsIgnoreCase("Feet")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            binding.lloutKilometers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editgeofence_units("Kilometers");
                }
            });
            binding.lloutMiles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editgeofence_units("Miles");
                }
            });

            binding.lloutMeters.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editgeofence_units("Meters");
                }
            });
            binding.lloutFeet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_geofence_units.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    editgeofence_units("Feet");
                }
            });
        }
    }

    public void geofence_units(String method_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_geofence_units.this, Target_activity.class);
                get_deal.putExtra("type", "1");
                myEdit.putString("units", method_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }

    public void editgeofence_units(String method_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_geofence_units.this, Target_activity.class);
                get_deal.putExtra("type", "2");
                myEdit.putString("units", method_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
}