package com.precisionmedcare.jkkj.utils;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;
import java.io.File;

public class UploadUtils {
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static/upload/image";

    /*
    *   创建或寻找项目下面的某个文件夹  没有则创建
    * */
    public static File getImgDirFile(HttpSession session){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX + "/" + session.getAttribute("username"));

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
    /*
    *  获取某个路径下面的文件，返回文件的绝对路径
    * relativePath:项目跟路径下的目录  --springboot static 目录相当于根路径（SpringBoot 默认）
    * */
    public static File getFileDirPath(String relativePath){
        String filePath = new String("src/main/resources/" + relativePath);
        File file = new File(filePath);
        return file;
    }
}
