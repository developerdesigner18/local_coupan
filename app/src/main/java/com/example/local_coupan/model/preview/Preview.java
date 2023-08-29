
package com.example.local_coupan.model.preview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preview {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("previewCouponData")
    @Expose
    private PreviewCouponData previewCouponData;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public PreviewCouponData getPreviewCouponData() {
        return previewCouponData;
    }

    public void setPreviewCouponData(PreviewCouponData previewCouponData) {
        this.previewCouponData = previewCouponData;
    }

}
