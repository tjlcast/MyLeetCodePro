package com.tjlcast.demo01;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * [Retrofit注解详解 之 FormUrlEncoded/Field/FieldMap注解]源码
 */
public class Example04 {

    public interface BlogService {
        @GET("/headers?showAll=true")
        @Headers({"CustomHeader1: customHeaderValue1", "CustomHeader2: customHeaderValue2"})
        Call<ResponseBody> testHeader(@Header("CustomHeader3") String customHeaderValue3) ;
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build() ;

        BlogService blogService = retrofit.create(BlogService.class);

        // 演示 @Headers 和 @Header
        Call<ResponseBody> call1 = blogService.testHeader("ikidou") ;
        ResponseBodyPrinter.printResponseBody(call1);
    }
}
