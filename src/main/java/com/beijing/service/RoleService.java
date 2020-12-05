package com.beijing.service;

import com.beijing.Exception.LoginException1;
import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;

import java.util.List;

public interface RoleService {
    Page querstRole(Page data) throws LoginException1;

    List queryRoleAll(Integer roleid);

    void addRoleAll(Integer[] cc, Integer roleid) throws LoginException1;

    void doEdit(String name, Integer id) throws LoginException1;

    void deleteRole(Integer uid) throws LoginException1;


    void doAddRole(String name) throws LoginException1;

    void deleteRoleAll(Integer[] datas) throws LoginException1;
}
