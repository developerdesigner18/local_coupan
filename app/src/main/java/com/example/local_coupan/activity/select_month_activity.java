package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectMonthBinding;

public class select_month_activity extends AppCompatActivity {
    ActivitySelectMonthBinding binding;

    String flag = "one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectMonthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (getIntent().getStringExtra("type").equals("1")){

            if (getIntent().getStringExtra("navigate").equals("expiry")) {

                flag = "two";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_month = sh.getString("expiry_launch_month", "");

                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_month);

                if (expiry_launch_month.equalsIgnoreCase("January")) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("February")) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("March")) {
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("April")) {
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("May")) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("June")) {
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("July")) {
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("August")) {
                    binding.truePercentage8.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("September")) {
                    binding.truePercentage9.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("October")) {
                    binding.truePercentage10.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("November")) {
                    binding.truePercentage11.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("December")) {
                    binding.truePercentage12.setVisibility(View.VISIBLE);
                }
                else {
                    Log.d("expiry_launch_month", "onCreate: " + expiry_launch_month);
                }

                binding.lloutJanuary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("January", "01");
                    }
                });
                binding.lloutFebruary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("February", "02");
                    }
                });
                binding.lloutMarch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("March", "03");
                    }
                });
                binding.lloutApril.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("April", "04");
                    }
                });
                binding.lloutMay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("May", "05");

                    }
                });
                binding.lloutJune.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage6.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("June", "06");
                    }
                });
                binding.lloutJuly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.VISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("July", "07");
                    }
                });
                binding.lloutAugust.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage8.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("August", "08");
                    }
                });
                binding.lloutSeptember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage9.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("September", "09");
                    }
                });
                binding.lloutOctober.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage10.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("October", "10");
                    }
                });
                binding.lloutNavember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage11.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("November", "11");
//                        Toast.makeText(select_month_activity.this, "November expiry", Toast.LENGTH_SHORT).show();
                    }
                });
                binding.lloutDecember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage12.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        select_month("December", "12");
                    }
                });

            }
            else if (getIntent().getStringExtra("navigate").equals("launch")) {

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                flag = "three";

                String launch_month = sh.getString("launch_month", "");

                Log.d("launch_month", "onCreate: " + launch_month);

                if (launch_month.equalsIgnoreCase("January")) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("February")) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("March")) {
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("April")) {
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("May")) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("June")) {
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("July")) {
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("August")) {
                    binding.truePercentage8.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("September")) {
                    binding.truePercentage9.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("October")) {
                    binding.truePercentage10.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("November")) {
                    binding.truePercentage11.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("December")) {
                    binding.truePercentage12.setVisibility(View.VISIBLE);
                }
                else {
                    Log.d("expiry_launch_month", "onCreate: " + launch_month);
                }

                binding.lloutJanuary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("January", "01");
                    }
                });
                binding.lloutFebruary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("February", "02");
                    }
                });
                binding.lloutMarch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("March", "03");
                    }
                });
                binding.lloutApril.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("April", "04");
                    }
                });
                binding.lloutMay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("May", "05");

                    }
                });
                binding.lloutJune.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage6.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("June", "06");
                    }
                });
                binding.lloutJuly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.VISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("July", "07");
                    }
                });
                binding.lloutAugust.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage8.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("August", "08");
                    }
                });
                binding.lloutSeptember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage9.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        select_month("September", "09");
                    }
                });
                binding.lloutOctober.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage10.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("October", "10");
                    }
                });
                binding.lloutNavember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage11.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        select_month("November", "11");
