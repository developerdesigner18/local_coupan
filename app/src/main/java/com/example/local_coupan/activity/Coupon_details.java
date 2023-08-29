package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.databinding.ActivityCouponDetailsBinding;
import com.example.local_coupan.model.preview.Preview;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Coupon_details extends AppCompatActivity {
    ActivityCouponDetailsBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCouponDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        Uri uri124 = getIntent().getData();
        if (uri124 != null) {
            List<String> params = uri124.getPathSegments();
            String params2 = uri124.getQuery();
            List<String> params3 = Collections.singletonList(uri124.getUserInfo());
            List<String> params4 = Collections.singletonList(uri124.getPath());
            Log.d("devi89", "onCreate: " + params2);
            myEdit.putString("id", params2);
            myEdit.apply();

        }
        String id = sh.getString("id", "");
        Log.d("devi89", "onCreate: n " + id);
        preview_data(id);

        binding.imgBudgetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.mapOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_map = new Intent(Coupon_details.this, select_location.class);
                get_map.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_map);
            }
        });

        binding.shareMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLocalBitmapUri(binding.couponImage);
//                Toast.makeText(Coupon_details.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.dealTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_offer_terms = new Intent(Coupon_details.this, Offer_terms_activity.class);
                get_offer_terms.putExtra("type", "2");
