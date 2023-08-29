package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.ApiInterface;
import com.example.local_coupan.databinding.ActivityRegisterScreenBinding;
import com.example.local_coupan.model.sign_up.SignUp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class register_screen extends AppCompatActivity {
    ActivityRegisterScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.imgSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Objects.requireNonNull(binding.edtName.getText()).toString().trim();
                String email = Objects.requireNonNull(binding.edtEmail.getText()).toString().trim();
                String password = Objects.requireNonNull(binding.edtPassword.getText()).toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    sign_up(email, name, password);
                } else {
                    Toast.makeText(register_screen.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sign_up(String email, String name, String password) {
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
            paramObject.put("name", name);
            paramObject.put("password", password);

            Log.d("devi123", "onCreate: " + paramObject);
            Call<SignUp> userCall = apiInterface.get_signup(String.valueOf(paramObject));

            userCall.enqueue(new Callback<SignUp>() {
                @Override
                public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                    Log.d("viru_qrcode", "onResponse: " + response.raw());

                    if (response.code() == 200) {

                        assert response.body() != null;
                        String message = response.body().getMessage();
                        String id = response.body().getUserData().getId();
                        Log.d("OTP_Code", "onResponse: " + message);
                        Log.d("id123", "onResponse: " + id);

//                        Toast.makeText(register_screen.this, "" + response.raw(), Toast.LENGTH_SHORT).show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(register_screen.this, login_screen.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            }
                        }, 0);
                    } else {
                        String message = null;
                        if (response.body() != null) {
                            message = response.body().getMessage();
                        }
                        Log.d("OTP_Code", "onResponse: " + message);
                        Toast.makeText(register_screen.this, message, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SignUp> call, Throwable t) {
                    Log.d("error_failure", "onFailure: " + "an error occurred" + " " + t);
                }
            });
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }
}