
package com.example.local_coupan;

import com.example.local_coupan.activity.Add_cupoan.AddCoupan;
import com.example.local_coupan.model.Edit__Coupan.EditData;
import com.example.local_coupan.model.GetQrcode;
import com.example.local_coupan.model.Get_id_vise_data.ID_CouponData;
import com.example.local_coupan.model.PaymentModel;
import com.example.local_coupan.model.get_coupon_data.GetData;
import com.example.local_coupan.model.id_wise_coupon.IdwiseCoupon;
import com.example.local_coupan.model.play_pause.PlayPause;
import com.example.local_coupan.model.preview.Preview;
import com.example.local_coupan.model.qrcode_scan.ScanQr;
import com.example.local_coupan.model.refund.Refund;
import com.example.local_coupan.model.share_data.ShareData;
import com.example.local_coupan.model.sign_in.LoginModel;
import com.example.local_coupan.model.sign_up.SignUp;
import com.example.local_coupan.model.userlist_model.Userlist;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart

    @POST("addCoupon")
    Call<AddCoupan> add_coupon(
            @Part("couponTitle") RequestBody couponTitle,
            @Part("brand") RequestBody brand,
            @Part("shop") RequestBody shop,
            @Part("product") RequestBody product,
            @Part("service") RequestBody service,
//            @Part("fixed") RequestBody fixed,
//            @Part("percent") RequestBody percent,
            @Part("dealType") RequestBody dealType,
//            @Part("offerText") RequestBody offerText,
//            @Part("percentageDiscount") RequestBody percentageDiscount,
            @Part("currency") RequestBody currency,
//            @Part("priceSaving") RequestBody priceSaving,
//            @Part("percentageSaving") RequestBody percentageSaving,
//            @Part("longProd") RequestBody longProd,
//            @Part("serText") RequestBody serText,
            @Part("launchDate") RequestBody launchDate,
            @Part("launchTime") RequestBody launchTime,
            @Part("expiryDate") RequestBody expiryDate,
            @Part("expiryTime") RequestBody expiryTime,
            @Part("shared") RequestBody shared,
            @Part("singleUse") RequestBody singleUse,
            @Part("maximumRedemptions") RequestBody maximumRedemptions,
            @Part("address1") RequestBody address1,
            @Part("address2") RequestBody address2,
            @Part("town") RequestBody town,
            @Part("city") RequestBody city,
            @Part("postcode") RequestBody postcode,
            @Part("openingTimes") RequestBody openingTimes,
//            @Part("message") RequestBody message,
//            @Part("market") RequestBody market,
//            @Part("profile") RequestBody profile,

            @Part("messageGroup") RequestBody messageGroup,
//            @Part("distance") RequestBody distance,
//            @Part("journeyType") RequestBody journeyType,
//            @Part("journeyTime") RequestBody journeyTime,
            @Part("ageMin") RequestBody ageMin,
            @Part("ageMax") RequestBody ageMax,
            @Part("gender") RequestBody gender,
            @Part("overTemperature") RequestBody overTemperature,
            @Part("underTemperature") RequestBody underTemperature,
            @Part("projectBudget") RequestBody projectBudget,
//            @Part("projectCurrency") RequestBody projectCurrency,
//            @Part("dailyBudget") RequestBody dailyBudget,
//            @Part("mapPin") RequestBody mapPin,
//            @Part("journey") RequestBody journey,
//            @Part("distanceUnits") RequestBody distanceUnits,
//            @Part("distancenum") RequestBody distancenum,
//            @Part("locationType") RequestBody locationType,
//            @Part("journeyTyep") RequestBody journeyTyep,
//            @Part("geofenceUnit") RequestBody geofenceUnit,
            @Part("terms") RequestBody terms,
            @Part("weather") RequestBody weather,
//            @Part("timeToLocation") RequestBody timeToLocation,
//            @Part("deal") RequestBody deal,
            @Part("showCalculations") RequestBody showCalculations,
            @Part("overallBudget") RequestBody overallBudget,
            @Part("maximumDailybudget") RequestBody maximumDailybudget,
            @Part("country") RequestBody country,
            @Part("userId") RequestBody userId,
            @Part("description") RequestBody description,
            @Part("marketingGroup") RequestBody marketingGroup,
//            @Query("location" ) ArrayList<String> location,
//            @Part("location") RequestBody location,
            @Part MultipartBody.Part couponImage,
            @Part("normalPrice") RequestBody normalPrice,
            @Part("offerPrice") RequestBody offerPrice,
            @Part("playPauseStatus") RequestBody playPauseStatus,
            @Part("budget") RequestBody budget,
            @Part MultipartBody.Part addressImage,
            @Part("deliveryCost") RequestBody deliveryCost,
            @Part("longitude") RequestBody longitude,
            @Part("latitude") RequestBody latitude,
            @Part("locationType") RequestBody locationType,
            @Part("journeyType") RequestBody journeyType,
            @Part("timeToLocation") RequestBody timeToLocation,
            @Part("distanceUnits") RequestBody distanceUnits,
            @Part("distancenum") RequestBody distancenum,
            @Part("termsDate") RequestBody termsDate

    );


    @Multipart
    @POST("editCouponData")
    Call<EditData> Editcoupan(@Part("couponTitle") RequestBody couponTitle,
                              @Part("brand") RequestBody brand,
                              @Part("shop") RequestBody shop,
                              @Part("product") RequestBody product,
                              @Part("service") RequestBody service,
//            @Part("fixed") RequestBody fixed,
//            @Part("percent") RequestBody percent,
                              @Part("dealType") RequestBody dealType,
//            @Part("offerText") RequestBody offerText,
//            @Part("percentageDiscount") RequestBody percentageDiscount,
                              @Part("currency") RequestBody currency,
//            @Part("priceSaving") RequestBody priceSaving,
//            @Part("percentageSaving") RequestBody percentageSaving,
//            @Part("longProd") RequestBody longProd,
//            @Part("serText") RequestBody serText,
                              @Part("launchDate") RequestBody launchDate,
                              @Part("launchTime") RequestBody launchTime,
                              @Part("expiryDate") RequestBody expiryDate,
                              @Part("expiryTime") RequestBody expiryTime,
                              @Part("shared") RequestBody shared,
                              @Part("singleUse") RequestBody singleUse,
                              @Part("maximumRedemptions") RequestBody maximumRedemptions,
                              @Part("address1") RequestBody address1,
                              @Part("address2") RequestBody address2,
                              @Part("town") RequestBody town,
                              @Part("city") RequestBody city,
                              @Part("postcode") RequestBody postcode,
                              @Part("openingTimes") RequestBody openingTimes,
//            @Part("message") RequestBody message,
//            @Part("market") RequestBody market,
//            @Part("profile") RequestBody profile,

                              @Part("distance") RequestBody distance,
                              @Part("journeyType") RequestBody journeyType,
//            @Part("journeyTime") RequestBody journeyTime,
                              @Part("ageMin") RequestBody ageMin,
                              @Part("ageMax") RequestBody ageMax,
                              @Part("gender") RequestBody gender,
                              @Part("overTemperature") RequestBody overTemperature,
                              @Part("underTemperature") RequestBody underTemperature,
                              @Part("projectBudget") RequestBody projectBudget,
//            @Part("projectCurrency") RequestBody projectCurrency,
//            @Part("dailyBudget") RequestBody dailyBudget,
//            @Part("mapPin") RequestBody mapPin,
//            @Part("journey") RequestBody journey,
                              @Part("distanceUnits") RequestBody distanceUnits,
                              @Part("distancenum") RequestBody distancenum,
                              @Part("locationType") RequestBody locationType,
//            @Part("journeyTyep") RequestBody journeyTyep,
                              @Part("geofenceUnit") RequestBody geofenceUnit,
                              @Part("terms") RequestBody terms,
                              @Part("weather") RequestBody weather,
                              @Part("timeToLocation") RequestBody timeToLocation,
//            @Part("deal") RequestBody deal,
                              @Part("showCalculations") RequestBody showCalculations,
                              @Part("overallBudget") RequestBody overallBudget,
                              @Part("maximumDailybudget") RequestBody maximumDailybudget,
                              @Part("country") RequestBody country,
                              @Part("userId") RequestBody userId,
                              @Part("description") RequestBody description,

//            @Query("location" ) ArrayList<String> location,
//            @Part("location") RequestBody location,

                              @Part("normalPrice") RequestBody normalPrice,
                              @Part("offerPrice") RequestBody offerPrice,
                              @Part("playPauseStatus") RequestBody playPauseStatus,
                              @Part("budget") RequestBody budget,

                              @Part("deliveryCost") RequestBody deliveryCost,
                              @Part("longitude") RequestBody longitude,
                              @Part("latitude") RequestBody latitude,
                              @Part("id") RequestBody id,
                              @Part MultipartBody.Part couponImage,
                              @Part("termsDate") RequestBody termsDate,
                              @Part MultipartBody.Part addressImage,
                              @Part("messageGroup") RequestBody messageGroup,
                              @Part("marketingGroup") RequestBody marketingGroup

    );

    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("refundPayment")
    Call<Refund> get_refund_coupon(@Body String id);

    @Headers("Content-Type: application/json")
    @POST("getCouponData")
    Call<GetData> show_coupon(@Body String id);

    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("getQRCode")
    Call<GetQrcode> get_qrcode_id(@Body String id);


    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("changeStatus")
    Call<PlayPause> get_play_pause_status(@Body String id);


    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("scanCoupon")
    Call<ScanQr> get_scan(@Body String id);


    @Headers("Content-Type: application/json")
    @POST("signUp")
    Call<SignUp> get_signup(@Body String body2);


    @Headers("Content-Type: application/json")
    @POST("signIn")
    Call<LoginModel> get_signin(@Body String body2);


    @Headers("Content-Type: application/json")
    @POST("couponData")
    Call<ID_CouponData> getCoupon_data(@Body String body2);


    @Headers({"Content-Type: application/json", "Accept: application/json", "Connection: keep-alive"})
    @POST("makePayment")
    Call<PaymentModel> get_payment_link(@Body String title);


    @Headers("Content-Type: application/json")
    @POST("preViewCoupon")
    Call<Preview> preview_data(@Body String body2);


    @Headers("Content-Type: application/json")
    @POST("shareUserCoupon")
    Call<ShareData> get_share_data(@Body String body2);


    @Headers("Content-Type: application/json")
    @POST("getAllUSers")
    Call<Userlist> get_user_list(@Body String id);


    @Headers("Content-Type: application/json")
    @POST("couponData")
    Call<IdwiseCoupon> get_id_wise_data(@Body String body2);
}