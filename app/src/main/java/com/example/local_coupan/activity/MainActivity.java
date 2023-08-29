package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.adapter.recycler_couponadapter;
import com.example.local_coupan.databinding.ActivityMainBinding;
import com.example.local_coupan.model.get_coupon_data.CouponDatum;
import com.example.local_coupan.model.get_coupon_data.GetData;
import com.example.local_coupan.model.get_coupon_data.Statistic;
import com.example.local_coupan.model.play_pause.PlayPause;
import com.example.local_coupan.preferences2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    recycler_couponadapter recycler_couponadapter2;
    ActivityMainBinding binding;
    preferences2 preferences;
    String type2 = "null";
    String addcoupan_v = "no";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getdata(); // get api calling

//        preferences.save(MainActivity.this, preferences.KEY_File, String.valueOf(""));
//        preferences.save(MainActivity.this, preferences.KEY_Location_File, String.valueOf(""));

        binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();
                binding.pullToRefresh.setRefreshing(false);
            }
        });

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        binding.searchView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.searchView1.setIconified(false);
            }
        });

        binding.searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recycler_couponadapter2.getFilter().filter(newText);
                return false;
            }
        });

        //recycler view set layout manager
        binding.recyclerCouponPage.setLayoutManager(new GridLayoutManager(this, 1));

        int position_2 = pref.getInt("position_for_scroll", 0);
        Log.d("position_final 2 ", "onCreate: " + position_2);
        binding.recyclerCouponPage.scrollToPosition(position_2); // when you are scroll that position set this position is top of the screen

        binding.imgMainBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.cardAddCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_add_coupon = new Intent(MainActivity.this, Addcoupon_activity.class);
                addcoupan_v = "add";
                get_add_coupon.putExtra("type", "1");
                get_add_coupon.putExtra("type2", "10");

                preferences.save(MainActivity.this, preferences.KEY_Type2, String.valueOf(10));
//                preferences.save(MainActivity.this, preferences.KEY_Type3, String.valueOf(100));
                preferences.save(MainActivity.this, preferences.KEY_Type4, String.valueOf(1));
