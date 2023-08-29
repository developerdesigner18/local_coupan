package com.example.local_coupan;

import android.content.Context;
import android.content.SharedPreferences;

public class preferences2 {

    public static final String APP_PREF = "AgeGuessingPreferences";
    public static SharedPreferences sp;
    public static String KEY_COUPON_TITLE = "key_coupon_title";
    public static String KEY_BRAND_NAME = "key_brand_name";
    public static String KEY_PRODUCT_NAME = "key_product_name";
    public static String KEY_PRODUCT_Image = "key_product_Image";
    public static String KEY_Detroye = "key_detroye";
    public static String KEY_Type2 = "type2";
    public static String KEY_Type3 = "type3";
    public static String KEY_Type4 = "type4";
    public static String KEY_Type5 = "type5";
    public static String KEY_Deal = "deal";
    public static String KEY_ID = "ID";
    public static String KEY_Part = "part";
    public static String KEY_File = "file";
    public static String KEY_Location_File = "Locationfile";
    public static String KEY_Bitmap = "bitt";
    public static String KEY_Lpart= "lpart";
    public static String KEY_lbitmap = "lbitm";
    public static String Key_delevary= "delevery";
    public static String Key_budget= "budhet";

    public static String edit_title = "title";
    public static String edit_brand= "brand";
    public static String edit_product= "product";
    public static String edit_delivery= "delivery";


    public static void save(Context context, String key, String value) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static String get(Context context, String key) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        String userId = sp.getString(key, "");
        return userId;
    }

    public static String getString(Context context, String key) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        String userId = sp.getString(key, "");
        return userId;
    }

    public static void saveInt(Context context, String key, int value) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static int getInt(Context context, String key) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        int userId = sp.getInt(key, 0);
        return userId;
    }

//
//    public static MultipartBody.Part getPPart(Context context, String key) {
//        sp = context.getSharedPreferences(APP_PREF, 0);
//        File fileDir = context.getFilesDir();
//        File file = new File(fileDir.getName());
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/"), file);
//        MultipartBody.Part userId = sp.getString(key, MultipartBody.Part.createFormData("couponImage", file.getName(), requestBody));
//        return userId;
//    }


    public static void saveBool(Context context, String key, Boolean value) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static Boolean getBool(Context context, String key) {
        sp = context.getSharedPreferences(APP_PREF, 0);
        return sp.getBoolean(key, false);
    }

    public static void clearPreference(Context context) {
        sp = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.apply();
    }
}