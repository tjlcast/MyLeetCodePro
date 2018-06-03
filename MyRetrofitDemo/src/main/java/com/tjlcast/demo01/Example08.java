package com.tjlcast.demo01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tjlcast.demo01.entity.Blog;
import com.tjlcast.demo01.entity.Result;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * [Retrofit CallAdapter rxJava]源码
 */
public class Example08 {

    public interface BlogService {
        @GET("/blog")
        Observable<Result<List<Blog>>> getBlogs(@Query("page") int page) ;
        /*
          「20160608补充」如果需要Header的值，可以把返回值替换为
            Observable<Response<Result<List<Blog>>>>
            Observable<retrofit2.adapter.rxjava.Result<Result<List<Blog>>>> //都叫Result，真是失策
         */
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create() ;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        BlogService blogService = retrofit.create(BlogService.class);

        blogService.getBlogs(1)
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Result<List<Blog>>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted") ;
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError") ;
                    }

                    @Override
                    public void onNext(Result<List<Blog>> listResult) {
                        System.out.println(listResult) ;
                    }
                }) ;
    }
}
