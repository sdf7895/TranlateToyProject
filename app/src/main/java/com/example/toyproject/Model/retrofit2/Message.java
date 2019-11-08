package com.example.toyproject.Model.retrofit2;

import com.example.toyproject.Model.Language;
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
        private Language language;

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

        public Language getLanguage() {
            return language;
        }

        public void setLanguage(Language language) {
            this.language = language;
        }
}

