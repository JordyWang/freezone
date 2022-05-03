package com.example.freezone.service;

import com.example.freezone.domain.Moment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangyizhou
* @description 针对表【moment】的数据库操作Service
* @createDate 2022-05-02 02:31:57
*/
public interface MomentService extends IService<Moment> {
    /**
     * 获取moment
     * @param momentId momentId
     * @return  获取到的moment
     */
    public Moment getMomentById(long momentId);

    /**
     * 删除moment
     * @param momentId
     * @return  void
     */
    public int delMomentById(long momentId);

    /**
     * 发送动态
     * @param senderUserId  发送用户id
     * @param contextText   发送文本内容
     * @param contextPicture    发送图片内容
     * @return  是否发送成功
     */
    public boolean sendMoment(long senderUserId,String contextText,String contextPicture);

    /**
     * 删除动态
     * @param momentId  动态id
     * @param senderUserId  发起人id
     * @return  是否删除成功
     */
    public boolean deleteMoment(long momentId,long senderUserId);

}
