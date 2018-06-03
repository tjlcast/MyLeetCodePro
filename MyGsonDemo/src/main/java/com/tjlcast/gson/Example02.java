package com.tjlcast.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;

import java.lang.reflect.Type;
import java.util.List;

import static java.lang.System.out ;

/**
 * Created by tangjialiang on 2018/5/27.
 */
public class Example02 {

    public static void main(String[] args) {
        // 使用 SerializedName
        Gson gson = new Gson();
        String userJ = "{\"name\":\"怪盗kidou\",\"age\":24, \"email_address\":\"tjl@emial.com\"}";
        User user = gson.fromJson(userJ, User.class);
        out.println(user);

        // 使用 数组 范型
        Gson gson1 = new Gson();
        String jsonArr = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson1.fromJson(jsonArr, String[].class);
        List<String> stringList = gson1.fromJson(jsonArr, new TypeToken<List<String>>() {}.getType()) ; // 表示new的是一个匿名内部类的对象。。这个匿名类继承自TypeToken类
        for (String str : strings) {
            out.println(str);
        }
        for (String str : stringList) {
            out.println(str);
        }

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

    public class UserResponse {
        public int code ;
        public String message ;
        public User data ;
    }

    /**
     * 过泛型的话我们可以将code和message字段抽取到一个Result的类中，
     * 这样我们只需要编写data字段所对应的POJO即可，
     * 更专注于我们的业务逻辑.
     * @param <T>
     */
    public class Result<T> {
        public int code ;
        public String Message ;
        public T data ;
    }

    /**
     * 没有使用范型的例子
     */
    public class UserResult {
        public int code ;
        public String message ;
        public User data ;
    }
    public class UserListResult {
        public int code ;
        public String message ;
        public List<User> data ;
    }

    public void generalMethod() {
        String json = "{}" ;
        Gson gson = new Gson() ;
        UserResult userResult = gson.fromJson(json, UserResult.class);
        User data = userResult.data;

        UserListResult userListResult = gson.fromJson(json, UserListResult.class);
        List<User> data1 = userListResult.data;
    }

    /**
     * 使用范型的例子
     */
    public void genericMethode() {
        String json = "{}" ;
        Gson gson = new Gson();

        Type userType = new TypeToken<Result<User>>() {}.getType();
        Result<User> userResult = gson.fromJson(json, userType);
        User data = userResult.data;

        Type userListType = new TypeToken<Result<List<User>>>() {}.getType();
        Result<List<User>> userListResult = gson.fromJson(json, userListType);
        List<User> data1 = userListResult.data;
    }
}
