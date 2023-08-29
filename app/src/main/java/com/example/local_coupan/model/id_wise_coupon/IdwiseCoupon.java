package com.example.local_coupan.model.id_wise_coupon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdwiseCoupon {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("couponData")
    @Expose
    private CouponData couponData;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CouponData getCouponData() {
        return couponData;
    }

    public void setCouponData(CouponData couponData) {
        this.couponData = couponData;
    }

}
