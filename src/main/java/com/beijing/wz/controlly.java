package com.beijing.wz;



import com.beijing.Until.UserUntil;
import com.beijing.bean.TUser;
import com.beijing.service.LoginService;

import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class controlly {
  @Autowired
    private LoginService loginService;
    @RequestMapping("/some")
    public String index(){
        System.out.println("1111");
        return "login01";
    }
    @RequestMapping("/main")
    public String manin(){

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
            tUser = loginService.qu1eryLogin(Loginacct, userpswd, type);
        } catch (LoadException e) {
            e.printStackTrace();
            userUntil.setSunccess(false);

        }

        userUntil.setSunccess(true);
        httpSession.setAttribute("user",tUser);

            return userUntil;


    }
}
