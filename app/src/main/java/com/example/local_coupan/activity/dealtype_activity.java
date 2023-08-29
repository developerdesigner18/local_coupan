package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityDealtypeBinding;
import com.example.local_coupan.preferences2;

public class dealtype_activity extends AppCompatActivity {

    ActivityDealtypeBinding binding;
    preferences2 preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        preferences.save(dealtype_activity.this, preferences.KEY_Type2, String.valueOf(2));

        binding = ActivityDealtypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getStringExtra("type").equals("1")) {

            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String deal_type = sh.getString("dealtype", "");
            Log.d("deal_type", "onCreate: " + deal_type);
            if (deal_type.equalsIgnoreCase("Other")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (deal_type.equalsIgnoreCase("Discount")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else {
                Log.d("deal_type", "please select any type");
            }

            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


            binding.lloutDiscount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    binding.truePercentage2.setVisibility(View.INVISIBLE);
//                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Toast.makeText(dealtype_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dealtype("Discount");
                        }
                    }, 1000);
                }
            });

            binding.lloutOther.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(dealtype_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
//                    binding.truePercentage1.setVisibility(View.INVISIBLE);
//                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dealtype("Other");
                        }
                    }, 1000);
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String deal_type = sh.getString("dealtype", "");
            Log.d("deal_type", "onCreate: " + deal_type);

            if (deal_type.equalsIgnoreCase("Other")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (deal_type.equalsIgnoreCase("Discount")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else {
                Log.d("deal_type", "please select any type");
            }

            binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            binding.lloutDiscount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    binding.truePercentage2.setVisibility(View.INVISIBLE);
//                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Toast.makeText(dealtype_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editdealtype("Discount");
                        }
                    }, 1000);
                }
            });


            binding.lloutOther.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(dealtype_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
//                    binding.truePercentage1.setVisibility(View.INVISIBLE);
//                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            editdealtype("Other");
                        }
                    }, 1000);
                }
            });
        }
    }

    public void dealtype(String dealtype) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(dealtype_activity.this, Coupon_deal_activity.class);
        get_deal.putExtra("type", "1");
        get_deal.putExtra("navigate", "null");
        myEdit.putString("dealtype", dealtype);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();

    }

    public void editdealtype(String dealtype) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(dealtype_activity.this, Coupon_deal_activity.class);
        get_deal.putExtra("type", "2");
//        get_deal.putExtra("navigate", "null");
        myEdit.putString("dealtype", dealtype);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();
    }
}