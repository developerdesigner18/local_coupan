
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectGenderBinding;

public class select_gender_activity extends AppCompatActivity {
    ActivitySelectGenderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectGenderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if (getIntent().getStringExtra("type").equals("1")) {

            String gender = sh.getString("gender", "");

            Log.d("gender", "onCreate: " + gender);

            if (gender.equalsIgnoreCase("Male")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (gender.equalsIgnoreCase("Female")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (gender.equalsIgnoreCase("Any")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else {
                Log.d("gender", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


            binding.lloutMale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gender("Male");
                        }
                    }, 1000);
                }
            });

            binding.lloutFemale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gender("Female");
                        }
                    }, 1000);
                }
            });

            binding.lloutAny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gender("Any");
                        }
                    }, 1000);
                }
            });
        }else if (getIntent().getStringExtra("type").equals("2")) {

            String gender = sh.getString("gender", "");

            Log.d("gender", "onCreate: " + gender);

            if (gender.equalsIgnoreCase("Male")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (gender.equalsIgnoreCase("Female")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (gender.equalsIgnoreCase("Any")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else {
                Log.d("gender", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


            binding.lloutMale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Editgender("Male");
                        }
                    }, 1000);
                }
            });

            binding.lloutFemale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Editgender("Female");
                        }
                    }, 1000);
                }
            });

            binding.lloutAny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_gender_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Editgender("Any");
                        }
                    }, 1000);
                }
            });
        }
    }

    public void gender(String gender_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(select_gender_activity.this, Target_activity.class);
        get_deal.putExtra("type", "1");
        myEdit.putString("gender", gender_type);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();
    }

    public void Editgender(String gender_type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(select_gender_activity.this, Target_activity.class);
        get_deal.putExtra("type", "2");
        myEdit.putString("gender", gender_type);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();
    }
}