package com.example.local_coupan.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.local_coupan.databinding.ActivityCouponDealBinding;
import com.example.local_coupan.model.preview.Address;
import com.example.local_coupan.preferences2;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Coupon_deal_activity extends AppCompatActivity {

    ActivityCouponDealBinding binding;
    preferences2 preferences;
    String flag = "null";

    String lau_date;
    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponDealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Log.d("devi67", "onCreate: " + getIntent().getStringExtra("type"));
        locationEnabled();

        if (getIntent().getStringExtra("type").equals("1")) {

            flag = "add";
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();

            binding.edtRegularPriceValue.setText(pref.getString("Rprice", ""));
            binding.edtOfferPriceValue.setText(pref.getString("offerpricce", ""));
            binding.txtDescription.setText(pref.getString("Dessss", ""));
            binding.txtMaximumAmount.setText(pref.getString("maxi", ""));
            Log.d("dataaaa", "onCreate: " + pref.getString("maxi", ""));

            binding.edtRegularPriceValue.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String num = binding.edtRegularPriceValue.getText().toString();
                    Log.d("num123", "onTextChanged: " + num);
                    if (num.contains(".") && num.substring(num.indexOf(".") + 1).length() > 2) {
                        binding.edtRegularPriceValue.setText(num.substring(0, num.length() - 1));
                        binding.edtRegularPriceValue.setSelection(binding.edtRegularPriceValue.getText().length());

                    } else {
                        Log.d("num123", "onTextChanged: " + ". is not in the string");
//                        Toast.makeText(Coupon_deal_activity.this, ". is not", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            binding.edtOfferPriceValue.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!binding.edtRegularPriceValue.getText().toString().isEmpty()) {

                        if (binding.edtOfferPriceValue.length() == 0) {

                            Toast.makeText(Coupon_deal_activity.this, "Enter Value ", Toast.LENGTH_SHORT).show();

                        } else {

                            String regular_price = binding.edtRegularPriceValue.getText().toString().trim();
                            float final_regular = Float.parseFloat(regular_price);
                            String offer_price = binding.edtOfferPriceValue.getText().toString().trim();
                            float final_offer = Float.parseFloat(offer_price);

                            if (final_regular < final_offer) {
                                binding.edtOfferPriceValue.setError("Offer Value is more than Regular Value");
                            } else {

                                if (offer_price.contains(".") && offer_price.substring(offer_price.indexOf(".") + 1).length() > 2) {
                                    binding.edtOfferPriceValue.setText(offer_price.substring(0, offer_price.length() - 1));
                                    binding.edtOfferPriceValue.setSelection(binding.edtOfferPriceValue.getText().length());

                                } else {
//                                    binding.edtOfferPriceValue.setError("Enter Value");
                                }
                            }
                        }

                    } else {
                        binding.edtRegularPriceValue.setError("Please Enter Value");
                        Toast.makeText(Coupon_deal_activity.this, "Enter Value in Regular Price", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            binding.txtDescription.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {

                        binding.descriptionSmall.setVisibility(View.VISIBLE);
                        binding.txtDescription.setHint("");
                    } else {
                        binding.txtDescription.setHint("Description");
//                        binding.descriptionSmall.setVisibility(View.GONE);

                        if (binding.txtDescription.getText().toString().isEmpty()) {
                            binding.descriptionSmall.setVisibility(View.GONE);
                        } else {
                            binding.descriptionSmall.setVisibility(View.VISIBLE);
                        }
                    }

                }
            });
            if (binding.txtDescription.getText().toString().isEmpty()) {
                binding.descriptionSmall.setVisibility(View.GONE);
            } else {
                binding.descriptionSmall.setVisibility(View.VISIBLE);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());
            String currentDateandTime2 = sdf2.format(new Date());
            String currentDateandTime3 = sdf3.format(new Date());

            binding.edtDateTimePicker.setText(currentDateandTime);
            if (sh.getString("flag_val", "").equals("from_launch")) {

                String launch_year = sh.getString("launch_year", "");
                String launch_month = sh.getString("launch_month", "");
                String launch_month_num = sh.getString("launch_month_num", "");
                String launch_month_num23 = sh.getString("launch_date_month", "");
                String launch_date = sh.getString("launch_date", "");
                String launch_time = sh.getString("launch_time", "");

                Log.d("launch_time12", "onCreate: " + launch_date + "/" + launch_month_num23 + "/" + launch_year + " " + launch_time);
                binding.edtDateTimePicker.setText(launch_date + "/" + launch_month_num + "/" + launch_year + " " + launch_time);

            }
            else {

                sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
                sdf2 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                sdf3 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                currentDateandTime = sdf.format(new Date());
                currentDateandTime2 = sdf2.format(new Date());
                currentDateandTime3 = sdf3.format(new Date());

                String[] date_split = currentDateandTime.split(" ");
                String only_date = date_split[0];
                String only_time = date_split[1];
                String[] date_break = only_date.split("/");
                String live_date = date_break[0];
                String live_month = date_break[1];
                int live_month1 = Integer.parseInt(live_month);
                String live_year = date_break[2];

                myEdit.putString("launch_year", live_year);
                myEdit.putString("launch_date", live_date);
                myEdit.putString("launch_time", only_time);
                myEdit.putString("launch_month_num", live_month);

                String month_name = "null";

                switch (live_month1) {
                    case 1:
                        month_name = "January";
                        break;
                    case 2:
                        month_name = "February";
                        break;
                    case 3:
                        month_name = "March";
                        break;
                    case 4:
                        month_name = "April";
                        break;
                    case 5:
                        month_name = "May";
                        break;
                    case 6:
                        month_name = "June";
                        break;
                    case 7:
                        month_name = "July";
                        break;
                    case 8:
                        month_name = "August";
                        break;
                    case 9:
                        month_name = "September";
                        break;
                    case 10:
                        month_name = "October";
                        break;
                    case 11:
                        month_name = "Navember";
                        break;
                    case 12:
                        month_name = "December";
                        break;
                    default:
                }

                String final_month = month_name;

                myEdit.putString("launch_month", final_month);
                myEdit.apply();

                binding.edtDateTimePicker.setText(currentDateandTime);

            }

            myEdit.putString("currentDateandTime1", binding.edtDateTimePicker.getText().toString());

            if (preferences2.get(Coupon_deal_activity.this, preferences2.KEY_Type3).equals("5")) {


                String exyeae = sh.getString("expiry_launch_year", "");
                String exmonthh = sh.getString("expiry_launch_month", "");
                String exmonthhnu = sh.getString("expiry_launch_monthnu", "");
                String exdate = sh.getString("expiry_launch_date", "");
                String extime = sh.getString("expiry_launch_time", "");

                binding.edtExpiryDateTime.setText(exdate + "/" + exmonthhnu + "/" + exyeae + " " + extime);

            } else {

                preferences.save(Coupon_deal_activity.this, preferences.KEY_Type3, String.valueOf("5"));

//                Toast.makeText(this, "KEY_value100", Toast.LENGTH_SHORT).show();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.MONTH, 1);
                    Date date = cal.getTime();
                    Log.d("devi4", "onCreate: " + date);
                    @SuppressLint("SimpleDateFormat")
                    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String date1 = format1.format(date);

//                    String exyeae = sh.getString("expiry_launch_year", "");
//                    String exmonthh = sh.getString("expiry_launch_month", "");
//                    String exmonthhnu = sh.getString("expiry_launch_monthnu", "");
//                    String exdate = sh.getString("expiry_launch_date", "");
//                    String extime = sh.getString("expiry_launch_time", "");

                    binding.edtExpiryDateTime.setText(date1);


                    String[] exiry_date_split = date1.split(" ");
                    String expiry_only_date = exiry_date_split[0];
                    String expiry_only_time = exiry_date_split[1];
                    String[] expiry_date_break = expiry_only_date.split("/");
                    String expiry_date = expiry_date_break[0];
                    String expiry_month = expiry_date_break[1];
                    int expiry_month1 = Integer.parseInt(expiry_month);
                    String expiry_year = expiry_date_break[2];

                    String expiry_month_name = "null";

                    switch (expiry_month1) {
                        case 1:
                            expiry_month_name = "January";
                            break;
                        case 2:
                            expiry_month_name = "February";
                            break;
                        case 3:
                            expiry_month_name = "March";
                            break;
                        case 4:
                            expiry_month_name = "April";
                            break;
                        case 5:
                            expiry_month_name = "May";
                            break;
                        case 6:
                            expiry_month_name = "June";
                            break;
                        case 7:
                            expiry_month_name = "July";
                            break;
                        case 8:
                            expiry_month_name = "August";
                            break;
                        case 9:
                            expiry_month_name = "September";
                            break;
                        case 10:
                            expiry_month_name = "October";
                            break;
                        case 11:
                            expiry_month_name = "Navember";
                            break;
                        case 12:
                            expiry_month_name = "December";
                            break;
                        default:
                    }

                    String expiry_final_month = expiry_month_name;
                    myEdit.putString("expiry_launch_year", expiry_year);
                    myEdit.putString("expiry_launch_month", expiry_final_month);
                    myEdit.putString("expiry_launch_monthnu", expiry_month);
                    myEdit.putString("expiry_launch_date", expiry_date);
                    myEdit.putString("expiry_launch_time", expiry_only_time);
                    myEdit.apply();

                }
            }

