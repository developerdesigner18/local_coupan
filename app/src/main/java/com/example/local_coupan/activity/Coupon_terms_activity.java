package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.local_coupan.databinding.ActivityCouponTermsBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Coupon_terms_activity extends AppCompatActivity {
    ActivityCouponTermsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String edtTermsDescription1 = sh.getString("edtTermsDescription", "");
            binding.edtTermsDescription.setText(edtTermsDescription1);

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String formattedDate = df.format(Calendar.getInstance().getTime());
            binding.update.setText(formattedDate);

            binding.imgCouponTermsBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String edtTermsDescription = binding.edtTermsDescription.getText().toString();

                    Log.d("viru_budget", edtTermsDescription);


                    myEdit.putString("edtTermsDescription", edtTermsDescription);
                    myEdit.putString("terms_update", binding.update.getText().toString());

                    Log.d("viru_budget2", edtTermsDescription);

                    myEdit.apply();

                    Intent get_terms = new Intent(Coupon_terms_activity.this, Terms_activity.class);
                    get_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_terms.putExtra("type", "1");
                    get_terms.putExtra("type2", "10");
                    startActivity(get_terms);
                    finish();

                }
            });

        } else if (getIntent().getStringExtra("type").equals("2")) {

            String terms = sh.getString("terms", "");
            String coupon_id = sh.getString("coupon_id", "");
            String terms_date = sh.getString("terms_date", "");

            binding.edtTermsDescription.setText(terms);
            binding.txtCouponId.setText(coupon_id);
            binding.update.setText(terms_date);

            binding.edtTermsDescription.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String formattedDate = df.format(Calendar.getInstance().getTime());
                    binding.update.setText(formattedDate);
                    myEdit.putString("terms_date", formattedDate);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            binding.imgCouponTermsBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myEdit.putString("terms", binding.edtTermsDescription.getText().toString().trim());
                    myEdit.apply();
                    onBackPressed();

                }
            });
        }
    }
}