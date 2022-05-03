package com.example.freezone.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName friend_relationship
 */
@TableName(value ="friend_relationship")
@Data
public class FriendRelationship implements Serializable {
    /**
     * 好友关系id，作为好友关系的唯一标识符,值由MyBatis自动生成
     */
    @TableId(value = "relationship_id")
    private Long relationshipId;

    /**
     * 用户1，表示用户1的好友有用户2
     */
    @TableField(value = "user_id_one")
    private Long userIdOne;

    /**
     * 用户2，表示用户1是用户2的单向好友
     */
    @TableField(value = "user_id_two")
    private Long userIdTwo;

    /**
     * 创建时间戳
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间戳
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