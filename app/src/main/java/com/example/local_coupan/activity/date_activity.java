package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityDateBinding;

public class date_activity extends AppCompatActivity {
    ActivityDateBinding binding;

    String date_code = "null";
    String date_code2 = "sen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getStringExtra("type").equals("1")) {
            date_code2="send";

            if (getIntent().getStringExtra("navigate").equals("launch")) {
                date_code = "launch";

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String launch_date = sh.getString("launch_date", "");

                Log.d("expiry_launch_month", "onCreate: " + launch_date);
                binding.edtDate.setText(launch_date);

                binding.edtDate.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {

                            Log.d("viru_code", "onEditorAction: " + date_code);
                            handled = true;

                        }
                        return handled;
                    }
                });

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        back();
                    }
                });
            }
            else if (getIntent().getStringExtra("navigate").equals("expiry")) {
                date_code = "expiry";
                date_code2="send";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_date = sh.getString("expiry_launch_date", "");
                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_date);
                binding.edtDate.setText(expiry_launch_date);

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        back();
                    }
                });

                binding.edtDate.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
//                            sendMessage();

                            handled = true;
                        }
                        return handled;
                    }
                });
            }
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            date_code2="editsend";

            if (getIntent().getStringExtra("navigate").equals("launch")) {
                date_code2="editsend";
                date_code = "launch";

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String launch_date = sh.getString("launch_date_date", "");

                Log.d("expiry_launch_month", "onCreate: " + launch_date);
                binding.edtDate.setText(launch_date);

                binding.edtDate.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
//                            editsendMessage();

                            Log.d("viru_code", "onEditorAction: " + date_code);
                            handled = true;
                        }
                        return handled;
                    }
                });

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        back();
                    }
                });

            }
            else if (getIntent().getStringExtra("navigate").equals("expiry")) {
                date_code = "expiry";
                date_code2= "editsend";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                String expiry_launch_date = sh.getString("expiry_date", "");
                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_date);
                binding.edtDate.setText(expiry_launch_date);

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        back();
                    }
                });

                binding.edtDate.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {

                            handled = true;
                        }
                        return handled;
                    }
                });
            }
        }
    }
    @Override
    public void onBackPressed() {
        back();
    }

    public void back() {
        Log.d("navigate123 ", "back: "+date_code2);
        if(date_code2.equalsIgnoreCase("send")){
            Intent get_back = new Intent(date_activity.this, Launch_date_activity.class);
//            get_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            binding.edtDate.setShowSoftInputOnFocus(true);
            Log.d("code123", "sendMessage: " + date_code);

            if (TextUtils.isEmpty(binding.edtDate.getText().toString())) {

                Toast.makeText(date_activity.this, "Please Enter A Date", Toast.LENGTH_SHORT).show();

            } else {

                String date_string = String.valueOf(binding.edtDate.getText());
                Log.d("date", "sendMessage: " + date_string);

                int date = Integer.parseInt(date_string);

                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                if (date <= 31 && date != 00) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (date_code.equals("launch")) {

                                get_back.putExtra("navigate", "launch");
                                String date = binding.edtDate.getText().toString();
//                            Toast.makeText(date_activity.this, "" + date, Toast.LENGTH_SHORT).show();

                                if (date.length() == 1) {
                                    date = "0" + date;
                                }

                                myEdit.putString("launch_date", date);
                            } else if (date_code.equals("expiry")) {

                                get_back.putExtra("navigate", "expiry");
                                String date = binding.edtDate.getText().toString();
//                            Toast.makeText(date_activity.this, "" + date, Toast.LENGTH_SHORT).show();

                                if (date.length() == 1) {
                                    date = "0" + date;
                                }
                                myEdit.putString("expiry_launch_date", date);
                            }
                            myEdit.apply();
                            get_back.putExtra("type", "2");

                            startActivity(get_back);
                            finish();
                        }
                    }, 1000);

                } else {
                    Toast.makeText(this, "Please valid date", Toast.LENGTH_SHORT).show();
                    binding.edtDate.setError("Please Enter Date between 1 to 31");
                }
            }
        }

        else{
            Intent get_back = new Intent(date_activity.this, edit_date_activity.class);
//        get_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            binding.edtDate.setShowSoftInputOnFocus(true);
            Log.d("code123", "sendMessage: " + date_code);

            if (TextUtils.isEmpty(binding.edtDate.getText().toString())) {
                Toast.makeText(date_activity.this, "Please Enter A Date", Toast.LENGTH_SHORT).show();
            }
            else {

                String date_string = String.valueOf(binding.edtDate.getText());
                Log.d("date", "sendMessage: " + date_string);
                int date = Integer.parseInt(date_string);
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                if (date <= 31 && date != 0) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (date_code.equals("launch")) {

                                String date = binding.edtDate.getText().toString();
//                            Toast.makeText(date_activity.this, "" + date, Toast.LENGTH_SHORT).show();

                                if (date.length() == 1) {
                                    date = "0" + date;
                                }

                                get_back.putExtra("navigate", "launch");
                                myEdit.putString("launch_date", date);
                                myEdit.putString("launch_date_date", date);
                            } else if (date_code.equals("expiry")) {

                                String date = binding.edtDate.getText().toString();
//                            Toast.makeText(date_activity.this, "" + date, Toast.LENGTH_SHORT).show();

                                if (date.length() == 1) {
                                    date = "0" + date;
                                }
                                get_back.putExtra("navigate", "expiry");
                                myEdit.putString("expiry_launch_date", date);
                                myEdit.putString("expiry_date", date);
                            }
                            myEdit.apply();
                            get_back.putExtra("type", "2");
                            startActivity(get_back);
                            finish();
                        }
                    }, 1000);
                } else {
                    Toast.makeText(this, "Please valid date", Toast.LENGTH_SHORT).show();
                    binding.edtDate.setError("Please Enter Date between 1 to 31");
                }
            }
        }
    }
}