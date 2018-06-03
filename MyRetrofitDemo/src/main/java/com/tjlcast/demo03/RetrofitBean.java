package com.tjlcast.demo03;

import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 工厂生产的实体类
 */
public class RetrofitBean {

    private Retrofit retrofit ;
    private Map<Class, Object> service = new HashMap<>() ;

    public Retrofit getRetrofit() {
        return retrofit ;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit ;
    }

    public Map<Class, Object> getService() {
        return service ;
    }

    public void setService(Map<Class, Object> service) {
        this.service = service ;
    }
}
