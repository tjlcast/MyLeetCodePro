package com.tjlcast.demo01;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * [Retrofit注解详解 之 HTTP注解]源码
 */
public class Example02 {

    public interface BlogService {
        @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
        Call<ResponseBody> getBlog(@Path("id") int id) ;
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();

        BlogService blogService = retrofit.create(BlogService.class);
        Call<ResponseBody> call = blogService.getBlog(2);
        ResponseBodyPrinter.printResponseBody(call);
    }
}
