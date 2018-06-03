package com.tjlcast.demo03;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by zhangbowen on 2016/5/17.
 * 环信公用请求头拦截器
 */
public class ImInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
//        String token = CacheFacade.getObject(Constants.IM.TOKEN);
        Request request = originalRequest
                .newBuilder()
//                .addHeader(Constants.Http.AUTHORIZATION, "Bearer " + token)
                .build();
        return chain.proceed(request);
    }
}