//            myEdit.putString("currentDateandTime1", currentDateandTime);
            String deal_type = sh.getString("dealtype", "");
            String Currency_type = sh.getString("usd", "");
            String show_calculation = sh.getString("calculation", "");
            String show_share = sh.getString("share", "");
            String show_use = sh.getString("use", "");


            if (deal_type.equals("")) {
                binding.txtDealtypeDiscount.setText("Discount");
                myEdit.putString("dealtype", "Discount");
                myEdit.apply();
            } else {
                binding.txtDealtypeDiscount.setText(deal_type);
            }

            if (deal_type.equalsIgnoreCase("other")) {

                binding.lloutRegular.setVisibility(View.GONE);
                binding.lloutOffer.setVisibility(View.GONE);
                binding.lloutCalculation.setVisibility(View.GONE);

            } else {

                Log.d("hsgfvy", "onCreate: " + deal_type);

            }

            if (Currency_type.equals("")) {

//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//
//                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//                Task<Location> task = fusedLocationProviderClient.getLastLocation();
//
//                task.addOnSuccessListener(new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        if (location != null) {
//                            currentlocation = location;
//                            double latitude = currentlocation.getLatitude();
//                            double longitude = currentlocation.getLongitude();
//                            Log.d("TAG123132", "onSuccess: " + latitude);
//                            Log.d("TAG123132", "onSuccess: " + longitude);
//
//                            Geocoder coder = new Geocoder(Coupon_deal_activity.this);
//                            List<android.location.Address> addresses = null;
//
//                            try {
//                                addresses = coder.getFromLocation(latitude, longitude, 1);
//                                Toast.makeText(Coupon_deal_activity.this, "" + addresses, Toast.LENGTH_SHORT).show();
//                                Log.d("address123", "onSuccess: " + addresses);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//
////                            String Country = addresses.get(0).getCountryName();
//                            String Country_code1 = addresses.get(0).getCountryCode();
//                            Toast.makeText(Coupon_deal_activity.this, "" + Country_code1, Toast.LENGTH_SHORT).show();
////
//                            String currency_type1 = Currency.getInstance(new Locale("", Country_code1)).getCurrencyCode();
                            binding.txtCurrencyType.setText("USD");
                            myEdit.putString("usd", "USD");
                            myEdit.apply();
//                        }
//                    }
//                });

            } else {
                binding.txtCurrencyType.setText(Currency_type);
            }

            binding.txtCalculationPercentage.setText(show_calculation);
            if (show_share.equals("")) {
                binding.checkShare.setChecked(true);
                myEdit.putString("share", "Yes");
                myEdit.apply();
//                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            }
            else {
                if (show_share.equals("Yes")) {
                    binding.checkShare.setChecked(true);
                    myEdit.putString("share", "Yes");
                    myEdit.apply();
//                    Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
                } else {
                    binding.checkShare.setChecked(false);
                    myEdit.putString("share", "No");
                    myEdit.apply();
//                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
                }
            }

            binding.checkShare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {

                        myEdit.putString("share", "Yes");
                        myEdit.apply();

                    } else {

                        myEdit.putString("share", "No");
                        myEdit.apply();

                    }
                }
            });

            if (show_use.equals("")) {
                binding.checkuse.setChecked(false);

                myEdit.putString("use", "No");
                myEdit.apply();
//                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();

            } else {

                if (show_use.equals("Yes")) {
                    binding.checkuse.setChecked(true);
                    myEdit.putString("use", "Yes");
                    myEdit.apply();
//                    Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
                } else {
                    binding.checkuse.setChecked(false);
                    myEdit.putString("use", "No");
                    myEdit.apply();
//                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();

                }
            }

            binding.checkuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        myEdit.putString("use", "Yes");
                        myEdit.apply();
                    } else {
                        myEdit.putString("use", "No");
                        myEdit.apply();
                    }
                }
            });
