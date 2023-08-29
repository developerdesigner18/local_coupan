
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectWeatherBinding;

public class select_weather_activity extends AppCompatActivity {
    ActivitySelectWeatherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String weather = sh.getString("weather", "");

            Log.d("weather", "onCreate: " + weather);

            if (weather.equalsIgnoreCase("Sun")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Rain")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Snow")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Wind")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Any")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


            binding.lloutSun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weather("Sun");
                        }
                    }, 1000);
                }
            });


            binding.lloutRain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weather("Rain");
                        }
                    }, 1000);
                }
            });


            binding.lloutSnow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weather("Snow");
                        }
                    }, 1000);
                }
            });

            binding.lloutWind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            weather("Wind");

                        }
                    }, 1000);
                }
            });

            binding.lloutAny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            weather("Any");
                        }
                    }, 1000);
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            String weather = sh.getString("weather", "");

            Log.d("weather", "onCreate: " + weather);

            if (weather.equalsIgnoreCase("Sun")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Rain")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Snow")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Wind")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (weather.equalsIgnoreCase("Any")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


            binding.lloutSun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edit_weather("Sun");
                        }
                    }, 1000);
                }
            });


            binding.lloutRain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edit_weather("Rain");

                        }
                    }, 1000);
                }
            });


            binding.lloutSnow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edit_weather("Snow");
                        }
                    }, 1000);
                }
            });

            binding.lloutWind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            edit_weather("Wind");

                        }
                    }, 1000);
                }
            });

            binding.lloutAny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_weather_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            edit_weather("Any");
                        }
                    }, 1000);
                }
            });
        }
    }

    public void weather(String weather_type) {
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(select_weather_activity.this, Target_activity.class);
        get_deal.putExtra("type", "1");
        myEdit.putString("weather", weather_type);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();
    }
    public void edit_weather(String weather_type) {
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Intent get_deal = new Intent(select_weather_activity.this, Target_activity.class);
        get_deal.putExtra("type", "2");
        myEdit.putString("weather", weather_type);
        myEdit.apply();
        get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_deal);
        finish();
    }
}