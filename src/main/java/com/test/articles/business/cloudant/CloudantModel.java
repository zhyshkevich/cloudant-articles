package com.test.articles.business.cloudant;

import com.google.gson.annotations.SerializedName;

public abstract class CloudantModel {

    @SerializedName("_id")
    private String id;

    @SerializedName("_rev")
    private String rev;

    private Boolean isDeleted;

    public CloudantModel() {
    }

    public CloudantModel(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public CloudantModel(String id, String rev, Boolean isDeleted) {
        this.id = id;
        this.rev = rev;
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