//            if (binding.checkShare.isChecked()) {
//                myEdit.putString("share", "Yes");
//                myEdit.apply();
//            } else {
//                myEdit.putString("share", "No");
//                myEdit.apply();
//            }


//            if (show_use.equals("")) {
//                binding.txtSingleYes.setText("No");
//                myEdit.putString("use", "No");
//                myEdit.apply();
//            } else {
//                binding.txtSingleYes.setText(show_use);
//            }

            if (pref.getString("maxi", "").equals("")) {
                binding.txtMaximumAmount.setText("1000");
            } else {
                binding.txtMaximumAmount.setText(pref.getString("maxi", ""));
            }


            Log.d("navigate", "onCreate: " + getIntent().getStringExtra("navigate"));

            binding.lloutDealtype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, dealtype_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "1");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, Show_Currency_activity.class);
                    myEdit.apply();
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "1");
                    startActivity(get_dealtype);

                }
            });

            binding.lloutCalculation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
                    myEdit.apply();
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, show_calculation_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "1");
                    startActivity(get_dealtype);
                }
            });
//            binding.lloutShare.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
//                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
//                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
//                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
//                    myEdit.apply();
//                    Intent get_share = new Intent(Coupon_deal_activity.this, share_and_use_activity.class);
//                    get_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_share.putExtra("navigate", "share");
//                    get_share.putExtra("type", "1");
//                    startActivity(get_share);
//                }
//            });

