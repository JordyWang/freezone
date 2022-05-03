package com.example.freezone.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName moment_like
 */
@TableName(value ="moment_like")
@Data
public class MomentLike implements Serializable {
    /**
     * 
     */
    @TableId(value = "like_id")
    private Long likeId;

    /**
     * 动态id,作为动态的唯一标识符,值由MyBatis自动生成
     */
    @TableField(value = "moment_id")
    private Long momentId;

    /**
     * 点赞者id,用于标识给动态点赞的用户
     */
    @TableField(value = "like_user_id")
    private Long likeUserId;

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