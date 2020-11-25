package com.beijing.wz;


import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TUser;
import com.beijing.service.LoginService;

import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class controlly {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/some")
    public String index() {

        return "login01";
    }

    @RequestMapping("/main")
    public String manin() {

        return "main";
    }


    //登录用户
    @RequestMapping("doLogin")
    @ResponseBody
    public UserUntil login(String Loginacct, String userpswd, String type, HttpSession httpSession) {
        System.out.println("333");
        UserUntil userUntil = new UserUntil();
        TUser tUser = null;
        try {
            tUser = loginService.queryLogin(Loginacct, userpswd, type);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }

        userUntil.setSunccess(true);
        httpSession.setAttribute("user", tUser);

        return userUntil;


    }

    @RequestMapping("/user")
    public String userIndex() {

        return "user";
    }


    @RequestMapping("/user/index01")
    @ResponseBody
    public UserUntil index01(HttpSession httpSession, @RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
                             @RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pageLast,
                             @RequestParam(value = "queryText", required = false) String queryText) {


        Page page1 = new Page(pageno, pageLast);
        page1.setQueryText(queryText);

        UserUntil ajaK = null;
        try {
            ajaK = loginService.q2ueryLimit(page1);
        } catch (LoadException e) {
            e.printStackTrace();
        }

        ajaK.setSunccess(true);

        return ajaK;
    }

    @RequestMapping("/user/toAdd")
    public String toAdd() {

        return "user/add";
    }

    //添加用户
    @ResponseBody
    @RequestMapping("/user/doAdd")
    public UserUntil doAdd(TUser tUser) {
        UserUntil userUntil = new UserUntil();
        try {
            loginService.doAdd(tUser);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);
        return userUntil;
    }

    @RequestMapping("/user/toUpdate")
    public String toUpdate() {

        return "user/update";
    }

    //修改用户
    @ResponseBody
    @RequestMapping("/user/doUpdate")
    public UserUntil doUpdate(TUser tUser) {
        UserUntil userUntil = new UserUntil();
        try {
            loginService.doUpdate(tUser);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);
        return userUntil;
    }

    //删除用户
    @ResponseBody
    @RequestMapping("/user/doDelete")
    public UserUntil doDelete(TUser tUser) {
        UserUntil userUntil = new UserUntil();
        try {
            loginService.doDelete(tUser);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);
        return userUntil;
    }


    //多选删除
    @ResponseBody
    @RequestMapping("/user/doDeleteBatch")
    public UserUntil doDeleteBatch(Integer[] datas) {
        UserUntil userUntil = new UserUntil();
        try {
            loginService.doDeleteBatch(datas);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);
            return userUntil;
        }
        userUntil.setSunccess(true);
        return userUntil;
    }

}
