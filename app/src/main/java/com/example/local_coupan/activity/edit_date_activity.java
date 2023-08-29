package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityEditDateBinding;
import com.example.local_coupan.preferences2;

public class edit_date_activity extends AppCompatActivity {
    ActivityEditDateBinding binding;
    preferences2 preferences;
    String launch_flag = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(2));
        Log.d("navigate123 2 ", "onCreate: " + getIntent().getStringExtra("navigate"));
        if (getIntent().getStringExtra("navigate").equals("launch")) {

            Log.d("devi3", "onCreate:" + preferences.get(edit_date_activity.this, preferences.KEY_Type2));

            String year = sh.getString("launch_date_year", "");
            String  month = sh.getString("launch_month", "");
            String monthnuol = sh.getString("launch_month_num", "");            String date = sh.getString("launch_date_date", "");
            String time = sh.getString("launch_time_1", "");
            String launch_month_num = sh.getString("launch_month_num", "");

            binding.yearNum.setText(year);



            String month_name = "null";

            switch (monthnuol) {
                case "01":
                    month_name = "January";
                    break;
                case "02":
                    month_name = "February";
                    break;
                case "03":
                    month_name = "March";
                    break;
                case "04":
                    month_name = "April";
                    break;
                case "05":
                    month_name = "May";
                    break;
                case "06":
                    month_name = "June";
                    break;
                case "07":
                    month_name = "July";
                    break;
                case "08":
                    month_name = "August";
                    break;
                case "09":
                    month_name = "September";
                    break;
                case "10":
                    month_name = "October";
                    break;
                case "11":
                    month_name = "Navember";
                    break;
                case "12":
                    month_name = "December";
                    break;
                default:
            }

            String final_month = month_name;
            binding.month.setText(final_month);
//            Toast.makeText(this, ""+month_name, Toast.LENGTH_SHORT).show();
            myEdit.putString("launch_month", final_month);
            myEdit.apply();



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
                    Intent choose_year = new Intent(edit_date_activity.this, select_year_activity.class);
                    choose_year.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_year.putExtra("type", "2");
                    choose_year.putExtra("navigate", "launch");
                    startActivity(choose_year);
                }
            });
            binding.lloutMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_month = new Intent(edit_date_activity.this, select_month_activity.class);
                    choose_month.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_month.putExtra("type", "2");
                    choose_month.putExtra("navigate", "launch");
                    startActivity(choose_month);
                }
            });
            binding.lloutDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_date = new Intent(edit_date_activity.this, date_activity.class);
                    choose_date.putExtra("navigate", "launch");
                    choose_date.putExtra("type", "2");
                    choose_date.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(choose_date);
                }
            });
            binding.lloutTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_launch_time = new Intent(edit_date_activity.this, time_activity.class);
                    choose_launch_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_launch_time.putExtra("navigate", "launch");
                    choose_launch_time.putExtra("type", "2");
                    startActivity(choose_launch_time);
                }
            });
            myEdit.putString("launch_date_year", binding.yearNum.getText().toString());
            myEdit.putString("launch_date_month", binding.month.getText().toString());
            myEdit.putString("launch_date_date", binding.date.getText().toString());
            myEdit.putString("launch_time_1", binding.time.getText().toString());
            myEdit.apply();
        }
        if (getIntent().getStringExtra("navigate").equals("expiry")) {

            String year = sh.getString("expiry_year", "");
            String monthnu = sh.getString("expiry_launch_monthnu", "");
            String month = sh.getString("expiry_month", "");
            String date = sh.getString("expiry_date", "");
            String time = pref.getString("expiry_time_1", "");
            binding.txtTitle.setText("Expiry Date");
            Log.d("devi6 1 ", "onCreate: e " + sh.getString("expiry_launch_time", ""));
            Log.d("devi6 2", "onCreate: e n " + pref.getString("expiry_launch_time", ""));
            Log.d("devi6 3", "onCreate: e n " + pref.getString("expiry_time_1", ""));
            binding.yearNum.setText(year);



            String month_name = "null";

            switch (monthnu) {
                case "01":
                    month_name = "January";
                    break;
                case "02":
                    month_name = "February";
                    break;
                case "03":
                    month_name = "March";
                    break;
                case "04":
                    month_name = "April";
                    break;
                case "05":
                    month_name = "May";
                    break;
                case "06":
                    month_name = "June";
                    break;
                case "07":
                    month_name = "July";
                    break;
                case "08":
                    month_name = "August";
                    break;
                case "09":
                    month_name = "September";
                    break;
                case "10":
                    month_name = "October";
                    break;
                case "11":
                    month_name = "Navember";
                    break;
                case "12":
                    month_name = "December";
                    break;
                default:
            }

            String final_month = month_name;
            binding.month.setText(final_month);

            binding.date.setText(date.toString());

            binding.time.setText(time.toString());

            binding.lloutYear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_year = new Intent(edit_date_activity.this, select_year_activity.class);
                    choose_year.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_year.putExtra("navigate", "expiry");
                    choose_year.putExtra("type", "2");
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
                    Intent choose_month = new Intent(edit_date_activity.this, select_month_activity.class);
                    choose_month.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_month.putExtra("navigate", "expiry");
                    choose_month.putExtra("type", "2");
                    startActivity(choose_month);
                }
            });
            binding.lloutDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_expiry_date = new Intent(edit_date_activity.this, date_activity.class);
                    choose_expiry_date.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_expiry_date.putExtra("navigate", "expiry");
                    choose_expiry_date.putExtra("type", "2");
                    startActivity(choose_expiry_date);
                }
            });
            binding.lloutTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choose_expiry_time = new Intent(edit_date_activity.this, time_activity.class);
                    choose_expiry_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    choose_expiry_time.putExtra("navigate", "expiry");
                    choose_expiry_time.putExtra("type", "2");
                    startActivity(choose_expiry_time);
                }
            });
            myEdit.putString("expiry_year", binding.yearNum.getText().toString());
            myEdit.putString("expiry_month", binding.month.getText().toString());
            myEdit.putString("expiry_date", binding.date.getText().toString());
            myEdit.putString("expiry_time_1", binding.time.getText().toString());
            myEdit.apply();
        }
    }

    public void back(String flag) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        if (!binding.yearNum.getText().toString().isEmpty() &&
                !binding.month.getText().toString().isEmpty() &&
                !binding.date.getText().toString().isEmpty() &&
                !binding.time.getText().toString().isEmpty()) {
            Log.d("devi67", "back: back edit");
            Intent get_deal_type = new Intent(edit_date_activity.this, Coupon_deal_activity.class);
            get_deal_type.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            get_deal_type.putExtra("type", "2");

            String month_name = binding.month.getText().toString();

            if (flag.equals("launch")) {

                if (month_name.equalsIgnoreCase("April") ||
                        month_name.equalsIgnoreCase("June") ||
                        month_name.equalsIgnoreCase("September") ||
                        month_name.equalsIgnoreCase("November")) {

                    String date = binding.date.getText().toString();

                    int date1 = Integer.parseInt(date);
                    if (date1 <= 30) {
                        preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

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
                        myEdit.apply();
                        startActivity(get_deal_type);

                    } else {
                        alert_message("You are selected " + month_name + " month so please enter date between 1 to 30");
//                        Toast.makeText(this, "You are selected february month so please enter date between 1 to 28", Toast.LENGTH_SHORT).show();
                    }

                } else if (!month_name.equals("February")) {
                    preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

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
                    myEdit.putString("final_launch_time", date + "/" + month + "/" + year + " " + time);
                    myEdit.apply();
                    startActivity(get_deal_type);

                } else {

                    String date = binding.date.getText().toString();
                    int date1 = Integer.parseInt(date);
                    if (date1 <= 28) {
                        preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

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

                        alert_message("You are selected february month so please enter date between 1 to 28");

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
                        preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(4));

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
                        myEdit.apply();
                        startActivity(get_deal_type);

                    } else {
                        alert_message("You are selected " + month_name + " month so please enter date between 1 to 30");
//                        Toast.makeText(this, "You are selected february month so please enter date between 1 to 28", Toast.LENGTH_SHORT).show();
                    }

                } else if (!binding.month.getText().equals("February")) {

                    preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                    preferences.save(edit_date_activity.this, preferences.KEY_Type3, String.valueOf(5));
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
                        preferences.save(edit_date_activity.this, preferences.KEY_Type2, String.valueOf(5));
                        preferences.save(edit_date_activity.this, preferences.KEY_Type3, String.valueOf(5));
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
                        alert_message("You are selected february month so please enter date between 1 to 28");
//                        Toast.makeText(this, "You are selected february month so please enter date between 1 to 28", Toast.LENGTH_SHORT).show();
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
