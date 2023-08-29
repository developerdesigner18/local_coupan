package com.example.local_coupan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.databinding.ActivityLoginScreenBinding;
import com.example.local_coupan.model.sign_in.LoginModel;
import com.example.local_coupan.preferences2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class login_screen extends AppCompatActivity {
    ActivityLoginScreenBinding binding;
    preferences2 preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("preference", "onCreate: " + preferences.get(login_screen.this, preferences.KEY_ID));


//        preferences.save(login_screen.this, preferences.KEY_ID, String.valueOf("63caa143d3c5d37a55ed4fb6"));
//        Toast.makeText(this, "id "+preferences.get(login_screen.this, preferences.KEY_ID), Toast.LENGTH_SHORT).show();


        if (preferences.get(login_screen.this, preferences.KEY_ID) != null && !preferences.get(login_screen.this, preferences.KEY_ID).equals("")) {


//            Toast.makeText(this, "ifff", Toast.LENGTH_SHORT).show();

            Intent get_main = new Intent(login_screen.this, MapsMainActivity.class);
            get_main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(get_main);

        }

        binding.txtGetNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_register = new Intent(login_screen.this, register_screen.class);
                get_register.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_register);
            }
        });

        binding.imgLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Objects.requireNonNull(binding.edtEmail.getText()).toString();
                String password = Objects.requireNonNull(binding.edtPassword.getText()).toString();

                if (!email.isEmpty() && !password.isEmpty()) {

                    sign_in(email, password);

                } else {

                    Toast.makeText(login_screen.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void sign_in(String email, String password) {
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
            paramObject.put("email", email);
            paramObject.put("password", password);

            Log.d("devi123", "onCreate: " + paramObject);
            Call<LoginModel> userCall = apiInterface.get_signin(String.valueOf(paramObject));

            userCall.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());
//                    Toast.makeText(login_screen.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                    if (response.code() == 200) {

                        assert response.body() != null;
                        String message = response.body().getMessage();
                        String login_id = response.body().getLoginUserId();
                        Boolean success = response.body().getSuccess();

                        Log.d("login_data", "onResponse: " + message);
                        Log.d("login_data", "onResponse: " + login_id);
                        Log.d("login_data", "onResponse: " + success);

                        preferences.save(login_screen.this, preferences.KEY_ID, String.valueOf(login_id));

//                        Toast.makeText(login_screen.this, "" + response.raw(), Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent get_login = new Intent(login_screen.this, MapsMainActivity.class);
                                get_login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(get_login);
                            }
                        }, 0);
//
//                    }
//                    else if (response.code() == 400){
////                        Log.d("OTP_Code", "onResponse: " + response.body());
//                        Toast.makeText(login_screen.this, "" + response.errorBody().toString(),ErrorM Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject = new JSONObject(response.errorBody().string());
                            String userMessage = jsonObject.getString("message");
                            Toast.makeText(login_screen.this, "" + userMessage, Toast.LENGTH_SHORT).show();

                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginModel> call, @NonNull Throwable t) {
                    Toast.makeText(login_screen.this, "an error occurred", Toast.LENGTH_SHORT).show();
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }
}