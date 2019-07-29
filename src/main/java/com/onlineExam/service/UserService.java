package com.onlineExam.service;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;

public interface UserService {

    DataResult deleteUser(String jobNo);

    DataResult getUserList(String jobNo,String userName,String department);

    DataResult validateUser(String jobNo, String passWord);

    DataResult changePassword(String jobNo, String passWord, String newPassword);

    DataResult getMyAchievement(Integer id, String userName,String title);

    SimpleResult updateUser(Integer id,String jobNo,String userName,String phone,String wxNo,String email,String department);

    SimpleResult register(String jobNo,String userName,String passWord);

}
