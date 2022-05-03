package com.example.freezone.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.freezone.domain.Moment;
import com.example.freezone.service.MomentService;
import com.example.freezone.mapper.MomentMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author wangyizhou
* @description 针对表【moment】的数据库操作Service实现
* @createDate 2022-05-02 02:31:57
*/
@Service
public class MomentServiceImpl extends ServiceImpl<MomentMapper, Moment>
    implements MomentService{


    @Resource
    private MomentMapper momentMapper;

    /**
     * 获取moment
     * @param momentId momentId
     * @return 获取到的moment
     */
    @Override
    public Moment getMomentById(long momentId) {
        return momentMapper.selectById(momentId);
    }

    /**
     * 删除moment
     *
     * @param momentId
     * @return void
     */
    @Override
    public int delMomentById(long momentId) {
        return momentMapper.deleteById(momentId);
    }

    /**
     * 发送动态
     * @param senderUserId  发送用户id
     * @param contextText   发送文本内容
     * @param contextPicture    发送图片内容
     * @return  是否发送成功
     */
    @Override
    public boolean sendMoment(long senderUserId, String contextText, String contextPicture) {
        // 1.如果文本和图片均为空则发送失败
        if (StringUtils.isAllBlank(contextText,contextPicture)) {
            return false;
        }

        // 2.敏感内容审核
        // TODO 敏感内容审核问题

        Moment moment = new Moment();
        moment.setSenderUserId(senderUserId);
        moment.setMomentContextText(contextText);
        moment.setMomentContextPicture(contextPicture);

        return this.save(moment);
    }



    /**
     * 删除动态
     * @param momentId  动态id
     * @param senderUserId  发起人id
     * @return  是否删除成功
     */
    @Override
    public boolean deleteMoment(long momentId, long senderUserId) {
        // 1.获取moment

        Moment moment = getMomentById(momentId);

        // 2.判断moment是否存在
        if (moment==null) {
            return false;
        }

        // 3.判断删除者是不是动态的发布者
        if (moment.getSenderUserId()!=senderUserId) {
            return false;
        }

        // 4.删除动态
        momentMapper.deleteById(momentId);
        return true;
    }


}




