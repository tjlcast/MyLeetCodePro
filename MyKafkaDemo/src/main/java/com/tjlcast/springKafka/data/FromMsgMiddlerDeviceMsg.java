package com.tjlcast.springKafka.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tangjialiang on 2018/4/22.
 */
@Data
public class FromMsgMiddlerDeviceMsg implements Serializable {

    private final JsonObject jsonObj ;  // optional
    private final String deviceId ;     // required
    private final Integer tenantId ;    // required
    private final String deviceType;    // optional

    public FromMsgMiddlerDeviceMsg(JsonObject jsonObj) {
        this.jsonObj = jsonObj ;
        this.deviceId = jsonObj.get("deviceId").getAsString() ;
        this.tenantId = Integer.valueOf(jsonObj.get("tenantId").getAsString()) ;
        this.deviceType = jsonObj.get("deviceType").getAsString();
    }

    public FromMsgMiddlerDeviceMsg(String str) {
        this(new JsonParser().parse(str).getAsJsonObject()) ;
    }

    public Integer getTenantId() {
        return this.tenantId ;
    }

    public String getDeviceId() {
        return this.deviceId ;
    }

    public static class Builder {
        String deviceId ;
        int tenantId ;

        JsonObject jsonObj = new JsonObject();  // todo
        String deviceType = "default";          // todo

        public Builder(int tenantId, String deviceId) {
            this.deviceId = deviceId ;
            this.tenantId = tenantId ;
        }

        public Builder jsonObj(JsonObject jsonObject) {
            this.jsonObj = jsonObject ;
            return this ;
        }
        public Builder deviceType(String deviceType) {
            this.deviceType = deviceType ;
            return this ;
        }
        public FromMsgMiddlerDeviceMsg build() {
            return new FromMsgMiddlerDeviceMsg(this) ;
        }
    }

    private FromMsgMiddlerDeviceMsg(Builder builder) {
        this.jsonObj = builder.jsonObj ;
        this.deviceId = builder.deviceId ;
        this.tenantId = builder.tenantId ;
        this.deviceType = builder.deviceType ;
    }

}
