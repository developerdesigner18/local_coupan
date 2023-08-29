package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityWebBinding;

public class Web_activity extends AppCompatActivity {

    ActivityWebBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        String payment_type = pref.getString("payment_type", "");

        binding.imgBackPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String url1 = getIntent().getStringExtra("payment_url");
        Log.d("viru_name1", "onCreate: " + url1);
        String url = url1;

        binding.webview.loadUrl(url);
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

//                Toast.makeText(Web_activity.this, view.getTitle(), Toast.LENGTH_SHORT).show();
                Log.d("devi3 1 ", view.getUrl());
                Log.d("devi3 2 ", view.getTitle());
                Log.d("devi3 3 ", view.getOriginalUrl());
//                String uuu = "https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-56 350085912097506";
                if (view.getTitle().equals("Payment")) {

                    if (payment_type.equals("payment")) {
                        payemnt_success("Your Payment has been Successful and Coupon is added Successfully..!");
                    } else if (payment_type.equals("topup")) {
                        payemnt_success("Your Budget has been Successfully Added..!");
                    } else{
                        payemnt_success("Your Payment has been Successful and Coupon is added Successfully..!");
                    }
                }
            }
        });
    }

    public void payemnt_success(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Payment Success")
                .setMessage(message)
                .setIcon(R.drawable.payment_success)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Web_activity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }).create().show();
    }
}