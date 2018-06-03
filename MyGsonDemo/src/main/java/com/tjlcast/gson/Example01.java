package com.tjlcast.gson;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

/**
 * 关于基本类型 与 POJO 类型的生成与解析
 * Created by tangjialiang on 2018/5/27.
 */
public class Example01 {

    public static void main(String[] args) {

        // 基本数据类型的解析
        Gson gson = new Gson() ;
        int i = gson.fromJson("100", int.class) ;
        double d = gson.fromJson("\"99.99\"", double.class) ;
        boolean b = gson.fromJson("true", boolean.class) ;
        String str = gson.fromJson("String", String.class) ;

        // 基本数据类型的生成
        Gson gson1 = new Gson() ;
        String jsonNumber = gson1.toJson(100) ;
        String jsonBoolean = gson1.toJson(false) ;
        String jsonString = gson1.toJson("String") ;

        //POJO 类型的解析
        Gson gson2 = new Gson();
        User user = new User("tjlcast", 24, "tjlcast@email.com") ;
        String userJson = gson2.toJson(user);
        System.out.println(userJson) ;

        // POJO 类型的生成
        Gson gson3 = new Gson();
        String userJson1 = "{\"name\":\"怪盗kidou\",\"age\":24, \"emailAddress\":\"tjl@emial.com\"}";
        User user1 = gson3.fromJson(userJson1, User.class) ;
        System.out.println(user1) ;
    }

    @AllArgsConstructor
    public static class User {
        private String name ;
        private int age ;
        private String emailAddress ;

        @Override
        public String toString() {
            return "User:["
                    + " name: " + name
                    + " age: " + age
                    + " emailAddress: " + emailAddress ;

        }
    }
}
