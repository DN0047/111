package com.beijing.service;

import com.beijing.bean.TUser;
import javafx.fxml.LoadException;

public interface LoginService {

  TUser qu1eryLogin(String Loginacct, String userpswd, String type) throws LoadException;
}