//                    get_offer_terms.putExtra("image", image);
                get_offer_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_offer_terms);
            }
        });

        binding.yucallTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_yucall_terms = new Intent(Coupon_details.this, Yucall_terms_activity.class);
                get_yucall_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_yucall_terms);
            }
        });

        binding.detailQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent get_yucall_terms = new Intent(Coupon_details.this, qrcode_activity.class);
                get_yucall_terms.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_yucall_terms);

            }
        });
    }


    public void preview_data(String id) {
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://54.90.77.44:8000/coupon/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("id", id);
            Log.d("devi123", "onCreate: " + paramObject);
            Call<Preview> userCall = apiInterface.preview_data(String.valueOf(paramObject));
            userCall.enqueue(new Callback<Preview>() {

                @SuppressLint({"ResourceAsColor", "SetTextI18n"})
                @Override
                public void onResponse(Call<Preview> call, Response<Preview> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());

//                    binding.lloutDetails.setVisibility(View.VISIBLE);
                    binding.progressDetails.setVisibility(View.INVISIBLE);

//                    Toast.makeText(Coupon_details.this, "" + response.raw(), Toast.LENGTH_SHORT).show();
                    if (response.code() == 200) {

                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = pref.edit();

                        String QRCodeImage = response.body().getPreviewCouponData().getQRCodeImage();
                        String CouponImage = response.body().getPreviewCouponData().getCouponImage();
                        String title = response.body().getPreviewCouponData().getTitle();
                        String coupon_id = response.body().getPreviewCouponData().getCouponId();
                        String brand = response.body().getPreviewCouponData().getBrand();
                        String product = response.body().getPreviewCouponData().getProduct();
                        String deal = response.body().getPreviewCouponData().getDeal();
                        String valid = response.body().getPreviewCouponData().getStatus();
                        String remainingPrice = response.body().getPreviewCouponData().getRemainingPrice();

                        String launch_date = response.body().getPreviewCouponData().getLaunchDate();
                        Log.d("launch_date_time", "onResponse: " + launch_date);
                        String lh_date = launch_date.substring(0, 10);
                        String[] time1 = launch_date.split("T");

                        String t1 = time1[1];
                        String final_time1 = t1.substring(0, 5);

                        String[] ll_date = lh_date.split("-");

                        myEdit.putString("coupon_image", CouponImage);
                        myEdit.apply();

                        String ll_dd = ll_date[2];
                        String ll_mm = ll_date[1];
                        String ll_yy = ll_date[0];

                        int month_nom1 = Integer.parseInt(ll_mm);

                        String month_name1 = "null";

                        switch (month_nom1) {
                            case 1:
                                month_name1 = "Jan";
                                break;
                            case 2:
                                month_name1 = "Feb";
                                break;
                            case 3:
                                month_name1 = "Mar";
                                break;
                            case 4:
                                month_name1 = "Apr";
                                break;
                            case 5:
                                month_name1 = "May";
                                break;
                            case 6:
                                month_name1 = "Jun";
                                break;
                            case 7:
                                month_name1 = "Jul";
                                break;
                            case 8:
                                month_name1 = "Aug";
                                break;
                            case 9:
                                month_name1 = "Sep";
                                break;
                            case 10:
                                month_name1 = "Oct";
                                break;
                            case 11:
                                month_name1 = "Nov";
                                break;
                            case 12:
                                month_name1 = "Dec";
                                break;
                            default:
                        }

                        binding.txtBudgetTitle.setText(title);
                        binding.launchDate.setText(ll_dd + " " + month_name1 + " " + final_time1);

                        myEdit.putString("coupon_id", coupon_id);
                        myEdit.apply();

                        String expiry_count = String.valueOf(response.body().getPreviewCouponData().getExpiryCountDown());
                        String description = response.body().getPreviewCouponData().getDescription();
                        String terms = response.body().getPreviewCouponData().getTerms();

                        String expiry_date = response.body().getPreviewCouponData().getExpiryDate();
                        String ex_date = expiry_date.substring(0, 10);
//                        String month = expiry_date.substring(5, 7);

                        String[] expiry_time = expiry_date.split("T");
                        String date = expiry_time[0];
                        String final_time = expiry_time[1];
                        String time = final_time.substring(0, 5);

                        String[] date1 = date.split("-");

                        String dd = date1[2];
                        String mm = date1[1];
                        int mm1 = Integer.parseInt(mm);
                        String yy = date1[0];

                        String month_name = "null";

                        switch (mm1) {
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
                                month_name = "November";
                                break;
                            case 12:
                                month_name = "December";
                                break;
                            default:
                        }

                        String final_date = dd + "  " + month_name + "  " + yy;

                        Log.d("month231", "onResponse: " + ex_date + " " + final_date + " " + month_name);

                        String discount = response.body().getPreviewCouponData().getDiscountPrice();
                        String dis_price = String.valueOf(discount);
                        String regular = response.body().getPreviewCouponData().getNormalPrice();
                        String reg_price = String.valueOf(regular);

                        String address1 = response.body().getPreviewCouponData().getAddress().getAddress1();
                        String address2 = response.body().getPreviewCouponData().getAddress().getAddress2();
                        String city = response.body().getPreviewCouponData().getAddress().getCity();
                        String postcode = response.body().getPreviewCouponData().getAddress().getPostcode();
                        String country = response.body().getPreviewCouponData().getAddress().getCountry();
                        String latitude = response.body().getPreviewCouponData().getAddress().getLatitude();
                        String longitude = response.body().getPreviewCouponData().getAddress().getLongitude();
                        String address_image = response.body().getPreviewCouponData().getAddress().getAddressImage();

//                        binding.address.setText(address1 + " " + address2 + "\n" + city + " , " + postcode + ",\n" + country);
                        Log.d("preview123", "onResponse: " + country);

                        Log.d("lat_lang123", "onResponse: " + latitude + " " + longitude);
                        Log.d("devi6", "onResponse: " + latitude);

                        if (latitude == null) {
                            latitude = "54.51381236935253";
                            myEdit.putString("preview_latitude", latitude);
                            myEdit.apply();
                        } else if (latitude.equals("")) {
                            latitude = "54.51381236935253";
                            myEdit.putString("preview_latitude", latitude);
                            myEdit.apply();
                        } else if (latitude.equalsIgnoreCase("latitude")) {
                            latitude = "54.51381236935253";
                            myEdit.putString("preview_latitude", latitude);
                            myEdit.apply();
                        } else {
                            String lat = latitude;
                            myEdit.putString("preview_latitude", lat);
                        }

                        if (longitude == null) {
                            longitude = "-2.0904716594366652";
                            myEdit.putString("preview_longitude", longitude);
                            myEdit.apply();
                        } else if (longitude.equals("")) {
                            longitude = "-2.0904716594366652";
                            myEdit.putString("preview_longitude", latitude);
                            myEdit.apply();
                        } else if (longitude.equalsIgnoreCase("longitude")) {
                            longitude = "-2.0904716594366652";
                            myEdit.putString("preview_longitude", longitude);
                            myEdit.apply();
                        } else {
                            String lang = longitude;
                            myEdit.putString("preview_longitude", lang);
                            myEdit.apply();
                        }

                        boolean share = response.body().getPreviewCouponData().getShared();
                        Log.d("shre123", "onResponse: " + share);

                        myEdit.putString("terms", terms);
                        myEdit.putString("CouponImage", CouponImage);

                        myEdit.putString("preview_address1", address1);
                        myEdit.putString("preview_address2", address2);
                        myEdit.putString("preview_city", city);
                        myEdit.putString("preview_country", country);
                        myEdit.putString("address_image", address_image);
                        myEdit.putString("title", title);
                        myEdit.putString("brand", brand);
                        myEdit.apply();
                        String currency = sh.getString("currency", "");
                        String symbol;

                        String text = "<font color=#858585>" + deal + " " + "</font> <font color=#1E1E1E>" + remainingPrice + "</font>";
                        binding.txtDealtype.setText(Html.fromHtml(text));

//                        binding.txtTitlePrevir.setText(title);
                        binding.txtCouponId.setText(coupon_id);
                        binding.txtBrand.setText(brand);
                        binding.txtProduct.setText(product);
//                        binding.txtDealtype.setText(deal);
//                        binding.status.setText(valid);
                        binding.txtExpiryDate.setText(final_date);
                        binding.txtExpiryCountdown.setText(expiry_count);
                        binding.textDescription.setText(description);
//                        binding.txtExpiryTime.setText(time);
                        binding.discountPrice.setText(dis_price);
                        binding.txtRegularPrice.setText(reg_price);
                        binding.txtRegularPrice.setPaintFlags(binding.txtRegularPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                        if (share) {
                            binding.shareMessage.setVisibility(View.VISIBLE);
                        } else {
                            binding.shareMessage.setVisibility(View.INVISIBLE);
                        }

//                        if (valid.equals("INVALID")) {
//                            binding.status.setTextColor(Color.BLACK);
//                        } else if (valid.equals("VALID")) {
//                            binding.status.setTextColor(Color.GREEN);
//                        }

                        myEdit.putString("qrcode_image", QRCodeImage);
                        myEdit.apply();

                        URL url = null;
                        try {
                            url = new URL(QRCodeImage);
                            Log.d("qrcode12", "onResponse: " + url);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        Picasso.get().load(String.valueOf(url)).into(binding.detailQrcode);
                        Log.d("qrcode12", "onResponse: " + url);

                        URL url1 = null;
                        try {
                            url1 = new URL(CouponImage);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
//                        Picasso.get().load(String.valueOf(url1)).into(binding.couponImage);
                        Glide.with(Coupon_details.this).load(url1).into(binding.couponImage);

                    } else {
                        Toast.makeText(Coupon_details.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Preview> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getLocalBitmapUri(ImageView couponImage) {
        // Extract Bitmap from ImageView drawable

//        Toast.makeText(Coupon_details.this, "clicked123", Toast.LENGTH_SHORT).show();


        Drawable drawable = couponImage.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable) {
            bmp = ((BitmapDrawable) couponImage.getDrawable()).getBitmap();
        } else {
//            Toast.makeText(Coupon_details.this, "else123", Toast.LENGTH_SHORT).show();
            return;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        Log.d("previewUrl", "getLocalBitmapUri: " + bmpUri);
//        Toast.makeText(Coupon_details.this, "clicked1234", Toast.LENGTH_SHORT).show();
        try {
            Log.d("previewUrl", "getLocalBitmapUri: " + bmpUri);
            // Use methods on Context to access package-specific directories on external storage.
            // This way, you don't need to request external read/write permission.
            // See https://youtu.be/5xVh-7ywKpE?t=4m65s
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            // **Warning:** This will fail for API >= 24, use a FileProvider as shown below instead.
            bmpUri = Uri.fromFile(file);


            String path = MediaStore.Images.Media.insertImage(getContentResolver(), bmp, "Title", null);
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            String id = sh.getString("id", "");
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            share.putExtra(Intent.EXTRA_TEXT, "https://yucall.page.link/ids/?" + id);
            Uri imageUri = Uri.parse(path);
            share.putExtra(Intent.EXTRA_STREAM, imageUri);
            startActivity(Intent.createChooser(share, "Send Image Via"));

        } catch (IOException e) {
            Log.d("previewUrl", "getLocalBitmapUri: " + e);
            e.printStackTrace();
        }
        Log.d("previewUrl", "getLocalBitmapUri: " + bmpUri);
    }
}