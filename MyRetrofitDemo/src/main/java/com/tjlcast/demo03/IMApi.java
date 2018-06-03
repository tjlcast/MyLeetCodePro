package com.tjlcast.demo03;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by tangjialiang on 2018/5/28.
 */
//IM_BASE_URL在配置文件中配置
//interceptor 为可选参数，与retrofit拦截器相同，实现拦截http
@HttpApi(value = "IM_BASE_URL", interceptor = {ImInterceptor.class})
public interface IMApi {
    /**
     * 修改群组信息
     *
     * @param updateGroupInfoBean
     * @param groupId
     * @return
     */
    @PUT("chatgroups/{group_id}")
    Call<String> updateGroup(@Body UpdateGroupInfoBean updateGroupInfoBean, @Path("group_id") String groupId);
}