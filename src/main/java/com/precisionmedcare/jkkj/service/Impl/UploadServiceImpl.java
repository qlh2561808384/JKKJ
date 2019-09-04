package com.precisionmedcare.jkkj.service.Impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.precisionmedcare.jkkj.domain.Resultgroup;
import com.precisionmedcare.jkkj.domain.Resultlog;
import com.precisionmedcare.jkkj.mapper.UploadMapper;
import com.precisionmedcare.jkkj.service.UploadService;
import com.precisionmedcare.jkkj.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
    @Override
    public void insertResultGroup(Map model, String ipAddress, HttpSession session,String IMAGE_PATH) throws IOException {
        List list = new ArrayList();
        if (!model.isEmpty()) {
            String username = model.get("username").toString();
            String patientID = model.get("patientID").toString();
            String detectionID = model.get("detectionID").toString();
            String heartbeat = model.get("heartbeat").toString();
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
                list.add(imgPath);
                Resultlog resultlog = new Resultlog();
                resultlog.setUpUser(username);
                resultlog.setUpTime(upTime);
                resultlog.setDetectionId(detectionID);
                resultlog.setPatientId(patientID);
                resultlog.setGroupId(resultgroupId);
                resultlog.setImgPath(imgPath);
                uploadMapper.insertResultLog(resultlog);
            }
            JSONObject jsonObject = JSONUtil.createObj();
            jsonObject.put("arg01", resultgroupId);
            jsonObject.put("patient_id", patientID);
            jsonObject.put("detect_id", detectionID);
            jsonObject.put("list", list);
            jsonObject.put("username", username);
            jsonObject.put("hearbeat", heartbeat);
            /*
            *   执行udp编程  调用python接口
            * */
            DatagramSocket ds = new DatagramSocket();
            byte[] bytes = JSONUtil.toJsonStr(jsonObject).getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
            dp.setPort(62000);
            dp.setAddress(InetAddress.getLocalHost());
            ds.send(dp);

        }
    }
}
