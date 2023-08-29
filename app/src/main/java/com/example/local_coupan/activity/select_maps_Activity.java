package com.example.local_coupan.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivitySelectMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.junit.internal.runners.statements.Fail;

import java.util.Locale;

public class select_maps_Activity extends FragmentActivity implements OnMapReadyCallback {

    ActivitySelectMapsBinding binding;
    String maping = "no";

    private int locationRequestCode = 1000;
    private double wayLatitude = 0.0, wayLongitude = 0.0;

    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    String Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(select_maps_Activity.this);

        Log.d("intent123", "onCreate: " + getIntent().getStringExtra("type"));

        if (getIntent().getStringExtra("type").equals("1")) {
            fetchLastLocation();
//            Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();

            maping = "one";

        } else if (getIntent().getStringExtra("type").equals("2")) {

            fetchLastLocation();
//            Toast.makeText(this, "two three", Toast.LENGTH_SHORT).show();
            maping = "two";

        } else if (getIntent().getStringExtra("type").equals("3")) {
            fetchLastLocation();
//            Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
            maping = "three";
        }
        binding.imgMapsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void fetchLastLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(select_maps_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        Log.d("fusedLocationProviderClient", "fetchLastLocation: " + fusedLocationProviderClient.getLastLocation());

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentlocation = location;
//                        Toast.makeText(select_maps_Activity.this, "Fetch2", Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.select_map);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(select_maps_Activity.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        if (maping.equals("one")) {

            String loccaa = sh.getString("new_location", "");

            String adEdLa = pref.getString("latitude", "");
            String adEdLo = pref.getString("longitude", "");
            Log.d("adEdLocheck", "onMapReady: " + adEdLo);
            if (loccaa.equals("first")) {
                Log.d("map_pin", "onMapReady: " + getIntent().getStringExtra("map_pin"));
                if (getIntent().getStringExtra("map_pin").equals("current")) {

                    LatLng current_latlang = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
                    MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");

                    String latitude = String.valueOf(currentlocation.getLatitude());

                    String longitude = String.valueOf(currentlocation.getLongitude());
                    Log.d("latlang", "onMapReady: " + currentlocation.getLatitude() + currentlocation.getLongitude());

                    myEdit.putString("latitude", latitude);
                    myEdit.putString("longitude", longitude);

                    myEdit.apply();
                    Float zoomLevel = googleMap.getCameraPosition().zoom;
                    Log.d("zoomlevel", "onMapClick: " + zoomLevel);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(current_latlang));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current_latlang, 19));
                    googleMap.addMarker(markerOptions);

                } else if (!adEdLo.isEmpty()) {

                    Double pinnn1 = Double.valueOf(sh.getString("latitude", ""));
                    Double pinnn2 = Double.valueOf(sh.getString("longitude", ""));
//                    Toast.makeText(this, "add edit " + pinnn1, Toast.LENGTH_SHORT).show();

                    Log.d("latlang", "onMapReady: " + pinnn1 + pinnn2);

//            LatLng latLng = new LatLng(pinnn1, pinnn2);
                    LatLng current_latlang = new LatLng(pinnn1, pinnn2);

                    MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(current_latlang));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current_latlang, 19));
                    googleMap.addMarker(markerOptions);

                } else if (getIntent().getStringExtra("map_pin").equals("address")) {

                    String latitude = sh.getString("latitude123", "");
                    String longitude = sh.getString("longitude123", "");

                    double l1 = Double.parseDouble(latitude);
                    double l2 = Double.parseDouble(longitude);

                    LatLng select_latlang = new LatLng(l1, l2);

                    myEdit.putString("latitude", latitude);
                    myEdit.putString("longitude", longitude);

                    myEdit.apply();

                    MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                    googleMap.addMarker(markerOptions2);

                } else {

                    Double pinnn1 = Double.valueOf(sh.getString("latitude", ""));
                    Double pinnn2 = Double.valueOf(sh.getString("longitude", ""));

                    Log.d("latlang", "onMapReady: " + pinnn1 + pinnn2);

//            LatLng latLng = new LatLng(pinnn1, pinnn2);
                    LatLng current_latlang = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());

                    MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(current_latlang));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current_latlang, 19));
                    googleMap.addMarker(markerOptions);

                }

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    public void onMapClick(@NonNull LatLng point) {

                        myEdit.putString("new_location", "second");
                        myEdit.apply();

                        googleMap.clear();

//                Toast.makeText(select_maps_Activity.this, point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
                        Log.d("viru_map", "onMapClick: " + point.latitude + " " + point.longitude);

                        String latitude = String.valueOf(point.latitude);
                        String longitude = String.valueOf(point.longitude);

                        double latval = Double.parseDouble(latitude);
                        double longval = Double.parseDouble(longitude);

                        LatLng sydney = new LatLng(latval, longval);

                        Log.d("viru_map1", "onMapClick: " + sydney);
                        googleMap.addMarker(new MarkerOptions().position(sydney));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                        Float zoomLevel = googleMap.getCameraPosition().zoom;
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 19));
                        myEdit.putString("selected_pin", String.valueOf(sydney));
                        myEdit.apply();
                        Log.d("viru_map", "onMapClick: " + latitude + " " + longitude);

                        String address1 = sh.getString("address1", "");
                        String address2 = sh.getString("address2", "");
                        String town_city = sh.getString("town_city", "");
                        String postcode = sh.getString("postcode", "");

                        myEdit.putString("latitude", latitude);
                        myEdit.putString("longitude", longitude);
                        myEdit.putString("address1", address1);
                        myEdit.putString("address2", address2);
                        myEdit.putString("town_city", town_city);
                        myEdit.putString("postcode", postcode);
                        myEdit.apply();
                    }
                });
            }

        } else if (maping.equals("two")) {
            String edit_lati = sh.getString("edit_latitude", "");
            String edit_longi = sh.getString("edit_longitude", "");

            Log.d("latitude", "onMapReady: " + edit_lati + " " + edit_longi);
            LatLng current_latlang1 = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
            Log.d("current_location", "onMapReady: " + current_latlang1);

            if (edit_lati.equals("0") || edit_longi.equals("0")) {

//                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                LatLng current_latlang = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");
                String latitude = String.valueOf(currentlocation.getLatitude());

                String longitude = String.valueOf(currentlocation.getLongitude());
                Log.d("latlang", "onMapReady: " + currentlocation.getLatitude() + currentlocation.getLongitude());

//                Toast.makeText(this, "" +  latitude + " " + longitude , Toast.LENGTH_SHORT).show();
                myEdit.putString("edit_latitude", latitude);
                myEdit.putString("edit_longitude", longitude);

                myEdit.apply();
                Float zoomLevel = googleMap.getCameraPosition().zoom;
                Log.d("zoomlevel", "onMapClick: " + zoomLevel);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(current_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current_latlang, 19));
                googleMap.addMarker(markerOptions);

            } else if (!edit_lati.isEmpty()) {

//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                double lat = Double.parseDouble(edit_lati);
                double lang = Double.parseDouble(edit_longi);

                LatLng select_latlang = new LatLng(lat, lang);

                myEdit.putString("edit_latitude", String.valueOf(lat));
                myEdit.putString("edit_longitude", String.valueOf(lang));
                myEdit.apply();

//                Toast.makeText(this, "" + select_latlang, Toast.LENGTH_SHORT).show();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);

            } else if (getIntent().getStringExtra("map_pin").equals("address")) {

//                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                String latitude = sh.getString("latitude123", "");
                String longitude = sh.getString("longitude123", "");
//                String latitude = sh.getString("edit_latitude", "");
//                String longitude = sh.getString("edit_longitude", "");
//                Toast.makeText(this, " m " + latitude, Toast.LENGTH_SHORT).show();
                double l1 = Double.parseDouble(latitude);
                double l2 = Double.parseDouble(longitude);

                LatLng select_latlang = new LatLng(l1, l2);

                myEdit.putString("edit_latitude", latitude);
                myEdit.putString("edit_longitude", longitude);

                myEdit.apply();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);

            } else {
//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                double lat = Double.parseDouble(edit_lati);
                double lang = Double.parseDouble(edit_longi);

                LatLng select_latlang = new LatLng(lat, lang);

                myEdit.putString("edit_latitude", String.valueOf(lat));
                myEdit.putString("edit_longitude", String.valueOf(lang));
                myEdit.apply();

//                Toast.makeText(this, "" + select_latlang, Toast.LENGTH_SHORT).show();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);
            }

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                public void onMapClick(@NonNull LatLng point) {

                    myEdit.putString("new_location", "second");
                    myEdit.apply();

                    googleMap.clear();

//                Toast.makeText(select_maps_Activity.this, point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
                    Log.d("viru_map", "onMapClick: " + point.latitude + " " + point.longitude);

                    String latitude = String.valueOf(point.latitude);
                    String longitude = String.valueOf(point.longitude);

                    double latval = Double.parseDouble(latitude);
                    double longval = Double.parseDouble(longitude);

                    LatLng sydney = new LatLng(latval, longval);

                    Log.d("viru_map1", "onMapClick: " + sydney);
                    googleMap.addMarker(new MarkerOptions().position(sydney));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    Float zoomLevel = googleMap.getCameraPosition().zoom;
                    Log.d("zoomlevel", "onMapClick: " + zoomLevel);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 19));
                    myEdit.putString("selected_pin", String.valueOf(sydney));
                    myEdit.apply();
                    Log.d("viru_map", "onMapClick: " + latitude + " " + longitude);

                    myEdit.putString("edit_latitude", latitude);
                    myEdit.putString("edit_longitude", longitude);
                    myEdit.apply();
                }
            });
        } else if (maping.equals("three")) {
            String edit_lati = sh.getString("edit_latitude", "");
            String edit_longi = sh.getString("edit_longitude", "");

            Log.d("latitude", "onMapReady: " + edit_lati + " " + edit_longi);
            LatLng current_latlang1 = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
            Log.d("current_location", "onMapReady: " + current_latlang1);

            if (edit_lati.equals("0") || edit_longi.equals("0")) {
//                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                LatLng current_latlang = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");
                String latitude = String.valueOf(currentlocation.getLatitude());

                String longitude = String.valueOf(currentlocation.getLongitude());
                Log.d("latlang", "onMapReady: " + currentlocation.getLatitude() + currentlocation.getLongitude());

//                Toast.makeText(this, "" +  latitude + " " + longitude , Toast.LENGTH_SHORT).show();
                myEdit.putString("edit_latitude", latitude);
                myEdit.putString("edit_longitude", longitude);

                myEdit.apply();
                Float zoomLevel = googleMap.getCameraPosition().zoom;
                Log.d("zoomlevel", "onMapClick: " + zoomLevel);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(current_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(current_latlang, 19));
                googleMap.addMarker(markerOptions);

            } else if (!edit_lati.isEmpty()) {
//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                double lat = Double.parseDouble(edit_lati);
                double lang = Double.parseDouble(edit_longi);

                LatLng select_latlang = new LatLng(lat, lang);

                myEdit.putString("edit_latitude", String.valueOf(lat));
                myEdit.putString("edit_longitude", String.valueOf(lang));
                myEdit.apply();

//                Toast.makeText(this, "" + select_latlang, Toast.LENGTH_SHORT).show();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);
            } else if (getIntent().getStringExtra("map_pin").equals("address")) {
//                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                String latitude = sh.getString("latitude123", "");
                String longitude = sh.getString("longitude123", "");
//                String latitude = sh.getString("edit_latitude", "");
//                String longitude = sh.getString("edit_longitude", "");
//                Toast.makeText(this, " m " + latitude, Toast.LENGTH_SHORT).show();
                double l1 = Double.parseDouble(latitude);
                double l2 = Double.parseDouble(longitude);

                LatLng select_latlang = new LatLng(l1, l2);

                myEdit.putString("edit_latitude", latitude);
                myEdit.putString("edit_longitude", longitude);

                myEdit.apply();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);

            } else {
//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                double lat = Double.parseDouble(edit_lati);
                double lang = Double.parseDouble(edit_longi);

                LatLng select_latlang = new LatLng(lat, lang);

                myEdit.putString("edit_latitude", String.valueOf(lat));
                myEdit.putString("edit_longitude", String.valueOf(lang));
                myEdit.apply();

//                Toast.makeText(this, "" + select_latlang, Toast.LENGTH_SHORT).show();

                MarkerOptions markerOptions2 = new MarkerOptions().position(select_latlang).title("I am Here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(select_latlang));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(select_latlang, 19));
                googleMap.addMarker(markerOptions2);
            }

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                public void onMapClick(@NonNull LatLng point) {

                    myEdit.putString("new_location", "second");
                    myEdit.apply();

                    googleMap.clear();

//                Toast.makeText(select_maps_Activity.this, point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
                    Log.d("viru_map", "onMapClick: " + point.latitude + " " + point.longitude);

                    String latitude = String.valueOf(point.latitude);
                    String longitude = String.valueOf(point.longitude);

                    double latval = Double.parseDouble(latitude);
                    double longval = Double.parseDouble(longitude);

                    LatLng sydney = new LatLng(latval, longval);

                    Log.d("viru_map1", "onMapClick: " + sydney);
                    googleMap.addMarker(new MarkerOptions().position(sydney));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    Float zoomLevel = googleMap.getCameraPosition().zoom;
                    Log.d("zoomlevel", "onMapClick: " + zoomLevel);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 19));
                    myEdit.putString("selected_pin", String.valueOf(sydney));
                    myEdit.apply();
                    Log.d("viru_map", "onMapClick: " + latitude + " " + longitude);

                    myEdit.putString("edit_latitude", latitude);
                    myEdit.putString("edit_longitude", longitude);
                    myEdit.apply();
                }
            });
        }

    }

    @Override
    public void onBackPressed() {

        if (maping.equals("one")) {
//            Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            Intent get_location = new Intent(select_maps_Activity.this, location_activity.class);
            get_location.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            String latitude = sh.getString("latitude", "");
            String longitude = sh.getString("longitude", "");

            String address1 = getIntent().getStringExtra("address1");
            String address2 = getIntent().getStringExtra("address2");
            String town_city = getIntent().getStringExtra("town_city");
            String postcode = getIntent().getStringExtra("postcode");
            String opening_times = getIntent().getStringExtra("opening_times");

            Log.d("dynamic_data", "onMapClick: " + address1 + address1 + town_city + postcode + opening_times);

            get_location.putExtra("address1", address1);
            get_location.putExtra("address2", address2);
            get_location.putExtra("town_city", town_city);
            get_location.putExtra("postcode", postcode);
            get_location.putExtra("opening_times", opening_times);
            get_location.putExtra("Array", String.valueOf(Array));
            Log.d("latlang", "onClick: " + latitude + " " + longitude);

            get_location.putExtra("navigate", "null");
            get_location.putExtra("type", "1");
            startActivity(get_location);
        } else if (maping.equals("two")) {
//            Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
            Intent getlocation = new Intent(select_maps_Activity.this, location_activity.class);
            getlocation.putExtra("type", "2");
            getlocation.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(getlocation);
        } else if (maping.equals("three")) {
//            Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
            Intent getlocation = new Intent(select_maps_Activity.this, location_activity.class);
            getlocation.putExtra("type", "3");
            getlocation.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(getlocation);
        }
    }
}