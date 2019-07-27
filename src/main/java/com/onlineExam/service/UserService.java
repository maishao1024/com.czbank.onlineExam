package com.onlineExam.service;

import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;

public interface UserService {

    DataResult validateUser(String jobNo, String passWord);

    DataResult changePassword(String jobNo, String passWord, String newPassword);

    DataResult getMyAchievement(Integer id, String userName);

    SimpleResult updateUser(Integer id,String jobNo,String userName,String phone,String wxNo,String email,String department);

//
//    boolean updateAccount(User user);
//
//    boolean updateAvatarImgUrlById(String avatarImgUrl, int id);
//
//    User getAccountByUsername(String username);
//
//    List<User> getAccountsByStudentIds(List<Integer> studentIds);
//
//    Map<String, Object> getAccounts(int pageNum, int pageSize);
//
//    boolean deleteAccount(int id);
//
//    boolean disabledAccount(int id);
//
//    boolean abledAccount(int id);
//
//    List<User> getAccountsByIds(Set<Integer> ids);
//
//    User getAccountById(int id);
}
