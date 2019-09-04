package com.precisionmedcare.jkkj.service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface UploadService {
    void insertResultGroup(Map model, String ipAddress, HttpSession session,String IMAGE_PATH) throws IOException;
}
