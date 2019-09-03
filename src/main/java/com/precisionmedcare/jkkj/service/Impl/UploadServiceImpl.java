package com.precisionmedcare.jkkj.service.Impl;

import com.precisionmedcare.jkkj.domain.Resultgroup;
import com.precisionmedcare.jkkj.domain.Resultlog;
import com.precisionmedcare.jkkj.mapper.UploadMapper;
import com.precisionmedcare.jkkj.service.UploadService;
import com.precisionmedcare.jkkj.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
    @Override
    public void insertResultGroup(Map model, String ipAddress, HttpSession session,String IMAGE_PATH) {
        if (!model.isEmpty()) {
            String username = model.get("username").toString();
            String patientID = model.get("patientID").toString();
            String detectionID = model.get("detectionID").toString();
            String city = model.get("city").toString();
            String upTime = dateUtil.get24HCurrentTime_Calendar("ymdhms");
            String date = dateUtil.get24HCurrentTime_Calendar("ymd");
            Resultgroup resultgroup = new Resultgroup();
            resultgroup.setUpTime(upTime);
            resultgroup.setDetectionId(detectionID);
            resultgroup.setUpUser(username);
            resultgroup.setPatientId(patientID);
            resultgroup.setCity(city);
            resultgroup.setDate(date);
            resultgroup.setIp(ipAddress);
            uploadMapper.insertResultGroup(resultgroup);
            long resultgroupId = resultgroup.getId();
            List imgNameList = (List) model.get("imageList");
            for (Object imgName : imgNameList) {
                String imgPath = IMAGE_PATH + session.getAttribute("username") + "/" + imgName;
                Resultlog resultlog = new Resultlog();
                resultlog.setUpUser(username);
                resultlog.setUpTime(upTime);
                resultlog.setDetectionId(detectionID);
                resultlog.setPatientId(patientID);
                resultlog.setGroupId(resultgroupId);
                resultlog.setImgPath(imgPath);
                uploadMapper.insertResultLog(resultlog);
            }
            //执行udp编程  调用python接口
        }
    }
}
