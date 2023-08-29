
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectJourneyTypeBinding;

public class select_journey_type extends AppCompatActivity {
    ActivitySelectJourneyTypeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectJourneyTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String journey = sh.getString("journey", "");

            Log.d("journey", "onCreate: " + journey);

            if (journey.equalsIgnoreCase("Car")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Public Transport")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Bicycle")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Walk")) {
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

            binding.lloutCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    journey_type("Car");
                }
            });
            binding.lloutPublic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    journey_type("Public Transport");
                }
            });

            binding.lloutBicycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    journey_type("Bicycle");
                }
            });
            binding.lloutWalk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    journey_type("Walk");
                }
            });
        } else if (getIntent().getStringExtra("type").equals("2")) {

            String journey = sh.getString("journey", "");

            Log.d("journey", "onCreate: " + journey);

            if (journey.equalsIgnoreCase("Car")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Public Transport")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Bicycle")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (journey.equalsIgnoreCase("Walk")) {
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

            binding.lloutCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editjourney_type("Car");
                }
            });
            binding.lloutPublic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editjourney_type("Public Transport");
                }
            });

            binding.lloutBicycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editjourney_type("Bicycle");
                }
            });
            binding.lloutWalk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_journey_type.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    editjourney_type("Walk");
                }
            });
        }
    }

    public void journey_type(String journey_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_journey_type.this, Target_activity.class);
                get_deal.putExtra("type", "1");
                myEdit.putString("journey", journey_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
    public void editjourney_type(String journey_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent get_deal = new Intent(select_journey_type.this, Target_activity.class);
                get_deal.putExtra("type", "2");
                myEdit.putString("journey", journey_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
}