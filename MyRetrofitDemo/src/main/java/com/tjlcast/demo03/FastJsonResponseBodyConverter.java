package com.tjlcast.demo03;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

import java.io.IOException;

import java.lang.reflect.Type;

/**
 * Created by tangjialiang on 2018/5/28.
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type ;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    /**
     * 转换方法
     * @param responseBody
     * @return
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        BufferedSource buffer = Okio.buffer(responseBody.source());
        String tempStr = buffer.readUtf8();
        buffer.close();

        try {
            return JSON.parseObject(tempStr, type) ;
        } catch (Exception e) {
            return (T) tempStr ;
        }
    }
}