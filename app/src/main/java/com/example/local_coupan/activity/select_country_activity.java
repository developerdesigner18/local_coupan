
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivitySelectCountryBinding;

public class select_country_activity extends AppCompatActivity {
    ActivitySelectCountryBinding binding;
    String Array;


    String flag = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {


            String country = sh.getString("country", "");

            Log.d("country123", "onCreate: " + country);

            if (country.equalsIgnoreCase("France")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Indonesia")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Kenya")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Nigeria")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Philippines")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Senegal")) {
                binding.truePercentage6.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("United Kingdom")) {
                binding.truePercentage7.setVisibility(View.VISIBLE);
            }


            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Bundle b = getIntent().getExtras();
            Array = b.getString("Array");

            binding.lloutFrance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "France");

                }
            });

            binding.lloutIndonesia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "Indonesia");

                }
            });

            binding.lloutKenya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "Kenya");

                }
            });

            binding.lloutNigeria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "Nigeria");

                }
            });

            binding.lloutPhilippines.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "Philippines");
                }
            });

            binding.lloutSenegal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    navigate_back("1", "Senegal");

                }
            });
            binding.lloutUK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    navigate_back("1", "United Kingdom");

                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            flag = "2";
            String country = sh.getString("country", "");

            Log.d("country", "onCreate: " + country);

            if (country.equalsIgnoreCase("France")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Indonesia")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Kenya")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Nigeria")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Philippines")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Senegal")) {
                binding.truePercentage6.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("United Kingdom")) {
                binding.truePercentage7.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Bundle b = getIntent().getExtras();
            Array = b.getString("Array");

            binding.lloutFrance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "France");

                }
            });

            binding.lloutIndonesia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "Indonesia");

                }
            });

            binding.lloutKenya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "Kenya");

                }
            });

            binding.lloutNigeria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "Nigeria");

                }
            });

            binding.lloutPhilippines.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "Philippines");
                }
            });

            binding.lloutSenegal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "Senegal");

                }
            });
            binding.lloutUK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    editnavigate_back("2", "United Kingdom");
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("3")) {

            flag = "3";

            String country = sh.getString("country", "");

            Log.d("country", "onCreate: " + country);

            if (country.equalsIgnoreCase("France")) {
                binding.truePercentage1.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Indonesia")) {
                binding.truePercentage2.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Kenya")) {
                binding.truePercentage3.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Nigeria")) {
                binding.truePercentage4.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Philippines")) {
                binding.truePercentage5.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("Senegal")) {
                binding.truePercentage6.setVisibility(View.VISIBLE);
            } else if (country.equalsIgnoreCase("United Kingdom")) {
                binding.truePercentage7.setVisibility(View.VISIBLE);
            } else {
                Log.d("currency", "please select any type");
            }

            binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            Bundle b = getIntent().getExtras();
            Array = b.getString("Array");

            binding.lloutFrance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage1.setVisibility(View.VISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "France");

                }
            });

            binding.lloutIndonesia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage2.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "Indonesia");

                }
            });

            binding.lloutKenya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage3.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "Kenya");

                }
            });

            binding.lloutNigeria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage4.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "Nigeria");

                }
            });

            binding.lloutPhilippines.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage5.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "Philippines");
                }
            });

            binding.lloutSenegal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage6.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage7.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "Senegal");

                }
            });

            binding.lloutUK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(select_country_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
                    binding.truePercentage7.setVisibility(View.VISIBLE);
                    binding.truePercentage1.setVisibility(View.INVISIBLE);
                    binding.truePercentage2.setVisibility(View.INVISIBLE);
                    binding.truePercentage3.setVisibility(View.INVISIBLE);
                    binding.truePercentage4.setVisibility(View.INVISIBLE);
                    binding.truePercentage5.setVisibility(View.INVISIBLE);
                    binding.truePercentage6.setVisibility(View.INVISIBLE);
                    editnavigate_back("3", "United Kingdom");
                }
            });
        }
    }

    public void navigate_back(String type, String country) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent get_deal = new Intent(select_country_activity.this, location_activity.class);
                get_deal.putExtra("type", type);
                myEdit.putString("country", country);

                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_deal.putExtra("Array", String.valueOf(Array));
                myEdit.apply();
                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_deal);


            }
        }, 1000);
    }

    public void editnavigate_back(String type, String country) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                if (flag.equals("2")) {
                    Intent get_deal = new Intent(select_country_activity.this, location_activity.class);
                    get_deal.putExtra("type", type);
                    myEdit.putString("country", country);

                    get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_deal.putExtra("Array", String.valueOf(Array));
                    myEdit.apply();
                    get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(get_deal);
                } else {
                    Intent get_deal = new Intent(select_country_activity.this, location_activity.class);
                    get_deal.putExtra("type", type);
                    myEdit.putString("country", country);

                    get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_deal.putExtra("Array", String.valueOf(Array));
                    myEdit.apply();
                    get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(get_deal);
                }
            }
        }, 1000);
    }
}