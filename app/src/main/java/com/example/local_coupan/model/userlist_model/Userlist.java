
package com.example.local_coupan.model.userlist_model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Userlist {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("LoginData")
    @Expose
    private List<Userlist_data> loginData = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Userlist_data> getLoginData() {
        return loginData;
    }

    public void setLoginData(List<Userlist_data> loginData) {
        this.loginData = loginData;
    }

}
