package com.beijing.Dao;

import com.beijing.bean.TPermission;

import java.util.List;

public interface PermissionMapper {
    List<TPermission> selectPermission();

   int updatePer(TPermission tPermission);

    int insertPer(TPermission tPermission);

    int deletePermission(TPermission tPermission);
}
