package com.precisionmedcare.jkkj.mapper;

import com.precisionmedcare.jkkj.domain.Logincode;
import com.precisionmedcare.jkkj.domain.Loginuser;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface LoginMapper {
    @Select("SELECT loginuser.*, logincode.activecode\n" +
            "FROM loginuser\n" +
            "         left join logincode on logincode.userid = loginuser.ID\n" +
            "WHERE username = #{username}\n" +
            "  AND logincode.status = 1\n" +
            "  AND pwd = #{password}\n" +
            "  AND type = 1\n" +
            "  AND isDel != 1;")
    List<HashMap> login(@Param("username")String username, @Param("password")String password);

    @Insert("INSERT INTO loginlog(userId,logType,logTime) VALUES(#{userid}, #{loginType},#{logintime})")
    void insertLoginlog(@Param("loginType") String loginType, @Param("userid") String userid,@Param("logintime")String time);
    /*
    *   useGeneratedKeys:默认是false
    *   useGeneratedKeys设置为 true 时，表示如果插入的表id以自增列为主键，则允许 JDBC 支持自动生成主键，并可将自动生成的主键id返回。
    *   useGeneratedKeys=“true” keyProperty=“id”
    *   useGeneratedKeys参数只针对 insert 语句生效，默认为 false；
    * */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO loginuser(userName,pwd,ugroup,remarks,type,endTime,isDel) VALUES(#{userName}, #{pwd}, #{ugroup},#{remarks},#{type},#{endTime},#{isDel})")
    void insertLoginUser(Loginuser loginuser);

    @Select("SELECT * FROM loginuser WHERE userName=#{username} AND pwd=#{password} AND type=1 AND isDel != 1 ")
    List<Loginuser> checkPwd(@Param("username") String username, @Param("password") String password);

    @Update("update loginuser set pwd = #{password} where id = #{id}")
    void updatePwd(@Param("id") String id, @Param("password") String password);

    @Insert("INSERT INTO logincode(status,activecode) VALUES(#{status}, #{activecode})")
    void insetLoginCode(Logincode logincode);

    @Insert("update logincode set userid = #{userid} where activecode = #{code} and status = 1")
    void insertLoginCode(@Param("userid")long userid,@Param("code")String code);

    @Select("SELECT * FROM logincode WHERE activecode=#{code} AND status = 1 ")
    List<Logincode> checkCode(@Param("code") String code);

    @Select("SELECT * FROM loginuser WHERE userName=#{username} AND isDel != 1  AND type = 1")
    List<Loginuser> checkUsername(@Param("username") String name);

    @Update("update logincode\n" +
            "set logincode.status = 0\n" +
            "where logincode.status = 1\n" +
            "  AND logincode.userid =\n" +
            "      (select loginuser.ID from loginuser where loginuser.userName = #{username} and loginuser.isDel = 0 and loginuser.type = 1)")
    void updateStatus(@Param("username") String name);

    @Update("update logincode\n" +
            "set logincode.userid = (select loginuser.ID\n" +
            "                        from loginuser\n" +
            "                        where loginuser.type = 1\n" +
            "                          and loginuser.isDel = 0\n" +
            "                          and loginuser.userName = #{username})\n" +
            "where logincode.status = 1\n" +
            "  AND logincode.activecode = #{code}")
    void updateActiveCode(@Param("username") String name,@Param("code")String newcode);

    @Select("select * from logincode where logincode.activecode = #{newCode} and logincode.status = 1")
    List<Logincode> checkNewCode(@Param("newCode") String newCode);
}

