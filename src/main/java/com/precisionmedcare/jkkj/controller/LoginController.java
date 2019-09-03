package com.precisionmedcare.jkkj.controller;


import com.precisionmedcare.jkkj.service.LoginService;
import com.precisionmedcare.jkkj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("getLoginUserData")
    public List getLoginUserDta(String username, String password) {
        List list = null;
        try {
            list = loginService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping("insertLoginLog")
    public Result insertLoginLog(String username, HttpSession session, String loginType, String userid) {
        Result result = new Result();
        try {
            loginService.insertLoginLog(username, session, result, loginType, userid);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("insertLogin")
    public Result insertLogin(String username, String password,String group,String remark,String endTime,String code) {
        Result result = new Result();
        try {
            loginService.insertLogin(username, password, group, remark, endTime,code);
            result.setSuccess(true);
            result.setContent("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setContent("注册失败，失败原因" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("getUsername")
    public Result getUsername(HttpSession session) {
        Result result = new Result();
        Object username = session.getAttribute("username");
        result.setContent(username);
        return result;
    }

    @RequestMapping("checkPwd")
    public List checkPwd(String username, String oldPwd) {
        Result result = new Result();
        List list = null;
        try {
            list = loginService.checkPwd(username, oldPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping("insertPwd")
    public Result insertPwd(String id,String newPwd) {
        Result result = new Result();
        try {
            loginService.insertPwd(id,newPwd);
            result.setSuccess(true);
            result.setContent("密码修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setContent("密码修改失败，失败原因" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("insertLoginCode")
    public Result insertLoginCode() {
        Result result = new Result();
        try {
            loginService.insertLoginCode();
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("checkCode")
    public List checkCode(String code) {
        Result result = new Result();
        List list = null;
        try {
            list = loginService.checkCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("checkUsername")
    public List checkUsername(String name) {
        Result result = new Result();
        List list = null;
        try {
            list = loginService.checkUsername(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("updateActiveCode")
    public Result updateActiveCode(String name, String newcode) {
        Result result = new Result();
        try {
            loginService.updateActiveCode(name,newcode);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("checkNewCode")
    public List checkNewCode(String newCode) {
        List list = null;
        try {
            list = loginService.checkNewCode(newCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
