package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.R;
import com.example.local_coupan.adapter.share_recycle_adapter;
import com.example.local_coupan.databinding.ActivityDirectShareBinding;
import com.example.local_coupan.model.id_wise_coupon.IdwiseCoupon;
import com.example.local_coupan.model.share_data.ShareData;
import com.example.local_coupan.model.userlist_model.Userlist;
import com.example.local_coupan.preferences2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class Direct_share_Activity extends AppCompatActivity {

    preferences2 preferences;
    ActivityDirectShareBinding binding;
    share_recycle_adapter share_adapter;
    String share_userid;
    List<String> shared_user_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDirectShareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String user_id = sh.getString("user_id", "");
        share_userid = sh.getString("share_userid", "");

        try {
            JSONArray jsonArray = new JSONArray(share_userid);
            Log.d("share_user_id", "onCreate: " + jsonArray.get(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        shared_user_list = Collections.singletonList(share_userid);
        String id1 = sh.getString("id1", "");
        Log.d("coupon_id123", "onCreate: " + id1);
        id_vise_coupon_data(id1);

        Log.d("share_userid", "onCreate: 1   " + shared_user_list.get(0));
        get_userlist(user_id);

        binding.imgDirectShareBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_share = new Intent(Direct_share_Activity.this, Share_activity.class);
                get_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_share);
                finish();
            }
        });

        binding.searchviewShare.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                share_adapter.getFilter().filter(newText);
                return false;
            }
        });

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.recyclerDirectShare.setLayoutManager(manager);
        binding.recyclerDirectShare.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
