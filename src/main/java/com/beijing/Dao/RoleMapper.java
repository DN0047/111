package com.beijing.Dao;

import com.beijing.bean.TRole;
import com.beijing.bean.TRolePermission;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface RoleMapper {
    List<TRole> queryRole(@Param("indexOf") int indexOf, @Param("pagesize") Integer pagesize);

    List<TRole> queryRoleText(String queryText);

    int queryRole1();

    List<Integer> queryRol(Integer roleid);

    int addRole(@Param("cc") Integer[] cc,@Param("roleid") Integer roleid);

    int updateEdit(@Param("name")String name,@Param("id") Integer id);

    int deleteRole(Integer uid);

    void deleteRoleAll(Integer uid);

    int doAddRole(String name);

    int deleteAll(Integer[] datas);

    void dRoAll(Integer[] datas);
}
