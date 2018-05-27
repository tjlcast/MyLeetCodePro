package com.tjlcast.springKafka;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tjlcast.springKafka.service.DataSourceProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by tangjialiang on 2018/5/27.
 */

@Component
public class SpringKafkaConsumer {

    @Autowired
    DataSourceProcessor dataSourceProcessor ;

    private static final Logger log = LoggerFactory.getLogger(SpringKafkaConsumer.class) ;

    @KafkaListener(topics =  {"deviceData"})
    public void receive(String message){
        // 得到Kafka上传的信息并转换为Json
        System.out.println(message);
        JsonObject jsonObj = (JsonObject)new JsonParser().parse(message);
    }
}

