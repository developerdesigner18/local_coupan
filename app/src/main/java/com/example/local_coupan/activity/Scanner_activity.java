package com.example.local_coupan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.R;
import com.example.local_coupan.databinding.ActivityScannerBinding;
import com.example.local_coupan.model.GetQrcode;
import com.example.local_coupan.model.id_wise_coupon.IdwiseCoupon;
import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Scanner_activity extends AppCompatActivity implements Callback<GetQrcode> {

    ActivityScannerBinding binding;
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkPermission();
        binding.backScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mCodeScanner = new CodeScanner(this, binding.scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(Scanner_activity.this, result.getText(), Toast.LENGTH_SHORT).show();
                        Log.d("qrcodescanner", "run: " + result.getText());

                        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
                        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        clientBuilder.addInterceptor(loggingInterceptor);

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://54.90.77.44:8000/coupon/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

                        try {

                            String id = result.getText();
                            String result123 = id.substring(1, id.length() - 1);

                            JSONObject paramObject = new JSONObject();
                            paramObject.put("id", result123);
                            Log.d("devi123", "onCreate: " + paramObject);
                            Call<IdwiseCoupon> userCall = apiInterface.get_id_wise_data(String.valueOf(paramObject));
                            userCall.enqueue(new Callback<IdwiseCoupon>() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onResponse(Call<IdwiseCoupon> call, Response<IdwiseCoupon> response) {
                                    Log.d("viru_qrcode", "onResponse: " + response.raw());
//                                    Toast.makeText(Scanner_activity.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                                    if (response.code() == 200) {

//                                        Toast.makeText(Scanner_activity.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                                        binding.materialCardView7.setVisibility(View.VISIBLE);
                                        binding.btnRedeem.setVisibility(View.VISIBLE);

                                        assert response.body() != null;
                                        String title = response.body().getCouponData().getCouponTitle();
                                        String description = response.body().getCouponData().getDescription();
                                        String brand = response.body().getCouponData().getBrand();
                                        String product = response.body().getCouponData().getProduct();
                                        String expiry_date = response.body().getCouponData().getExpiryDate();
                                        String count_down = response.body().getCouponData().getExpiryCountDown();
//                                        Toast.makeText(Scanner_activity.this, "C1  " + count_down, Toast.LENGTH_SHORT).show();
                                        String deal = response.body().getCouponData().getDeal();
                                        String Copon_image = response.body().getCouponData().getCouponImage();
                                        String percentage_saving = String.valueOf(response.body().getCouponData().getPercentageSaving());

                                        String remainingPrice = response.body().getCouponData().getRemainingPrice();
                                        String expiry_date1 = response.body().getCouponData().getExpiryDate();
                                        String ex_date = expiry_date1.substring(0, 10);
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
                                                month_name = "Jan";
                                                break;
                                            case 2:
                                                month_name = "Feb";
                                                break;
                                            case 3:
                                                month_name = "Mar";
                                                break;
                                            case 4:
                                                month_name = "Apr";
                                                break;
                                            case 5:
                                                month_name = "May";
                                                break;
                                            case 6:
                                                month_name = "Jun";
                                                break;
                                            case 7:
                                                month_name = "Jul";
                                                break;
                                            case 8:
                                                month_name = "Aug";
                                                break;
                                            case 9:
                                                month_name = "Sep";
                                                break;
                                            case 10:
                                                month_name = "Oct";
                                                break;
                                            case 11:
                                                month_name = "Nav";
                                                break;
                                            case 12:
                                                month_name = "Dec";
                                                break;
                                            default:
                                        }

                                        String final_date = dd + " " + month_name + " " + yy;

//                                        binding.textDescription.setText(description);
                                        binding.brand.setText(brand);
                                        binding.txtProduct.setText(product);
                                        binding.date.setText(final_date);
                                        binding.expiryCountdown.setText(count_down);
//                                        Toast.makeText(Scanner_activity.this, "C2  " + count_down, Toast.LENGTH_SHORT).show();

//                                        binding.deal.setText(deal);
                                        String text = "<font color=#858585>" + deal + " " + "</font> <font color=#1E1E1E>" + remainingPrice + "</font>";
                                        binding.deal.setText(Html.fromHtml(text));

                                        SharedPreferences pref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor myedit = pref.edit();
                                        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                                        myedit.putString("dealtype123", text);
                                        myedit.apply();

//                                        binding.deal2.setText(remainingPrice + " " + deal);
                                        binding.textDescription.setText(percentage_saving + " % off " + title);

                                        String ti = String.valueOf(title.charAt(0)).toUpperCase(Locale.ROOT);
                                        binding.couponCapital.setText(ti);

                                        binding.titleCouponName.setText(title);

//                                        binding.titleCouponName.setVisibility(View.VISIBLE);
//                                        binding.offerid.setVisibility(View.VISIBLE);
//                                        binding.textUserId.setVisibility(View.VISIBLE);
//                                        binding.materialCardView.setVisibility(View.VISIBLE);
//                                        binding.textDescription.setVisibility(View.VISIBLE);
//                                        binding.textOfferId.setVisibility(View.VISIBLE);
//                                        binding.userid.setVisibility(View.VISIBLE);
//                                        binding.discount.setVisibility(View.VISIBLE);
//                                        binding.discount1.setVisibility(View.VISIBLE);
//                                        binding.btnRedeem.setVisibility(View.VISIBLE);
//                                        binding.discount2.setVisibility(View.VISIBLE);

                                        binding.btnRedeem.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if (response.body().getCouponData().getShared() && response.body().getCouponData().getPlayPauseStatus()) {
                                                    qrcode(result.getText());
                                                } else {
                                                    if (!response.body().getCouponData().getShared()) {
                                                        alert_message("Scanning is Restricted");
                                                    } else {
                                                        alert_message("This Coupon Is Paused So Can't Redeem.");
//                                                    Toast.makeText(Scanner_activity.this, "sharing is restricted for this coupon", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        });

                                    } else {
//                                        Toast.makeText(Scanner_activity.this, "Wrong QRCode", Toast.LENGTH_SHORT).show();
                                        alert_message("Scanned QRCode is invalid!");
                                    }
                                }

                                @Override
                                public void onFailure(Call<IdwiseCoupon> call, Throwable t) {
                                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                                    Toast.makeText(Scanner_activity.this, "" + t, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (
                                JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        binding.scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    public void qrcode(String qrcode_id) {

        String final_id = qrcode_id;
        String result = final_id.substring(1, final_id.length() - 1);

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        myEdit.putString("ids", result);
        myEdit.apply();

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.90.77.44:8000/coupon/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("id", result);
            Log.d("devi123", "onCreate: " + paramObject);
            Call<GetQrcode> userCall = apiInterface.get_qrcode_id(String.valueOf(paramObject));
            userCall.enqueue((Callback<GetQrcode>) this);

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onResponse(Call<GetQrcode> call, Response<GetQrcode> response) {

        Log.d("viru_qrcode", "onResponse: " + response.raw());

        if (response.code() == 200) {

//            Toast.makeText(this, "" + response.raw(), Toast.LENGTH_LONG).show();

            Log.d("OTP_Code", "onResponse: " + response.body().getSuccess());


            int otp = response.body().getOTPCode();
            Log.d("OTP_Code", "onResponse: " + otp);
            assert response.body() != null;
            Log.d("OTP_Code", "onResponse: " + response.body().getMessage());
            Toast.makeText(this, "" + otp, Toast.LENGTH_SHORT).show();

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = pref.edit();

            myEdit.putInt("OTP", otp);
            myEdit.apply();

            Intent get_OTP = new Intent(Scanner_activity.this, OTPverify.class);
            get_OTP.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(get_OTP);
        } else {

            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onFailure(Call<GetQrcode> call, Throwable t) {
        Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
    }

    public void alert_message(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Share Message")
                .setMessage(message)
                .setCancelable(false)
                .setNeutralButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
//                        mCodeScanner = new CodeScanner(Scanner_activity.this, binding.scannerView);
                        Intent i = new Intent(Scanner_activity.this, Scanner_activity.class);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(i);
                        overridePendingTransition(0, 0);
                    }
                }).create().show();
    }

    @SuppressLint("ObsoleteSdkInt")
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                                Manifest.permission.CAMERA,},
                        1);
            }
        }
    }
}