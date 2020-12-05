package com.beijing.wz;

import com.beijing.Exception.LoginException1;
import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/role")
    public String toAdd() {

        return "role/index";
    }

    @ResponseBody
    @RequestMapping("/role/pageQuery")
    public UserUntil pageRole(Page data) {
        UserUntil userUntil = new UserUntil();
        try {
            Page page = roleService.querstRole(data);
            userUntil.page = page;
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);


        return userUntil;
    }

    @RequestMapping("/role/assignPermission")
    public String assignPermission() {

        return "role/assignPermission";
    }


    @ResponseBody
    @RequestMapping("/role/loadDataAsync")
    public List loadDataAsync(Integer roleid) {

        List list = roleService.queryRoleAll(roleid);


        return list;
    }

    @ResponseBody
    @RequestMapping("/role/doAssignPermission")
    public UserUntil doAssignPermission(Integer[] cc, Integer roleid) {
        UserUntil userUntil = new UserUntil();
        try {
            roleService.addRoleAll(cc, roleid);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);

        return userUntil;
    }

    @RequestMapping("/role/edit")
    public String edit() {

        return "role/edit";
    }

    @ResponseBody
    @RequestMapping("/role/doEdit")
    public UserUntil doEdit(String name, Integer id) {
        UserUntil userUntil = new UserUntil();
        try {
            roleService.doEdit(name, id);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);

        return userUntil;
    }

    @ResponseBody
    @RequestMapping("/role/delete")
    public UserUntil deleteRole(Integer uid) {
        UserUntil userUntil = new UserUntil();
        try {
            roleService.deleteRole(uid);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);

        return userUntil;
    }

    @RequestMapping("/role/add")
    public String addRole() {

        return "role/add";
    }

    @ResponseBody
    @RequestMapping("/role/doAdd")
    public UserUntil doAddRole(String name) {
        UserUntil userUntil = new UserUntil();
        try {
             roleService.doAddRole(name);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);

        return userUntil;
    }

    @ResponseBody
    @RequestMapping("/role/batchDelete")
    public UserUntil deleteRoleAll(Integer[] datas) {

        UserUntil userUntil = new UserUntil();
        try {
            roleService.deleteRoleAll(datas);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);

        return userUntil;
    }
}
