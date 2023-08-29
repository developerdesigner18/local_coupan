package com.example.local_coupan.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.local_coupan.databinding.ActivitySelectMarketGroupBinding;

import java.util.ArrayList;

public class select_market_group_activity extends AppCompatActivity {
    ActivitySelectMarketGroupBinding binding;

    String flag = "null";
    String flag12 = "null";
    ArrayList groupad1 = new ArrayList();
    ArrayList groupad = new ArrayList();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectMarketGroupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getStringExtra("type").equals("1")) {

            if (getIntent().getStringExtra("navigate").equals("market")) {

                binding.textViewTitle.setText("Marketing Group");
                flag = "market";
                flag12 = "add";
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();


                Log.d("TAG123", "onCreate: " + pref.getString("marketGropuArray", "").equals(""));
                if (pref.getString("marketGropuArray", "").equals("")) {

                    Log.d("TAG", "onCreate: ");
                } else {

                    String marketGropuArray = pref.getString("marketGropuArray", "");
                    Log.d("marketGropuArray", "onCreate: " + marketGropuArray);
                    String substring_group = marketGropuArray.substring(1, marketGropuArray.length() - 1);
                    Log.d("select_group123", "onCreate: " + substring_group);

                    if (substring_group.contains("Group A")) {
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        groupad.add("Group A");
                    }
                    if (substring_group.contains("Group B")) {
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        groupad.add("Group B");
                    }
                    if (substring_group.contains("Group C")) {
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        groupad.add("Group C");
                    }
                    if (substring_group.contains("Group D")) {
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        groupad.add("Group D");
                    }
                    if (substring_group.contains("Group E")) {
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        groupad.add("Group E");
                    }
                }

                binding.lloutGroupA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group A")) {
                            groupad.remove("Group A");
                            binding.truePercentage1.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group A");
                            binding.truePercentage1.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group B")) {
                            groupad.remove("Group B");
                            binding.truePercentage2.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group B");
                            binding.truePercentage2.setVisibility(View.VISIBLE);
                        }

                    }
                });

                binding.lloutGroupC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (groupad.contains("Group C")) {
                            groupad.remove("Group C");
                            binding.truePercentage3.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group C");
                            binding.truePercentage3.setVisibility(View.VISIBLE);
                        }

                    }
                });

                binding.lloutGroupD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group D")) {
                            groupad.remove("Group D");
                            binding.truePercentage4.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group D");
                            binding.truePercentage4.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (groupad.contains("Group E")) {
                            groupad.remove("Group E");
                            binding.truePercentage5.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group E");
                            binding.truePercentage5.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.imgBackGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        back_group("1");

                    }
                });

            } else if (getIntent().getStringExtra("navigate").equals("target_message")) {

                flag = "message";
                flag12 = "add";
                binding.textViewTitle.setText("Messaging Group");

                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();


                if (pref.getString("messageGropuArray", "").equals("")) {

                    Log.d("TAG1111", "onCreate:1111 ");

                } else {

                    String marketGropuArray1 = pref.getString("messageGropuArray", "");
                    Log.d("marketGropuArray", "onCreate: " + marketGropuArray1);
                    String substring_group = marketGropuArray1.substring(1, marketGropuArray1.length() - 1);
                    Log.d("select_group123", "onCreate: " + substring_group);

                    if (substring_group.contains("Group A")) {
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        groupad1.add("Group A");
                    }
                    if (substring_group.contains("Group B")) {
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        groupad1.add("Group B");
                    }
                    if (substring_group.contains("Group C")) {
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        groupad1.add("Group C");
                    }
                    if (substring_group.contains("Group D")) {
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        groupad1.add("Group D");
                    }
                    if (substring_group.contains("Group E")) {
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        groupad1.add("Group E");
                    }

                }

                binding.lloutGroupA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (groupad1.contains("Group A")) {
                            groupad1.remove("Group A");
                            binding.truePercentage1.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group A");
                            binding.truePercentage1.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (groupad1.contains("Group B")) {
                            groupad1.remove("Group B");
                            binding.truePercentage2.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group B");
                            binding.truePercentage2.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group C")) {
                            groupad1.remove("Group C");
                            binding.truePercentage3.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group C");
                            binding.truePercentage3.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group D")) {
                            groupad1.remove("Group D");
                            binding.truePercentage4.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group D");
                            binding.truePercentage4.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group E")) {
                            groupad1.remove("Group E");
                            binding.truePercentage5.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group E");
                            binding.truePercentage5.setVisibility(View.VISIBLE);
                        }
                        Log.d("groupad1", "onClick: " + groupad1);
                    }
                });

                binding.imgBackGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        back_group("1");

                    }
                });
            }
        }
        else if (getIntent().getStringExtra("type").equals("2")) {
            if (getIntent().getStringExtra("navigate").equals("market")) {

                binding.textViewTitle.setText("Marketing Group");
                flag = "market";
                flag12 = "edit";
                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();


                Log.d("TAG123", "onCreate: " + pref.getString("marketGropuArray", "").equals(""));
                if (pref.getString("marketGropuArray", "").equals("")) {

                    Log.d("TAG", "onCreate: ");
                } else {
                    String marketGropuArray = pref.getString("marketGropuArray", "");
                    Log.d("marketGropuArray", "onCreate: " + marketGropuArray);
                    String substring_group = marketGropuArray.substring(1, marketGropuArray.length() - 1);
                    Log.d("select_group123", "onCreate: " + substring_group);

                    if (substring_group.contains("Group A")) {
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        groupad.add("Group A");
                    }
                    if (substring_group.contains("Group B")) {
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        groupad.add("Group B");
                    }
                    if (substring_group.contains("Group C")) {
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        groupad.add("Group C");
                    }
                    if (substring_group.contains("Group D")) {
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        groupad.add("Group D");
                    }
                    if (substring_group.contains("Group E")) {
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        groupad.add("Group E");
                    }
                }

                binding.lloutGroupA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group A")) {
                            groupad.remove("Group A");
                            binding.truePercentage1.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group A");
                            binding.truePercentage1.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group B")) {
                            groupad.remove("Group B");
                            binding.truePercentage2.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group B");
                            binding.truePercentage2.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group C")) {
                            groupad.remove("Group C");
                            binding.truePercentage3.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group C");
                            binding.truePercentage3.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group D")) {
                            groupad.remove("Group D");
                            binding.truePercentage4.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group D");
                            binding.truePercentage4.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad.contains("Group E")) {
                            groupad.remove("Group E");
                            binding.truePercentage5.setVisibility(View.INVISIBLE);
                        } else {
                            groupad.add("Group E");
                            binding.truePercentage5.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.imgBackGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        back_group("2");

                    }
                });
            } else if (getIntent().getStringExtra("navigate").equals("target_message")) {

                flag = "message";
                flag12 = "edit";
                binding.textViewTitle.setText("Messaging Group");

                SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = pref.edit();


                if (pref.getString("messageGropuArray", "").equals("")) {

                    Log.d("TAG1111", "onCreate:1111 ");

                } else {

                    String marketGropuArray1 = pref.getString("messageGropuArray", "");
                    Log.d("marketGropuArray", "onCreate: " + marketGropuArray1);
                    String substring_group = marketGropuArray1.substring(1, marketGropuArray1.length() - 1);
                    Log.d("select_group123", "onCreate: " + substring_group);

                    if (substring_group.contains("Group A")) {
                        binding.truePercentage1.setVisibility(View.VISIBLE);
                        groupad1.add("Group A");
                    }
                    if (substring_group.contains("Group B")) {
                        binding.truePercentage2.setVisibility(View.VISIBLE);
                        groupad1.add("Group B");
                    }
                    if (substring_group.contains("Group C")) {
                        binding.truePercentage3.setVisibility(View.VISIBLE);
                        groupad1.add("Group C");
                    }
                    if (substring_group.contains("Group D")) {
                        binding.truePercentage4.setVisibility(View.VISIBLE);
                        groupad1.add("Group D");
                    }
                    if (substring_group.contains("Group E")) {
                        binding.truePercentage5.setVisibility(View.VISIBLE);
                        groupad1.add("Group E");
                    }

                }

                binding.lloutGroupA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (groupad1.contains("Group A")) {
                            groupad1.remove("Group A");
                            binding.truePercentage1.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group A");
                            binding.truePercentage1.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group B")) {
                            groupad1.remove("Group B");
                            binding.truePercentage2.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group B");
                            binding.truePercentage2.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group C")) {
                            groupad1.remove("Group C");
                            binding.truePercentage3.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group C");
                            binding.truePercentage3.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group D")) {
                            groupad1.remove("Group D");
                            binding.truePercentage4.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group D");
                            binding.truePercentage4.setVisibility(View.VISIBLE);
                        }
                    }
                });

                binding.lloutGroupE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (groupad1.contains("Group E")) {
                            groupad1.remove("Group E");
                            binding.truePercentage5.setVisibility(View.INVISIBLE);
                        } else {
                            groupad1.add("Group E");
                            binding.truePercentage5.setVisibility(View.VISIBLE);
                        }
                        Log.d("groupad1", "onClick: " + groupad1);
                    }
                });

                binding.imgBackGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        back_group("2");

                    }
                });
            }
        }
        else {
            binding.textViewTitle.setText("Messaging Group");
            binding.imgBackGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent get_back = new Intent(select_market_group_activity.this, Share_activity.class);
                    get_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(get_back);
                }
            });
        }
    }

    public void back_group(String type) {

        SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = pref.edit();
        if (flag.equals("market")) {

            Bundle args = new Bundle();
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor aaaa = pref.edit();

            String markeyArrayy = String.valueOf(groupad);
            Log.d("marketArray 2", "onClick: " + markeyArrayy);
            Intent get_target = new Intent(select_market_group_activity.this, Target_activity.class);
            get_target.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            get_target.putExtra("type", type);
            aaaa.putString("marketGropuArray", markeyArrayy);
            aaaa.putString("return", "yesm");
            aaaa.apply();

            startActivity(get_target);
            finish();

        } else if (flag.equals("message")) {

            Bundle args = new Bundle();
            SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor aaaa = pref.edit();

            String markeyArrayy1 = String.valueOf(groupad1);
            Log.d("marketArray 2", "onClick: " + markeyArrayy1);
            Intent get_target = new Intent(select_market_group_activity.this, Target_activity.class);
            get_target.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            get_target.putExtra("type", type);
            aaaa.putString("messageGropuArray", markeyArrayy1);
            aaaa.putString("return", "yesm");
            aaaa.apply();

            startActivity(get_target);
            finish();
        }
    }

    @Override
    public void onBackPressed() {

        if (flag12.equals("add")) {
            back_group("1");
        } else if (flag12.equals("edit")) {
            back_group("2");
        }else {
            Intent get_back = new Intent(select_market_group_activity.this, Share_activity.class);
            get_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(get_back);
        }
    }
}