//                preferences.save(MainActivity.this, preferences.KEY_Type5, String.valueOf(2));
                get_add_coupon.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_add_coupon);
            }
        });
    }

    private void getdata() {

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

            String ids = preferences.get(MainActivity.this, preferences.KEY_ID);
            Log.d("deviids", "getdata: " + ids);
            JSONObject paramObject = new JSONObject();
            paramObject.put("id", ids);
            Log.d("devi123", "onCreate: " + paramObject);

            Call<GetData> call = apiInterface.show_coupon(String.valueOf(paramObject));

            Log.d("devi123", "getdata: " + paramObject);
            call.enqueue(new Callback<GetData>() {
                @Override
                public void onResponse(@NonNull Call<GetData> call, @NonNull Response<GetData> response) {

                    Log.d("devi3", "onResponse: " + response.raw());
                    Log.d("success123", "onResponse: " + response.body().getSuccess());

                    List<CouponDatum> coupon_data = response.body().getCouponData();
                    binding.progressbar.setVisibility(View.GONE);
                    SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = pref.edit();
                    int position_2 = pref.getInt("position_for_scroll", 0);
                    Log.d("position_final 2 ", "onCreate: " + position_2);
                    binding.recyclerCouponPage.scrollToPosition(position_2);

                    if (coupon_data != null && coupon_data.size() > 0) {

                        Log.d("devi2", "onResponse: ys " + coupon_data.get(0).getCouponTitle());
                        recycler_couponadapter2 = new recycler_couponadapter(response.body().getCouponData());//
                        binding.recyclerCouponPage.setAdapter(recycler_couponadapter2);

//                        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                        SharedPreferences.Editor myEdit = pref.edit();

                        recycler_couponadapter2.setOnItemClicklistner(new recycler_couponadapter.OnItemClickListener() {

                            @Override
                            public void onbudgetclick(int position) {

                                String title = response.body().getCouponData().get(position).getCouponTitle();
                                String coupon_id = response.body().getCouponData().get(position).getId();
                                String userid = response.body().getCouponData().get(position).getUserId();
                                boolean status = response.body().getCouponData().get(position).getPlayPauseStatus();
                                Double remainingBudget = response.body().getCouponData().get(position).getStatistics().get(0).getRemainingBudget();

                                String remainingBudget1 = remainingBudget.toString();

                                Intent get_budget = new Intent(MainActivity.this, Budget_activity.class);
                                get_budget.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                Log.d("Coupon_details", "onbudgetclick: " + title + " " + coupon_id + " " + userid);

                                myEdit.putString("title", title);
                                myEdit.putString("coupon_id", coupon_id);
                                myEdit.putString("userid", userid);
                                myEdit.putString("remainingBudget1", remainingBudget1);
                                myEdit.putBoolean("status", status);
                                myEdit.apply();

                                startActivity(get_budget);

                            }
                            @Override
                            public void ondeliveries(int position) {


                                List<Statistic> data = response.body().getCouponData().get(position).getStatistics();

                                if (data.get(0).getDeliveries() != null &&
                                        data.get(0).getUnitPrice() != null &&
                                        data.get(0).getScannedRedemptions() != null &&
                                        data.get(0).getRemainingBudget() != null &&
                                        data.get(0).getSpendToDate() != null) {

                                    Double unit_price = response.body().getCouponData().get(position).getStatistics().get(0).getUnitPrice();
                                    Float spend_to_date = response.body().getCouponData().get(position).getStatistics().get(0).getSpendToDate();
                                    Double remainingBudget = response.body().getCouponData().get(position).getStatistics().get(0).getRemainingBudget();
                                    Integer deliveries = response.body().getCouponData().get(position).getStatistics().get(0).getDeliveries();
                                    int scannedRedemptions = response.body().getCouponData().get(position).getStatistics().get(0).getScannedRedemptions();

                                    Log.d("getStatistics", "scanned: " + unit_price + " " + spend_to_date + " " + remainingBudget + " " + deliveries + " " + scannedRedemptions);

                                    String unit_price1 = unit_price.toString();
                                    String remainingBudget1 = remainingBudget.toString();
                                    String scannedRedemptions1 = String.valueOf(scannedRedemptions);

                                    myEdit.putString("unit_price1", unit_price1);
                                    myEdit.putFloat("spend_to_date", spend_to_date);
                                    myEdit.putString("remainingBudget1", remainingBudget1);
                                    myEdit.putInt("deliveries", deliveries);
                                    myEdit.putString("scannedRedemptions", scannedRedemptions1);

                                    myEdit.apply();

                                    Intent get_statistics = new Intent(MainActivity.this, Statistics_activity.class);
                                    get_statistics.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(get_statistics);

                                } else {
                                    Toast.makeText(MainActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void scanned(int position) {

                                List<Statistic> data = response.body().getCouponData().get(position).getStatistics();

                                if (data.get(0).getDeliveries() != null &&
                                        data.get(0).getUnitPrice() != null &&
                                        data.get(0).getScannedRedemptions() != null &&
                                        data.get(0).getRemainingBudget() != null &&
                                        data.get(0).getSpendToDate() != null) {

                                    Double unit_price = response.body().getCouponData().get(position).getStatistics().get(0).getUnitPrice();
                                    float spend_to_date = response.body().getCouponData().get(position).getStatistics().get(0).getSpendToDate();
                                    Double remainingBudget = response.body().getCouponData().get(position).getStatistics().get(0).getRemainingBudget();
                                    Integer deliveries = response.body().getCouponData().get(position).getStatistics().get(0).getDeliveries();
                                    int scannedRedemptions = response.body().getCouponData().get(position).getScanned_Redemptions();

                                    String currency1 = response.body().getCouponData().get(position).getCurrency();

                                    Log.d("getStatistics", "scanned: " + unit_price + " " + spend_to_date + " " + remainingBudget + " " + deliveries + " " + scannedRedemptions);

                                    String unit_price1 = unit_price.toString();
                                    String remainingBudget1 = remainingBudget.toString();
                                    String scannedRedemptions1 = String.valueOf(scannedRedemptions);

                                    myEdit.putString("unit_price1", unit_price1);
                                    myEdit.putFloat("spend_to_date", spend_to_date);
                                    myEdit.putString("remainingBudget1", remainingBudget1);
//                                    myEdit.putString("", currency1);
                                    myEdit.putInt("deliveries", deliveries);
                                    myEdit.putString("scannedRedemptions", scannedRedemptions1);

                                    myEdit.apply();

                                    Intent get_statistics = new Intent(MainActivity.this, Statistics_activity.class);
                                    get_statistics.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(get_statistics);

                                } else {
                                    Toast.makeText(MainActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onrunclick(int position) {

                                binding.progressbar.setVisibility(View.VISIBLE);

//                                int color = R.color.transparent_black;
//                                binding.recyclerCouponPage.setForeground(new ColorDrawable(ContextCompat.getColor(MainActivity.this,color)));

                                String id = response.body().getCouponData().get(position).getId();
                                Log.d("click_id", "onrunclick: " + id);

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
                                    paramObject.put("id", id);
                                    Log.d("run_id", "onCreate: " + paramObject);
                                    Call<PlayPause> userCall = apiInterface.get_play_pause_status(String.valueOf(paramObject));

                                    userCall.enqueue(new Callback<PlayPause>() {
                                        @Override
                                        public void onResponse(Call<PlayPause> call, Response<PlayPause> response) {

                                            Log.d("viru_qrcode", "onResponse: " + response.raw());
                                            Log.d("viru_qrcode", "onResponse: " + response.message());

                                            if (response.body().getSuccess()) {

//                                                Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                                                Intent i = new Intent(MainActivity.this, MainActivity.class);
//                                                finish();
//                                                overridePendingTransition(0, 0);
//                                                startActivity(i);
//                                                overridePendingTransition(0, 0);

                                                getdata();

                                                int position1 = position;
                                                Log.d("position_final 1 ", "onResponse: "  + position1);
                                                myEdit.putInt("position_for_scroll", position1);
                                                myEdit.apply();
//                                                binding.progressbar.setVisibility(View.GONE);
//                                                int color = R.color.transparent;
//                                                binding.recyclerCouponPage.setForeground(new ColorDrawable(ContextCompat.getColor(MainActivity.this,color)));

                                            } else {
                                                Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_LONG).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<PlayPause> call, Throwable t) {
                                            Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                                        }
                                    });
                                } catch (
                                        JSONException e) {
                                    e.printStackTrace();
                                }
//                                } else {
//                                    Toast.makeText(MainActivity.this, "After making Payment your Coupon will go Live", Toast.LENGTH_SHORT).show();
//                                }
                            }
                            @Override
                            public void onpreviewclick(int position) {

                                Intent get_coupon_details = new Intent(MainActivity.this, Coupon_details.class);
                                get_coupon_details.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                String id = response.body().getCouponData().get(position).getId();
                                String currency = response.body().getCouponData().get(position).getCurrency();
                                String terms_date = response.body().getCouponData().get(position).getTermsDate();
                                get_coupon_details.putExtra("type", "1");
                                myEdit.putString("id", id);
                                myEdit.putString("currency", currency);
                                myEdit.putString("terms_date", terms_date);
                                myEdit.apply();
                                Log.d("previewid", "onpreviewclick: " + id);
                                startActivity(get_coupon_details);

                            }
                            @Override
                            public void oneditlick(int position) {
                                type2 = "edit";
                                String id1 = coupon_data.get(position).getId();


                                boolean otherShared;
//
//                                if (coupon_data.get(position).getOtherShared() == null) {
//                                    otherShared = false;
//                                } else {
                                otherShared = coupon_data.get(position).getOtherShared();
//                                }

//                                myEdit.putBoolean("otherShared",otherShared);
//                                myEdit.apply();

                                if (otherShared) {
                                    Intent get_share = new Intent(MainActivity.this, Addcoupon_activity.class);
                                    get_share.putExtra("type", "3");
                                    get_share.putExtra("type2", "20");
                                    myEdit.putString("ids12", id1);
                                    myEdit.putInt("position_for_scroll", position);
                                    myEdit.apply();
                                    String shared_name = coupon_data.get(position).getShareCoupon();
                                    myEdit.putString("shared_name", shared_name);
                                    myEdit.apply();
                                    get_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(get_share);
                                } else if (!otherShared) {
                                    get_data_from_id(id1);
                                    myEdit.putInt("position_for_scroll", position);
                                    myEdit.apply();
                                    Log.d("viru1234", "oneditlick: " + id1);
                                } else {
                                    get_data_from_id(id1);
                                    myEdit.putInt("position_for_scroll", position);
                                    myEdit.apply();
                                    Log.d("viru1234", "oneditlick: " + id1);
                                }
                            }
                            @Override
                            public void onshareclick(int position) {

                                type2 = "share";
                                String id1 = coupon_data.get(position).getId();
                                String user_id = response.body().getCouponData().get(position).getUserId();
                                boolean status = coupon_data.get(position).getPlayPauseStatus();
                                Integer deliveries = response.body().getCouponData().get(position).getStatistics().get(0).getDeliveries();
                                int scannedRedemptions = response.body().getCouponData().get(position).getStatistics().get(0).getScannedRedemptions();
                                String share_userid = String.valueOf(response.body().getCouponData().get(position).getShareUserID());

                                myEdit.putInt("position_share", position);

                                Log.d("position123", "onshareclick: Main" + position);
                                myEdit.putInt("position_for_scroll", position);
                                myEdit.apply();

                                String share_userid1 = share_userid.substring(1, share_userid.length() - 1);

                                Log.d("share_userid", "onbudgetclick: " + share_userid);
//                                myEdit.putInt("deliveries", deliveries);
                                myEdit.putString("share_userid", share_userid);
                                myEdit.putString("id1", id1);
                                myEdit.putBoolean("status", status);
                                myEdit.putString("user_id", user_id);
                                myEdit.apply();
                                Intent get_share = new Intent(MainActivity.this, Share_activity.class);
                                get_share.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_share);
                            }
                        });

                    } else {
//                        Toast.makeText(MainActivity.this, "else", Toast.LENGTH_SHORT).show();
                        Log.d("devi2", "onResponse: ");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<GetData> call, @NonNull Throwable t) {
                    Log.d("devi2", "onFailure: " + t);
                    binding.progressbar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "fail" + t, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void get_data_from_id(String id2) {
        Intent get_edit = new Intent(MainActivity.this, Addcoupon_activity.class);
        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();

        myEdit.putString("ids12", id2);
        myEdit.apply();

        Log.d("ids", "get_data_from_id: " + id2);
        get_edit.putExtra("type", "2");
        get_edit.putExtra("type2", "20");
        get_edit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(get_edit);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        binding.searchView1.setIconified(true);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        getdata();
        super.onResume();
    }
}

