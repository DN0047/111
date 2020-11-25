package com.beijing.service;

import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TUser;
import javafx.fxml.LoadException;

public interface LoginService {

    TUser queryLogin(String Loginacct, String userpswd, String type) throws LoadException;

    UserUntil q2ueryLimit(Page page1) throws LoadException;

    void doAdd(TUser tUser) throws LoadException;

    void doUpdate(TUser tUser) throws LoadException;

    void doDelete(TUser tUser) throws LoadException;


    void doDeleteBatch(Integer[] datas) throws LoadException;
}
