package com.example.freezone.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName moment
 */
@TableName(value ="moment")
@Data
public class Moment implements Serializable {
    /**
     * 动态id,作为动态的唯一标识符,值由MyBatis自动生成
     */
    @TableId(value = "moment_id")
    private Long momentId;

    /**
     * 发送者的id，用于标识动态的作者
     */
    @TableField(value = "sender_user_id")
    private Long senderUserId;

    /**
     * 动态内容文本，动态的文字内容
     */
    @TableField(value = "moment_context_text")
    private String momentContextText;

    /**
     * 动态图片,动态的图片内容，以链接储存图片，最多九张，以封号分隔。
     */
    @TableField(value = "moment_context_picture")
    private String momentContextPicture;

    /**
     * 点赞数，本条动态的点赞数量
     */
    @TableField(value = "moment_like_number")
    private Integer momentLikeNumber;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除，0-表示逻辑存在,1表示逻辑删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}