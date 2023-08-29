
package com.example.local_coupan.model.share_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareData {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("sharealldata")
    @Expose
    private share_all_data sharealldata;

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

    public share_all_data getsharealldata() {
        return sharealldata;
    }

    public void setsharealldata(share_all_data sharealldata) {
        this.sharealldata = sharealldata;
    }

}
