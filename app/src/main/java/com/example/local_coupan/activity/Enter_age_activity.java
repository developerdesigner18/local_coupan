package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityEnterAgeBinding;

public class Enter_age_activity extends AppCompatActivity {
    ActivityEnterAgeBinding binding;

    String flag = "null";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterAgeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        if (getIntent().getStringExtra("type").equals("1")) {


            flag = "add";

            if (pref.getString("maxxxx", "").equals("") || pref.getString("miiin", "").equals("")) {
                binding.edtMinAge.setText("18");
                binding.edtMaxAge.setText("100");
            } else {
                binding.edtMaxAge.setText(pref.getString("maxxxx", ""));
                binding.edtMinAge.setText(pref.getString("miiin", ""));
            }
            binding.imgBackAge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    age();
                }
            });

        } else if (getIntent().getStringExtra("type").equals("2")) {

            flag = "edit";
            binding.edtMaxAge.setText(pref.getString("maxxxx", ""));
            binding.edtMinAge.setText(pref.getString("miiin", ""));

            binding.imgBackAge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    age();
                }
            });
        }
    }

    public void age() {

        int min_age = 0, max_age = 0;

        if (binding.edtMinAge.getText().toString().equals("")) {
            min_age = Integer.parseInt("15");
        } else {
            min_age = Integer.parseInt(binding.edtMinAge.getText().toString());
        }

        if (binding.edtMaxAge.getText().toString().equals("")) {
            max_age = Integer.parseInt("100");
        } else {
            max_age = Integer.parseInt(binding.edtMaxAge.getText().toString());
        }

        if (min_age <= max_age) {

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();
            myEdit.putString("miiin", binding.edtMinAge.getText().toString().trim());
            myEdit.putString("maxxxx", binding.edtMaxAge.getText().toString().trim());
            myEdit.apply();
            Intent get_age = new Intent(Enter_age_activity.this, Target_activity.class);

            String min_age1 = String.valueOf(min_age);
            String max_age1 = String.valueOf(max_age);

            myEdit.putString("min_age", min_age1);
            myEdit.putString("max_age", max_age1);
            myEdit.apply();

            Log.d("age_age", "onClick:  " + min_age + " " + max_age);
            if (flag.equals("add")) {
                get_age.putExtra("type", "1");
            } else if (flag.equals("edit")) {
                get_age.putExtra("type", "2");
            }
            get_age.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(get_age);
            finish();

        } else {
            Toast.makeText(Enter_age_activity.this, "Please Enter Valid age group", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        age();
    }
}