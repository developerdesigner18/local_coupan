
package com.example.local_coupan.model.qrcode_scan;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("couponTitle")
    @Expose
    private String couponTitle;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("shop")
    @Expose
    private String shop;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("couponImage")
    @Expose
    private Object couponImage;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("expiryCountDown")
    @Expose
    private String expiryCountDown;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("remainingPrice")
    @Expose
    private String remainingPrice;
    @SerializedName("percentageDiscount")
    @Expose
    private Integer percentageDiscount;
    @SerializedName("priceSaving")
    @Expose
    private Integer priceSaving;
    @SerializedName("percentageSaving")
    @Expose
    private Double percentageSaving;
    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("dealValue")
    @Expose
    private String dealValue;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("marketingGroup")
    @Expose
    private List<Object> marketingGroup = null;
    @SerializedName("messageGroup")
    @Expose
    private List<String> messageGroup = null;
    public List<String> getMessageGroup() {
        return messageGroup;
    }

    public void setMessageGroup(List<String> messageGroup) {
        this.messageGroup = messageGroup;
    }
    @SerializedName("journey")
    @Expose
    private String journey;
    @SerializedName("journeyTime")
    @Expose
    private String journeyTime;
    @SerializedName("projectBudget")
    @Expose
    private Integer projectBudget;
    @SerializedName("projectCurrency")
    @Expose
    private String projectCurrency;
    @SerializedName("dailyBudget")
    @Expose
    private Integer dailyBudget;
    @SerializedName("playPauseStatus")
    @Expose
    private Boolean playPauseStatus;
    @SerializedName("geofenceUnit")
    @Expose
    private String geofenceUnit;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("budget")
    @Expose
    private Double budget;
    @SerializedName("deliveryCost")
    @Expose
    private Double deliveryCost;
    @SerializedName("deal")
    @Expose
    private Integer deal;
    @SerializedName("overallBudget")
    @Expose
    private Integer overallBudget;
    @SerializedName("maximumDailybudget")
    @Expose
    private Integer maximumDailybudget;
    @SerializedName("userUseCode")
    @Expose
    private Double userUseCode;
    @SerializedName("shareUserID")
    @Expose
    private List<Object> shareUserID = null;
    @SerializedName("location")
    @Expose
    private List<Object> location = null;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("OTPQRCode")
    @Expose
    private Integer oTPQRCode;
    @SerializedName("QRCodeImage")
    @Expose
    private String qRCodeImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getDealValue() {
        return dealValue;
    }

    public void setDealValue(String dealValue) {
        this.dealValue = dealValue;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getoTPQRCode() {
        return oTPQRCode;
    }

    public void setoTPQRCode(Integer oTPQRCode) {
        this.oTPQRCode = oTPQRCode;
    }

    public String getqRCodeImage() {
        return qRCodeImage;
    }

    public void setqRCodeImage(String qRCodeImage) {
        this.qRCodeImage = qRCodeImage;
    }

    public Object getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(Object couponImage) {
        this.couponImage = couponImage;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Integer percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public Integer getPriceSaving() {
        return priceSaving;
    }

    public void setPriceSaving(Integer priceSaving) {
        this.priceSaving = priceSaving;
    }

    public Double getPercentageSaving() {
        return percentageSaving;
    }

    public void setPercentageSaving(Double percentageSaving) {
        this.percentageSaving = percentageSaving;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Object> getMarketingGroup() {
        return marketingGroup;
    }

    public void setMarketingGroup(List<Object> marketingGroup) {
        this.marketingGroup = marketingGroup;
    }



    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public String getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
    }

    public Integer getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getProjectCurrency() {
        return projectCurrency;
    }

    public void setProjectCurrency(String projectCurrency) {
        this.projectCurrency = projectCurrency;
    }

    public Integer getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(Integer dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public Boolean getPlayPauseStatus() {
        return playPauseStatus;
    }

    public void setPlayPauseStatus(Boolean playPauseStatus) {
        this.playPauseStatus = playPauseStatus;
    }

    public String getGeofenceUnit() {
        return geofenceUnit;
    }

    public void setGeofenceUnit(String geofenceUnit) {
        this.geofenceUnit = geofenceUnit;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    public Integer getOverallBudget() {
        return overallBudget;
    }

    public void setOverallBudget(Integer overallBudget) {
        this.overallBudget = overallBudget;
    }

    public Integer getMaximumDailybudget() {
        return maximumDailybudget;
    }

    public void setMaximumDailybudget(Integer maximumDailybudget) {
        this.maximumDailybudget = maximumDailybudget;
    }

    public String getExpiryCountDown() {
        return expiryCountDown;
    }

    public void setExpiryCountDown(String expiryCountDown) {
        this.expiryCountDown = expiryCountDown;
    }

    public Double getUserUseCode() {
        return userUseCode;
    }

    public void setUserUseCode(Double userUseCode) {
        this.userUseCode = userUseCode;
    }

    public String getRemainingPrice() {
        return remainingPrice;
    }

    public void setRemainingPrice(String remainingPrice) {
        this.remainingPrice = remainingPrice;
    }

    public List<Object> getShareUserID() {
        return shareUserID;
    }

    public void setShareUserID(List<Object> shareUserID) {
        this.shareUserID = shareUserID;
    }

    public List<Object> getLocation() {
        return location;
    }

    public void setLocation(List<Object> location) {
        this.location = location;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getOTPQRCode() {
        return oTPQRCode;
    }

    public void setOTPQRCode(Integer oTPQRCode) {
        this.oTPQRCode = oTPQRCode;
    }

    public String getQRCodeImage() {
        return qRCodeImage;
    }

    public void setQRCodeImage(String qRCodeImage) {
        this.qRCodeImage = qRCodeImage;
    }

}
