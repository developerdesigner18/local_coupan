
package com.example.local_coupan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivityTimeBinding;

public class time_activity extends AppCompatActivity {
    ActivityTimeBinding binding;

    String time;
    String flag = "null";
    String flag2 = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (getIntent().getStringExtra("type").equals("1")) {
            flag2 = "1";
            if (getIntent().getStringExtra("navigate").equals("expiry")) {

                flag = "expiry_time";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String expiry_launch_time = sh.getString("expiry_launch_time", "");
                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_time);
                binding.edtTime.setText(expiry_launch_time);

                getSelectedTime();

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(time_activity.this, Launch_date_activity.class);
//                        intent.putExtra("navigate", "expiry");
//                        startActivity(intent);
                    onBackPressed();
                    }
                });
            } else if (getIntent().getStringExtra("navigate").equals("launch")) {

                flag = "launch_time";

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String launch_time = sh.getString("launch_time", "");
                Log.d("launch_time", "onCreate: " + launch_time);
                binding.edtTime.setText(launch_time);

                getSelectedTime();

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(time_activity.this, Launch_date_activity.class);
//                        intent.putExtra("navigate", "launch");
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                    onBackPressed();
                    }
                });
            }

        } else if (getIntent().getStringExtra("type").equals("2")) {

            flag2 = "2";

            if (getIntent().getStringExtra("navigate").equals("expiry")) {

                flag = "expiry_time";
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String expiry_launch_time = sh.getString("expiry_time_1", "");
                Log.d("expiry_launch_month", "onCreate: " + expiry_launch_time);
                binding.edtTime.setText(expiry_launch_time);

                editgetSelectedTime();

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(time_activity.this, edit_date_activity.class);
//                        intent.putExtra("navigate", "expiry");
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                    onBackPressed();
                    }
                });
            } else if (getIntent().getStringExtra("navigate").equals("launch")) {

                flag = "launch_time";

                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String launch_time = sh.getString("launch_time_1", "");
                Log.d("launch_time", "onCreate: " + launch_time);
                binding.edtTime.setText(launch_time);

                editgetSelectedTime();

                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(time_activity.this, edit_date_activity.class);
//                        intent.putExtra("navigate", "launch");
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
                    onBackPressed();
                    }
                });
            }
        }
    }

    private void getSelectedTime() {
        binding.simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                String hour = String.valueOf(hourOfDay);
                String minute1 = String.valueOf(minute);

                if (hourOfDay >= 0 && hourOfDay < 12) {

                    if (hourOfDay <= 9) {
                        hour = "0" + hourOfDay;
                    }
                    if (minute <= 9) {
                        minute1 = "0" + minute;
                    }
                    time = hour + ":" + minute1;


                } else {
                    if (hourOfDay == 12) {
                        if (hourOfDay <= 9) {
                            hour = "0" + hourOfDay;
                        }
                        if (minute <= 9) {
                            minute1 = "0" + minute;
                        }
                        time = hour + ":" + minute1;
                    } else {
                        if (hourOfDay <= 9) {
                            hour = "0" + hourOfDay;
                        }
                        if (minute <= 9) {
                            minute1 = "0" + minute;
                        }
                        time = hour + ":" + minute1;
                    }
                }

                Log.d("viru_time1", "tiemPicker: " + time);
                binding.edtTime.setText(time);
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                Log.d("flag123", "onTimeChanged: " + flag);

                if (flag.equals("expiry_time")) {
                    myEdit.putString("expiry_launch_time", time);
                    myEdit.apply();
                } else if (flag.equals("launch_time")) {
                    myEdit.putString("launch_time", time);
                    myEdit.apply();
                    Log.d("devi42", "onTimeChanged: " + pref.getString("launch_time", ""));
                }
                Log.d("devi4", "onTimeChanged: " + pref.getString("expiry_launch_time", ""));
            }
        });
    }

    private void editgetSelectedTime() {
        binding.simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                String hour = String.valueOf(hourOfDay);
                String minute1 = String.valueOf(minute);

                if (hourOfDay >= 0 && hourOfDay < 12) {

                    if (hourOfDay <= 9) {
                        hour = "0" + hourOfDay;
                    }
                    if (minute <= 9) {
                        minute1 = "0" + minute;
                    }
                    time = hour + ":" + minute1;

                } else {
                    if (hourOfDay == 12) {
                        if (hourOfDay <= 9) {
                            hour = "0" + hourOfDay;
                        }
                        if (minute <= 9) {
                            minute1 = "0" + minute;
                        }
                        time = hour + ":" + minute1;
                    } else {
                        if (hourOfDay <= 9) {
                            hour = "0" + hourOfDay;
                        }
                        if (minute <= 9) {
                            minute1 = "0" + minute;
                        }
                        time = hour + ":" + minute1;
                    }
                }

                Log.d("viru_time1", "tiemPicker: " + time);
                binding.edtTime.setText(time);
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                Log.d("flag123", "onTimeChanged: " + flag);

                if (flag.equalsIgnoreCase("expiry_time")) {
                    myEdit.putString("expiry_launch_time", time);
                    myEdit.putString("expiry_time_1", time);
                    Log.d("devi42 2", "onTimeChanged: " + time);
                    myEdit.apply();
                } else if (flag.equals("launch_time")) {
                    myEdit.putString("launch_time", time);
                    myEdit.putString("launch_time_1", time);
                    myEdit.apply();
                    Log.d("devi42", "onTimeChanged: " + pref.getString("launch_time", ""));
                }
                Log.d("devi4", "onTimeChanged: " + pref.getString("expiry_time_1", ""));
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (flag2.equals("1")) {

            if (flag.equals("expiry_time")) {

                Intent intent = new Intent(time_activity.this, Launch_date_activity.class);
                intent.putExtra("navigate", "expiry");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            } else if (flag.equals("launch_time")) {

                Intent intent = new Intent(time_activity.this, Launch_date_activity.class);
                intent.putExtra("navigate", "launch");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        } else if (flag2.equals("2")) {

            if (flag.equals("expiry_time")) {

                Intent intent = new Intent(time_activity.this, edit_date_activity.class);
                intent.putExtra("navigate", "expiry");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            } else if (flag.equals("launch_time")) {

                Intent intent = new Intent(time_activity.this, edit_date_activity.class);
                intent.putExtra("navigate", "launch");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        }
    }
}