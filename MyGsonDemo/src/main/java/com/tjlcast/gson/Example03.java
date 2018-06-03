package com.tjlcast.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

/**
 * Created by tangjialiang on 2018/5/27.
 */
public class Example03 {

    public void method01() throws IOException {
        String json = "{\"name\":\"怪盗kidou\",\"age\":\"24\"}" ;
        User user = new User() ;
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject() ;

        while(reader.hasNext()) {
            String s = reader.nextName() ;
            switch (s) {
                case "name":
                    user.name = reader.nextString() ;
                    break ;
                case "age":
                    user.age = reader.nextInt() ;
                    break ;
                case "email":
                    user.emailAddress = reader.nextString() ;
                    break ;
            }
        }
    }

    /**
     * PrintStream(System.out) 、StringBuilder、StringBuffer和*Writer都实现了Appendable
     */
    public void method02() throws IOException {

        // 手动方式
        Gson gson = new Gson();
        User user = new User("tjl", 23, "tjl");
        gson.toJson(user, System.out) ; // toJson 的第二个参数类型为Appendable.

        //
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        writer.beginObject()
                .name("name").value("tjl")
                .name("age").value(23)
                .name("email").nullValue()
                .endObject() ;

        writer.flush();
    }


    @AllArgsConstructor
    public static class User {

        User() {
            this("tjl", 23, "tjl@email.com") ;
        }

        private String name ;

        private int age ;

        @SerializedName("email_address")
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
