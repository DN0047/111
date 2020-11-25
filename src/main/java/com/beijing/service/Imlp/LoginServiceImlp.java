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

        TUser c = loginMapper.equalsLogin(Loginacct, userpswd);
        if (c == null) {
            throw new LoadException("密码错误");
        }

        return c;
    }

    @Override
    public UserUntil q2ueryLimit(Page page1) {
        int i = page1.indexOf();
        List<TUser> tUserList = loginMapper.selectLimit(i, page1.getPagesize(), page1.getQueryText());
        int integer = loginMapper.selectTotalsize();
        page1.setTotalno(integer);
        page1.listpage = tUserList;
        UserUntil userUntil = new UserUntil();
        userUntil.page = page1;
        return userUntil;
    }

    @Override
    public void doAdd(TUser tUser) throws LoadException {
        tUser.setUserpswd("222");
        int i = loginMapper.insertUser(tUser);
        if (i != 1) {
            throw new LoadException("添加失败");
        }


    }

    @Override
    public void doUpdate(TUser tUser) throws LoadException {
        int i = loginMapper.updateUser(tUser);
        if (i != 1) {
            throw new LoadException("修改失败");
        }
    }

    @Override
    public void doDelete(TUser tUser) throws LoadException {
        loginMapper.delectUserRole(tUser);
        int i = loginMapper.delectUser(tUser);
        if (i != 1) {
            throw new LoadException("修改失败");
        }
    }

    @Override
    public void doDeleteBatch(Integer[] datas) throws LoadException {
        int i = loginMapper.delectUserAll(datas);

        if (i != datas.length) {
            throw new LoadException("删除失败");
        }
    }


}
