package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.local_coupan.databinding.ActivityShareAndUseBinding;
import com.example.local_coupan.preferences2;

public class share_and_use_activity extends AppCompatActivity {
    ActivityShareAndUseBinding binding;
    preferences2 preferences;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShareAndUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        preferences.save(share_and_use_activity .this,preferences.KEY_Type2,String.valueOf(2));


//        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        SharedPreferences.Editor myEdit = pref.edit();
//
//        if (getIntent().getStringExtra("type").equals("1")) {
//
//            if (getIntent().getStringExtra("navigate").equals("share")) {
//
//                String share = pref.getString("share", "");
//
//                if (share.equalsIgnoreCase("Yes")) {
//                    binding.truePercentage1.setVisibility(View.VISIBLE);
//                } else if (share.equalsIgnoreCase("No")) {
//                    binding.truePercentage2.setVisibility(View.VISIBLE);
//                } else {
//                    Log.d("expiry_launch_month", "onCreate: " + share);
//                }
//
//                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        onBackPressed();
//                    }
//                });
//
//                binding.lloutTrue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage1.setVisibility(View.VISIBLE);
//                        binding.truePercentage2.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "1");
//                                get_deal.putExtra("navigate", "null");
//                                String share = "Yes";
//                                myEdit.putString("share", share);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//                binding.lloutFalse.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage2.setVisibility(View.VISIBLE);
//                        binding.truePercentage1.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "1");
//                                get_deal.putExtra("navigate", "null");
//                                String share = "No";
//                                myEdit.putString("share", share);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//            } else if (getIntent().getStringExtra("navigate").equals("use")) {
//
//                binding.textViewTitle.setText("Use");
//
//                String use = pref.getString("use", "");
//
//                if (use.equalsIgnoreCase("Yes")) {
//                    binding.truePercentage1.setVisibility(View.VISIBLE);
//                } else if (use.equalsIgnoreCase("No")) {
//                    binding.truePercentage2.setVisibility(View.VISIBLE);
//                } else {
//                    Log.d("expiry_launch_month", "onCreate: " + use);
//                }
//
//                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        onBackPressed();
//                    }
//                });
//
//                binding.lloutTrue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage1.setVisibility(View.VISIBLE);
//                        binding.truePercentage2.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "1");
//                                get_deal.putExtra("navigate", "null");
//                                String use = "Yes";
//                                myEdit.putString("use", use);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//                binding.lloutFalse.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage2.setVisibility(View.VISIBLE);
//                        binding.truePercentage1.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "1");
//                                get_deal.putExtra("navigate", "null");
//                                String use = "No";
//                                myEdit.putString("use", use);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//            }
//        }
//        else if (getIntent().getStringExtra("type").equals("2")) {
//
//
//            if (getIntent().getStringExtra("navigate").equals("share")) {
//
////                Boolean share1 = pref.getBoolean("can_share", true);
////
////                String share;
////                if (share1) {
////                    share = "Yes";
////                } else {
////                    share = "No";
////                }
//
//                String can_share = pref.getString("share", "");
//
//                if (can_share.equalsIgnoreCase("Yes")) {
//                    binding.truePercentage1.setVisibility(View.VISIBLE);
//                } else if (can_share.equalsIgnoreCase("No")) {
//                    binding.truePercentage2.setVisibility(View.VISIBLE);
//                } else {
//                    Log.d("expiry_launch_month", "onCreate: " + can_share);
//                }
//
//                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        onBackPressed();
//                    }
//                });
//
//                binding.lloutTrue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage1.setVisibility(View.VISIBLE);
//                        binding.truePercentage2.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "2");
////                                get_deal.putExtra("navigate", "null");
//                                String share = "Yes";
//                                myEdit.putString("share", share);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//                binding.lloutFalse.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage2.setVisibility(View.VISIBLE);
//                        binding.truePercentage1.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "2");
////                                get_deal.putExtra("navigate", "null");
//                                String share = "No";
//                                myEdit.putString("share", share);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//            }
//            else if (getIntent().getStringExtra("navigate").equals("use")) {
//
//                binding.textViewTitle.setText("Use");
//
////                String can_share = pref.getString("can_share", "");
//                String single = pref.getString("single", "");
//
//                if (single.equalsIgnoreCase("Yes")) {
//                    binding.truePercentage1.setVisibility(View.VISIBLE);
//                } else if (single.equalsIgnoreCase("No")) {
//                    binding.truePercentage2.setVisibility(View.VISIBLE);
//                } else {
//                    Log.d("expiry_launch_month", "onCreate: " + single);
//                }
//
//                binding.imgBackCurrency.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        onBackPressed();
//                    }
//                });
//
//                binding.lloutTrue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage1.setVisibility(View.VISIBLE);
//                        binding.truePercentage2.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "2");
////                                get_deal.putExtra("navigate", "null");
////                                String use = "Yes";
//                                myEdit.putString("single", "Yes");
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//                binding.lloutFalse.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(share_and_use_activity.this, "Wait a Second", Toast.LENGTH_SHORT).show();
//                        binding.truePercentage2.setVisibility(View.VISIBLE);
//                        binding.truePercentage1.setVisibility(View.INVISIBLE);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Intent get_deal = new Intent(share_and_use_activity.this, Coupon_deal_activity.class);
//                                get_deal.putExtra("type", "2");
////                                get_deal.putExtra("navigate", "null");
//                                String use = "No";
//                                myEdit.putString("single", use);
//                                myEdit.apply();
//                                get_deal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(get_deal);
//                                finish();
//                            }
//                        }, 1000);
//                    }
//                });
//            }
//        }
    }
}