package com.precisionmedcare.jkkj.service.Impl;

import com.precisionmedcare.jkkj.domain.Logincode;
import com.precisionmedcare.jkkj.domain.Loginuser;
import com.precisionmedcare.jkkj.mapper.LoginMapper;
import com.precisionmedcare.jkkj.service.LoginService;
import com.precisionmedcare.jkkj.utils.Result;
import com.precisionmedcare.jkkj.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override

    public List login(String username, String password) {
        List list = loginMapper.login(username, password);
        return list;
    }

    @Override
    public void insertLoginLog(String username, HttpSession session, Result result, String loginType, String userid) {
        String ymdhms = dateUtil.get24HCurrentTime_Calendar("ymdhms");
        loginMapper.insertLoginlog(loginType, userid, ymdhms);
        session.setAttribute("username", username);
    }

    @Override
    public void insertLogin(String username, String password, String group, String remark, String endTime,String code) {
   /*     String[] split = endTime.split("-");
        LocalDate localDate = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);*/
        Date date = dateUtil.stringToData(endTime);
        Loginuser loginuser = new Loginuser();
        if (username != null && !"".equals(username)) {
            loginuser.setUserName(username);
        }
        if (date != null) {
            loginuser.setEndTime(date);
        }
        loginuser.setIsDel((byte) 0);
        if (password != null && !"".equals(password)) {
            loginuser.setPwd(password);
        }
        if (remark != null && !"".equals(remark)) {
            loginuser.setRemarks(remark);
        }
        if (group != null && !"".equals(group)) {
            loginuser.setUgroup(group);
        }
        loginuser.setType(1);
        loginMapper.insertLoginUser(loginuser);
        long userid = loginuser.getId();
        loginMapper.insertLoginCode(userid,code);
    }

    @Override
    public List checkPwd(String username, String oldPwd) {
        List list = loginMapper.checkPwd(username, oldPwd);
        return list;
    }

    @Override
    public void insertPwd(String id, String newPwd) {
        loginMapper.updatePwd(id, newPwd);
    }

    @Override
    public void insertLoginCode() {
        Logincode logincode = new Logincode();
        String[] moreUUID = dateUtil.getMoreUUID(5);
        for (int i = 0; i < moreUUID.length; i++) {
            logincode.setStatus(1);
            String code = moreUUID[i];
            logincode.setActivecode(code);
            loginMapper.insetLoginCode(logincode);
        }
    }

    @Override
    public List checkCode(String code) {
        List list = loginMapper.checkCode(code);
        return list;
    }

    @Override
    public List checkUsername(String name) {
        List list = loginMapper.checkUsername(name);
        return list;
    }

    @Override
    public void updateActiveCode(String name, String newcode) {
        loginMapper.updateStatus(name);
        loginMapper.updateActiveCode(name,newcode);
    }

    @Override
    public List checkNewCode(String newCode) {
        List list = loginMapper.checkNewCode(newCode);
        return list;
    }
}
