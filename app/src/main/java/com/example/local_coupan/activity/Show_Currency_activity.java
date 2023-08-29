
package com.example.local_coupan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivityShowCurrencyBinding;
import com.example.local_coupan.preferences2;

public class Show_Currency_activity extends AppCompatActivity {
    ActivityShowCurrencyBinding binding;
    preferences2 preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowCurrencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        preferences.save(Show_Currency_activity .this,preferences.KEY_Type2,String.valueOf(2));
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String currency = sh.getString("usd", "");

            Log.d("deal_type", "onCreate: " + currency);

            if (currency.equalsIgnoreCase("USD")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("GBP")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("KES")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("XOF")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("EUR")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }
            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutUsd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();

                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    currency("USD");
                }
            });
            binding.lloutGbp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    currency("GBP");
                }
            });
            binding.lloutKes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    currency("KES");
                }
            });
            binding.lloutxof.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    currency("XOF");
                }
            });
            binding.llouteur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    currency("EUR");

                }
            });
        }else if (getIntent().getStringExtra("type").equals("2")){
            String currency = sh.getString("currency", "");

            Log.d("deal_type", "onCreate: " + currency);

            if (currency.equalsIgnoreCase("USD")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("GBP")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("KES")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("XOF")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (currency.equalsIgnoreCase("EUR")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }
            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutUsd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();

                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Editcurrency("USD");
                }
            });
            binding.lloutGbp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Editcurrency("GBP");
                }
            });
            binding.lloutKes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Editcurrency("KES");
                }
            });
            binding.lloutxof.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Editcurrency("XOF");
                }
            });
            binding.llouteur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Toast.makeText(Show_Currency_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    Editcurrency("EUR");

                }
            });
        }

    }

    public void currency(String currency_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_deal = new Intent(Show_Currency_activity.this, Coupon_deal_activity.class);
                get_deal.putExtra("type", "1");
                get_deal.putExtra("navigate", "null");
                myEdit.putString("usd", currency_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }

    public void Editcurrency(String currency_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_deal = new Intent(Show_Currency_activity.this, Coupon_deal_activity.class);
                get_deal.putExtra("type", "2");
//                get_deal.putExtra("navigate", "null");
                myEdit.putString("currency", currency_type);
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);
                finish();
            }
        }, 1000);
    }
}