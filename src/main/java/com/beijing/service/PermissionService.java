package com.beijing.service;

import com.beijing.Exception.LoginException1;
import com.beijing.bean.TPermission;

import java.util.List;

public interface PermissionService {
    List<TPermission> permission();

    void doUpdate(TPermission tPermission) throws LoginException1;

    void doAdd(TPermission tPermission) throws LoginException1;

    void deletePermission(TPermission tPermission) throws LoginException1;
}
