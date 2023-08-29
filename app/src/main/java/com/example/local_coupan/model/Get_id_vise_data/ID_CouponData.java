
package com.example.local_coupan.model.Get_id_vise_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ID_CouponData {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("couponData")
    @Expose
    private CouponData__1 couponData;

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

    public CouponData__1 getCouponData() {
        return couponData;
    }

    public void setCouponData(CouponData__1 couponData) {
        this.couponData = couponData;
    }

}
