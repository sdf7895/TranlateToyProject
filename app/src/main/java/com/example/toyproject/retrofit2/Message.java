package com.example.toyproject.retrofit2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("service")
        @Expose
        private String service;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("result")
        @Expose
        private DetailData detailData;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public DetailData getDetailData() {
            return detailData;
        }

        public void setdetailData(DetailData detailData) {
            this.detailData = detailData;
        }

    }

