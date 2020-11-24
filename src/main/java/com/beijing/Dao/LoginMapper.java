package com.beijing.Dao;

import com.beijing.bean.TUser;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    TUser equalsLogin(@Param("loginacct") String Loginacct, @Param("userpswd") String userpswd);
}
