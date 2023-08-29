package com.example.local_coupan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivityTermsBinding;
import com.example.local_coupan.preferences2;

public class Terms_activity extends AppCompatActivity {

    ActivityTermsBinding binding;
    preferences2 preferences;
    String flasg = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
//        Toast.makeText(this, ""+extras.getString("type"), Toast.LENGTH_SHORT).show();
        if (extras.getString("type").equals("1")) {
            flasg = "one";
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String trms = sh.getString("edtTermsDescription", "");
//            Toast.makeText(this, "terms " + trms, Toast.LENGTH_SHORT).show();

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();
            myEdit.putString("termss", trms);
            myEdit.apply();

            binding.lloutTerms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_couponterms = new Intent(Terms_activity.this, Coupon_terms_activity.class);
                    get_couponterms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_couponterms.putExtra("type", "1");
                    startActivity(get_couponterms);
                }
            });
            binding.lloutYucallterms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent get_yucall_terms = new Intent(Terms_activity.this, Yucall_coupon_activity.class);
                    get_yucall_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_yucall_terms.putExtra("type", "1");
                    startActivity(get_yucall_terms);

                }
            });
            binding.imgTermsBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
        } else if (extras.getString("type").equals("2")) {
            flasg = "two";
            binding.imgTermsBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();

                }
            });
            binding.lloutTerms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent get_couponterms = new Intent(Terms_activity.this, Coupon_terms_activity.class);
                    get_couponterms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_couponterms.putExtra("type", "2");
                    startActivity(get_couponterms);
                }
            });
            binding.lloutYucallterms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_yucall_terms = new Intent(Terms_activity.this, Yucall_coupon_activity.class);
                    get_yucall_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_yucall_terms.putExtra("type", "2");
                    startActivity(get_yucall_terms);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Toast.makeText(this, ""+flasg, Toast.LENGTH_SHORT).show();
        if (flasg.equals("one")) {
            Intent intent = new Intent(Terms_activity.this, Addcoupon_activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("type", "1");
            intent.putExtra("type2", "10");
            startActivity(intent);
        } else {
            Intent get_add = new Intent(Terms_activity.this, Addcoupon_activity.class);
            get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            get_add.putExtra("type", "2");
            get_add.putExtra("type2", "30");
//            preferences.save(Terms_activity.this, preferences.KEY_Type5, String.valueOf(2));
            startActivity(get_add);
        }
    }
}