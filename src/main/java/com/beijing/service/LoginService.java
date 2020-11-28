package com.beijing.service;

import com.beijing.Until.Page;
import com.beijing.Until.UserUntil;
import com.beijing.bean.TRole;
import com.beijing.bean.TUser;
import javafx.fxml.LoadException;

import java.util.List;

public interface LoginService {

    TUser queryLogin(String Loginacct, String userpswd, String type) throws LoadException;

    UserUntil q2ueryLimit(Page page1) throws LoadException;

    void doAdd(TUser tUser) throws LoadException;

    void doUpdate(TUser tUser) throws LoadException;

    void doDelete(TUser tUser) throws LoadException;


    void doDeleteBatch(Integer[] datas) throws LoadException;

    List<TRole> queryRoleAll();

    List<TRole> queryRoleID(Integer id);

    void doAssignRole01(Integer userid, Integer[] ids) throws LoadException;

    void doUnAssignRole02(Integer userid, Integer[] ids) throws LoadException;
}
