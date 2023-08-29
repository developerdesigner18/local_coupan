
package com.example.local_coupan.model.play_pause;

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
    @SerializedName("couponImage")
    @Expose
    private String couponImage;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("dealType")
    @Expose
    private String dealType;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("normalPrice")
    @Expose
    private Integer normalPrice;
    @SerializedName("offerPrice")
    @Expose
    private Integer offerPrice;
    @SerializedName("priceSaving")
    @Expose
    private Integer priceSaving;
    @SerializedName("percentageSaving")
    @Expose
    private Double percentageSaving;
    @SerializedName("launchDate")
    @Expose
    private String launchDate;
    @SerializedName("launchTime")
    @Expose
    private String launchTime;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("expiryTime")
    @Expose
    private String expiryTime;
    @SerializedName("shared")
    @Expose
    private Boolean shared;
    @SerializedName("singleUse")
    @Expose
    private Boolean singleUse;
    @SerializedName("maximumRedemptions")
    @Expose
    private Integer maximumRedemptions;
    @SerializedName("location")
    @Expose
    private List<Object> location;
    @SerializedName("geoJson")
    @Expose
    private GeoJson geoJson;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("addressImage")
    @Expose
    private String addressImage;
    @SerializedName("openingTimes")
    @Expose
    private String openingTimes;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("marketingGroup")
    @Expose
    private List<String> marketingGroup;
    @SerializedName("messageGroup")
    @Expose
    private List<String> messageGroup;
    @SerializedName("distanceUnits")
    @Expose
    private String distanceUnits;
    @SerializedName("distancenum")
    @Expose
    private Integer distancenum;
    @SerializedName("journeyType")
    @Expose
    private String journeyType;
    @SerializedName("ageMin")
    @Expose
    private Integer ageMin;
    @SerializedName("ageMax")
    @Expose
    private Integer ageMax;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("weather")
    @Expose
    private String weather;
    @SerializedName("overTemperature")
    @Expose
    private Integer overTemperature;
    @SerializedName("underTemperature")
    @Expose
    private Integer underTemperature;
    @SerializedName("projectBudget")
    @Expose
    private Integer projectBudget;
    @SerializedName("playPauseStatus")
    @Expose
    private Boolean playPauseStatus;
    @SerializedName("locationType")
    @Expose
    private String locationType;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("termsDate")
    @Expose
    private String termsDate;
    @SerializedName("budget")
    @Expose
    private Double budget;
    @SerializedName("deliveryCost")
    @Expose
    private Double deliveryCost;
    @SerializedName("showCalculations")
    @Expose
    private String showCalculations;
    @SerializedName("overallBudget")
    @Expose
    private Integer overallBudget;
    @SerializedName("statistics")
    @Expose
    private List<Object> statistics;
    @SerializedName("maximumDailybudget")
    @Expose
    private Integer maximumDailybudget;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("timeToLocation")
    @Expose
    private String timeToLocation;
    @SerializedName("userUseCode")
    @Expose
    private Double userUseCode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("isPayment")
    @Expose
    private Boolean isPayment;
    @SerializedName("shareUserID")
    @Expose
    private List<String> shareUserID;
    @SerializedName("otherShared")
    @Expose
    private Boolean otherShared;
    @SerializedName("isSingleUse")
    @Expose
    private Boolean isSingleUse;
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
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("geofenceUnit")
    @Expose
    private String geofenceUnit;

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

    public String getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(String couponImage) {
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

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Integer normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
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

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(Boolean singleUse) {
        this.singleUse = singleUse;
    }

    public Integer getMaximumRedemptions() {
        return maximumRedemptions;
    }

    public void setMaximumRedemptions(Integer maximumRedemptions) {
        this.maximumRedemptions = maximumRedemptions;
    }

    public List<Object> getLocation() {
        return location;
    }

    public void setLocation(List<Object> location) {
        this.location = location;
    }

    public GeoJson getGeoJson() {
        return geoJson;
    }

    public void setGeoJson(GeoJson geoJson) {
        this.geoJson = geoJson;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddressImage() {
        return addressImage;
    }

    public void setAddressImage(String addressImage) {
        this.addressImage = addressImage;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
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

    public List<String> getMarketingGroup() {
        return marketingGroup;
    }

    public void setMarketingGroup(List<String> marketingGroup) {
        this.marketingGroup = marketingGroup;
    }

    public List<String> getMessageGroup() {
        return messageGroup;
    }

    public void setMessageGroup(List<String> messageGroup) {
        this.messageGroup = messageGroup;
    }

    public String getDistanceUnits() {
        return distanceUnits;
    }

    public void setDistanceUnits(String distanceUnits) {
        this.distanceUnits = distanceUnits;
    }

    public Integer getDistancenum() {
        return distancenum;
    }

    public void setDistancenum(Integer distancenum) {
        this.distancenum = distancenum;
    }

    public String getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(String journeyType) {
        this.journeyType = journeyType;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Integer getOverTemperature() {
        return overTemperature;
    }

    public void setOverTemperature(Integer overTemperature) {
        this.overTemperature = overTemperature;
    }

    public Integer getUnderTemperature() {
        return underTemperature;
    }

    public void setUnderTemperature(Integer underTemperature) {
        this.underTemperature = underTemperature;
    }

    public Integer getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

    public Boolean getPlayPauseStatus() {
        return playPauseStatus;
    }

    public void setPlayPauseStatus(Boolean playPauseStatus) {
        this.playPauseStatus = playPauseStatus;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTermsDate() {
        return termsDate;
    }

    public void setTermsDate(String termsDate) {
        this.termsDate = termsDate;
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

    public String getShowCalculations() {
        return showCalculations;
    }

    public void setShowCalculations(String showCalculations) {
        this.showCalculations = showCalculations;
    }

    public Integer getOverallBudget() {
        return overallBudget;
    }

    public void setOverallBudget(Integer overallBudget) {
        this.overallBudget = overallBudget;
    }

    public List<Object> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Object> statistics) {
        this.statistics = statistics;
    }

    public Integer getMaximumDailybudget() {
        return maximumDailybudget;
    }

    public void setMaximumDailybudget(Integer maximumDailybudget) {
        this.maximumDailybudget = maximumDailybudget;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeToLocation() {
        return timeToLocation;
    }

    public void setTimeToLocation(String timeToLocation) {
        this.timeToLocation = timeToLocation;
    }

    public Double getUserUseCode() {
        return userUseCode;
    }

    public void setUserUseCode(Double userUseCode) {
        this.userUseCode = userUseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    public List<String> getShareUserID() {
        return shareUserID;
    }

    public void setShareUserID(List<String> shareUserID) {
        this.shareUserID = shareUserID;
    }

    public Boolean getOtherShared() {
        return otherShared;
    }

    public void setOtherShared(Boolean otherShared) {
        this.otherShared = otherShared;
    }

    public Boolean getIsSingleUse() {
        return isSingleUse;
    }

    public void setIsSingleUse(Boolean isSingleUse) {
        this.isSingleUse = isSingleUse;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getGeofenceUnit() {
        return geofenceUnit;
    }

    public void setGeofenceUnit(String geofenceUnit) {
        this.geofenceUnit = geofenceUnit;
    }

}
