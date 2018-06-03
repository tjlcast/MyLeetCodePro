package com.tjlcast.demo03;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhangbowen on 2016/1/21.
 * 环信及时通讯服务
 */
@Service
public class IMService {
    @HttpService
    private IMApi imApi;
    /**
     * 修改群组信息
     *
     * @param updateGroupInfoBean
     * @param groupId
     */
    public void updateGroupInfo(UpdateGroupInfoBean updateGroupInfoBean, String groupId) {
        try {
            imApi.updateGroup(updateGroupInfoBean, groupId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}