package com.tjlcast.demo02;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 基于Retrofit的方法
 */
public class UserLoginRetrofit {

    public interface ApiManager {
        @GET("login/")
        Call<ResponseBody> getData(@Query("name") String name, @Query("password") String pw) ;
    }

    private void getLogin() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://lcaohost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        Call<ResponseBody> call = apiManager.getData("tjl", "12345");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    // do something.
                } else {
                    // do others.
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                // do onFailure.
            }
        });
    }
}
