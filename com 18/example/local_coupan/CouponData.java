
package com.example.local_coupan;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CouponData {

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
    private Object couponImage;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("dealType")
    @Expose
    private String dealType;
    @SerializedName("offerText")
    @Expose
    private String offerText;
    @SerializedName("percentageDiscount")
    @Expose
    private Integer percentageDiscount;
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
    @SerializedName("displayPriceSaving")
    @Expose
    private Boolean displayPriceSaving;
    @SerializedName("displayPercentSaving")
    @Expose
    private Boolean displayPercentSaving;
    @SerializedName("longProd")
    @Expose
    private String longProd;
    @SerializedName("serText")
    @Expose
    private String serText;
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
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("town")
    @Expose
    private String town;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("mapPin")
    @Expose
    private String mapPin;
    @SerializedName("addressImage")
    @Expose
    private Object addressImage;
    @SerializedName("openingTimes")
    @Expose
    private String openingTimes;
    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("marketingGroup")
    @Expose
    private String marketingGroup;
    @SerializedName("messageGroup")
    @Expose
    private List<String> messageGroup = null;
    public List<String> getMessageGroup() {
        return messageGroup;
    }

    public void setMessageGroup(List<String> messageGroup) {
        this.messageGroup = messageGroup;
    }
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("journey")
    @Expose
    private String journey;
    @SerializedName("distanceUnits")
    @Expose
    private String distanceUnits;
    @SerializedName("distancenum")
    @Expose
    private Integer distancenum;
    @SerializedName("journeyType")
    @Expose
    private String journeyType;
    @SerializedName("journeyTime")
    @Expose
    private String journeyTime;
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
    @SerializedName("projectCurrency")
    @Expose
    private String projectCurrency;
    @SerializedName("dailyBudget")
    @Expose
    private Integer dailyBudget;
    @SerializedName("playPauseStatus")
    @Expose
    private Boolean playPauseStatus;
    @SerializedName("locationType")
    @Expose
    private String locationType;
    @SerializedName("geofenceUnit")
    @Expose
    private String geofenceUnit;
    @SerializedName("journeyTyep")
    @Expose
    private String journeyTyep;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("budget")
    @Expose
    private Integer budget;
    @SerializedName("deliveryCost")
    @Expose
    private Double deliveryCost;
    @SerializedName("deal")
    @Expose
    private Integer deal;
    @SerializedName("showCalculations")
    @Expose
    private String showCalculations;
    @SerializedName("overallBudget")
    @Expose
    private Integer overallBudget;
    @SerializedName("maximumDailybudget")
    @Expose
    private Integer maximumDailybudget;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("timeToLocation")
    @Expose
    private String timeToLocation;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("QRCode")
    @Expose
    private String qRCode;

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

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public Integer getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Integer percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
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

    public Integer getPercentageSaving() {
        return percentageSaving;
    }

    public void setPercentageSaving(Double percentageSaving) {
        this.percentageSaving = percentageSaving;
    }

    public Boolean getDisplayPriceSaving() {
        return displayPriceSaving;
    }

    public void setDisplayPriceSaving(Boolean displayPriceSaving) {
        this.displayPriceSaving = displayPriceSaving;
    }

    public Boolean getDisplayPercentSaving() {
        return displayPercentSaving;
    }

    public void setDisplayPercentSaving(Boolean displayPercentSaving) {
        this.displayPercentSaving = displayPercentSaving;
    }

    public String getLongProd() {
        return longProd;
    }

    public void setLongProd(String longProd) {
        this.longProd = longProd;
    }

    public String getSerText() {
        return serText;
    }

    public void setSerText(String serText) {
        this.serText = serText;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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

    public String getMapPin() {
        return mapPin;
    }

    public void setMapPin(String mapPin) {
        this.mapPin = mapPin;
    }

    public Object getAddressImage() {
        return addressImage;
    }

    public void setAddressImage(Object addressImage) {
        this.addressImage = addressImage;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
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

    public String getMarketingGroup() {
        return marketingGroup;
    }

    public void setMarketingGroup(String marketingGroup) {
        this.marketingGroup = marketingGroup;
    }



    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
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

    public String getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getGeofenceUnit() {
        return geofenceUnit;
    }

    public void setGeofenceUnit(String geofenceUnit) {
        this.geofenceUnit = geofenceUnit;
    }

    public String getJourneyTyep() {
        return journeyTyep;
    }

    public void setJourneyTyep(String journeyTyep) {
        this.journeyTyep = journeyTyep;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
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

    public String getQRCode() {
        return qRCode;
    }

    public void setQRCode(String qRCode) {
        this.qRCode = qRCode;
    }

}
