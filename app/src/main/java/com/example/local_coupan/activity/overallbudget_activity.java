package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.local_coupan.databinding.ActivityOverallbudgetBinding;

public class overallbudget_activity extends AppCompatActivity {
    ActivityOverallbudgetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOverallbudgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String alloverbudget = sh.getString("edt_enter_overallbudget", "");
        String maximumbudget = sh.getString("edt_entermaximumbudget", "");

        binding.edtEntermaximumbudget.setText(maximumbudget);
        binding.edtEnterOverallbudget.setText(alloverbudget);

        binding.imgBudgetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onBackPressed() {
        String edt_enter_overallbudget = binding.edtEnterOverallbudget.getText().toString();
        String edt_entermaximumbudget = binding.edtEntermaximumbudget.getText().toString();

        if (edt_entermaximumbudget.equals("") || edt_entermaximumbudget.isEmpty()){
            Log.d("check_buged", "onBackPressed: null");
            edt_entermaximumbudget = "0";
        }
        Log.d("viru_budget", edt_enter_overallbudget + " " + edt_entermaximumbudget);

        if (!binding.edtEnterOverallbudget.getText().toString().isEmpty()) {

            int overall_budget = Integer.parseInt(edt_enter_overallbudget);
            int maximum_budget = Integer.parseInt(edt_entermaximumbudget);
            Log.d("check_buged", "onBackPressed: null"+edt_entermaximumbudget);

            if (overall_budget > maximum_budget) {
                Intent get_add = new Intent(overallbudget_activity.this, Addcoupon_activity.class);
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                myEdit.putString("edt_enter_overallbudget", edt_enter_overallbudget);
                myEdit.putString("edt_entermaximumbudget", edt_entermaximumbudget);

                Log.d("viru_budget5", edt_enter_overallbudget + " " + edt_entermaximumbudget);

                myEdit.apply();
                get_add.putExtra("type", "1");
                get_add.putExtra("type2", "2");
                startActivity(get_add);
            } else {
                binding.edtEntermaximumbudget.setError("Maximum Daily Budget is More than Over ALl budget");
            }
        } else {
            Toast.makeText(overallbudget_activity.this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }
}