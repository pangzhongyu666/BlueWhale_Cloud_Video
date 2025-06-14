package com.cloud.bluewhale.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户登录Mapper
 */
public interface UserLoginMapper {

    /**
     * 判断手机号是否存在
     * @param phone 手机号
     * @return 手机号对应的记录数
     */
    @Select("select count(*) from bluewhale.tb_user where phone = #{phone}")
    Integer ifExistPhone(String phone);
}
