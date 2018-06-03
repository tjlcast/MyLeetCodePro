package com.tjlcast.gson.tesDemo;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out ;

/**
 * Created by tangjialiang on 2018/5/27.
 */
public class Test {

    static class Person {
        private Person() {
            out.println("person construct") ;
        }
    }

    static class Student extends Person {
        public Student() {
            super();
            out.println("student construct");
        }
    }

    @AllArgsConstructor
    class User<T> {
        private String name ;
        private int age ;
        private String emailAddress ;
        String[] others;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", emailAddress='" + emailAddress + '\'' +
                    ", others=" + Arrays.toString(others) +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student ss = new Student() ;

        String userJson1 = "{\"name\":\"怪盗kidou\",\"age\":24, \"emailAddress\":\"tjl@emial.com\", \"others\":[123, 21]}";

        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(userJson1, JsonObject.class);

        out.println(jsonObj.get("name").toString()) ;
        out.println(jsonObj.get("name").getAsString()) ;

        out.println(jsonObj.get("others").isJsonPrimitive());
        out.println(jsonObj.get("others").isJsonArray());
        // out.println(jsonObj.get("others").getAsString());       // getAsString 得到这个字段的值(即必须是jsonPrimitive类型)
        out.println(jsonObj.get("age").isJsonPrimitive());

        User<String[]> user = gson.fromJson(userJson1, new TypeToken<User<String[]>>() {}.getType()) ;
        out.println(user);

        JsonParser jsonParser = new JsonParser();
        JsonObject parse = (JsonObject)jsonParser.parse(userJson1);
        JsonElement element = parse.get("others");
        out.println(element);
        out.println(element.isJsonPrimitive());
    }
}
