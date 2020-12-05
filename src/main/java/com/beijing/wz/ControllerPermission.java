package com.beijing.wz;

import com.beijing.Exception.LoginException1;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TPermission;
import com.beijing.service.PermissionService;
import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ControllerPermission {
    @Autowired
    PermissionService permissionService;

    @ResponseBody
    @RequestMapping("/permission/loadData")
    public UserUntil permission() {
        UserUntil userUntil = new UserUntil();
        TPermission date = new TPermission();

        List<TPermission> faste=permissionService.permission();
        HashMap<Long, TPermission> pren = new HashMap<>();

        for (TPermission  map: faste) {

                pren.put(map.getId(),map);

        }


        for (TPermission  fu: faste) {

         TPermission permission=fu;
         if (permission.getPid()==0){
             date=permission;
         }else {
             //子找父
             TPermission permission1 = pren.get(permission.getPid());
             permission1.children.add(permission);
             permission1.setOpen(true);
         }



        }


        userUntil.data=date;
        userUntil.setSunccess(true);

        return userUntil;


    }

    @RequestMapping("/permission/toUpdate")
    public String toUpdate() {

        return "permission/update";
    }


    @RequestMapping("/permission/doUpdate")
    @ResponseBody
    public UserUntil doUpdate(TPermission tPermission) {
        UserUntil until = new UserUntil();
        try {
            permissionService.doUpdate(tPermission);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            until.setSunccess(false);
            return until;
        }
        until.setSunccess(true);
        return until;
    }

    @RequestMapping("/permission/toAdd")
    public String toAdd() {

        return "permission/add";
    }

    @RequestMapping("/permission/doAdd")
    @ResponseBody
    public UserUntil doAdd(TPermission tPermission) {
        UserUntil until = new UserUntil();
        try {
            permissionService.doAdd(tPermission);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            until.setSunccess(false);
            return until;
        }
        until.setSunccess(true);
        return until;
    }

    @RequestMapping("/permission/deletePermission")
    @ResponseBody
    public UserUntil deletePermission(TPermission tPermission) {
        UserUntil until = new UserUntil();
        try {
            permissionService.deletePermission(tPermission);
        } catch (LoginException1 loginException1) {
            loginException1.printStackTrace();
            until.setSunccess(false);
            return until;
        }
        until.setSunccess(true);
        return until;
    }
}