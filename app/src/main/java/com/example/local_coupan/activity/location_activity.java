package com.example.local_coupan.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.local_coupan.databinding.ActivityLocationBinding;
import com.example.local_coupan.preferences2;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.GeoPoint;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class location_activity extends AppCompatActivity {

    ActivityLocationBinding binding;
    public int GALLERY_REQ_CODE;
    JSONArray jsonArray2 = new JSONArray();
    preferences2 preferences;
    String arraytext;
    String campareimg = "no";
    private Bitmap bitmap, bt7, bitmap5;
    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    MultipartBody.Part part;
    File f;
    String flag = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationEnabled();
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        binding.dash.setVisibility(View.GONE);

        Log.d("devi5", "onCreate: " + getIntent().getStringExtra("type"));

        if (getIntent().getStringExtra("type").equals("1")) {

            flag = "1";
            Bundle b = getIntent().getExtras();
            arraytext = b.getString("Array");
            String bitmap6 = preferences.get(location_activity.this, preferences.KEY_lbitmap);
            Bitmap btt = StringToBitMap(bitmap6);
            binding.imgFromUserLocation.setImageBitmap(btt);
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            Log.d("llimages", "onCreate: " + btt);

            String latitude = sh.getString("latitude", "");
            String longitude = sh.getString("longitude", "");
            String country = sh.getString("country", "");
            String address1 = sh.getString("address1", "");
            String address2 = sh.getString("address2", "");
            String town_city = sh.getString("town_city", "");
            String postcode = sh.getString("postcode", "");
            String opening_times = sh.getString("opening_times", "");

//            Toast.makeText(this, "" + latitude, Toast.LENGTH_SHORT).show();

            if (!latitude.isEmpty() && !longitude.isEmpty()) {

                String final_latitude = latitude.substring(0, 6);
                String final_longitude = longitude.substring(0, 6);

                binding.txtLatitude.setText(final_latitude);
                binding.txtLongitude.setText(final_longitude);

            }

            if (country.equals("")) {

//                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                Task<Location> task = fusedLocationProviderClient.getLastLocation();
////
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
//                            Geocoder coder = new Geocoder(location_activity.this);
//                            List<android.location.Address> addresses = null;
//
//                            try {
//                                addresses = coder.getFromLocation(latitude, longitude, 1);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//
//                            String Country = addresses.get(0).getCountryName();
//                            String Country_code1 = addresses.get(0).getCountryCode();
//                            Toast.makeText(Coupon_deal_activity.this, "" + Country_code1, Toast.LENGTH_SHORT).show();
//
//                            String currency_type1 = Currency.getInstance(new Locale("", Country_code1)).getCurrencyCode();
////
                            binding.txtCountryName.setText("UK");
                            myEdit.putString("country", "United Kingdom");
//                            Toast.makeText(location_activity.this, "if" + Country, Toast.LENGTH_SHORT).show();

                            myEdit.apply();
//                        }
//                    }
//                });
            } else {
                binding.txtCountryName.setText(country);
                myEdit.putString("country",country);
                myEdit.apply();
//                Toast.makeText(this, "else " + country, Toast.LENGTH_SHORT).show();
            }
            binding.edtAddress1.setText(address1);
            binding.edtAddress2.setText(address2);
            binding.edtTownCity.setText(town_city);
            binding.edtPostcode.setText(postcode);
            binding.edtOpningtimes.setText(opening_times);

//            binding.cardAddCoupon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent get_add = new Intent(location_activity.this, Addcoupon_activity.class);
//                    preferences.save(location_activity.this, preferences.KEY_Type4, String.valueOf(6));
//                    get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                    SharedPreferences.Editor myEdit = pref.edit();
//                    String jsonArray2 = sh.getString("location_datas", "");
//                    String latitude = binding.txtLatitude.getText().toString();
//                    String longitude = binding.txtLongitude.getText().toString();
//                    String country = binding.txtCountryName.getText().toString();
//                    myEdit.putString("Array_location", jsonArray2);
//                    myEdit.putString("address1", String.valueOf(binding.edtAddress1.getText().toString()));
//                    myEdit.putString("address2", String.valueOf(binding.edtAddress2.getText().toString()));
//                    myEdit.putString("town_city", String.valueOf(binding.edtTownCity.getText().toString()));
//                    myEdit.putString("postcode", String.valueOf(binding.edtPostcode.getText().toString()));
//                    myEdit.putString("opening_times", String.valueOf(binding.edtOpningtimes.getText().toString()));
////                    myEdit.putString("latitude", String.valueOf(binding.txtLatitude.getText().toString()));
////                    myEdit.putString("longitude", String.va   lueOf(binding.txtLongitude.getText().toString()));
//                    myEdit.putString("country", String.valueOf(binding.txtCountryName.getText().toString()));
//
//                    myEdit.apply();
//                    Log.d("devi6 l ", "onClick: " + binding.edtAddress1.getText().toString());
//                    get_add.putExtra("Array_location", String.valueOf(jsonArray2));
//                    get_add.putExtra("type", "1");
//                    get_add.putExtra("type2", "10");
//                    startActivity(get_add);
//                    Log.d("deviaddd 1", "onClick: 2 " + jsonArray2);
//
//                }
//            });

            binding.lloutLocationOnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();
                    String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
                    String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
                    String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
                    String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
                    String country = binding.txtCountryName.getText().toString();

                    String full_address = address1 + address2 + town_city + postcode;

                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = pref.edit();

                    myEdit.putString("address1", address1);
                    myEdit.putString("address2", address2);
                    myEdit.putString("town_city", town_city);
                    myEdit.putString("postcode", postcode);
                    myEdit.putString("opening_times", opening_times);

                    myEdit.putString("new_location", "first");
                    myEdit.apply();

                    Log.d("location_setting", "onClick: " + binding.txtLatitude.getText().toString() + " " + binding.txtLatitude.getText().toString());

                    if (!binding.txtLatitude.getText().toString().equals("") || !binding.txtLongitude.getText().toString().equals("")) {
//
//                        Toast.makeText(location_activity.this, "Address22", Toast.LENGTH_SHORT).show();

//                        String latitude123 = binding.txtLatitude.getText().toString();
//                        String longitude123 = binding.txtLongitude.getText().toString();

                        String latitude123 = pref.getString("latitude123", "");
                        String longitude123 = pref.getString("longitude123", "");
                        myEdit.putString("latitude123", latitude123);
                        myEdit.putString("longitude123", longitude123);
                        myEdit.apply();

                        Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                        get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        get_map.putExtra("type", "1");
                        get_map.putExtra("map_pin", "address");
                        startActivity(get_map);
                    } else if (address1.isEmpty() && town_city.isEmpty() && postcode.isEmpty() && country.isEmpty()) {

//                        Toast.makeText(location_activity.this, "current", Toast.LENGTH_SHORT).show();

//                        Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
//                        get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                        get_map.putExtra("type", "1");
//                        get_map.putExtra("map_pin", "current");
//                        startActivity(get_map);
                        getLocationFromAddress(full_address, "1");


                    } else if (!address1.isEmpty() && !town_city.isEmpty() && !postcode.isEmpty()) {

                        getLocationFromAddress(full_address, "1");

                    } else {
                        Toast.makeText(location_activity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            binding.lloutImgUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Build.VERSION.SDK_INT >= 23) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            selectImage();
                        } else {
                            ActivityCompat.requestPermissions(location_activity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        }
                    }
                }
            });
            binding.imgLocationBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
            binding.lloutcountry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent get_country = new Intent(location_activity.this, select_country_activity.class);
                    get_country.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
                    String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
                    String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
                    String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
                    String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();

                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = pref.edit();

                    myEdit.putString("address1", address1);
                    myEdit.putString("address2", address2);
                    myEdit.putString("town_city", town_city);
                    myEdit.putString("postcode", postcode);

