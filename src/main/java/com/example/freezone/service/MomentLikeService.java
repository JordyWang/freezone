package com.example.freezone.service;

import com.example.freezone.domain.MomentLike;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * @author wangyizhou
 * @description 针对表【moment_like】的数据库操作Service
 * @createDate 2022-05-02 09:59:46
 */
public interface MomentLikeService extends IService<MomentLike> {

    /**
     * 点赞动态
     * @param momentId  动态id
     * @param senderUserId  点赞用户id
     * @return  是否点赞成功
     */
    public boolean likeMoment(long momentId,long senderUserId);


    /**
     * 取消动态点赞
     * @param momentId  动态id
     * @param senderUserId  取消点赞用户id
     * @return  是否成功
     */
    public boolean unlikeMoment(long momentId,long senderUserId);


    /**
     * 是否已经给动态点过赞
     * @param momentId  动态id
     * @param userId  用户id
     * @return  是否给动态点过赞
     */
    public boolean isLikeMoment(long momentId,long userId);

}

