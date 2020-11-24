package com.beijing.service.Imlp;

import com.beijing.Dao.LoginMapper;
import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TUser;
import com.beijing.service.LoginService;
import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImlp implements LoginService {

@Autowired
    LoginMapper loginMapper;

    @Override
    public TUser queryLogin(String Loginacct, String userpswd, String type) throws LoadException {
        System.out.println("22222");
       TUser c=loginMapper.equalsLogin(Loginacct,userpswd);
       if (c==null){
          throw new LoadException("密码错误");
       }

       return c;
    }

    @Override
    public UserUntil q2ueryLimit(Page page1)  {
        int i = page1.indexOf();
     List<TUser> tUserList= loginMapper.selectLimit(i,page1.getPagesize());
   int  integer = loginMapper.selectTotalsize();
         page1.setTotalno(integer);



        page1.listpage=tUserList;
        UserUntil userUntil = new UserUntil();
        userUntil.page=page1;



        return userUntil;
    }
}
