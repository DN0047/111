package com.beijing.service.Imlp;

import com.beijing.Dao.LoginMapper;
import com.beijing.bean.TUser;
import com.beijing.service.LoginService;
import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class LoginServiceImlp implements LoginService {

@Autowired
    LoginMapper loginMapper;

    @Override
    public TUser qu1eryLogin(String Loginacct, String userpswd, String type) throws LoadException {
        System.out.println("22222");
       TUser c=loginMapper.equalsLogin(Loginacct,userpswd);
       if (c==null){
          throw new LoadException("密码错误");
       }

       return c;
    }
}
