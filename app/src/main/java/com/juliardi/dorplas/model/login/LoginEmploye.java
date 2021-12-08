package com.juliardi.dorplas.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class LoginEmploye {

    @SerializedName("id_employes")
    @Expose
    private String idEmployes;
    @SerializedName("name_employes")
    @Expose
    private String nameEmployes;
    @SerializedName("email_employes")
    @Expose
    private String emailEmployes;
    @SerializedName("jwt_token_employes")
    @Expose
    private String jwtTokenEmployes;

    public String getIdEmployes() {
        return idEmployes;
    }

    public void setIdEmployes(String idEmployes) {
        this.idEmployes = idEmployes;
    }

    public String getNameEmployes() {
        return nameEmployes;
    }

    public void setNameEmployes(String nameEmployes) {
        this.nameEmployes = nameEmployes;
    }

    public String getEmailEmployes() {
        return emailEmployes;
    }

    public void setEmailEmployes(String emailEmployes) {
        this.emailEmployes = emailEmployes;
    }

    public String getJwtTokenEmployes() {
        return jwtTokenEmployes;
    }

    public void setJwtTokenEmployes(String jwtTokenEmployes) {
        this.jwtTokenEmployes = jwtTokenEmployes;
    }


}