//        binding.recyclerDirectShare.setLayoutManager(new LinearLayoutManager(Direct_share_Activity.this, 1));

        LinearLayoutManager layoutManager = new LinearLayoutManager(Direct_share_Activity.this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerDirectShare.setLayoutManager(layoutManager);

    }

    public void get_userlist(String userid) {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.90.77.44:8000/user/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("id", userid);

            Log.d("devi123", "onCreate: " + paramObject);
            Call<Userlist> userCall = apiInterface.get_user_list(String.valueOf(paramObject));
            userCall.enqueue(new Callback<Userlist>() {
                @Override
                public void onResponse(Call<Userlist> call, Response<Userlist> response) {

                    binding.prgressShare.setVisibility(View.INVISIBLE);

//                Toast.makeText(Direct_share_Activity.this, "" + response.raw(), Toast.LENGTH_SHORT).show();
                    Log.d("share_api", "onResponse: " + response.raw());

                    assert response.body() != null;
                    share_adapter = new share_recycle_adapter(Direct_share_Activity.this, response.body().getLoginData());
                    binding.recyclerDirectShare.setAdapter(share_adapter);

                    share_adapter.setOnItemClicklistner(new share_recycle_adapter.OnItemClickListener() {
                        @Override
                        public void oncheck_click(int position) {

                            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                            String coupon_id = pref.getString("id1", "");
                            String ids = preferences.get(Direct_share_Activity.this, preferences.KEY_ID);
                            String shareuserid = response.body().getLoginData().get(position).getId();
                            Log.d("position123", "on_next_click: " + position);

                            get_share_data(ids, shareuserid, coupon_id, coupon_id); //share api integration

                        }

                        @Override
                        public void on_next_click(int position) {

                            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                            SharedPreferences.Editor myEdit = pref.edit();

                            String name = response.body().getLoginData().get(position).getName();
                            myEdit.putString("share_name", name);
                            myEdit.apply();
                            Intent get_OTP = new Intent(Direct_share_Activity.this, coupon_share.class);
                            get_OTP.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(get_OTP);

                        }
                    });
                }

                @Override
                public void onFailure(Call<Userlist> call, Throwable t) {
//                    Toast.makeText(Direct_share_Activity.this, "" + t, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }

    public void get_share_data(String userID, String shareUserId, String couponID, String parent_id) {

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
            paramObject.put("userID", userID);
            paramObject.put("shareUserId", shareUserId);
            paramObject.put("couponID", couponID);
            paramObject.put("parent_id", parent_id);

            Log.d("devi123", "onCreate: " + paramObject);

            Call<ShareData> userCall = apiInterface.get_share_data(String.valueOf(paramObject));
            userCall.enqueue(new Callback<ShareData>() {
                @Override
                public void onResponse(Call<ShareData> call, Response<ShareData> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());

                    if (response.code() == 200) {

                        String message = response.body().getMessage();

                        Log.d("message123", "onResponse: " + message);
                        Log.d("OTP_Code", "onResponse: " + response.body().getSuccess());

                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = pref.edit();
                        myEdit.apply();

                        if (message.equalsIgnoreCase("Successfully Created shared coupon")) {
                            Toast.makeText(Direct_share_Activity.this, "" + message, Toast.LENGTH_LONG).show();
                            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                            String id1 = sh.getString("id1", "");

//                            finish();
//                            overridePendingTransition(0, 0);
//                            startActivity(getIntent());
//                            overridePendingTransition(0, 0);
                            id_vise_coupon_data(id1);
//                            binding.prgressShare.setVisibility(View.VISIBLE);

//                            finish();
//                            overridePendingTransition(0, 0);
//                            startActivity(getIntent());
//                            overridePendingTransition(0, 0);

//                            Toast.makeText(Direct_share_Activity.this, "" + id1, Toast.LENGTH_SHORT).show();
//                            getdata(); // get api integration
//                            id_vise_coupon_data(id1); // get api integration

                        } else {
                            alert_message(message);
                        }
                    } else {
                        Toast.makeText(Direct_share_Activity.this, "Something Went Wrong!" + "", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ShareData> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void alert_message(String message_from_share) {
        new AlertDialog.Builder(this)
                .setTitle("Share Message")
                .setMessage(message_from_share)
                .setCancelable(false)
                .setNeutralButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        binding.prgressShare.setVisibility(View.VISIBLE);
//                        binding.recyclerDirectShare.setVisibility(View.GONE);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                binding.prgressShare.setVisibility(View.GONE);

//                                finish();
//                                startActivity(getIntent());
//                                finish();
//                                overridePendingTransition(0, 0);
//                                startActivity(getIntent());
//                                overridePendingTransition(0, 0);

                                Intent get_refresh = new Intent(Direct_share_Activity.this, Direct_share_Activity.class);
                                get_refresh.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_refresh);
                            }
                        }, 0);
                    }
                }).create().show();
    }

    public void id_vise_coupon_data(String ids) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://54.90.77.44:8000/coupon/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        try {

            String id = ids;
            JSONObject paramObject = new JSONObject();
            paramObject.put("id", id);
            Log.d("devi123", "onCreate: " + paramObject);
            Call<IdwiseCoupon> userCall = apiInterface.get_id_wise_data(String.valueOf(paramObject));
            userCall.enqueue(new Callback<IdwiseCoupon>() {

                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<IdwiseCoupon> call, Response<IdwiseCoupon> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());
//                    Toast.makeText(Direct_share_Activity.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                    if (response.code() == 200) {

//                      Toast.makeText(Addcoupon_activity.this, "" + response.raw(), Toast.LENGTH_SHORT).show();
//                      Add coupon Data
//                      Toast.makeText(Addcoupon_activity.this, "Share Edit data", Toast.LENGTH_SHORT).show();

                        List<String> share_userid = response.body().getCouponData().getShareUserID();
                        String title123 = response.body().getCouponData().getCouponTitle();
                        Log.d("share_userid", "onResponse: " + share_userid);
//                        Toast.makeText(Direct_share_Activity.this, "" + title123, Toast.LENGTH_SHORT).show();
                        Integer deliveries = response.body().getCouponData().getStatistics().get(0).getDeliveries();
                        Integer scanned_redemption = response.body().getCouponData().getScanned_Redemptions();
                        String Share_userids = String.valueOf(share_userid);
                        myEdit.putString("share_userids", Share_userids);
                        myEdit.putInt("deliveries", deliveries);

                        String scanned_redemption1 = String.valueOf(scanned_redemption);
                        myEdit.putString("scanned_redemption", scanned_redemption1);
                        myEdit.apply();

                    } else {
                        Toast.makeText(Direct_share_Activity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<IdwiseCoupon> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
//                    Toast.makeText(Addcoupon_activity.this, "" + t, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    private void getdata() {
//
//        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        clientBuilder.addInterceptor(loggingInterceptor);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://54.90.77.44:8000/coupon/")
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//
//        try {
//
//            String ids = preferences.get(Direct_share_Activity.this, preferences.KEY_ID);
//            Log.d("deviids", "getdata: " + ids);
//            JSONObject paramObject = new JSONObject();
//            paramObject.put("id", ids);
//            Log.d("devi123", "onCreate: " + paramObject);
//
//            Call<GetCouponData> call = apiInterface.show_coupon(String.valueOf(paramObject));
//
//            Log.d("devi123", "getdata: " + paramObject);
//            call.enqueue(new Callback<GetCouponData>() {
//                @Override
//                public void onResponse(@NonNull Call<GetCouponData> call, @NonNull Response<GetCouponData> response) {
//
//                    Log.d("devi3", "onResponse: " + response.raw());
//
//                    Log.d("success123", "onResponse: " + response.body().getSuccess());
//
//                    List<CouponDatum2> coupon_data = response.body().getCouponData();
//
//                    if (response.code() == 200) {
//
//                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                        SharedPreferences.Editor myEdit = pref.edit();
//                        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//
//                        int position = sh.getInt("position_share", 1);
//
//                        String id1 = sh.getString("id1", "");
//                        Toast.makeText(Direct_share_Activity.this, "" + id1, Toast.LENGTH_SHORT).show();
//
//
//
//
//
//                        Log.d("position123", "onResponse: Share" + position);
//
//                        String share_userid = String.valueOf(response.body().getCouponData().get(position).getShareUserID());
//                        Integer deliveries = response.body().getCouponData().get(position).getStatistics().get(0).getDeliveries();
//
//                        String share_userid1 = share_userid.substring(1, share_userid.length() - 1);
//
//                        Log.d("share_userid", "onbudgetclick: " + share_userid);
//                        Log.d("share_userid", "onbudgetclick: " + share_userid1);
//
//                        myEdit.putString("share_userid", share_userid);
//                        myEdit.putInt("deliveries", deliveries);
//                        myEdit.apply();
//
//                        finish();
//                        overridePendingTransition(0, 0);
//                        startActivity(getIntent());
//                        overridePendingTransition(0, 0);
//
//                        binding.prgressShare.setVisibility(View.GONE);
//
//                        Log.d("devi2", "onResponse: ys " + coupon_data.get(0).getCouponTitle());
////                        Toast.makeText(Direct_share_Activity.this, "success share", Toast.LENGTH_SHORT).show();
//
//                    } else {
////                        Toast.makeText(MainActivity.this, "else", Toast.LENGTH_SHORT).show();
//                        Log.d("devi2", "onResponse: ");
//                    }
//                }
//
//                @Override
//                public void onFailure(@NonNull Call<GetCouponData> call, @NonNull Throwable t) {
//                    Log.d("devi2", "onFailure: " + t);
//
//                    Toast.makeText(Direct_share_Activity.this, "fail", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } catch (
//                JSONException e) {
//            e.printStackTrace();
//        }
//    }
}