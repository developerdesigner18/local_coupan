package com.example.local_coupan.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivitySelectLocationBinding;
import com.example.local_coupan.databinding.CustomFilterDialogboxBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class select_location extends FragmentActivity implements OnMapReadyCallback {
//public class select_location extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener123 {

    GoogleMap mMap, cu_map;
    private final List<Marker> originMarkers = new ArrayList<>();
    private final List<Marker> destinationMarkers = new ArrayList<>();
    private final List<Polyline> polylinePaths = new ArrayList<>();
    private ActivitySelectLocationBinding binding;
    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    CustomFilterDialogboxBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySelectLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding1 = binding.inflate(LayoutInflater.from(select_location.this),R.layout.custom_filter_dialogbox, null, false);
//        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        binding.imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.imgLocation.setImageResource(R.drawable.location);

                binding.imgTime.setImageResource(R.drawable.sand_clock);
                binding.imgCoin.setImageResource(R.drawable.coin);

            }
        });

        binding.imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_filtter_dialog();
            }
        });

//        binding.imgFolder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String origin = "";
//                String destination = "";
//
//                if (origin.isEmpty()) {
//                    Toast.makeText(select_location.this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (destination.isEmpty()) {
//                    Toast.makeText(select_location.this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                try {
//                    new DirectionFinder(, origin, destination).execute();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        binding.imgCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imgTime.setImageResource(R.drawable.sand_clock);
                binding.imgCoin.setImageResource(R.drawable.coin);
                binding.imgLocation.setImageResource(R.drawable.location);
            }
        });

        binding.imgBackMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.imgTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imgTime.setImageResource(R.drawable.sand_clock);
                binding.imgCoin.setImageResource(R.drawable.coin);
                binding.imgLocation.setImageResource(R.drawable.location);
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        cu_map = googleMap;

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String latitude = sh.getString("preview_latitude", "");
        String longitude = sh.getString("preview_longitude", "");

        Log.d("longitude4123", "onMapReady: " + latitude + " " + longitude);
        double lat = Double.parseDouble(latitude);
        double lang = Double.parseDouble(longitude);

        LatLng map_pin = new LatLng(lat, lang);

//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);

        LatLng sydney = new LatLng(lat, lang);
        mMap.addMarker(new MarkerOptions().position(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lang), 19));
        mMap.setInfoWindowAdapter(new custom_info_window(select_location.this));


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

//        Task<Location> task = fusedLocationProviderClient.getLastLocation();

