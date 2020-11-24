package com.beijing.Dao;

import com.beijing.bean.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {

    TUser equalsLogin(@Param("loginacct") String Loginacct, @Param("userpswd") String userpswd);

    List<TUser> selectLimit(@Param("i") int i, @Param("pagesize") Integer pagesize);

    int selectTotalsize();
}
