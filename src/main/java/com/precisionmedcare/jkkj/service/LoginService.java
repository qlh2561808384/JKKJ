package com.precisionmedcare.jkkj.service;

import com.precisionmedcare.jkkj.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {
    List login(String username, String password);

    void insertLoginLog(String username, HttpSession session, Result result, String loginType, String userid);

    void insertLogin(String username, String password, String group, String remark, String endTime,String code);

    List checkPwd(String username, String oldPwd);

    void insertPwd(String id,String newPwd);

    void insertLoginCode();

    List checkCode(String code);

    List checkUsername(String name);

    void updateActiveCode(String name, String newcode);

    List checkNewCode(String newCode);

}
