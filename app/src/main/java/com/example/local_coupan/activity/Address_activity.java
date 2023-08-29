package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.local_coupan.databinding.ActivityAddressBinding;

public class Address_activity extends AppCompatActivity {
    ActivityAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.lloutAddress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent get_location = new Intent(Address_activity.this, location_activity.class);
                get_location.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                get_location.putExtra("type", "2");
                startActivity(get_location);

            }
        });
    }
}