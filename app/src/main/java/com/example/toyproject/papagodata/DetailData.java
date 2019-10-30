package com.example.toyproject.papagodata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailData {

    @SerializedName("srcLangType")
    @Expose
    private String srcLangType;
    @SerializedName("tarLangType")
    @Expose
    private String tarLangType;
    @SerializedName("translatedText")
    @Expose
    private String translatedText;

    public String getSrcLangType() {
        return srcLangType;
    }

    public void setSrcLangType(String srcLangType) {
        this.srcLangType = srcLangType;
    }

    public String getTarLangType() {
        return tarLangType;
    }

    public void setTarLangType(String tarLangType) {
        this.tarLangType = tarLangType;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
