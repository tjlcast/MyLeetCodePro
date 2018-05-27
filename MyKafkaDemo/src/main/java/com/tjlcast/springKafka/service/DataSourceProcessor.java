package com.tjlcast.springKafka.service;

import com.tjlcast.springKafka.data.FromMsgMiddlerDeviceMsg;

/**
 * Created by tangjialiang on 2018/4/22.
 */
public interface DataSourceProcessor {
    void process(FromMsgMiddlerDeviceMsg msg) ;     // send data to akka
}