//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if (location != null) {
//                    currentlocation = location;
//                    double latitude = currentlocation.getLatitude();
//                    double longitude = currentlocation.getLongitude();
//                    Log.d("TAG123132", "onSuccess: " + latitude);
//                    Log.d("TAG123132", "onSuccess: " + longitude);
//
//                    LatLng current_latlang = new LatLng(currentlocation.getLatitude(), currentlocation.getLongitude());
//                    MarkerOptions markerOptions = new MarkerOptions().position(current_latlang).title("I am Here");
//                    cu_map.addMarker(markerOptions);
//
////                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
////                    SharedPreferences.Editor myEdit = pref.edit();
//
////                    myEdit.putString("current_latitude", String.valueOf(latitude));
////                    myEdit.putString("current_longitude", String.valueOf(longitude));
////                    myEdit.apply();
//                }
//            }
//        });

    }

    public class custom_info_window implements GoogleMap.InfoWindowAdapter {

        private final View mWindow;

        @SuppressLint("InflateParams")
        public custom_info_window(Context mcontext) {
            mWindow = LayoutInflater.from(mcontext).inflate(R.layout.custom_map_window, null);
        }

        @SuppressLint("SetTextI18n")
        private void rendowWindowText(Marker marker, View view) {

            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String city_data = sh.getString("preview_city", "");
            String address1_data = sh.getString("preview_address1", "");
            String address2_data = sh.getString("preview_address2", "");
            String title_data = sh.getString("title", "");
            String brand_data = sh.getString("brand", "");
            String country_data = sh.getString("preview_country", "");
            String address_image = sh.getString("address_image", "");
            String CouponImage = sh.getString("CouponImage", "");

            String add_image = address_image;
            Log.d("address_image", "rendowWindowText: " + address_image);
            Log.d("CouponImage", "rendowWindowText: " + CouponImage);

            TextView tvtitle = view.findViewById(R.id.title_window);
//            TextView tvbrand = view.findViewById(R.id.brand_window);
            TextView address1 = view.findViewById(R.id.address1_window);
            TextView address2 = view.findViewById(R.id.address2_window);
            TextView city = view.findViewById(R.id.address3_window);
            TextView letter = view.findViewById(R.id.letter);


            Log.d("location_data", "rendowWindowText: " + title_data + " " + brand_data);
//            CardView img_icon = view.findViewById(R.id.img_coupon_window);
            ImageView location = view.findViewById(R.id.img_location_window);
            ImageView imageView3 = view.findViewById(R.id.imageView3);

            if (address2_data.equals("")){
                address2.setVisibility(View.GONE);
                imageView3.setVisibility(View.GONE);
            }else{
                address2.setText(address2_data);
                imageView3.setVisibility(View.VISIBLE);
            }

            tvtitle.setText(title_data);
            letter.setText(String.valueOf(title_data.toUpperCase(Locale.ROOT).charAt(0)));

//            tvbrand.setText(brand_data);
            address1.setText(address1_data);

            city.setText(city_data);

            if (add_image.equalsIgnoreCase("http://54.90.77.44:8000/public/images/undefined")) {
                location.setImageResource(R.drawable.location_image);
            } else if (add_image.isEmpty()) {
                location.setImageResource(R.drawable.location_image);
            } else {
                URL url2 = null;
                try {
                    url2 = new URL(add_image);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Log.d("image_load", "rendowWindowText:1 ");
                Glide.with(select_location.this).load(url2).into(location);
            }

//            if (CouponImage.equalsIgnoreCase("http://54.90.77.44:8000/public/images/undefined")) {
//                img_icon.setImageResource(R.drawable.logo);
//            } else if (CouponImage.isEmpty()) {
//                img_icon.setImageResource(R.drawable.logo);
//            } else {
//                URL url1 = null;
//                try {
//                    url1 = new URL(CouponImage);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//                Log.d("image_load", "rendowWindowText:2 ");
//                Picasso.get().load(String.valueOf(url1)).into(img_icon);
//            }
        }

        //
        @Nullable
        @Override
        public View getInfoContents(@NonNull Marker marker) {
            rendowWindowText(marker, mWindow);
            return mWindow;
        }

        @Nullable
        @Override
        public View getInfoWindow(@NonNull Marker marker) {
            rendowWindowText(marker, mWindow);
            return mWindow;
        }
    }
//
//    @Override
//    public void onDirectionFinderStart() {
////        progressDialog = ProgressDialog.show(this, "Please wait.",
////                "Finding direction..!", true);
//
//        if (originMarkers != null) {
//            for (Marker marker : originMarkers) {
//                marker.remove();
//            }
//        }
//
//        if (destinationMarkers != null) {
//            for (Marker marker : destinationMarkers) {
//                marker.remove();
//            }
//        }
//
//        if (polylinePaths != null) {
//            for (Polyline polyline:polylinePaths ) {
//                polyline.remove();
//            }
//        }
//    }
//
//    public void onDirectionFinderSuccess(List<Route> routes) {
//        polylinePaths = new ArrayList<>();
//        originMarkers = new ArrayList<>();
//        destinationMarkers = new ArrayList<>();
//
//        for (Route route : routes) {
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
////            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
////            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);
//
//            originMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(Color.BLUE))
//                    .title(route.startAddress)
//                    .position(route.startLocation)));
//            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(Color.RED))
//                    .title(route.endAddress)
//                    .position(route.endLocation)));
//
//            PolylineOptions polylineOptions = new PolylineOptions().
//                    geodesic(true).
//                    color(Color.BLUE).
//                    width(10);
//
//            for (int i = 0; i < route.points.size(); i++)
//                polylineOptions.add(route.points.get(i));
//
//            polylinePaths.add(mMap.addPolyline(polylineOptions));
//        }
//    }

    public void get_filtter_dialog() {

        Dialog dialog = new Dialog(select_location.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_filter_dialogbox);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);

//        alertDialog.getWindow().setLayout();
        dialog.getWindow().setLayout(width , height);
        dialog.setCanceledOnTouchOutside(false);

        binding1=CustomFilterDialogboxBinding.inflate(getLayoutInflater());
        dialog.setContentView(binding1.getRoot());

        binding1.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        String deal_type = sh.getString("filter_type", "");

        Log.d("deal_type", "onCreate: " + deal_type);

        if (deal_type.equalsIgnoreCase("None")) {
            binding1.true1.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Home")) {
            binding1.true2.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Electronics")) {
            binding1.true3.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Food & Drink")) {
            binding1.true4.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Travel")) {
            binding1.true5.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Clothing & Footwear")) {
            binding1.true6.setVisibility(View.VISIBLE);
        } else if (deal_type.equalsIgnoreCase("Health & Beauty")) {
            binding1.true7.setVisibility(View.VISIBLE);
        } else {
            Log.d("deal_type", "please select any type");
        }

//        8160

        binding1.lloutNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();

               myEdit.putString("filter_type","None");
               myEdit.apply();

                binding1.true1.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Home");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true2.setVisibility(View.VISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Electronics");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true3.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Food & Drink");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true4.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Travel");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true5.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Clothing & Footwear");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true6.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true7.setVisibility(View.INVISIBLE);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.BOLD);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.NORMAL);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
            }
        });

        binding1.lloutHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEdit.putString("filter_type","Health & Beauty");
                myEdit.apply();
//                Toast.makeText(select_location.this, "Clicked", Toast.LENGTH_SHORT).show();
                binding1.true7.setVisibility(View.VISIBLE);
                binding1.true2.setVisibility(View.INVISIBLE);
                binding1.true1.setVisibility(View.INVISIBLE);
                binding1.true3.setVisibility(View.INVISIBLE);
                binding1.true4.setVisibility(View.INVISIBLE);
                binding1.true5.setVisibility(View.INVISIBLE);
                binding1.true6.setVisibility(View.INVISIBLE);
                binding1.health.setTypeface(binding1.health.getTypeface(), Typeface.BOLD);
                binding1.none.setTypeface(binding1.none.getTypeface(), Typeface.NORMAL);
                binding1.home.setTypeface(binding1.home.getTypeface(), Typeface.NORMAL);
                binding1.elec.setTypeface(binding1.elec.getTypeface(), Typeface.NORMAL);
                binding1.food.setTypeface(binding1.food.getTypeface(), Typeface.NORMAL);
                binding1.travel.setTypeface(binding1.travel.getTypeface(), Typeface.NORMAL);
                binding1.cloth.setTypeface(binding1.cloth.getTypeface(), Typeface.NORMAL);
            }
        });
        dialog.show();
    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}