package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivityTargetBinding;
import com.example.local_coupan.preferences2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Target_activity extends AppCompatActivity {
    ActivityTargetBinding binding;
    preferences2 preferences;
    String flag = "null";
    final String[] listItems = new String[]{"Group A", "Group B", "Group C", "Group D", "Group E"};
    final boolean[] checkedItems = new boolean[listItems.length];
    final List<String> selectedItems = Arrays.asList(listItems);

    String markett = "one";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTargetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

//            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();

            flag = "add";
//          SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            Log.d("marketArray", "onCreate: " + markett);
            markett = sh.getString("marketGropuArray", "");
            String noo = sh.getString("return", "");
            String gender = sh.getString("gender", "");
            String get_min_age = sh.getString("min_age", "");
            String weather = sh.getString("weather", "");
            String get_max_age = sh.getString("max_age", "");
            String get_min_temp = sh.getString("min_temp", "");
            String get_max_temp = sh.getString("max_temp", "");
            String get_journey_type = sh.getString("journey", "");
            String get_location_method = sh.getString("method", "");
            String units = sh.getString("units", "");

            if (get_max_temp.equals("")) {
                binding.txtMaxTemp.setText("50");
            } else {
                binding.txtMaxTemp.setText(get_max_temp);
            }
            if (get_min_temp.equals("")) {
                binding.txtMinTemp.setText("-10");
            } else {
                binding.txtMinTemp.setText(get_min_temp);
            }
            if (get_max_age.equals("")) {
                binding.txtMaxAge.setText("100");
            } else {
                binding.txtMaxAge.setText(get_max_age);
            }

            if (get_min_age.equals("")) {
                binding.txtMinAge.setText("18");
            } else {
                binding.txtMinAge.setText(get_min_age);
            }


            binding.txtTimeToLocationType.setText(pref.getString("D1", ""));
            binding.edtDistance.setText(pref.getString("D2", ""));

            if (weather.equals("")){
                binding.txtWeatherType.setText("Any");
                myEdit.putString("weather", "Any");
                myEdit.apply();
            } else {
                binding.txtWeatherType.setText(weather);
            }

            if (gender.equals("")){
                binding.txtGenderType.setText("Any");
                myEdit.putString("gender", "Any");
                myEdit.apply();
            } else {
                binding.txtGenderType.setText(gender);
            }

            if(get_journey_type.equals("")){
                binding.txtJourneyTypeFineal.setText("Walk");
                myEdit.putString("journey", "Walk");
                myEdit.apply();
            }else {
                binding.txtJourneyTypeFineal.setText(get_journey_type);
            }

            if(get_location_method.equals("")){
                binding.txtLocationMethod.setText("Journey Time");
                myEdit.putString("method","Journey Time");
                myEdit.apply();
            }else {
                binding.txtLocationMethod.setText(get_location_method);
            }
            binding.txtGetUnits.setText(units);

            if (binding.txtLocationMethod.getText().equals("Geofence")) {
                binding.lloutjourneytype.setVisibility(View.GONE);
                binding.llouttimetolocation.setVisibility(View.GONE);
                binding.lloutunits.setVisibility(View.VISIBLE);
                binding.lloutDistance.setVisibility(View.VISIBLE);
            } else if (binding.txtLocationMethod.getText().equals("Journey Time")) {
                binding.lloutjourneytype.setVisibility(View.VISIBLE);
                binding.llouttimetolocation.setVisibility(View.VISIBLE);
                binding.lloutunits.setVisibility(View.GONE);
                binding.lloutDistance.setVisibility(View.GONE);
            }

            binding.imgTargetBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });

            binding.lloutlocationMethod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_location_method = new Intent(Target_activity.this, select_location_method.class);
                    get_location_method.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_location_method.putExtra("type", "1");
                    startActivity(get_location_method);
                }
            });

            binding.lloutGender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_gender_activity.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "1");
                    startActivity(get_gender);

                }
            });

            binding.lloutMessageGroupTarget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_market = new Intent(Target_activity.this, select_market_group_activity.class);
                    get_market.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_market.putExtra("navigate", "target_message");
                    get_market.putExtra("type", "1");
                    startActivity(get_market);
                }
            });

            binding.lloutweather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_weather_activity.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "1");
                    startActivity(get_gender);
                }
            });

            binding.lloutjourneytype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_journey_types = new Intent(Target_activity.this, select_journey_type.class);
                    get_journey_types.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_journey_types.putExtra("type", "1");
                    startActivity(get_journey_types);
                }
            });

            binding.lloutunits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_units = new Intent(Target_activity.this, select_geofence_units.class);
                    get_units.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_units.putExtra("type", "1");
                    startActivity(get_units);
                }
            });

            binding.lloutAge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Target_activity.this, Enter_age_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "1");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutSetTemrecture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Target_activity.this, Enter_temprerture_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "1");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutMarketGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_market = new Intent(Target_activity.this, select_market_group_activity.class);
                    get_market.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_market.putExtra("navigate", "market");
                    get_market.putExtra("type", "1");
                    startActivity(get_market);
                }
            });

        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            flag = "edit";
