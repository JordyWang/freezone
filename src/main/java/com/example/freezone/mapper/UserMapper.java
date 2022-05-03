package com.example.freezone.mapper;

import com.example.freezone.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wangyizhou
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-02 02:04:04
* @Entity com.example.freezone.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




