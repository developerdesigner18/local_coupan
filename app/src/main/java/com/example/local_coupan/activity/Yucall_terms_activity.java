package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.local_coupan.databinding.ActivityYucallTermsBinding;

public class Yucall_terms_activity extends AppCompatActivity {

    ActivityYucallTermsBinding binding;

    final static float move = 200;
    float ratio = 1.0f;
    int bastDst;
    float baseratio;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYucallTermsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.yucallGetTerms.setTextSize(ratio + 10);
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String terms_date = sh.getString("terms_date", "");

//        String[] date = terms_date.split("/");
//        String dd = date[0];
//        String mm = date[1];
//        String yy = date[2];
//
//        int mm1 = Integer.parseInt(mm);
//
//        String month_name = "null";
//
//        switch (mm1) {
//            case 1:
//                month_name = "January";
//                break;
//            case 2:
//                month_name = "February";
//                break;
//            case 3:
//                month_name = "March";
//                break;
//            case 4:
//                month_name = "April";
//                break;
//            case 5:
//                month_name = "May";
//                break;
//            case 6:
//                month_name = "June";
//                break;
//            case 7:
//                month_name = "July";
//                break;
//            case 8:
//                month_name = "August";
//                break;
//            case 9:
//                month_name = "September";
//                break;
//            case 10:
//                month_name = "October";
//                break;
//            case 11:
//                month_name = "November";
//                break;
//            case 12:
//                month_name = "December";
//                break;
//            default:
//        }
//
//        binding.termsDate.setText(dd + " " + month_name + " " + yy);
        binding.termsDate.setText(terms_date);
        binding.imgYutermsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            binding.yucallGetTerms.setAutoSizeTextTypeUniformWithConfiguration(
//                    16, 0, 1, TypedValue.COMPLEX_UNIT_DIP);
//        }

        binding.yucallGetTerms.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getPointerCount() == 2) {
                    int action = event.getAction();
                    int mainaction = action & MotionEvent.ACTION_MASK;
                    if (mainaction == MotionEvent.ACTION_POINTER_DOWN) {
                        bastDst = getDistance(event);
                        baseratio = ratio;
                    } else {
                        float scale = (getDistance(event) - bastDst) / move;
                        float factor = (float) Math.pow(3, scale);
                        ratio = Math.min(1024.0f, Math.max(0.1f, baseratio * factor));
                        binding.yucallGetTerms.setTextSize(ratio + 17);
                    }
                }
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int mainaction = action & MotionEvent.ACTION_MASK;
            if (mainaction == MotionEvent.ACTION_POINTER_DOWN) {
                bastDst = getDistance(event);
                baseratio = ratio;
            } else {
                float scale = (getDistance(event) - bastDst) / move;
                float factor = (float) Math.pow(2, scale);
                ratio = Math.min(1024.0f, Math.max(0.1f, baseratio * factor));
                binding.yucallGetTerms.setTextSize(ratio + 17);
            }
        }
        return true;
    }

    // get distance between the touch event
    private int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}