package com.beijing.service.Imlp;

import com.beijing.Dao.PermissionMapper;
import com.beijing.Dao.RoleMapper;
import com.beijing.Exception.LoginException1;
import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TPermission;
import com.beijing.bean.TRole;
import com.beijing.bean.TRolePermission;
import com.beijing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImlp implements RoleService {
    @Autowired
    RoleMapper roleMapping;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Page querstRole(Page data) throws LoginException1 {
        List<TRole> roles;
        if (data.getQueryText()!=null){

         roles=   roleMapping.queryRoleText(data.getQueryText());
        }else {

            roles = roleMapping.queryRole(data.indexOf(), data.getPagesize());
        }

      int i =  roleMapping.queryRole1();
        data.setTotalno(i);
        data.list=roles;
        if (roles.size()==0){
            throw new LoginException1("加载失败");
        }
        return data;
    }

    @Override
    public List queryRoleAll(Integer roleid) {
        UserUntil userUntil = new UserUntil();
        List<TPermission> permission = permissionMapper.selectPermission();
      List<Integer> tt=  roleMapping.queryRol(roleid);
        ArrayList<TPermission> date = new ArrayList<>();
        HashMap<Long, TPermission> map = new HashMap<>();
        for (TPermission uu: permission) {
            map.put(uu.getId(),uu);
            long id = uu.getId();
            Integer integer = Integer.valueOf((int) id);
            if (tt.contains(integer)){
                uu.setChecked(true);
            }
        }

        for (TPermission permission1: permission) {
            TPermission perm=permission1;
            if (permission1.getPid()==0){
                date.add(permission1);
            }else {
                TPermission permission2 = map.get(perm.getPid());
                permission2.children.add(perm);
                permission2.setOpen(true);
            }
        }

        return date;
    }

    @Override
    public void addRoleAll(Integer[] cc, Integer roleid) throws LoginException1 {
      int i=  roleMapping.addRole(cc,roleid);

      if (i!=cc.length){
          throw new LoginException1("添加失败");
      }
    }

    @Override
    public void doEdit(String name, Integer id) throws LoginException1 {
     int i=   roleMapping.updateEdit(name,id);

        if (i!=1){
            throw new LoginException1("修好失败");
        }
    }

    @Override
    public void deleteRole(Integer uid) throws LoginException1 {

        roleMapping.deleteRoleAll(uid);
        int i=   roleMapping.deleteRole(uid);

        if (i!=1){
            throw new LoginException1("删除失败");
        }
    }

    @Override
    public void doAddRole(String name) throws LoginException1 {
        int i=   roleMapping.doAddRole(name);

        if (i!=1){
            throw new LoginException1("添加失败");
        }
    }

    @Override
    public void deleteRoleAll(Integer[] datas) throws LoginException1 {


             roleMapping.dRoAll(datas);

        int i=   roleMapping.deleteAll(datas);

        if (i!=datas.length){
            throw new LoginException1("删除失败1");
        }
    }
}
