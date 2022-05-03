package com.example.freezone.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.freezone.domain.FriendRelationship;
import com.example.freezone.service.FriendRelationshipService;
import com.example.freezone.mapper.FriendRelationshipMapper;
import com.example.freezone.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.freezone.constant.FriendRelationship.*;

/**
* @author wangyizhou
* @description 针对表【friend_relationship】的数据库操作Service实现
* @createDate 2022-05-02 09:43:46
*/
@Service
public class FriendRelationshipServiceImpl extends ServiceImpl<FriendRelationshipMapper, FriendRelationship>
    implements FriendRelationshipService{

    @Resource
    private UserService userService;
    private FriendRelationshipMapper friendRelationshipMapper;

    @Override
    public boolean addFriend(long userIdOne, long userIdTwo) {
        // 1.判断好友关系(包含用户id合法)
        if (checkFriendRelationship(userIdOne,userIdTwo)!=0) {
            return false;
        }
        // 2.添加好友关系
        FriendRelationship friendRelationship = new FriendRelationship();
        friendRelationship.setUserIdOne(userIdOne);
        friendRelationship.setUserIdTwo(userIdTwo);
        return this.save(friendRelationship);

    }

    @Override
    public boolean delFriend(long userIdOne, long userIdTwo) {
        // 1.判断好友关系(包含用户id合法)
        if (checkFriendRelationship(userIdOne,userIdTwo)<=0) {
            return false;
        }
        // 2.删除好友关系
        QueryWrapper<FriendRelationship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id_one",userIdOne);
        queryWrapper.eq("user_id_two",userIdTwo);
        return friendRelationshipMapper.delete(queryWrapper)>0;

    }

    @Override
    public int checkFriendRelationship(long userIdOne, long userIdTwo) {
        // 1.判断两个用户是否存在
        if (userService.checkUserId(userIdOne) || userService.checkUserId(userIdTwo)){
            return FRIENDRELATIONSHIP_USER_ILLEGAL;
        }

        // 2.判断好友关系是否已经存在
        QueryWrapper<FriendRelationship> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id_one",userIdOne);
        queryWrapper.eq("user_id_two",userIdTwo);
        long count = friendRelationshipMapper.selectCount(queryWrapper);
        if (count>0){
            return FRIENDRELATIONSHIP_ALREADY_EXIST;
        }
        return FRIENDRELATIONSHIP_NOT_EXIST;
    }


}




