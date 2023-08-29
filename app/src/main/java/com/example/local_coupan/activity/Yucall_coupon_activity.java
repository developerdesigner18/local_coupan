package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.example.local_coupan.databinding.ActivityYucallCouponBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class Yucall_coupon_activity extends AppCompatActivity {

    ActivityYucallCouponBinding binding;

    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYucallCouponBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationEnabled();
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        if (getIntent().getStringExtra("type").equals("1")) {

            String edtTermsDescription1 = sh.getString("edtyucalTermsDescription", "");
            binding.yucallTermsss.setText(edtTermsDescription1);

//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//
//            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//            Task<Location> task = fusedLocationProviderClient.getLastLocation();
//
//            task.addOnSuccessListener(new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
//                    if (location != null) {
//                        currentlocation = location;
//                        double latitude = currentlocation.getLatitude();
//                        double longitude = currentlocation.getLongitude();
//                        Log.d("TAG123132", "onSuccess: " + latitude);
//                        Log.d("TAG123132", "onSuccess: " + longitude);
//
//                        Geocoder coder = new Geocoder(Yucall_coupon_activity.this);
//                        List<Address> addresses = null;
//
//                        try {
//                            addresses = coder.getFromLocation(latitude, longitude, 1);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                            String Country = addresses.get(0).getCountryName();
//                        String Country_code1=addresses.get(0).getCountryCode();
//                            Toast.makeText(Coupon_deal_activity.this, "" + Country_code1, Toast.LENGTH_SHORT).show();
//
//                        String currency_type1 = Currency.getInstance(new Locale("", Country_code1)).getCurrencyCode();
//
//                        binding.txtLocationName.setText(Country);
//                        myEdit.putString("terms_country", Country);
//                        myEdit.apply();
//                    }
//                }
//            });

            binding.imgYucallBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String edtTermsDescription = binding.yucallTermsss.getText().toString();

                    Log.d("viru_budget", edtTermsDescription);
                    myEdit.putString("edtyucalTermsDescription", edtTermsDescription);

                    Log.d("viru_budget2", edtTermsDescription);

                    myEdit.apply();
                    Intent get_terms = new Intent(Yucall_coupon_activity.this, Terms_activity.class);
                    get_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_terms.putExtra("type", "1");
                    get_terms.putExtra("type2", "10");
                    startActivity(get_terms);
                    finish();
                }
            });


        } else if (getIntent().getStringExtra("type").equals("2")) {

            String country = sh.getString("terms_country", "");

            binding.txtLocationName.setText(country);

            binding.imgYucallBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }
    private void locationEnabled () {
        LocationManager lm = (LocationManager)
                getSystemService(Context. LOCATION_SERVICE ) ;
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager. GPS_PROVIDER ) ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager. NETWORK_PROVIDER ) ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(Yucall_coupon_activity.this )
                    .setMessage( "GPS Enable" )
                    .setPositiveButton( "Settings" , new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick (DialogInterface paramDialogInterface , int paramInt) {
                                    startActivity( new Intent(Settings. ACTION_LOCATION_SOURCE_SETTINGS )) ;
                                }
                            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            locationEnabled();
                        }
                    })
                    .show() ;
        }
    }
}