//            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
//            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
            String location_mthod = sh.getString("method", "");
            String min_age = sh.getString("miiin", "");
            String max_age = sh.getString("maxxxx", "");
            String gender = sh.getString("gender", "");
            String min_temp = sh.getString("tempmin", "");
            String max_temp = sh.getString("tempmax", "");
            String weather = sh.getString("weather", "");
            String market_group = sh.getString("market_group", "");

            Log.d("market_group", "onCreate: " + market_group);

            String distanceUnits = sh.getString("units", "");
            String distancenum = sh.getString("distancenum", "");
            String journeyTime = sh.getString("journeyTime", "");
            String journey_type = sh.getString("journey", "");

            binding.txtLocationMethod.setText(location_mthod);
            binding.txtMinAge.setText(min_age);
            binding.txtMaxAge.setText(max_age);
            binding.txtGenderType.setText(gender);
            binding.txtMinTemp.setText(min_temp);
            binding.txtMaxTemp.setText(max_temp);
            binding.txtWeatherType.setText(weather);

            binding.edtDistance.setText(distancenum);
            binding.txtGetUnits.setText(distanceUnits);
            binding.txtJourneyTypeFineal.setText(journey_type);
            binding.txtTimeToLocationType.setText(journeyTime);

            if (binding.txtLocationMethod.getText().equals("Geofence")) {
                binding.lloutjourneytype.setVisibility(View.GONE);
                binding.llouttimetolocation.setVisibility(View.GONE);
                binding.lloutunits.setVisibility(View.VISIBLE);
                binding.lloutDistance.setVisibility(View.VISIBLE);
            } else if (binding.txtLocationMethod.getText().equals("Journey Time")) {
                binding.lloutjourneytype.setVisibility(View.VISIBLE);
                binding.llouttimetolocation.setVisibility(View.VISIBLE);
                binding.lloutunits.setVisibility(View.GONE);
                binding.lloutDistance.setVisibility(View.GONE);
            }

            binding.imgTargetBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    editback();

                }
            });

            binding.lloutMarketGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_market = new Intent(Target_activity.this, select_market_group_activity.class);
                    get_market.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_market.putExtra("navigate", "market");
                    get_market.putExtra("type", "2");
                    startActivity(get_market);
                }
            });
            binding.lloutMessageGroupTarget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_market = new Intent(Target_activity.this, select_market_group_activity.class);
                    get_market.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_market.putExtra("navigate", "target_message");
                    get_market.putExtra("type", "2");
                    startActivity(get_market);

                }
            });

            binding.lloutSetTemrecture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Target_activity.this, Enter_temprerture_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);
                }
            });
            binding.lloutAge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Target_activity.this, Enter_age_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);
                }
            });
            binding.lloutweather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_weather_activity.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "2");
                    startActivity(get_gender);
                }
            });
            binding.lloutGender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_gender_activity.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "2");
                    startActivity(get_gender);
                }
            });
            binding.lloutlocationMethod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_location_method.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "2");
                    startActivity(get_gender);
                }
            });
            binding.lloutjourneytype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_journey_type.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "2");
                    startActivity(get_gender);
                }
            });
            binding.lloutunits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("D1", binding.txtTimeToLocationType.getText().toString().trim());
                    myEdit.putString("D2", binding.edtDistance.getText().toString().trim());
                    myEdit.apply();
                    Intent get_gender = new Intent(Target_activity.this, select_geofence_units.class);
                    get_gender.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_gender.putExtra("type", "2");
                    startActivity(get_gender);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {

        if (flag.equals("add")) {
            back();
        } else if (flag.equals("edit")) {
            editback();
        }

    }

    public void editback() {
//
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (binding.txtLocationMethod.getText().toString().equals("Journey Time")) {

            if (!binding.txtJourneyTypeFineal.getText().toString().isEmpty()) {

            } else {
                binding.txtJourneyTypeFineal.setError("Please Enter in fields");
            }
            if (!binding.txtTimeToLocationType.getText().toString().isEmpty()) {
            } else {
                binding.txtTimeToLocationType.setError("Please Enter in fields");
            }

        } else if (binding.txtLocationMethod.getText().toString().equals("Geofence")) {

            if (!binding.txtGetUnits.getText().toString().isEmpty()) {
            } else {
                binding.txtGetUnits.setError("Please Enter in fields");
            }
            if (!binding.edtDistance.getText().toString().isEmpty()) {
            } else {
                binding.edtDistance.setError("Please Enter in fields");
            }
        }
        if (binding.txtLocationMethod.getText().toString().equals("Journey Time")) {

            if (!binding.txtLocationMethod.getText().toString().isEmpty() &&
                    !binding.txtMinAge.getText().toString().isEmpty() &&
                    !binding.txtMaxAge.getText().toString().isEmpty() &&
                    !binding.txtWeatherType.getText().toString().isEmpty() &&
                    !binding.txtGenderType.getText().toString().isEmpty() &&
                    !binding.txtMinTemp.getText().toString().isEmpty() &&
//                    !markett.equals("one") &&
//                    !markett.equals("[]") &&
                    !binding.txtMaxTemp.getText().toString().isEmpty() &&
                    !binding.txtJourneyTypeFineal.getText().toString().isEmpty() &&
                    !binding.txtTimeToLocationType.getText().toString().isEmpty()) {

                String txt_location_method = binding.txtLocationMethod.getText().toString();
                String txt_journey_method = binding.txtJourneyTypeFineal.getText().toString();
                String txt_time_to_location_type = binding.txtTimeToLocationType.getText().toString();
//                String get_units = binding.txtGetUnits.getText().toString();
//                String get_distance = binding.edtDistance.getText().toString();
                String txt_gender_type = binding.txtGenderType.getText().toString();
                String txt_weather_type = binding.txtWeatherType.getText().toString();
                String txt_min_temp = binding.txtMinTemp.getText().toString();
                String txt_max_temp = binding.txtMaxTemp.getText().toString();
                String txt_min_age = binding.txtMinAge.getText().toString();
                String txt_max_age = binding.txtMaxAge.getText().toString();


//                Log.d("viru_target", txt_location_method + " " + get_units + txt_journey_method + " " + txt_time_to_location_type + " " + " " + txt_gender_type + " " + txt_weather_type);

//            Bundle args = new Bundle();
//            args.putSerializable("marketArray",(Serializable));
//            get_target.putExtra("BUNDLE",args);

                myEdit.putString("method", txt_location_method);
                myEdit.putString("journey", txt_journey_method);
//                myEdit.putString("get_units_target", get_units);
//                myEdit.putString("get_distance_target", get_distance);
                myEdit.putString("journeyTime", txt_time_to_location_type);

                myEdit.putString("gender", txt_gender_type);
                myEdit.putString("weather", txt_weather_type);

                myEdit.putString("txt_min_age_target", txt_min_age);
                myEdit.putString("txt_max_age_target", txt_max_age);
                myEdit.putString("txt_min_temp_target", txt_min_temp);
                myEdit.putString("txt_max_temp_target", txt_max_temp);
//            myEdit.putString("marketing", markett);

                myEdit.apply();

//            !binding.edtDistance.getText().toString().isEmpty()

                Intent get_add = new Intent(Target_activity.this, Addcoupon_activity.class);
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_add.putExtra("type", "2");
                get_add.putExtra("type2", "30");
                startActivity(get_add);

                finish();

            } else {
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();

            }
        }else if (binding.txtLocationMethod.getText().toString().equals("Geofence")) {
            if (!binding.txtLocationMethod.getText().toString().isEmpty() &&
                    !binding.txtMinAge.getText().toString().isEmpty() &&
                    !binding.txtMaxAge.getText().toString().isEmpty() &&
                    !binding.txtWeatherType.getText().toString().isEmpty() &&
                    !binding.txtGenderType.getText().toString().isEmpty() &&
                    !binding.txtMinTemp.getText().toString().isEmpty() &&
//                    !markett.toString().equals("one") &&
//                    !markett.toString().equals("[]") &&
                    !binding.txtMaxTemp.getText().toString().isEmpty() &&
                    !binding.txtGetUnits.getText().toString().isEmpty() &&
                    !binding.edtDistance.getText().toString().isEmpty()) {



                String txt_location_method = binding.txtLocationMethod.getText().toString();
//                String txt_journey_method = binding.txtJourneyTypeFineal.getText().toString();
//                String txt_time_to_location_type = binding.txtTimeToLocationType.getText().toString();
                String get_units = binding.txtGetUnits.getText().toString();
                String get_distance = binding.edtDistance.getText().toString();
                String txt_gender_type = binding.txtGenderType.getText().toString();
                String txt_weather_type = binding.txtWeatherType.getText().toString();
                String txt_min_temp = binding.txtMinTemp.getText().toString();
                String txt_max_temp = binding.txtMaxTemp.getText().toString();
                String txt_min_age = binding.txtMinAge.getText().toString();
                String txt_max_age = binding.txtMaxAge.getText().toString();


//                Log.d("viru_target", txt_location_method + " " + get_units + txt_journey_method + " " + txt_time_to_location_type + " " + " " + txt_gender_type + " " + txt_weather_type);

//            Bundle args = new Bundle();
//            args.putSerializable("marketArray",(Serializable));
//            get_target.putExtra("BUNDLE",args);

                myEdit.putString("txt_location_method_target", txt_location_method);
//                myEdit.putString("txt_journey_method_target", txt_journey_method);
                myEdit.putString("get_units_target", get_units);
                myEdit.putString("D2", get_distance);
//                myEdit.putString("txt_time_to_location_type_target", txt_time_to_location_type);

                myEdit.putString("txt_gender_type_target", txt_gender_type);
                myEdit.putString("txt_weather_type_target", txt_weather_type);

                myEdit.putString("txt_min_age_target", txt_min_age);
                myEdit.putString("txt_max_age_target", txt_max_age);
                myEdit.putString("txt_min_temp_target", txt_min_temp);
                myEdit.putString("txt_max_temp_target", txt_max_temp);
//            myEdit.putString("marketing", markett);

                myEdit.apply();

//            !binding.edtDistance.getText().toString().isEmpty()

                Intent get_add = new Intent(Target_activity.this, Addcoupon_activity.class);
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_add.putExtra("type", "2");
                get_add.putExtra("type2", "30");
                startActivity(get_add);
                finish();

            }
            else {
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void back() {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (binding.txtLocationMethod.getText().toString().equals("Journey Time")) {

            if (!binding.txtJourneyTypeFineal.getText().toString().isEmpty()) {

            } else {
                binding.txtJourneyTypeFineal.setError("Please Enter in fields");
            }
            if (!binding.txtTimeToLocationType.getText().toString().isEmpty()) {
            } else {
                binding.txtTimeToLocationType.setError("Please Enter in fields");
            }

        } else if (binding.txtLocationMethod.getText().toString().equals("Geofence")) {

            if (!binding.txtGetUnits.getText().toString().isEmpty()) {
            } else {
                binding.txtGetUnits.setError("Please Enter in fields");
            }
            if (!binding.edtDistance.getText().toString().isEmpty()) {
            } else {
                binding.edtDistance.setError("Please Enter in fields");
            }
        }
        if (binding.txtLocationMethod.getText().toString().equals("Journey Time")) {

            if (!binding.txtLocationMethod.getText().toString().isEmpty() &&
                    !binding.txtMinAge.getText().toString().isEmpty() &&
                    !binding.txtMaxAge.getText().toString().isEmpty() &&
                    !binding.txtWeatherType.getText().toString().isEmpty() &&
                    !binding.txtGenderType.getText().toString().isEmpty() &&
                    !binding.txtMinTemp.getText().toString().isEmpty() &&
//                    !markett.equals("one") &&
//                    !markett.equals("[]") &&
                    !binding.txtMaxTemp.getText().toString().isEmpty() &&
                    !binding.txtJourneyTypeFineal.getText().toString().isEmpty() &&
                    !binding.txtTimeToLocationType.getText().toString().isEmpty()) {

                String txt_location_method = binding.txtLocationMethod.getText().toString();
                String txt_journey_method = binding.txtJourneyTypeFineal.getText().toString();
                String txt_time_to_location_type = binding.txtTimeToLocationType.getText().toString();
//                String get_units = binding.txtGetUnits.getText().toString();
//                String get_distance = binding.edtDistance.getText().toString();
                String txt_gender_type = binding.txtGenderType.getText().toString();
                String txt_weather_type = binding.txtWeatherType.getText().toString();
                String txt_min_temp = binding.txtMinTemp.getText().toString();
                String txt_max_temp = binding.txtMaxTemp.getText().toString();
                String txt_min_age = binding.txtMinAge.getText().toString();
                String txt_max_age = binding.txtMaxAge.getText().toString();


//                Log.d("viru_target", txt_location_method + " " + get_units + txt_journey_method + " " + txt_time_to_location_type + " " + " " + txt_gender_type + " " + txt_weather_type);

//            Bundle args = new Bundle();
//            args.putSerializable("marketArray",(Serializable));
//            get_target.putExtra("BUNDLE",args);

                myEdit.putString("txt_location_method_target", txt_location_method);
                myEdit.putString("txt_journey_method_target", txt_journey_method);
                myEdit.putString("D1", txt_time_to_location_type);
                myEdit.putString("txt_gender_type_target", txt_gender_type);
                myEdit.putString("txt_weather_type_target", txt_weather_type);
                myEdit.putString("txt_min_age_target", txt_min_age);
                myEdit.putString("txt_max_age_target", txt_max_age);
                myEdit.putString("txt_min_temp_target", txt_min_temp);
                myEdit.putString("txt_max_temp_target", txt_max_temp);
//            myEdit.putString("marketing", markett);

                myEdit.apply();

//            !binding.edtDistance.getText().toString().isEmpty()

                Intent get_add = new Intent(Target_activity.this, Addcoupon_activity.class);
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_add.putExtra("type", "1");
                get_add.putExtra("type2", "10");
                startActivity(get_add);

                finish();

            } else {
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();

            }
        } else if (binding.txtLocationMethod.getText().toString().equals("Geofence")) {
            if (!binding.txtLocationMethod.getText().toString().isEmpty() &&
                    !binding.txtMinAge.getText().toString().isEmpty() &&
                    !binding.txtMaxAge.getText().toString().isEmpty() &&
                    !binding.txtWeatherType.getText().toString().isEmpty() &&
                    !binding.txtGenderType.getText().toString().isEmpty() &&
                    !binding.txtMinTemp.getText().toString().isEmpty() &&
//                    !markett.toString().equals("one") &&
//                    !markett.toString().equals("[]") &&
                    !binding.txtMaxTemp.getText().toString().isEmpty() &&
                    !binding.txtGetUnits.getText().toString().isEmpty() &&
                    !binding.edtDistance.getText().toString().isEmpty()) {


                String txt_location_method = binding.txtLocationMethod.getText().toString();
//                String txt_journey_method = binding.txtJourneyTypeFineal.getText().toString();
//                String txt_time_to_location_type = binding.txtTimeToLocationType.getText().toString();
                String get_units = binding.txtGetUnits.getText().toString();
                String get_distance = binding.edtDistance.getText().toString();
                String txt_gender_type = binding.txtGenderType.getText().toString();
                String txt_weather_type = binding.txtWeatherType.getText().toString();
                String txt_min_temp = binding.txtMinTemp.getText().toString();
                String txt_max_temp = binding.txtMaxTemp.getText().toString();
                String txt_min_age = binding.txtMinAge.getText().toString();
                String txt_max_age = binding.txtMaxAge.getText().toString();


//                Log.d("viru_target", txt_location_method + " " + get_units + txt_journey_method + " " + txt_time_to_location_type + " " + " " + txt_gender_type + " " + txt_weather_type);

//            Bundle args = new Bundle();
//            args.putSerializable("marketArray",(Serializable));
//            get_target.putExtra("BUNDLE",args);

                myEdit.putString("txt_location_method_target", txt_location_method);
//                myEdit.putString("txt_journey_method_target", txt_journey_method);
                myEdit.putString("get_units_target", get_units);
                myEdit.putString("D2", get_distance);
//                myEdit.putString("txt_time_to_location_type_target", txt_time_to_location_type);

                myEdit.putString("txt_gender_type_target", txt_gender_type);
                myEdit.putString("txt_weather_type_target", txt_weather_type);

                myEdit.putString("txt_min_age_target", txt_min_age);
                myEdit.putString("txt_max_age_target", txt_max_age);
                myEdit.putString("txt_min_temp_target", txt_min_temp);
                myEdit.putString("txt_max_temp_target", txt_max_temp);
//            myEdit.putString("marketing", markett);

                myEdit.apply();

//            !binding.edtDistance.getText().toString().isEmpty()

                Intent get_add = new Intent(Target_activity.this, Addcoupon_activity.class);
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_add.putExtra("type", "1");
                get_add.putExtra("type2", "10");
                startActivity(get_add);

                finish();

            } else {

                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
            }
        }
    }
}