package com.example.mybtpns.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NasabahResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("message")
    @Expose
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}