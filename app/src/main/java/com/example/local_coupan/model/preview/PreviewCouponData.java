
package com.example.local_coupan.model.preview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreviewCouponData {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("QRCodeImage")
    @Expose
    private String qRCodeImage;
    @SerializedName("CouponImage")
    @Expose
    private String couponImage;
    @SerializedName("coupon_id")
    @Expose
    private String couponId;
    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("remainingPrice")
    @Expose
    private String remainingPrice;
    @SerializedName("Product")
    @Expose
    private String product;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("launchDate")
    @Expose
    private String launchDate;
    @SerializedName("deal")
    @Expose
    private String deal;
    @SerializedName("expiryCountDown")
    @Expose
    private String expiryCountDown;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("normalPrice")
    @Expose
    private String normalPrice;
    @SerializedName("Shared")
    @Expose
    private Boolean shared;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("discount_price")
    @Expose
    private String discountPrice;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("status")
    @Expose
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQRCodeImage() {
        return qRCodeImage;
    }

    public void setQRCodeImage(String qRCodeImage) {
        this.qRCodeImage = qRCodeImage;
    }

    public String getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(String couponImage) {
        this.couponImage = couponImage;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getExpiryCountDown() {
        return expiryCountDown;
    }

    public void setExpiryCountDown(String expiryCountDown) {
        this.expiryCountDown = expiryCountDown;
    }

    public String getqRCodeImage() {
        return qRCodeImage;
    }

    public void setqRCodeImage(String qRCodeImage) {
        this.qRCodeImage = qRCodeImage;
    }

    public String getRemainingPrice() {
        return remainingPrice;
    }

    public void setRemainingPrice(String remainingPrice) {
        this.remainingPrice = remainingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
