
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityShowCalculationBinding;
import com.example.local_coupan.preferences2;

public class
show_calculation_activity extends AppCompatActivity {
    ActivityShowCalculationBinding binding;
    preferences2 preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        preferences.save(show_calculation_activity .this,preferences.KEY_Type2,String.valueOf(2));

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if (getIntent().getStringExtra("type").equals("1")) {
            String calculation = sh.getString("calculation", "");

            Log.d("calculation", "onCreate: " + calculation);

            if (calculation.equalsIgnoreCase("Percentage")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("Value Discount")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("Percentage & Value Discount")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("None")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else {
                Log.d("calculation", "please select any type");
            }


            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            binding.lloutPercentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    calculation("Percentage");
                }
            });

            binding.lloutValueDiscount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    calculation("Value Discount");
                }
            });
            binding.lloutValuePercentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    calculation("Percentage & Value Discount");
                }
            });
            binding.lloutNone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    calculation("None");
                }
            });
        }else if (getIntent().getStringExtra("type").equals("2")) {

            String calculation = sh.getString("calculation", "");

            Log.d("calculation", "onCreate: " + calculation);

            if (calculation.equalsIgnoreCase("Percentage")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("Value Discount")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("Percentage & Value Discount")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (calculation.equalsIgnoreCase("None")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else {
                Log.d("calculation", "please select any type");
            }

            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutPercentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editcalculation("Percentage");
                }
            });

            binding.lloutValueDiscount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editcalculation("Value Discount");
                }
            });

            binding.lloutValuePercentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    editcalculation("Percentage & Value Discount");
                }
            });

            binding.lloutNone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(show_calculation_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    editcalculation("None");
                }
            });
        }
    }

    public void calculation(String calculation_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_deal = new Intent(show_calculation_activity.this, Coupon_deal_activity.class);
                get_deal.putExtra("type", "1");
                get_deal.putExtra("navigate", "null");
                myEdit.putString("calculation", calculation_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }

    public void editcalculation(String calculation_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_deal = new Intent(show_calculation_activity.this, Coupon_deal_activity.class);
                get_deal.putExtra("type", "2");
//                get_deal.putExtra("navigate", "null");
                myEdit.putString("calculation", calculation_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
}