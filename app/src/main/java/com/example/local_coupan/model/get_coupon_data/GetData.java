
package com.example.local_coupan.model.get_coupon_data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetData {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("couponData")
    @Expose
    private List<CouponDatum> couponData;

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

    public List<CouponDatum> getCouponData() {
        return couponData;
    }

    public void setCouponData(List<CouponDatum> couponData) {
        this.couponData = couponData;
    }

}
