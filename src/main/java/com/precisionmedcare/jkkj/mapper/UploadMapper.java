package com.precisionmedcare.jkkj.mapper;

import com.precisionmedcare.jkkj.domain.Resultgroup;
import com.precisionmedcare.jkkj.domain.Resultlog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO resultgroup(upUser,patientId,detectionId,upTime,date,ip,city) VALUES(#{upUser}, #{patientId},#{detectionId},#{upTime}, #{date},#{ip},#{city})")
    void insertResultGroup(Resultgroup resultgroup);

    @Insert("INSERT INTO resultlog(upUser,patientId,detectionId,upTime,groupId,imgPath) VALUES(#{upUser}, #{patientId},#{detectionId},#{upTime},#{groupId},#{imgPath})")
    void insertResultLog(Resultlog resultlog);
}
