package com.example.freezone.service;

import com.example.freezone.domain.FriendRelationship;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangyizhou
* @description 针对表【friend_relationship】的数据库操作Service
* @createDate 2022-05-02 09:43:46
*/
public interface FriendRelationshipService extends IService<FriendRelationship> {

    /**
     * 添加好友(关注，无需同意)
     * @param userIdOne 用户1的id,用户1加用户2为好友
     * @param userIdTwo 用户2的id,用户2被用户1加好友
     * @return  是否添加成功
     */
    public boolean addFriend(long userIdOne,long userIdTwo);


    /**
     * 删除好友
     * @param userIdOne 用户1的id,用户1删除用户2好友
     * @param userIdTwo 用户1的id,用户2被用户2为删除
     * @return  是否删除成功
     */
    public boolean delFriend(long userIdOne,long userIdTwo);


    public int checkFriendRelationship(long userIdOne, long userIdTwo);
}