//                    String country = binding.txtCountryName.getText().toString();
//                    myEdit.putString("country", country);

                    myEdit.putString("opening_times", opening_times);
                    myEdit.apply();
//                    myEdit.putString("Array", String.valueOf(jsonArray2));

                    get_country.putExtra("type", "1");
                    startActivity(get_country);
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("2")) {

            flag = "2";
//            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//            SharedPreferences.Editor myEdit = pref.edit();
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String adress1 = sh.getString("address1", "");
            String adress2 = sh.getString("address2", "");
            String town_city = sh.getString("town_city", "");
            String country = sh.getString("country", "");
            String location = sh.getString("location", "");
            String opening_time = sh.getString("opening_time", "");
            String location_image = sh.getString("location_image", "");
            String postcode = sh.getString("postcode", "");

            String latitude = sh.getString("edit_latitude", "");
            String longitude = sh.getString("edit_longitude", "");

            Log.d("viru_location", "onCreate: " + adress2 + adress1 + town_city + country + location + opening_time + location_image);

            binding.edtAddress1.setText(adress1);
            binding.edtAddress2.setText(adress2);
            binding.edtTownCity.setText(town_city);
            binding.txtCountryName.setText(country);
            binding.edtOpningtimes.setText(opening_time);
            binding.edtPostcode.setText(postcode);

            if (latitude.equals("0") || longitude.equals("0")) {
                binding.txtLatitude.setVisibility(View.INVISIBLE);
                binding.txtLongitude.setVisibility(View.INVISIBLE);
            } else {
                binding.txtLatitude.setText(latitude.substring(0, 6));
                binding.txtLongitude.setText(longitude.substring(0, 6));
            }

            binding.edtAddress1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtAddress1.getText().toString();
                    myEdit.putString("address1", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtAddress2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtAddress2.getText().toString();
                    myEdit.putString("address2", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtTownCity.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtTownCity.getText().toString();
                    myEdit.putString("town_city", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtPostcode.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtPostcode.getText().toString();
                    myEdit.putString("postcode", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtOpningtimes.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtOpningtimes.getText().toString();
                    myEdit.putString("opening_time", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            String image = location_image;

            URL url = null;
            try {
                url = new URL(image);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

//            Picasso.get().load(String.valueOf(url)).into(binding.imgFromUserLocation);


            String bitmap6 = preferences.get(location_activity.this, preferences.KEY_lbitmap);
            Bitmap btt = StringToBitMap(bitmap6);
            binding.imgFromUserLocation.setImageBitmap(btt);

            if (!bitmap6.isEmpty()) {
//                Toast.makeText(this, "new ", Toast.LENGTH_SHORT).show();
            } else {
                new GetImageFromUrl(binding.imgFromUserLocation).execute(String.valueOf(url));

//                Toast.makeText(this, "old ", Toast.LENGTH_SHORT).show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @SuppressLint("LongLogTag")
                    public void run() {
                        Log.d("devi963", "run: " + campareimg);
                        if (campareimg.equals("new")) {
                            Log.d("TAG", "run: new");
//                                    Toast.makeText(location_activity.this, "new", Toast.LENGTH_SHORT).show();
                        } else {
                            //create a file to wrtite bitmap data
                            Log.d("filejkeyvalue", "run: " + preferences.get(location_activity.this, preferences.KEY_Location_File));
                            if (preferences.get(location_activity.this, preferences.KEY_Location_File).equals("")) {
                                Log.d("filejkeyvalue", "run: 2");
//                                        Toast.makeText(location_activity.this, "run", Toast.LENGTH_SHORT).show();
                                f = new File(location_activity.this.getCacheDir(), "location_img.JPEG");
                                try {
                                    f.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //convert bitmat to byte by byte
                                Bitmap bitmap15 = bt7;
                                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                bitmap15.compress(Bitmap.CompressFormat.JPEG, 0, bos);
                                byte[] bitmapdata = bos.toByteArray();

                                //writte the bites in file
                                try {
                                    FileOutputStream fos = new FileOutputStream(f);
                                    fos.write(bitmapdata);
                                    fos.flush();
                                    fos.close();

                                } catch (FileNotFoundException e) {
                                    Log.d("devi1 FileNotFoundException ", "run: " + e);
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Log.d("devi1 FileNotFoundException2 ", "run: " + e);
                                }
                                Log.d("devi1url 3", "onCreate: " + bitmap5);
                                Log.d("devi1url 12", "run: " + f);
                                String edcopanimgs = String.valueOf(f);
                                preferences.save(location_activity.this, preferences.KEY_Location_File, String.valueOf(f));
//                            part = createpart(edcopanimgs);
//                        getFileFromBitmap.getFileFromBitmap(bt7,MainActivity.this);
                            } else {
                                Log.d("filejkeyvalue", "run: 1");
//                                        Toast.makeText(location_activity.this, "wait", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }, 10000);
            }

            binding.lloutcountry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(location_activity.this, select_country_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "2");
                    startActivity(get_dealtype);
                }
            });
            binding.imgLocationBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
            binding.lloutLocationOnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();
                    String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
                    String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
                    String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
                    String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
                    String country = binding.txtCountryName.getText().toString();

                    String full_address = address1 + address2 + town_city + postcode;

                    if (!binding.txtLatitude.getText().toString().equals("") || !binding.txtLongitude.getText().toString().equals("")) {


//                        String latitude123 = binding.txtLatitude.getText().toString();
//                        String longitude123 = binding.txtLongitude.getText().toString();

                        String latitude123 = pref.getString("edit_latitude", "");
                        String longitude123 = pref.getString("edit_longitude", "");
                        myEdit.putString("edit_latitude", latitude123);
                        myEdit.putString("edit_longitude", longitude123);

//                        Toast.makeText(location_activity.this, "A 1" + latitude123Toast, .LENGTH_SHORT).show();
                        myEdit.apply();

                        Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                        get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        get_map.putExtra("type", "2");
                        get_map.putExtra("map_pin", "address");
                        startActivity(get_map);


                    } else if (address1.isEmpty()
//                            && address2.isEmpty()
                            && town_city.isEmpty() && postcode.isEmpty() && country.isEmpty()) {

                        Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                        get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = pref.edit();

                        myEdit.putString("address1", address1);
                        myEdit.putString("address2", address2);
                        myEdit.putString("town_city", town_city);
                        myEdit.putString("postcode", postcode);
                        myEdit.putString("opening_times", opening_times);

                        myEdit.putString("new_location", "first");
                        myEdit.apply();
                        get_map.putExtra("type", "2");
                        get_map.putExtra("map_pin", "current");
                        startActivity(get_map);

                    } else if (!address1.isEmpty() && !town_city.isEmpty() && !postcode.isEmpty()) {

                        getLocationFromAddress(full_address, "2");

                    } else {

                        Toast.makeText(location_activity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();

                    }

                }
            });
//            binding.cardAddCoupon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent get_add = new Intent(location_activity.this, Addcoupon_activity.class);
//                    preferences.save(location_activity.this, preferences.KEY_Type4, String.valueOf(6));
//                    get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    get_add.putExtra("type", "2");
//                    get_add.putExtra("type2", "30");
//                    startActivity(get_add);
//                }
//            });
            binding.lloutImgUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    checkPermission();

                    if (Build.VERSION.SDK_INT >= 23) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            selectImage();

                        } else {
                            ActivityCompat.requestPermissions(location_activity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        }
                    }
                }
            });
        }
        else if (getIntent().getStringExtra("type").equals("3")) {
            flag = "3";

            Log.d("shared_coupon_user", "onCreate: " + "shared coupon from another user");

            Log.d("shared_coupon_user", "onCreate: " + "shared coupon from another user");

            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String adress1 = sh.getString("address1", "");
            String adress2 = sh.getString("address2", "");
            String town_city = sh.getString("town_city", "");
            String country = sh.getString("country", "");
            String location = sh.getString("location", "");
            String opening_time = sh.getString("opening_time", "");
            String location_image = sh.getString("location_image", "");
            String postcode = sh.getString("postcode", "");

            String latitude = sh.getString("edit_latitude", "");
            String longitude = sh.getString("edit_longitude", "");

            Log.d("viru_location", "onCreate: " + adress2 + adress1 + town_city + country + location + opening_time + location_image);
//            URL url_coupon_iamge = null;
//            try {
//                url_coupon_iamge = new URL(location_image);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }


            String image = location_image;

            URL url = null;
            try {
                url = new URL(image);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

//            Picasso.get().load(String.valueOf(url)).into(binding.imgFromUserLocation);


            String bitmap6 = preferences.get(location_activity.this, preferences.KEY_lbitmap);
            Bitmap btt = StringToBitMap(bitmap6);
            binding.imgFromUserLocation.setImageBitmap(btt);
            Log.d("check_bitecode", "onCreate: " + bitmap6);
            if (!bitmap6.isEmpty()) {
//                Toast.makeText(this, "new ", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("check_shlocation", "onCreate: " + url);
                new GetImageFromUrl(binding.imgFromUserLocation).execute(String.valueOf(url));
//                Toast.makeText(this, "old ", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @SuppressLint("LongLogTag")
                    public void run() {
                        Log.d("devi963", "run: " + campareimg);
                        if (campareimg.equals("new")) {
                            Log.d("TAG", "run: new");
//                                    Toast.makeText(location_activity.this, "new", Toast.LENGTH_SHORT).show();
                        } else {
                            //create a file to wrtite bitmap data
                            Log.d("filejkeyvalue", "run: " + preferences.get(location_activity.this, preferences.KEY_Location_File));
                            if (preferences.get(location_activity.this, preferences.KEY_Location_File).equals("")) {
                                Log.d("filejkeyvalue", "run: 2");
//                                        Toast.makeText(location_activity.this, "run", Toast.LENGTH_SHORT).show();
                                f = new File(location_activity.this.getCacheDir(), "location_img.JPEG");
                                try {
                                    f.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //convert bitmat to byte by byte
                                Bitmap bitmap15 = bt7;
                                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                bitmap15.compress(Bitmap.CompressFormat.JPEG, 0, bos);
                                byte[] bitmapdata = bos.toByteArray();

                                //writte the bites in file
                                try {
                                    FileOutputStream fos = new FileOutputStream(f);
                                    fos.write(bitmapdata);
                                    fos.flush();
                                    fos.close();
                                } catch (FileNotFoundException e) {
                                    Log.d("devi1 FileNotFoundException ", "run: " + e);
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Log.d("devi1 FileNotFoundException2 ", "run: " + e);
                                }
                                Log.d("devi1url 3", "onCreate: " + bitmap5);
                                Log.d("devi1url 12", "run: " + f);
                                String edcopanimgs = String.valueOf(f);
                                preferences.save(location_activity.this, preferences.KEY_Location_File, String.valueOf(f));
//                            part = createpart(edcopanimgs);
//                        getFileFromBitmap.getFileFromBitmap(bt7,MainActivity.this);
                            } else {
                                Log.d("filejkeyvalue", "run: 1");
//                                        Toast.makeText(location_activity.this, "wait", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }, 10000);
            }
            binding.edtAddress1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtAddress1.getText().toString();
                    myEdit.putString("address1", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtAddress2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtAddress2.getText().toString();
                    myEdit.putString("address2", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtTownCity.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtTownCity.getText().toString();
                    myEdit.putString("town_city", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtPostcode.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtPostcode.getText().toString();
                    myEdit.putString("postcode", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtOpningtimes.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String address1 = binding.edtOpningtimes.getText().toString();
                    myEdit.putString("opening_time", address1);
                    myEdit.apply();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            binding.edtAddress1.setText(adress1);
            binding.edtAddress2.setText(adress2);
            binding.edtTownCity.setText(town_city);
            binding.txtCountryName.setText(country);
            binding.edtOpningtimes.setText(opening_time);
            binding.edtPostcode.setText(postcode);

            binding.lloutLocationOnMap.setOnClickListener(v -> {
                String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();
                String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
                String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
//                String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
//                String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
//                String country = binding.txtCountryName.getText().toString();
                String full_address = address1 + address2 + town_city + postcode;
//                Toast.makeText(this, "1 "+country, Toast.LENGTH_SHORT).show();
                if (!binding.txtLatitude.getText().toString().equals("") || !binding.txtLongitude.getText().toString().equals("")) {

//                        String latitude123 = binding.txtLatitude.getText().toString();
//                        String longitude123 = binding.txtLongitude.getText().toString();

                    String latitude123 = pref.getString("edit_latitude", "");
                    String longitude123 = pref.getString("edit_longitude", "");
                    myEdit.putString("edit_latitude", latitude123);
                    myEdit.putString("edit_longitude", longitude123);

//                    Toast.makeText(location_activity.this, "A 1"+latitude123, Toast.LENGTH_SHORT).show();
                    myEdit.apply();

                    Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                    get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    get_map.putExtra("type", "3");
                    get_map.putExtra("map_pin", "address");
                    startActivity(get_map);


                } else if (address1.isEmpty()
//                            && address2.isEmpty()
                        && town_city.isEmpty() && postcode.isEmpty() && country.isEmpty()) {

                    Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                    get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    myEdit.putString("address1", address1);
                    myEdit.putString("address2", address2);
                    myEdit.putString("town_city", town_city);
                    myEdit.putString("postcode", postcode);
                    myEdit.putString("opening_times", opening_times);

                    myEdit.putString("new_location", "first");
                    myEdit.apply();
                    get_map.putExtra("type", "3");
                    get_map.putExtra("map_pin", "current");
                    startActivity(get_map);

                } else if (!address1.isEmpty() && !town_city.isEmpty() && !postcode.isEmpty()) {

                    getLocationFromAddress(full_address, "3");

                } else {

                    Toast.makeText(location_activity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();

                }


            });
            binding.imgLocationBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();
                }
            });
            binding.lloutcountry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_dealtype = new Intent(location_activity.this, select_country_activity.class);
                    get_dealtype.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_dealtype.putExtra("type", "3");
                    startActivity(get_dealtype);
                }
            });
            binding.lloutImgUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Build.VERSION.SDK_INT >= 23) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            selectImage();
                        } else {
                            ActivityCompat.requestPermissions(location_activity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        }
                    }
                }
            });
            if (latitude.equals("0") || longitude.equals("0")) {
                binding.txtLatitude.setVisibility(View.INVISIBLE);
                binding.txtLongitude.setVisibility(View.INVISIBLE);
            } else {
                binding.txtLatitude.setText(latitude.substring(0, 6));
                binding.txtLongitude.setText(longitude.substring(0, 6));

            }

//            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
//
//            String adress1 = sh.getString("address1", "");
//            String adress2 = sh.getString("address2", "");
//            String town_city = sh.getString("town_city", "");
//            String country = sh.getString("country", "");
//            String location = sh.getString("location", "");
//            String opening_time = sh.getString("opening_time", "");
//            String location_image = sh.getString("location_image", "");
//            String postcode = sh.getString("postcode", "");
//
//            String latitude = sh.getString("edit_latitude", "");
//            String longitude = sh.getString("edit_longitude", "");
//
//            Log.d("viru_location", "onCreate: " + adress2 + adress1 + town_city + country + location + opening_time + location_image);
//
//
//            binding.edtAddress1.setText(adress1);
//            binding.edtAddress2.setText(adress2);
//            binding.edtTownCity.setText(town_city);
//            binding.txtCountryName.setText(country);
//            binding.edtOpningtimes.setText(opening_time);
//            binding.edtPostcode.setText(postcode);
//
//            binding.edtAddress1.setFocusable(false);
//            binding.edtAddress2.setFocusable(false);
//            binding.edtTownCity.setFocusable(false);
//            binding.edtOpningtimes.setFocusable(false);
//            binding.edtPostcode.setFocusable(false);
//
//            binding.imgLocationBack.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onBackPressed();
//                }
//            });
//
//            if (latitude.equals("0") || longitude.equals("0")) {
//                binding.txtLatitude.setVisibility(View.INVISIBLE);
//                binding.txtLongitude.setVisibility(View.INVISIBLE);
//            } else {
//                binding.txtLatitude.setText(latitude.substring(0, 6));
//                binding.txtLongitude.setText(longitude.substring(0, 6));
//            }
//        }
//        }
        }

    }

    private void selectImage() {

        String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
        String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
        String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
        String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
        String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        myEdit.putString("address1", address1);
        myEdit.putString("address2", address2);
        myEdit.putString("town_city", town_city);
        myEdit.putString("postcode", postcode);
        myEdit.putString("opening_times", opening_times);
        myEdit.apply();
//                    myEdit.putString("Array", String.valueOf(jsonArray2));

        Intent i_gallary = new Intent();
        i_gallary.setType("image/*");
        i_gallary.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i_gallary, "Select Picture"), GALLERY_REQ_CODE);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQ_CODE) {
            Uri selectedImageUri = data.getData();

            if (null != selectedImageUri) {
                bitmap = BitmapFactory.decodeFile(String.valueOf(selectedImageUri));
                try {
                    InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    binding.imgFromUserLocation.setImageBitmap(bitmap);
                    String btos = BitMapToString(bitmap);
                    preferences.save(location_activity.this, preferences.KEY_lbitmap, String.valueOf(btos));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                File file = new File(getRealPathFromURI(selectedImageUri, getApplicationContext()));

                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();
                preferences.save(location_activity.this, preferences.KEY_Location_File, String.valueOf(file));
                myEdit.putString("lastimageloaction", String.valueOf(file));
                myEdit.apply();
                campareimg = "new";
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/"), file);
                part = MultipartBody.Part.createFormData("addressImage", file.getName(), requestBody);
                Log.d("filepath", "onActivityResult: " + file);

//                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                SharedPreferences.Editor myEdit = pref.edit();
            }
        }
    }

    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
    }


    public GeoPoint getLocationFromAddress(String strAddress, String type) {

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        GeoPoint p1 = null;

        try {

            address = coder.getFromLocationName(strAddress, 2);
            if (address == null) {
                return null;
            }


            Log.d("location123", "getLocationFromAddress: " + "location");
            if (address.size() > 0) {
//                Toast.makeText(this, "Please Enter valid Address", Toast.LENGTH_SHORT).show();


                Address location = address.get(0);

                Log.d("location123", "getLocationFromAddress: " + location);

                location.getLatitude();
                location.getLongitude();
                double l1 = location.getLatitude();
                double l2 = location.getLongitude();
                Log.d("devi22", "getLocationFromAddress: " + l1 + " " + l2);
//            Toast.makeText(this, "" + l1 + " " + l2, Toast.LENGTH_SHORT).show();
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();

                String latitude = String.valueOf(l1);
                String longitude = String.valueOf(l2);


                binding.dash.setVisibility(View.INVISIBLE);
//            binding.txtLatitude.setVisibility(View.INVISIBLE);
//            binding.txtLongitude.setVisibility(View.INVISIBLE);

                myEdit.putString("latitude123", latitude);
                myEdit.putString("longitude123", longitude);
                myEdit.apply();

                Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
                try {
                    List<Address> addresses = geoCoder.getFromLocation(l1, l2, 1);

                    String add = "";
                    if (addresses.size() > 0) {
                        for (int i = 0; i < addresses.get(0).getMaxAddressLineIndex(); i++)
                            add += addresses.get(0).getAddressLine(i) + "\n";

                    }

                    Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                    get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    get_map.putExtra("type", type);

                    String address1 = Objects.requireNonNull(binding.edtAddress1.getText()).toString();
                    String address2 = Objects.requireNonNull(binding.edtAddress2.getText()).toString();
                    String town_city = Objects.requireNonNull(binding.edtTownCity.getText()).toString();
                    String postcode = Objects.requireNonNull(binding.edtPostcode.getText()).toString();
                    String opening_times = Objects.requireNonNull(binding.edtOpningtimes.getText()).toString();

                    get_map.putExtra("address1", address1);
                    get_map.putExtra("address2", address2);
                    get_map.putExtra("town_city", town_city);
                    get_map.putExtra("postcode", postcode);
                    get_map.putExtra("opening_times", opening_times);
                    myEdit.putString("new_location", "first");
                    myEdit.apply();

//                startActivity(get_map);

                    Log.d("viru_location222", "getLocationFromAddress: " + address.get(0).getCountryName());

//                    binding.txtCountryName.setText(address.get(0).getCountryName());

                    String select_country = binding.txtCountryName.getText().toString();


                    if (address.get(0).getCountryName().equals(select_country)) {

                        Log.d("location_address", "getLocationFromAddress: " + "address");
                        get_map.putExtra("map_pin", "address");
                        startActivity(get_map);


                    } else {
                        Log.d("location_address", "getLocationFromAddress: " + "current");
                        get_map.putExtra("map_pin", "current");
                        startActivity(get_map);

                    }

//                Toast.makeText(this, "" + address.get(0).getCountryName(), Toast.LENGTH_SHORT).show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                return p1;
            } else {

                Intent get_map = new Intent(location_activity.this, select_maps_Activity.class);
                get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                get_map.putExtra("type", type);
                get_map.putExtra("map_pin", "current");
                startActivity(get_map);

//                Toast.makeText(this, "Please Enter Valid Address", Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public final String getRealPathFromURI(@NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(context, "context");
        Cursor returnCursor = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        Intrinsics.checkNotNull(returnCursor);
        int nameIndex = returnCursor.getColumnIndex("_display_name");
        int sizeIndex = returnCursor.getColumnIndex("_size");
        returnCursor.moveToFirst();
        String name = returnCursor.getString(nameIndex);
        String size = String.valueOf(returnCursor.getLong(sizeIndex));
        File file = new File(context.getFilesDir(), name);

        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            FileOutputStream outputStream = new FileOutputStream(file);
            int read = 0;
            int maxBufferSize = 1048576;
            int bytesAvailable = inputStream != null ? inputStream.available() : 0;
            int bufferSize = Math.min(bytesAvailable, maxBufferSize);
            byte[] buffers = new byte[bufferSize];

            while (true) {
                Integer var16 = inputStream != null ? inputStream.read(buffers) : null;
                boolean var18 = false;
                if (var16 != null) {
                    read = var16;
                }

                if (var16 != null) {
                    if (var16 == -1) {
                        Log.e("File Size", "Size " + file.length());
                        if (inputStream != null) {
                            inputStream.close();
                        }

                        outputStream.close();
                        Log.e("File Path", "Path " + file.getPath());
                        break;
                    }
                }

                outputStream.write(buffers, 0, read);
            }
        } catch (Exception var19) {
            String var10001 = var19.getMessage();
            Intrinsics.checkNotNull(var10001);
            Log.e("Exception", var10001);
        }

        return file.getPath();
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public GetImageFromUrl(ImageView img) {
            Log.d("devi1 9", "GetImageFromUrl: ");
            this.imageView = img;
        }

        @Override
        public Bitmap doInBackground(String... url) {
            String stringUrl = url[0];
//            bitmap = null;
            InputStream inputStream;
            try {

                inputStream = new java.net.URL(stringUrl).openStream();
                bitmap5 = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                Log.d("getFileFromBitmap try", "doInBackground: " + e);
                e.printStackTrace();
            }
            return bitmap5;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            binding.imgFromUserLocation.setImageBitmap(bitmap);
            Log.d("devi1 bit", "onPostExecute: " + bitmap);
            bt7 = bitmap;
        }
    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(location_activity.this).setMessage("GPS Enable").setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    locationEnabled();
                }
            }).show();
        }
    }

    @Override
    public void onBackPressed() {

        if (flag.equals("1")) {

            if (!binding.edtAddress1.getText().toString().equals("") &&
                    !binding.edtAddress2.getText().toString().equals("") &&
                    !binding.edtPostcode.getText().toString().equals("") &&
                    !binding.edtTownCity.getText().toString().equals("") &&
                    !binding.edtOpningtimes.getText().toString().equals("") &&
                    !binding.txtCountryName.getText().toString().equals("") &&
                    !binding.txtLatitude.getText().toString().equals("") &&
                    !binding.txtLongitude.getText().toString().equals("") &&
                    !preferences.get(location_activity.this, preferences.KEY_lbitmap).equals("")) {

                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                Intent get_add = new Intent(location_activity.this, Addcoupon_activity.class);
                preferences.save(location_activity.this, preferences.KEY_Type4, String.valueOf(6));
                get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();
                String jsonArray2 = sh.getString("location_datas", "");
                String latitude = binding.txtLatitude.getText().toString();
                String longitude = binding.txtLongitude.getText().toString();
                String country = binding.txtCountryName.getText().toString();
                myEdit.putString("Array_location", jsonArray2);
                myEdit.putString("address1", String.valueOf(binding.edtAddress1.getText().toString()));
                myEdit.putString("address2", String.valueOf(binding.edtAddress2.getText().toString()));
                myEdit.putString("town_city", String.valueOf(binding.edtTownCity.getText().toString()));
                myEdit.putString("postcode", String.valueOf(binding.edtPostcode.getText().toString()));
                myEdit.putString("opening_times", String.valueOf(binding.edtOpningtimes.getText().toString()));
//                    myEdit.putString("latitude", String.valueOf(binding.txtLatitude.getText().toString()));
//                    myEdit.putString("longitude", String.valueOf(binding.txtLongitude.getText().toString()));
                myEdit.putString("country", String.valueOf(binding.txtCountryName.getText().toString()));
                myEdit.apply();
                Log.d("devi6 l ", "onClick: " + binding.edtAddress1.getText().toString());
                get_add.putExtra("Array_location", String.valueOf(jsonArray2));
                get_add.putExtra("type", "1");
                get_add.putExtra("type2", "10");
                startActivity(get_add);
                Log.d("deviaddd 1", "onClick: 2 " + jsonArray2);

            } else {
                Toast.makeText(this, "Please Fill Every Fields", Toast.LENGTH_SHORT).show();
            }
        } else if (flag.equals("2")) {

            Intent get_add = new Intent(location_activity.this, Addcoupon_activity.class);
            preferences.save(location_activity.this, preferences.KEY_Type4, String.valueOf(6));
            get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();
//                    String jsonArray2 = sh.getString("location_datas", "");
            String latitude = binding.txtLatitude.getText().toString();
            String longitude = binding.txtLongitude.getText().toString();
            String country = binding.txtCountryName.getText().toString();
//                    myEdit.putString("Array_location", jsonArray2);
            myEdit.putString("address1", String.valueOf(binding.edtAddress1.getText().toString()));
            myEdit.putString("address2", String.valueOf(binding.edtAddress2.getText().toString()));
            myEdit.putString("town_city", String.valueOf(binding.edtTownCity.getText().toString()));
            myEdit.putString("postcode", String.valueOf(Objects.requireNonNull(binding.edtPostcode.getText()).toString()));
            myEdit.putString("opening_times", String.valueOf(binding.edtOpningtimes.getText().toString()));
//                    myEdit.putString("latitude", String.valueOf(binding.txtLatitude.getText().toString()));
//                    myEdit.putString("longitude", String.valueOf(binding.txtLongitude.getText().toString()));
            myEdit.putString("country", String.valueOf(binding.txtCountryName.getText().toString()));

            myEdit.apply();
            Log.d("devi6 l ", "onClick: " + binding.edtAddress1.getText().toString());
            get_add.putExtra("Array_location", String.valueOf(jsonArray2));
            get_add.putExtra("type", "2");
            get_add.putExtra("type2", "30");
            startActivity(get_add);
            Log.d("deviaddd 1", "onClick: 2 " + jsonArray2);

        } else {

            Intent get_add = new Intent(location_activity.this, Addcoupon_activity.class);
            preferences.save(location_activity.this, preferences.KEY_Type4, String.valueOf(6));
            get_add.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();
//                    String jsonArray2 = sh.getString("location_datas", "");
            String latitude = binding.txtLatitude.getText().toString();
            String longitude = binding.txtLongitude.getText().toString();
            String country = binding.txtCountryName.getText().toString();
//                    myEdit.putString("Array_location", jsonArray2);
            myEdit.putString("address1", String.valueOf(binding.edtAddress1.getText().toString()));
            myEdit.putString("address2", String.valueOf(binding.edtAddress2.getText().toString()));
            myEdit.putString("town_city", String.valueOf(binding.edtTownCity.getText().toString()));
            myEdit.putString("postcode", String.valueOf(Objects.requireNonNull(binding.edtPostcode.getText()).toString()));
            myEdit.putString("opening_times", String.valueOf(binding.edtOpningtimes.getText().toString()));
//                    myEdit.putString("latitude", String.valueOf(binding.txtLatitude.getText().toString()));
//                    myEdit.putString("longitude", String.valueOf(binding.txtLongitude.getText().toString()));
            myEdit.putString("country", String.valueOf(binding.txtCountryName.getText().toString()));

            myEdit.apply();
            Log.d("devi6 l ", "onClick: " + binding.edtAddress1.getText().toString());
            get_add.putExtra("Array_location", String.valueOf(jsonArray2));
            get_add.putExtra("type", "3");
            get_add.putExtra("type2", "30");
            startActivity(get_add);
            Log.d("deviaddd 1", "onClick: 2 " + jsonArray2);
        }
    }
}