//            binding.lloutUses.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
//                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
//                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
//                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
////                    myEdit.putString("single", binding.txtSingleYes.getText().toString().trim());
//                    myEdit.apply();
//                    Intent get_share = new Intent(Coupon_deal_activity.this, share_and_use_activity.class);
//                    get_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_share.putExtra("type", "1");
//                    get_share.putExtra("navigate", "use");
//
//                    startActivity(get_share);
//                }
//            });
            binding.imgCouponDealBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Coupon_deal_activity.super.onBackPressed();
                    back();
                }
            });

            binding.lloutLaunchDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
                    myEdit.apply();
                    Intent get_expiry_date_time = new Intent(Coupon_deal_activity.this, Launch_date_activity.class);
                    get_expiry_date_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_expiry_date_time.putExtra("type", "2");
                    get_expiry_date_time.putExtra("navigate", "launch");
                    get_expiry_date_time.putExtra("deal", "null");
                    startActivity(get_expiry_date_time);
                }
            });

            binding.lloutExpiryDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                    myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                    myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                    myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());
                    myEdit.apply();
                    Intent get_expiry_date_time = new Intent(Coupon_deal_activity.this, Launch_date_activity.class);
                    get_expiry_date_time.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_expiry_date_time.putExtra("navigate", "expiry");
                    get_expiry_date_time.putExtra("deal", "null");
                    startActivity(get_expiry_date_time);
                }
            });

        }
        else if (getIntent().getStringExtra("type").equals("2")) {

            flag = "edit";
            Log.d("devi5", "onCreate: else");

            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();

            String currency = sh.getString("currency", "");
            String deal_type = sh.getString("dealtype", "");
            String regular_price = sh.getString("regular_price", "");
            String offer_price = sh.getString("offer_price", "");
            String calculation = sh.getString("calculation", "");
            String launchdate = sh.getString("launchdate", "");
            String exprirydate = sh.getString("exprirydate", "");
            String description = sh.getString("description", "");
            String final_launch_time = sh.getString("final_launch_time", "");
            String final_launch_time_full = sh.getString("final_launch_time_FULL", "");
            String final_expiry_time = sh.getString("final_expiry_time", "");
            String maximum_redumption = sh.getString("maximum_redumption", "");
            String can_share = sh.getString("share", "");
            String single = sh.getString("single", "");

            if (can_share.equals("Yes")) {
                binding.checkShare.setChecked(true);
            } else {
                binding.checkShare.setChecked(false);
            }

            if (single.equals("Yes")) {
                binding.checkuse.setChecked(true);
            } else {
                binding.checkuse.setChecked(false);
            }

            binding.checkShare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {

                        myEdit.putString("share", "Yes");
                        myEdit.apply();

                    } else {

                        myEdit.putString("share", "No");
                        myEdit.apply();

                    }
                }
            });

            binding.checkuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                        myEdit.putString("single", "Yes");
                        myEdit.apply();
                    } else {
                        myEdit.putString("single", "No");
                        myEdit.apply();
                    }
                }
            });

            String exdate1 = sh.getString("expiry_date", "");
            String exmonth1 = sh.getString("expiry_month", "");
            String exmonthnum23 = sh.getString("expiry_launch_monthnu", "");
            String exyear1 = sh.getString("expiry_year", "");
            String extime1 = sh.getString("expiry_time_1", "");

            binding.edtExpiryDateTime.setText(exdate1+ "/" + exmonthnum23 + "/" + exyear1 + " " + extime1);
            String year = sh.getString("launch_date_year", "");
            String month = sh.getString("launch_date_month", "");
            String date = sh.getString("launch_date_date", "");
            String year_api = sh.getString("launch_date_year_api", "");
            String month_api = sh.getString("launch_date_month_api", "");
            String date_api = sh.getString("launch_date_date_api", "");
            String time = sh.getString("launch_time_1", "");

            String monthnuol = sh.getString("launch_month_num", "");

