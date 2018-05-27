package com.tjlcast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by tangjialiang on 2018/5/26.
 */
public class ResponseBodyPrinter {
    /**
     * 为了方便保证执行的顺序，适用的是同步方法
     */
    public static void printResponseBody(Call<ResponseBody> call) {
        try {
            Response<ResponseBody> response = call.execute() ;
            if (response.isSuccessful()) {
                System.out.println(response.body().string()) ;
            } else {
                System.out.println("HttpCode:" + response.code());
                System.out.println("Message:" + response.message());
                System.out.println(response.errorBody().string()) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
