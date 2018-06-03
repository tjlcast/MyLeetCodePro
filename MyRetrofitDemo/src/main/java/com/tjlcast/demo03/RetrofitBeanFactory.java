package com.tjlcast.demo03;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjialiang on 2018/5/28.
 *
 * 工厂类
 */
public class RetrofitBeanFactory {
    // key:     请求地址
    // value:   当前请求地址下class所对应的service(key:class value:service)
    private static Map<String, RetrofitBean> resolvableDependencies = new HashMap<>() ;
    private static final int readTimeOut    = 15 ;
    private static final int writeTimeOut   = 15 ;
    private static final int connTimeOut    = 15 ;

    /**
     * 获取service服务实体
     * @param requireType
     * @return
     */
    public static Object getBean(Class requireType) {
        for (Map.Entry<String, RetrofitBean> entrySet : resolvableDependencies.entrySet()) {
            RetrofitBean retrofitBean = entrySet.getValue();
            for (Map.Entry<Class, Object> serviceSet : retrofitBean.getService().entrySet()) {
                if (requireType == serviceSet.getKey()) {
                    return serviceSet.getValue();
                }
            }
        }
        return null;
    }

    public static Object putBean(String baseUrl, Class serviceClass, Class... interceptorClass) {
        if (StringUtils.isEmpty(baseUrl)) {
            return null ;
        }
        RetrofitBean retrofitBean = resolvableDependencies.get(baseUrl);
        // 如果为空设置一个
        if (retrofitBean == null) {
            retrofitBean = new RetrofitBean() ;
            OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder()
                    .connectTimeout(readTimeOut, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeOut, TimeUnit.SECONDS)
                    .readTimeout(connTimeOut, TimeUnit.SECONDS)
                    .addInterceptor(new LoggingInterceptor());
            if (interceptorClass != null && interceptorClass.length > 0) {
                for (Class clazz : interceptorClass) {
                    if (Interceptor.class.isAssignableFrom(clazz)) {
                        try {
                            clientBuilder.addInterceptor((Interceptor) clazz.newInstance()) ;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(clientBuilder.build())
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .build() ;
            retrofitBean.setRetrofit(retrofit);
            resolvableDependencies.put(baseUrl, retrofitBean) ;
        }

        Retrofit retrofit = retrofitBean.getRetrofit();
        Object bean = retrofit.create(serviceClass);
        retrofitBean.getService().put(serviceClass, bean);
        return bean;
    }

    public static Map<String, RetrofitBean> getResolvableDependencies() {
        return resolvableDependencies;
    }
}
