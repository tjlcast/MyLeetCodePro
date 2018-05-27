package com.tjlcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tangjialiang on 2018/5/27.
 */

@Service
public class MyService {

    @Autowired
    private YmlConfig config ;

    public MyService () {
//        ObjectMapper objectMapper = new ObjectMapper() ;
//
//        //测试加载yml文件
//        System.out.println("simpleProp: " + config.getSimpleProp());
//        System.out.println("arrayProps: " + objectMapper.writeValueAsString(config.getArrayProps()));
//        System.out.println("listProp1: " + objectMapper.writeValueAsString(config.getListProp1()));
//        System.out.println("listProp2: " + objectMapper.writeValueAsString(config.getListProp2()));
//        System.out.println("mapProps: " + objectMapper.writeValueAsString(config.getMapProps()));
    }
}
