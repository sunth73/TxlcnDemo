package com.sunth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Sunth
 * @DateTime 2019-10-11 10:01
 * 描述
 */
@Mapper
public interface MapperB {

    @Update("update t_bank set money = money-#{money} where username=#{username}")
    int update(@Param("money") int money, @Param("username") String username);

    @Select("select money from t_bank where username=#{username}")
    int select(@Param("username") String username);
}
