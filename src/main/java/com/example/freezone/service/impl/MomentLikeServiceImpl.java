package com.example.freezone.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.freezone.domain.MomentLike;
import com.example.freezone.service.MomentLikeService;
import com.example.freezone.mapper.MomentLikeMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.freezone.domain.Moment;
import com.example.freezone.service.MomentService;


import javax.annotation.Resource;

/**
* @author wangyizhou
* @description 针对表【moment_like】的数据库操作Service实现
* @createDate 2022-05-02 19:06:15
*/
@Service
public class MomentLikeServiceImpl extends ServiceImpl<MomentLikeMapper, MomentLike>
    implements MomentLikeService{
    @Resource
    private MomentService momentService;
    private MomentLikeMapper momentLikeMapper;


    /**
     * 点赞动态
     *
     * @param momentId     动态id
     * @param senderUserId 点赞用户id
     * @return 是否点赞成功
     */
    @Override
    public boolean likeMoment(long momentId, long senderUserId) {
        // 1.获取moment

        Moment moment = momentService.getMomentById(momentId);

        // 2.判断moment是否存在
        if (moment == null) {
            return false;
        }

        // 3.判断senderUserId是否合法
        // TODO: 判断UserId是否合法

        // 4.判断like关系是否已经存在

        // 5.不存在才可以点

        return false;
    }

    /**
     * 取消动态点赞
     *
     * @param momentId     动态id
     * @param senderUserId 取消点赞用户id
     * @return 是否成功
     */
    @Override
    public boolean unlikeMoment(long momentId, long senderUserId) {
        return false;
    }

    @Override
    public boolean isLikeMoment(long momentId, long userId) {
        QueryWrapper<MomentLike> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("moment_id",momentId);
        queryWrapper.eq("like_user_id",userId);
        MomentLike momentLike = momentLikeMapper.selectOne(queryWrapper);
        return momentLike!=null;
    }

}