//            Toast.makeText(this, ""+monthnuol, Toast.LENGTH_SHORT).show();
//            myEdit.putString("expiry_date", expiry_date);
//            myEdit.putString("expiry_month", expiry_month);
//            myEdit.putString("expiry_year", expiry_year);
//            myEdit.putString("expiry_time_1", expiry_time_1);

            Log.d("viru_deal2", "onResponsefinal_launch_time: " + currency + regular_price + offer_price
                    + can_share + single + calculation + launchdate + exprirydate + maximum_redumption);


            binding.edtDateTimePicker.setText(date + "/" + monthnuol + "/" + year + " " + time);


            lau_date = date_api + "/" + month_api + "/" + year_api;
            Log.d("launch_time12 1 ", "onCreate: " + binding.edtDateTimePicker.getText().toString());
            Log.d("launch_time12 2 ", "onCreate: " + launchdate);
            Log.d("launch_time12 3 ", "onCreate: " + lau_date);
//            binding.edtExpiryDateTime.setText(exprirydate + final_expiry_time);


            if (deal_type.equals("Other")) {
                binding.lloutRegular.setVisibility(View.GONE);
                binding.lloutOffer.setVisibility(View.GONE);
                binding.lloutCalculation.setVisibility(View.GONE);

                binding.edtRegularPriceValue.setText("0");
                binding.edtOfferPriceValue.setText("0");
                binding.txtCalculationPercentage.setText("None");

            } else {
                binding.lloutRegular.setVisibility(View.VISIBLE);
                binding.lloutOffer.setVisibility(View.VISIBLE);
                binding.lloutCalculation.setVisibility(View.VISIBLE);

                binding.edtRegularPriceValue.setText(regular_price);
                binding.edtOfferPriceValue.setText(offer_price);
                binding.txtCalculationPercentage.setText(calculation);
            }
            binding.txtDealtypeDiscount.setText(deal_type);
            binding.txtCurrencyType.setText(currency);

//            binding.edtRegularPriceValue.setText(regular_price);
//            binding.edtOfferPriceValue.setText(offer_price);
//            binding.txtCalculationPercentage.setText(calculation);
            binding.txtDescription.setText(description);
            binding.txtMaximumAmount.setText(maximum_redumption);
//            binding.txtShare.setText(can_share);
//            binding.txtSingleYes.setText(single);

            Log.d("devi69", "onCreate: " + binding.edtExpiryDateTime.getText().toString());

            binding.edtRegularPriceValue.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String edit_title = binding.edtRegularPriceValue.getText().toString();
                    myEdit.putString("regular_price", edit_title);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            binding.edtOfferPriceValue.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String edtOfferPriceValue = binding.edtOfferPriceValue.getText().toString();
                    myEdit.putString("offer_price", edtOfferPriceValue);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            binding.txtDescription.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String description = binding.txtDescription.getText().toString();
                    myEdit.putString("description", description);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            binding.txtMaximumAmount.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String txtMaximumAmount = binding.txtMaximumAmount.getText().toString();
                    myEdit.putString("maximum_redumption", txtMaximumAmount);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            binding.lloutDealtype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, dealtype_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);

                }
            });

            binding.imgCouponDealBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Editback();
                }
            });

