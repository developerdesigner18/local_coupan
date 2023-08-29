
package com.example.local_coupan.model.get_coupon_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistic {
    @SerializedName("Unit Price")
    @Expose
    private Double unitPrice;
    @SerializedName("Spend to Date")
    @Expose
    private Float spendToDate;
    @SerializedName("Remaining Budget")
    @Expose
    private Double remainingBudget;
    @SerializedName("Deliveries")
    @Expose
    private Integer deliveries;
    @SerializedName("Scanned Redemptions")
    @Expose
    private Integer scannedRedemptions;

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getSpendToDate() {
        return spendToDate;
    }

    public void setSpendToDate(Float spendToDate) {
        this.spendToDate = spendToDate;
    }

    public Double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(Double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public Integer getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Integer deliveries) {
        this.deliveries = deliveries;
    }

    public Integer getScannedRedemptions() {
        return scannedRedemptions;
    }

    public void setScannedRedemptions(Integer scannedRedemptions) {
        this.scannedRedemptions = scannedRedemptions;
    }
}