//                        Toast.makeText(select_month_activity.this, "November launch", Toast.LENGTH_SHORT).show();
                    }
                });
                binding.lloutDecember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage12.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        select_month("December", "12");
                    }
                });

            }
        }
        else if(getIntent().getStringExtra("type").equals("2")){


            if (getIntent().getStringExtra("navigate").equals("expiry")) {

                flag = "two";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_month = sh.getString("expiry_month", "");

                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_month);

                if (expiry_launch_month.equalsIgnoreCase("January")) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("February")) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("March")) {
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("April")) {
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("May")) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("June")) {
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("July")) {
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("August")) {
                    binding.truePercentage8.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("September")) {
                    binding.truePercentage9.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("October")) {
                    binding.truePercentage10.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("November")) {
                    binding.truePercentage11.setVisibility(View.VISIBLE);
                }
                else if (expiry_launch_month.equalsIgnoreCase("December")) {
                    binding.truePercentage12.setVisibility(View.VISIBLE);
                }
                else {
                    Log.d("expiry_launch_month", "onCreate: " + expiry_launch_month);
                }



                binding.lloutJanuary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("January", "01");
                    }
                });
                binding.lloutFebruary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("February", "02");
                    }
                });
                binding.lloutMarch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("March", "03");
                    }
                });
                binding.lloutApril.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("April", "04");
                    }
                });
                binding.lloutMay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("May", "05");

                    }
                });
                binding.lloutJune.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage6.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("June", "06");
                    }
                });
                binding.lloutJuly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.VISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("July", "07");
                    }
                });
                binding.lloutAugust.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage8.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("August", "08");
                    }
                });
                binding.lloutSeptember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage9.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("September", "09");
                    }
                });
                binding.lloutOctober.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage10.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("October", "10");
                    }
                });
                binding.lloutNavember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage11.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("November", "11");
                    }
                });
                binding.lloutDecember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage12.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        editselect_month("December", "12");
                    }
                });
            }
            else if (getIntent().getStringExtra("navigate").equals("launch")) {

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                flag = "three";
                String launch_month = sh.getString("launch_date_month", "");

                Log.d("launch_month", "onCreate: " + launch_month);

                if (launch_month.equalsIgnoreCase("January")) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("February")) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("March")) {
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("April")) {
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("May")) {
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("June")) {
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("July")) {
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("August")) {
                    binding.truePercentage8.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("September")) {
                    binding.truePercentage9.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("October")) {
                    binding.truePercentage10.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("November")) {
                    binding.truePercentage11.setVisibility(View.VISIBLE);
                }
                else if (launch_month.equalsIgnoreCase("December")) {
                    binding.truePercentage12.setVisibility(View.VISIBLE);
                }
                else {
                    Log.d("expiry_launch_month", "onCreate: " + launch_month);
                }


                binding.lloutJanuary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("January", "01");
                    }
                });
                binding.lloutFebruary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("February", "02");
                    }
                });
                binding.lloutMarch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("March", "03");
                    }
                });
                binding.lloutApril.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("April", "04");
                    }
                });
                binding.lloutMay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("May", "05");

                    }
                });
                binding.lloutJune.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage6.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("June", "06");
                    }
                });
                binding.lloutJuly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.VISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("July", "07");
                    }
                });
                binding.lloutAugust.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage8.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("August", "08");
                    }
                });
                binding.lloutSeptember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage9.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);

                        editselect_month("September", "09");
                    }
                });
                binding.lloutOctober.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage10.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("October", "10");
                    }
                });
                binding.lloutNavember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage11.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage12.setVisibility(View.INVISIBLE);
                        editselect_month("November", "11");
                    }
                });
                binding.lloutDecember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_month_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage12.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        binding.truePercentage3.setVisibility(View.INVISIBLE);
                        binding.truePercentage4.setVisibility(View.INVISIBLE);
                        binding.truePercentage5.setVisibility(View.INVISIBLE);
                        binding.truePercentage6.setVisibility(View.INVISIBLE);
                        binding.truePercentage7.setVisibility(View.INVISIBLE);
                        binding.truePercentage8.setVisibility(View.INVISIBLE);
                        binding.truePercentage9.setVisibility(View.INVISIBLE);
                        binding.truePercentage10.setVisibility(View.INVISIBLE);
                        binding.truePercentage11.setVisibility(View.INVISIBLE);
                        editselect_month("December", "12");
                    }
                });
            }
        }
    }

    public void select_month(String month, String month_num) {
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_launch = new Intent(select_month_activity.this, Launch_date_activity.class);
                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (flag.equals("two")) {
                    myEdit.putString("expiry_launch_monthnu", month_num);
                    myEdit.putString("expiry_launch_month", month);
                    myEdit.apply();
                    get_launch.putExtra("navigate", "expiry");

                    Toast.makeText(select_month_activity.this, "From expiry", Toast.LENGTH_SHORT).show();
                } else if (flag.equals("three")) {

                    myEdit.putString("launch_month_num", month_num);
                    myEdit.putString("launch_month", month);
                    myEdit.putString("launch_date_month", month);
                    myEdit.apply();
                    get_launch.putExtra("navigate", "launch");
                    Toast.makeText(select_month_activity.this, "From launch", Toast.LENGTH_SHORT).show();
                }

                startActivity(get_launch);
                finish();
            }
        }, 1000);
    }
    public void editselect_month(String month, String month_num) {
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get_launch = new Intent(select_month_activity.this, edit_date_activity.class);
                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (flag.equals("two")) {
                    myEdit.putString("expiry_launch_monthnu", month_num);
                    myEdit.putString("expiry_month", month);
                    myEdit.putString("expiry_launch_month", month);
                    myEdit.apply();
                    get_launch.putExtra("navigate", "expiry");
                } else if (flag.equals("three")) {
                    myEdit.putString("launch_month_num", month_num);
                    myEdit.putString("launch_date_month", month_num);
                    myEdit.putString("launch_month", month);
                    myEdit.apply();
                    get_launch.putExtra("navigate", "launch");
                }
                startActivity(get_launch);
                finish();
            }
        }, 1000);
    }
}
