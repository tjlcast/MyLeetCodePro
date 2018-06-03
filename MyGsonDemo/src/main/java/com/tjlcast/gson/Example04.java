package com.tjlcast.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by tangjialiang on 2018/5/27.
 */
public class Example04 {

    static class Category {
        @Expose public int id ;
        @Expose public String name ;
        @Expose public List<Category> children ;

        // 因业务需要增加，但并不需要序列化
        public Category parent ;
    }

    public static void main(String[] args) {
        Category category = new Category();

        // 如果需要注解 @Expose 生效，使用GsonBuilder
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        String s = gson.toJson(category);
    }
}
