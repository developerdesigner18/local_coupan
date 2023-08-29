package com.example.local_coupan.model;

public class coupan_title_model {

    String txt_coupon_title, txt_coupon_live, txt_budget, txt_price, txt_deliveries, txt_deliveries_price, txt_scanned_redemption, txt_scanned_number;

    public coupan_title_model(String txt_coupon_title, String txt_coupon_live, String txt_budget, String txt_price, String txt_deliveries, String txt_deliveries_price, String txt_scanned_redemption, String txt_scanned_number) {
        this.txt_coupon_title = txt_coupon_title;
        this.txt_coupon_live = txt_coupon_live;
        this.txt_budget = txt_budget;
        this.txt_price = txt_price;
        this.txt_deliveries = txt_deliveries;
        this.txt_deliveries_price = txt_deliveries_price;
        this.txt_scanned_redemption = txt_scanned_redemption;
        this.txt_scanned_number = txt_scanned_number;
    }

    public String getTxt_coupon_title() {
        return txt_coupon_title;
    }

    public void setTxt_coupon_title(String txt_coupon_title) {
        this.txt_coupon_title = txt_coupon_title;
    }

    public String getTxt_coupon_live() {
        return txt_coupon_live;
    }

    public void setTxt_coupon_live(String txt_coupon_live) {
        this.txt_coupon_live = txt_coupon_live;
    }

    public String getTxt_budget() {
        return txt_budget;
    }

    public void setTxt_budget(String txt_budget) {
        this.txt_budget = txt_budget;
    }

    public String getTxt_price() {
        return txt_price;
    }

    public void setTxt_price(String txt_price) {
        this.txt_price = txt_price;
    }

    public String getTxt_deliveries() {
        return txt_deliveries;
    }

    public void setTxt_deliveries(String txt_deliveries) {
        this.txt_deliveries = txt_deliveries;
    }

    public String getTxt_deliveries_price() {
        return txt_deliveries_price;
    }

    public void setTxt_deliveries_price(String txt_deliveries_price) {
        this.txt_deliveries_price = txt_deliveries_price;
    }

    public String getTxt_scanned_redemption() {
        return txt_scanned_redemption;
    }

    public void setTxt_scanned_redemption(String txt_scanned_redemption) {
        this.txt_scanned_redemption = txt_scanned_redemption;
    }

    public String getTxt_scanned_number() {
        return txt_scanned_number;
    }

    public void setTxt_scanned_number(String txt_scanned_number) {
        this.txt_scanned_number = txt_scanned_number;
    }
}
