package com.tjlcast.demo03;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * Retrofit LoggingInterceptor日期拦截器
 */
public class LoggingInterceptor implements Interceptor{
    private static Logger LOGGER = Logger.getLogger(LoggingInterceptor.class.getName()) ;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LOGGER.info(String.format("发送请求: %s%n请求头：%s",
                request.url(), request.headers())) ;
        Response response = chain.proceed(request);
        return response ;
    }
}
