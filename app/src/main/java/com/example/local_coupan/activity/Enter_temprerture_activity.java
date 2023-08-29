
package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityEnterTemprertureBinding;

public class Enter_temprerture_activity extends AppCompatActivity {
    ActivityEnterTemprertureBinding binding;

    String flag = "null";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterTemprertureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        if (getIntent().getStringExtra("type").equals("1")) {

            flag = "add";

            if (pref.getString("tempmin", "").equals("") || pref.getString("tempmax", "").equals("")){
                binding.edtMinTemp.setText("-10");
                binding.edtMaxTemp.setText("50");
            }else {
                binding.edtMinTemp.setText(pref.getString("tempmin", ""));
                binding.edtMaxTemp.setText(pref.getString("tempmax", ""));
            }

            binding.imgBackTempreture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });

        }else if (getIntent().getStringExtra("type").equals("2")) {
            flag = "edit";

            binding.edtMinTemp.setText(pref.getString("tempmin", ""));
            binding.edtMaxTemp.setText(pref.getString("tempmax", ""));

            binding.imgBackTempreture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });
        }
    }

    public void temp() {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();


        int min_temp = Integer.parseInt(binding.edtMinTemp.getText().toString());
        int max_temp = Integer.parseInt(binding.edtMaxTemp.getText().toString());

        if (min_temp <= max_temp) {
            myEdit.putString("tempmin",binding.edtMinTemp.getText().toString().trim());
            myEdit.putString("tempmax",binding.edtMaxTemp.getText().toString().trim());
            myEdit.apply();
            Intent get_age = new Intent(Enter_temprerture_activity.this, Target_activity.class);
            myEdit.putString("min_temp", String.valueOf(min_temp));
            myEdit.putString("max_temp", String.valueOf(max_temp));
            myEdit.apply();

            if (flag.equals("add")) {
                get_age.putExtra("type", "1");
            } else if (flag.equals("edit")) {
                get_age.putExtra("type", "2");
            }

            get_age.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(get_age);
            finish();

        } else {
            Toast.makeText(Enter_temprerture_activity.this, "Please Enter Valid Temperature", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        back();
    }

    public void back() {

        if (!binding.edtMinTemp.getText().toString().isEmpty() &&
                !binding.edtMaxTemp.getText().toString().isEmpty()) {

            temp();
        } else {
            Toast.makeText(this, "Please Enter Temperature", Toast.LENGTH_SHORT).show();
        }
    }
}