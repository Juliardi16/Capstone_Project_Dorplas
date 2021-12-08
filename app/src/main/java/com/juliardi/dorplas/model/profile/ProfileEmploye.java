package com.juliardi.dorplas.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileEmploye {
    @SerializedName("id_employes")
    @Expose
    private String idEmployes;
    @SerializedName("id_employe_roles")
    @Expose
    private String idEmployeRoles;
    @SerializedName("name_employes")
    @Expose
    private String nameEmployes;
    @SerializedName("email_employes")
    @Expose
    private String emailEmployes;
    @SerializedName("password_employes")
    @Expose
    private String passwordEmployes;
    @SerializedName("contact_employes")
    @Expose
    private String contactEmployes;
    @SerializedName("profile_image_employes")
    @Expose
    private String profileImageEmployes;
    @SerializedName("ForEmployeRoles")
    @Expose
    private Object forEmployeRoles;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    public String getIdEmployes() {
        return idEmployes;
    }

    public void setIdEmployes(String idEmployes) {
        this.idEmployes = idEmployes;
    }

    public String getIdEmployeRoles() {
        return idEmployeRoles;
    }

    public void setIdEmployeRoles(String idEmployeRoles) {
        this.idEmployeRoles = idEmployeRoles;
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

    public String getPasswordEmployes() {
        return passwordEmployes;
    }

    public void setPasswordEmployes(String passwordEmployes) {
        this.passwordEmployes = passwordEmployes;
    }

    public String getContactEmployes() {
        return contactEmployes;
    }

    public void setContactEmployes(String contactEmployes) {
        this.contactEmployes = contactEmployes;
    }

    public String getProfileImageEmployes() {
        return profileImageEmployes;
    }

    public void setProfileImageEmployes(String profileImageEmployes) {
        this.profileImageEmployes = profileImageEmployes;
    }

    public Object getForEmployeRoles() {
        return forEmployeRoles;
    }

    public void setForEmployeRoles(Object forEmployeRoles) {
        this.forEmployeRoles = forEmployeRoles;
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

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }
}
