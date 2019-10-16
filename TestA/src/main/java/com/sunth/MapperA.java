package com.sunth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author Sunth
 * @DateTime 2019-10-11 10:01
 * 描述
 */
@Mapper
@Component
public interface MapperA {

    @Update("update t_bank set money = money+#{money} where username=#{username}")
    int update(@Param("money") int money,@Param("username") String username);
}
