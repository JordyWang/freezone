package com.example.freezone.mapper;

import com.example.freezone.domain.Moment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wangyizhou
* @description 针对表【moment】的数据库操作Mapper
* @createDate 2022-05-02 02:31:57
* @Entity com.example.freezone.domain.Moment
*/
@Mapper
public interface MomentMapper extends BaseMapper<Moment> {

}




