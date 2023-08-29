package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityLaunchDateBinding;
import com.example.local_coupan.preferences2;

import java.time.Year;

public class Launch_date_activity extends AppCompatActivity {

    ActivityLaunchDateBinding binding;
    preferences2 preferences;
    String launch_flag = "null";

    @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaunchDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);


        preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(2));
        Log.d("navigate123 1 ", "onCreate: " + getIntent().getStringExtra("navigate"));

        if (getIntent().getStringExtra("navigate").equals("launch")) {

            Log.d("devi3", "onCreate:" + preferences.get(Launch_date_activity.this, preferences.KEY_Type2));
            if (preferences.get(Launch_date_activity.this, preferences.KEY_Type2).equals(10)) {
                myEdit.putString("launch_year", "");
                myEdit.putString("launch_month", "");
                myEdit.putString("launch_date", "");
                myEdit.putString("launch_time", "");
                myEdit.putString("launch_month_num", "");
            }
            String year = sh.getString("launch_year", "");
            String month = sh.getString("launch_month", "");
            String date = sh.getString("launch_date", "");
            String time = sh.getString("launch_time", "");
            String launch_month_num = sh.getString("launch_month_num", "");

            binding.yearNum.setText(year);
            binding.month.setText(month);
            binding.date.setText(date);
            binding.time.setText(time);

            Log.d("launch_date123", "onCreate: " + year + " " + month + " " + date + " " + time + launch_month_num);

            binding.imgBackLaunchDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back("launch");
                }
            });
            binding.lloutYear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent choose_year = new Intent(Launch_date_activity.this, select_year_activity.class);
                    choose_year.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_year.putExtra("type", "1");
                    choose_year.putExtra("navigate", "launch");
                    startActivity(choose_year);

                }
            });
            binding.lloutMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_month = new Intent(Launch_date_activity.this, select_month_activity.class);
                    choose_month.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_month.putExtra("type", "1");
                    choose_month.putExtra("navigate", "launch");
                    startActivity(choose_month);
                }
            });
            binding.lloutDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_date = new Intent(Launch_date_activity.this, date_activity.class);
                    choose_date.putExtra("navigate", "launch");
                    choose_date.putExtra("type", "1");
                    choose_date.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(choose_date);
                }
            });
            binding.lloutTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_launch_time = new Intent(Launch_date_activity.this, time_activity.class);
                    choose_launch_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_launch_time.putExtra("navigate", "launch");
                    choose_launch_time.putExtra("type", "1");
                    startActivity(choose_launch_time);
                }
            });
        }


        if (getIntent().getStringExtra("navigate").equals("expiry")) {

            String year = sh.getString("expiry_launch_year", "");
            String monthnu = sh.getString("expiry_launch_monthnu", "");
            String month = sh.getString("expiry_launch_month", "");
            String date = sh.getString("expiry_launch_date", "");
            String time = sh.getString("expiry_launch_time", "");

            binding.txtTitle.setText("Expiry Date");
            Log.d("devi6", "onCreate: e " + sh.getString("expiry_launch_time", ""));
            Log.d("devi6", "onCreate: e n " + pref.getString("expiry_launch_time", ""));
            binding.yearNum.setText(year);
            binding.month.setText(month);
            binding.date.setText(date);
            binding.time.setText(time);

            binding.lloutYear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_year = new Intent(Launch_date_activity.this, select_year_activity.class);
                    choose_year.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_year.putExtra("navigate", "expiry");
                    choose_year.putExtra("type", "1");
                    startActivity(choose_year);
                }
            });
            binding.imgBackLaunchDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back("expiry");
                }
            });
            binding.lloutMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_month = new Intent(Launch_date_activity.this, select_month_activity.class);
                    choose_month.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_month.putExtra("navigate", "expiry");
                    choose_month.putExtra("type", "1");
                    startActivity(choose_month);
                }
            });
            binding.lloutDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_expiry_date = new Intent(Launch_date_activity.this, date_activity.class);
                    choose_expiry_date.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_expiry_date.putExtra("navigate", "expiry");
                    choose_expiry_date.putExtra("type", "1");
                    startActivity(choose_expiry_date);
                }
            });

            binding.lloutTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_expiry_time = new Intent(Launch_date_activity.this, time_activity.class);
                    choose_expiry_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_expiry_time.putExtra("navigate", "expiry");
                    choose_expiry_time.putExtra("type", "1");
                    startActivity(choose_expiry_time);
                }
            });
        }
    }

    public void back(String flag) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        if (!binding.yearNum.getText().toString().isEmpty() &&
                !binding.month.getText().toString().isEmpty() &&
                !binding.date.getText().toString().isEmpty() &&
                !binding.time.getText().toString().isEmpty()) {

            Intent get_deal_type = new Intent(Launch_date_activity.this, Coupon_deal_activity.class);
            get_deal_type.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            get_deal_type.putExtra("type", "1");

            String month_name = binding.month.getText().toString();
            String year123 = binding.yearNum.getText().toString();
            int final_year = Integer.parseInt(year123);

            if (flag.equals("launch")) {

                if (month_name.equalsIgnoreCase("April") ||
                        month_name.equalsIgnoreCase("June") ||
                        month_name.equalsIgnoreCase("September") ||
                        month_name.equalsIgnoreCase("November")) {

                    String date = binding.date.getText().toString();
                    int date1 = Integer.parseInt(date);

                    if (date1 <= 30) {

                        preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                        preferences.save(Launch_date_activity.this, preferences.KEY_Type3, String.valueOf(5));

                        Log.d("viru", "back: " + launch_flag);

                        myEdit.putString("flag_val", "from_launch");

                        String year = binding.yearNum.getText().toString();
                        String month = binding.month.getText().toString();
                        date = binding.date.getText().toString();
                        String time = binding.time.getText().toString();

                        myEdit.putString("launch_year", year);
                        myEdit.putString("launch_month", month);
                        myEdit.putString("launch_date", date);
                        myEdit.putString("launch_time", time);

//                        myEdit.putString("final_launch_time", time);
                        Log.d("final_launch_time123", "back: " + year);
                        Log.d("final_launch_time123", "back: " + month);
                        Log.d("final_launch_time123", "back: " + date);
                        Log.d("final_launch_time123", "back: " + time);
                        myEdit.putString("final_launch_time_FULL", date + "/" + month + "/" + year + " " + time);
//                        String final_expiry_time = sh.getString("final_expiry_time", "");
                        myEdit.apply();
                        startActivity(get_deal_type);
                    } else {
                        alert_message("You are selected " + month_name + " month so please enter date between 1 to 30");
//                        Toast.makeText(this, "You are selected february month so please enter date between 1 to 28", Toast.LENGTH_SHORT).show();
                    }
                } else if (!binding.month.getText().equals("February")) {

                    preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

                    Log.d("viru", "back: " + launch_flag);

                    myEdit.putString("flag_val", "from_launch");

                    String year = binding.yearNum.getText().toString();
                    String month = binding.month.getText().toString();
                    String date = binding.date.getText().toString();
                    String time = binding.time.getText().toString();

                    myEdit.putString("launch_year", year);
                    myEdit.putString("launch_month", month);
                    myEdit.putString("launch_date", date);
                    myEdit.putString("launch_time", time);
                    myEdit.apply();
                    startActivity(get_deal_type);

                } else {
                    String date = binding.date.getText().toString();
                    int date1 = Integer.parseInt(date);

                    if (date1 <= 28) {
                        preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

                        Log.d("viru", "back: " + launch_flag);

                        myEdit.putString("flag_val", "from_launch");

                        String year = binding.yearNum.getText().toString();
                        String month = binding.month.getText().toString();
                        date = binding.date.getText().toString();
                        String time = binding.time.getText().toString();

                        myEdit.putString("launch_year", year);
                        myEdit.putString("launch_month", month);
                        myEdit.putString("launch_date", date);
                        myEdit.putString("launch_time", time);
                        myEdit.apply();
                        startActivity(get_deal_type);

                    } else {

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            Year year1 = Year.of(final_year);
                            String leap;
                            if (year1.isLeap()) {

                                if (date1 <= 29) {
                                    preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

                                    Log.d("viru", "back: " + launch_flag);

                                    myEdit.putString("flag_val", "from_launch");

                                    String year = binding.yearNum.getText().toString();
                                    String month = binding.month.getText().toString();
                                    date = binding.date.getText().toString();
                                    String time = binding.time.getText().toString();

                                    myEdit.putString("launch_year", year);
                                    myEdit.putString("launch_month", month);
                                    myEdit.putString("launch_date", date);
                                    myEdit.putString("launch_time", time);
                                    myEdit.apply();
                                    startActivity(get_deal_type);

                                } else {
                                }
                            } else {
                                alert_message("You are selected february month so please enter date between 1 to 28");
                            }
                        }
                        alert_message("You are selected february month so please enter date between 1 to 29");
                    }
                }
            } else if (flag.equals("expiry")) {

                if (month_name.equalsIgnoreCase("April") ||
                        month_name.equalsIgnoreCase("June") ||
                        month_name.equalsIgnoreCase("September") ||
                        month_name.equalsIgnoreCase("November")) {

                    String date = binding.date.getText().toString();
                    int date1 = Integer.parseInt(date);

                    if (date1 <= 30) {

                        preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                        preferences.save(Launch_date_activity.this, preferences.KEY_Type3, String.valueOf(5));

                        Log.d("viru", "back: " + launch_flag);

                        myEdit.putString("flag_val", "from_launch");

                        String year = binding.yearNum.getText().toString();
                        String month = binding.month.getText().toString();
                        date = binding.date.getText().toString();
                        String time = binding.time.getText().toString();

//                        myEdit.putString("launch_year", year);
//                        myEdit.putString("launch_month", month);
//                        myEdit.putString("launch_date", date);
//                        myEdit.putString("launch_time", time);

                        myEdit.putString("expiry_launch_year", year);
//                myEdit.putString("expiry_launch_monthnu", expiry_month);
                        myEdit.putString("expiry_launch_month", month);
                        myEdit.putString("expiry_launch_date", date);
                        myEdit.putString("expiry_launch_time", time);

//                        myEdit.putString("final_launch_time", time);
                        Log.d("final_launch_time123", "back: " + year);
                        Log.d("final_launch_time123", "back: " + month);
                        Log.d("final_launch_time123", "back: " + date);
                        Log.d("final_launch_time123", "back: " + time);
//                        myEdit.putString("final_launch_time_FULL", date + "/" + month + "/" + year + " " + time);
//                        String final_expiry_time = sh.getString("final_expiry_time", "");
                        myEdit.apply();
                        startActivity(get_deal_type);
                    } else {
                        alert_message("You are selected " + month_name + " month so please enter date between 1 to 30");
//                        Toast.makeText(this, "You are selected february month so please enter date between 1 to 28", Toast.LENGTH_SHORT).show();
                    }

                } else if (!binding.month.getText().equals("February")) {


                    preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                    preferences.save(Launch_date_activity.this, preferences.KEY_Type3, String.valueOf(5));
                    get_deal_type.putExtra("navigate", "expiry");

                    String expiry_year = binding.yearNum.getText().toString();
                    String expiry_month = binding.month.getText().toString();
                    String expiry_date = binding.date.getText().toString();
                    String expiry_time = binding.time.getText().toString();

                    myEdit.putString("expiry_launch_year", expiry_year);
//                myEdit.putString("expiry_launch_monthnu", expiry_month);
                    myEdit.putString("expiry_launch_month", expiry_month);
                    myEdit.putString("expiry_launch_date", expiry_date);
                    myEdit.putString("expiry_launch_time", expiry_time);

                    Log.d("date_time", "back: " + expiry_year + expiry_month + expiry_date + expiry_time);

                    myEdit.apply();
                    startActivity(get_deal_type);

                } else {

                    String date = binding.date.getText().toString();
                    int date1 = Integer.parseInt(date);

                    if (date1 <= 28) {

                        preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                        preferences.save(Launch_date_activity.this, preferences.KEY_Type3, String.valueOf(5));
                        get_deal_type.putExtra("navigate", "expiry");

                        String expiry_year = binding.yearNum.getText().toString();
                        String expiry_month = binding.month.getText().toString();
                        String expiry_date = binding.date.getText().toString();
                        String expiry_time = binding.time.getText().toString();

                        myEdit.putString("expiry_launch_year", expiry_year);
//                myEdit.putString("expiry_launch_monthnu", expiry_month);
                        myEdit.putString("expiry_launch_month", expiry_month);
                        myEdit.putString("expiry_launch_date", expiry_date);
                        myEdit.putString("expiry_launch_time", expiry_time);

                        Log.d("date_time", "back: " + expiry_year + expiry_month + expiry_date + expiry_time);

                        myEdit.apply();
                        startActivity(get_deal_type);
                    } else {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            Year year1 = Year.of(final_year);
                            String leap;
                            if (year1.isLeap()) {

                                if (date1 <= 29) {
                                    preferences.save(Launch_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

                                    Log.d("viru", "back: " + launch_flag);

                                    myEdit.putString("flag_val", "from_launch");

                                    String year = binding.yearNum.getText().toString();
                                    String month = binding.month.getText().toString();
                                    date = binding.date.getText().toString();
                                    String time = binding.time.getText().toString();

                                    myEdit.putString("expiry_launch_year", year);
//                myEdit.putString("expiry_launch_monthnu", expiry_month);
                                    myEdit.putString("expiry_launch_month", month);
                                    myEdit.putString("expiry_launch_date", date);
                                    myEdit.putString("expiry_launch_time", time);
                                    myEdit.apply();
                                    startActivity(get_deal_type);

                                } else {
                                }
                            } else {
                                alert_message("You are selected february month so please enter date between 1 to 28");
                            }
                        }
                        alert_message("You are selected february month so please enter date between 1 to 29");
                    }
                }
            }
        } else {
            Toast.makeText(this, "Please Fill on all Fields", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (binding.txtTitle.getText().equals("Launch Date")) {
            back("launch");
        } else if (binding.txtTitle.getText().equals("Expiry Date")) {
            back("expiry");
        }
    }

    public void alert_message(String message_from_share) {
        new AlertDialog.Builder(this)
                .setTitle("Share Message")
                .setMessage(message_from_share)
                .setNeutralButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }
}