//            binding.lloutShare.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, share_and_use_activity.class);
//                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_dealtype.putExtra("type", "2");
//                    get_dealtype.putExtra("navigate", "share");
//                    startActivity(get_dealtype);
//                }
//            });
//            binding.lloutUses.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, share_and_use_activity.class);
//                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_dealtype.putExtra("type", "2");
//                    get_dealtype.putExtra("navigate", "use");
//                    startActivity(get_dealtype);
//                }
//            });
            binding.lloutCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, Show_Currency_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutLaunchDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, edit_date_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    get_dealtype.putExtra("navigate", "launch");
                    get_dealtype.putExtra("deal", "null");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutExpiryDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, edit_date_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_dealtype.putExtra("type", "2");
                    get_dealtype.putExtra("navigate", "expiry");
//                    get_dealtype.putExtra("deal", "null");
                    startActivity(get_dealtype);
                }
            });

            binding.lloutCalculation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(Coupon_deal_activity.this, show_calculation_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if (flag.equals("add")) {
            back();
        } else if (flag.equals("edit")) {
            Editback();
        }
    }

    public void back() {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (!binding.txtDealtypeDiscount.getText().toString().isEmpty() &&
                !binding.txtCurrencyType.getText().toString().isEmpty() &&
//                !binding.txtCalculationPercentage.getText().toString().isEmpty() &&
//                !binding.txtShare.getText().toString().isEmpty() &&
//                !binding.txtSingleYes.getText().toString().isEmpty() &&
                !binding.txtDescription.getText().toString().isEmpty() &&
                !binding.txtMaximumAmount.getText().toString().isEmpty()
//                &&
//                !binding.txtRegularPrice.getText().toString().isEmpty() &&
//                !binding.txtOfferPrice.getText().toString().isEmpty()
        ) {


            //launch date and time
            String launch_deal_year = sh.getString("year_deal", "");
            String launch_deal_month = sh.getString("month_deal", "");
            String launch_deal_date = sh.getString("date_deal", "");
            String launch_deal_time = sh.getString("time_deal", "");

            //expiry date and time

            String expiry_deal_year = sh.getString("expiry_year", "");
            String expiry_deal_month = sh.getString("expiry_month", "");
            String expiry_deal_date = sh.getString("expiry_date", "");
            String expiry_deal_time = sh.getString("expiry_time", "");


            Log.d("final_launch_date", "back:  " + launch_deal_year + " " + launch_deal_month + " " + launch_deal_date + " " + launch_deal_time);
            Log.d("final_expiry_date", "back:  " + expiry_deal_year + " " + expiry_deal_month + " " + expiry_deal_date + " " + expiry_deal_time);


            String dealtype = binding.txtDealtypeDiscount.getText().toString();
            String currency = binding.txtCurrencyType.getText().toString();
            String calculation = binding.txtCalculationPercentage.getText().toString();
//            String share = binding.txtShare.getText().toString();
//            String use = binding.txtSingleYes.getText().toString();
            String Description = binding.txtDescription.getText().toString();
            String maximumamount = binding.txtMaximumAmount.getText().toString();
            String regular_price = binding.edtRegularPriceValue.getText().toString();
            String offer_price = binding.edtOfferPriceValue.getText().toString();
            String expriree_times = binding.edtExpiryDateTime.getText().toString();
            String launch_date = binding.edtDateTimePicker.getText().toString();

            Log.d("launch_date", "back: " + launch_date);

            @SuppressLint("SimpleDateFormat")

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//            Date myDate = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d yy");
//            simpleDateFormat.format(myDate);

            Date launchdate = null;
            Date expirydate = null;

            Date currenctdate = new Date();
            String pattern = "dd/MM/yyyy";
            String dateInString = new SimpleDateFormat(pattern).format(new Date());

            try {

                launchdate = sdf.parse(launch_date);
                expirydate = sdf.parse(expriree_times);
                currenctdate = sdf.parse(dateInString);

                Log.d("date_compare", "back: " + launchdate + "      ");
                Log.d("date_compare", "back: " + currenctdate + "      ");
                Log.d("date_compare", "back: " + dateInString + "      ");

                assert launchdate != null;
                if (currenctdate.compareTo(launchdate) < 0 || currenctdate.compareTo(launchdate) == 0) {

                    if (launchdate.compareTo(expirydate) < 0) {

                        Log.d("date_compare", "back: " + launchdate + " is less than " + expirydate);

                        myEdit.putString("deal_dealtype", dealtype);
                        myEdit.putString("deal_currency", currency);
                        myEdit.putString("deal_calculation", calculation);
//                        myEdit.putString("deal_share", share);
//                        myEdit.putString("deal_use", use);
                        myEdit.putString("deal_Description", Description);
                        myEdit.putString("deal_maximumamount", maximumamount);
                        myEdit.putString("deal_regular_price", regular_price);
                        myEdit.putString("deal_offer_price", offer_price);
                        myEdit.putString("launch_deal_year", launch_deal_year);
                        myEdit.putString("launch_deal_month", launch_deal_month);
                        myEdit.putString("launch_deal_date", launch_deal_date);
                        myEdit.putString("launch_deal_time", launch_deal_time);
                        myEdit.putString("expiry_deal_year", expiry_deal_year);
                        myEdit.putString("expiry_deal_month", expiry_deal_month);
                        myEdit.putString("expiry_deal_date", expiry_deal_date);
                        myEdit.putString("expiry_deal_time", expiry_deal_time);
                        myEdit.putString("expriree_times", expriree_times);

                        myEdit.putString("Rprice", regular_price);
                        myEdit.putString("offerpricce", offer_price);
                        myEdit.putString("Dessss", Description);
                        myEdit.putString("maxi", maximumamount);

                        myEdit.putString("Rprice", binding.edtRegularPriceValue.getText().toString().trim());
                        myEdit.putString("offerpricce", binding.edtOfferPriceValue.getText().toString().trim());
                        myEdit.putString("Dessss", binding.txtDescription.getText().toString().trim());
                        myEdit.putString("maxi", binding.txtMaximumAmount.getText().toString().trim());

                        preferences.save(Coupon_deal_activity.this, preferences.KEY_Type5, String.valueOf(2));
                        myEdit.apply();

                        Intent get_deal_type = new Intent(Coupon_deal_activity.this, Addcoupon_activity.class);
                        get_deal_type.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        get_deal_type.putExtra("type", "1");
                        get_deal_type.putExtra("type2", "35");
                        startActivity(get_deal_type);

                    } else if (launchdate.compareTo(expirydate) > 0 || launchdate.compareTo(expirydate) == 0) {
                        Log.d("date_compare", "back: " + launchdate + " is more than " + expirydate);
                        Toast.makeText(this, "Please Enter Expiry date later than Launch date", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Please Enter Launch date later than Current date", Toast.LENGTH_SHORT).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void Editback() {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (!binding.txtDealtypeDiscount.getText().toString().isEmpty() &&
                !binding.txtCurrencyType.getText().toString().isEmpty() &&
                !binding.txtCalculationPercentage.getText().toString().isEmpty() &&
//                !binding.txtShare.getText().toString().isEmpty() &&
//                !binding.txtSingleYes.getText().toString().isEmpty() &&
                !binding.txtDescription.getText().toString().isEmpty() &&
                !binding.txtMaximumAmount.getText().toString().isEmpty() &&
                !binding.txtRegularPrice.getText().toString().isEmpty() &&
                !binding.txtOfferPrice.getText().toString().isEmpty()
        ) {

            //launch date and time
            String launch_deal_year = sh.getString("year_deal", "");
            String launch_deal_month = sh.getString("month_deal", "");
            String launch_deal_date = sh.getString("date_deal", "");
            String launch_deal_time = sh.getString("time_deal", "");

            //expiry date and time

            String expiry_deal_year = sh.getString("expiry_year", "");
            String expiry_deal_month = sh.getString("expiry_month", "");
            String expiry_deal_date = sh.getString("expiry_date", "");
            String expiry_deal_time = sh.getString("expiry_time", "");

            Log.d("final_launch_date", "back:  " + launch_deal_year + " " + launch_deal_month + " " + launch_deal_date + " " + launch_deal_time);
            Log.d("final_expiry_date", "back:  " + expiry_deal_year + " " + expiry_deal_month + " " + expiry_deal_date + " " + expiry_deal_time);

            String dealtype = binding.txtDealtypeDiscount.getText().toString();
            String currency = binding.txtCurrencyType.getText().toString();
            String calculation = binding.txtCalculationPercentage.getText().toString();
//            String share = binding.checkShare.get().toString();
//            String use = binding.txtSingleYes.getText().toString();
            String Description = binding.txtDescription.getText().toString();
            String maximumamount = binding.txtMaximumAmount.getText().toString();
            String regular_price = binding.edtRegularPriceValue.getText().toString();
            String offer_price = binding.edtOfferPriceValue.getText().toString();
            String expriree_times = binding.edtExpiryDateTime.getText().toString();
            String launch_date = binding.edtDateTimePicker.getText().toString();

            Log.d("launch_date1243", "Editback: " + launch_date);

            @SuppressLint("SimpleDateFormat")

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date launchdate = null;
            Date expirydate = null;

            Date lauchAPI;
//
//            String pattern = "dd/MM/yyyy";
//            String dateInString = new SimpleDateFormat(pattern).format(new Date());

            try {
                lauchAPI = sdf.parse(lau_date);
                launchdate = sdf.parse(launch_date);
                expirydate = sdf.parse(expriree_times);
                Log.d("date_compare 1 ", "back: " + lauchAPI + "    kh   " + lau_date);

//                Log.d("date_compare 1 ", "back: " + launch_date);
                Log.d("date_compare 2 ", "back: " + launchdate + " ");

                assert launchdate != null;
//                if (currenctdate.compareTo(launchdate) < 0) {
//                    Toast.makeText(this, "yess succes", Toast.LENGTH_SHORT).show();

                if (launchdate.compareTo(lauchAPI) > 0 || launchdate.compareTo(lauchAPI) == 0) {

                    if (launchdate.compareTo(expirydate) < 0) {
//                    Toast.makeText(this, "" + launchdate + " is less than " + expirydate, Toast.LENGTH_SHORT).show();
                        Log.d("date_compare", "back: " + launchdate + " is less than " + expirydate);

//                        Log.d("edit_dara", "Editback: " + dealtype + currency + calculation + share + use + Description + maximumamount + regular_price + offer_price + expriree_times);

                        myEdit.putString("expriree_times", expriree_times);
                        myEdit.putString("edtDateTimePicker_time", launch_date);
                        myEdit.putString("dealtype", dealtype);
                        myEdit.putString("currency", currency);
                        myEdit.putString("calculation", calculation);

//                        if (binding.checkShare.isChecked()) {
//                            myEdit.putString("share", "Yes");
//                            myEdit.apply();
//                        } else {
//                            myEdit.putString("share", "No");
//                            myEdit.apply();
//                        }
//
//                        if (binding.checkuse.isChecked()) {
//                            myEdit.putString("use", "Yes");
//                            myEdit.apply();
//                        } else {
//                            myEdit.putString("use", "No");
//                            myEdit.apply();
//                        }

                        //                        myEdit.putString("share", share);
                        //                        myEdit.putString("use", use);
                        myEdit.putString("description", Description);
                        myEdit.putString("maximum_redumption", maximumamount);
                        myEdit.putString("regular_price", regular_price);
                        myEdit.putString("offer_price", offer_price);
                        myEdit.putString("launch_deal_year", launch_deal_year);
                        myEdit.putString("launch_deal_month", launch_deal_month);
                        myEdit.putString("launch_deal_date", launch_deal_date);
                        myEdit.putString("final_launch_time", launch_deal_time);
                        myEdit.putString("expiry_deal_year", expiry_deal_year);
                        myEdit.putString("expiry_deal_month", expiry_deal_month);
                        myEdit.putString("expiry_deal_date", expiry_deal_date);
                        myEdit.putString("final_expiry_time", expiry_deal_time);
                        myEdit.putString("exprirydate", expriree_times);
                        myEdit.putString("launchdate", expriree_times);
                        preferences.save(Coupon_deal_activity.this, preferences.KEY_Type5, String.valueOf(2));
                        myEdit.apply();

                        Intent get_deal_type = new Intent(Coupon_deal_activity.this, Addcoupon_activity.class);
                        get_deal_type.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        get_deal_type.putExtra("type", "2");
                        get_deal_type.putExtra("type2", "30");
                        startActivity(get_deal_type);

                    } else if (launchdate.compareTo(expirydate) > 0 || launchdate.compareTo(expirydate) == 0) {
                        Log.d("date_compare", "back: " + launchdate + " is more than " + expirydate);
                        Toast.makeText(this, "Please Enter Expiry date later than Launch date", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(this, "Selected Launch Date is earlier than coupon creation date.", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(Coupon_deal_activity.this)
                    .setMessage("GPS Enable")
                    .setPositiveButton("Settings", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            locationEnabled();
                        }
                    })
                    .show();
        }
    }
}
