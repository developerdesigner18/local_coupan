
package com.example.local_coupan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivitySelectYearBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class select_year_activity extends AppCompatActivity {

    ActivitySelectYearBinding binding;
    String year_code = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectYearBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgBackCurrency.setOnClickListener(v -> {
            onBackPressed();
        });
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            if (getIntent().getStringExtra("navigate").equals("launch")) {


                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy", Locale.getDefault());
                String expiry_date_time = sdf2.format(new Date());
                int expiry_date_timet = Integer.parseInt(sdf2.format(new Date()));
                expiry_date_timet = expiry_date_timet + 1;

                String nextyyy = String.valueOf(expiry_date_timet);
                binding.txtYear.setText(expiry_date_time);
                binding.textView10.setText(nextyyy);

                String launch_year = sh.getString("launch_year", "");

                Log.d("expiry_launch_month", "onCreate: " + launch_year);

                String current_year = binding.txtYear.getText().toString();
                String next_year = binding.textView10.getText().toString();

                if (launch_year.equalsIgnoreCase(current_year)) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                } else if (launch_year.equalsIgnoreCase(next_year)) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                } else {
                    Log.d("expiry_launch_month", "onCreate: " + launch_year);
                }

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

                binding.llout2022.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, Launch_date_activity.class);
                                get_launch.putExtra("navigate", "launch");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();

                                myEdit.putString("year", expiry_date_time);
                                myEdit.putString("launch_year", expiry_date_time);
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });

                binding.llout2023.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, Launch_date_activity.class);
                                get_launch.putExtra("navigate", "launch");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();
                                myEdit.putString("year", String.valueOf(nextyyy));
                                myEdit.putString("launch_year", String.valueOf(nextyyy));
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });

            }
            else if (getIntent().getStringExtra("navigate").equals("expiry")) {

                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy", Locale.getDefault());
                String expiry_date_time = sdf2.format(new Date());
                int expiry_date_timet = Integer.parseInt(sdf2.format(new Date()));
                expiry_date_timet = expiry_date_timet + 1;


                String nextyyy = String.valueOf(expiry_date_timet);
                binding.txtYear.setText(expiry_date_time);
                binding.textView10.setText(nextyyy);


//                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_year = sh.getString("expiry_launch_year", "");

                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_year);

                String current_year = binding.txtYear.getText().toString();
                String next_year = binding.textView10.getText().toString();

                if (expiry_launch_year.equalsIgnoreCase(current_year)) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                } else if (expiry_launch_year.equalsIgnoreCase(next_year)) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                } else {
                    Log.d("expiry_launch_month", "onCreate: " + expiry_launch_year);
                }

                binding.llout2022.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, Launch_date_activity.class);
                                get_launch.putExtra("navigate", "expiry");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();

                                myEdit.putString("year", expiry_date_time);
                                myEdit.putString("expiry_launch_year", expiry_date_time);
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
                binding.llout2023.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, Launch_date_activity.class);
                                get_launch.putExtra("navigate", "expiry");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();
                                myEdit.putString("year", String.valueOf(nextyyy));
                                myEdit.putString("expiry_launch_year", String.valueOf(nextyyy));
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
            }

        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            if (getIntent().getStringExtra("navigate").equals("launch")) {


                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy", Locale.getDefault());
                String expiry_date_time = sdf2.format(new Date());
                int expiry_date_timet = Integer.parseInt(sdf2.format(new Date()));
                expiry_date_timet = expiry_date_timet + 1;


                String nextyyy = String.valueOf(expiry_date_timet);
                binding.txtYear.setText(expiry_date_time);
                binding.textView10.setText(nextyyy);


                String launch_year = sh.getString("launch_date_year", "");

                Log.d("expiry_launch_month", "onCreate: " + launch_year);

                String current_year = binding.txtYear.getText().toString();
                String next_year = binding.textView10.getText().toString();

                if (launch_year.equalsIgnoreCase(current_year)) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                } else if (launch_year.equalsIgnoreCase(next_year)) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                } else {
                    Log.d("expiry_launch_month", "onCreate: " + launch_year);
                }

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

                binding.llout2022.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, edit_date_activity.class);
                                get_launch.putExtra("navigate", "launch");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();

                                myEdit.putString("year", expiry_date_time);
                                myEdit.putString("launch_year", expiry_date_time);
                                myEdit.putString("launch_date_year", expiry_date_time);
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
                binding.llout2023.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, edit_date_activity.class);
                                get_launch.putExtra("navigate", "launch");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();
                                myEdit.putString("year", String.valueOf(nextyyy));
                                myEdit.putString("launch_year", String.valueOf(nextyyy));
                                myEdit.putString("launch_date_year", String.valueOf(nextyyy));
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
            }
            else if (getIntent().getStringExtra("navigate").equals("expiry")) {

                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy", Locale.getDefault());
                String expiry_date_time = sdf2.format(new Date());
                int expiry_date_timet = Integer.parseInt(sdf2.format(new Date()));
                expiry_date_timet = expiry_date_timet + 1;


                String nextyyy = String.valueOf(expiry_date_timet);
                binding.txtYear.setText(expiry_date_time);
                binding.textView10.setText(nextyyy);


//                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_year = sh.getString("expiry_year", "");

                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_year);

                String current_year = binding.txtYear.getText().toString();
                String next_year = binding.textView10.getText().toString();

                if (expiry_launch_year.equalsIgnoreCase(current_year)) {
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                } else if (expiry_launch_year.equalsIgnoreCase(next_year)) {
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                } else {
                    Log.d("expiry_launch_month", "onCreate: " + expiry_launch_year);
                }

                binding.llout2022.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        binding.truePercentage2.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, edit_date_activity.class);
                                get_launch.putExtra("navigate", "expiry");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();

                                myEdit.putString("year", expiry_date_time);
                                myEdit.putString("expiry_year", expiry_date_time.toString());
                                myEdit.putString("expiry_launch_year", expiry_date_time.toString());
                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
                binding.llout2023.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(select_year_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        binding.truePercentage1.setVisibility(View.INVISIBLE);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_launch = new Intent(select_year_activity.this, edit_date_activity.class);
                                get_launch.putExtra("navigate", "expiry");
                                get_launch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_launch);
                                finish();
                                myEdit.putString("year", String.valueOf(nextyyy));
                                myEdit.putString("expiry_year", String.valueOf(nextyyy));
                                myEdit.putString("expiry_launch_year", String.valueOf(nextyyy));

                                myEdit.apply();
                            }
                        }, 1000);
                    }
                });
            }
        }
    }
}