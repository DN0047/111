package com.beijing.service.Imlp;

import com.beijing.Dao.PermissionMapper;
import com.beijing.Exception.LoginException1;
import com.beijing.bean.TPermission;
import com.beijing.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImlp implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<TPermission> permission() {
        List<TPermission> permissions =   permissionMapper.selectPermission();
        return permissions;
    }

    @Override
    public void doUpdate(TPermission tPermission) throws LoginException1 {

        int i = permissionMapper.updatePer(tPermission);
        if (i!=1){
            throw new LoginException1("修改错误");
        }

    }

    @Override
    public void doAdd(TPermission tPermission) throws LoginException1 {
        int i = permissionMapper.insertPer(tPermission);
        if (i!=1){
            throw new LoginException1("添加错误");
        }
    }

    @Override
    public void deletePermission(TPermission tPermission) throws LoginException1 {
        int i = permissionMapper.deletePermission(tPermission);
        if (i!=1){
            throw new LoginException1("添加错误");
        }
    }
}
