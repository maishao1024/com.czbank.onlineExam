package com.onlineExam.service.impl;

import com.onlineExam.dao.AchievementMapper;
import com.onlineExam.dao.UserMapper;
import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.dto.SingleAchievement;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.User;
import com.onlineExam.model.example.UserExample;
import com.onlineExam.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public SimpleResult updateUser(Integer id, String jobNo, String userName, String phone, String wxNo, String email, String department) {
        SimpleResult simpleResult = new SimpleResult();
        User user = new User();
        user.setJobNo(jobNo);
        user.setUsername(userName);
        user.setWxno(wxNo);
        user.setDepartment(department);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUpdateTime(new Date());
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        try {
            int i = userMapper.updateByExampleSelective(user,example);
            if (i == 1){
                simpleResult.setResMsg(ERRORCODE.SUCESS.errMsg);
                simpleResult.setSuccess(true);
            }
        }catch (Exception e){
            simpleResult.setResMsg(ERRORCODE.COMMON.errMsg);
            simpleResult.setSuccess(false);
        }
        return simpleResult;
    }

    @Override
    public DataResult validateUser(String jobNo, String password) {
        DataResult dataResult = new DataResult();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andJobNoEqualTo(jobNo);
        List<User> user;
        try {
            user = userMapper.selectByExample(example);
        }catch (Exception e){
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        if (user.size() == 1){
            if (StringUtils.equals(password,user.get(0).getPassword())){
                dataResult.setData(user);
                return dataResult;
            }else {
                return DataResult.fixedError(ERRORCODE.WRONG_PASSWORD);
            }
        }
        return DataResult.fixedError(ERRORCODE.WRONG_USERNAME_OR_PASSWORD);
    }

    @Override
    public DataResult getMyAchievement(Integer id, String userName) {
        DataResult dataResult = new DataResult();
        List<SingleAchievement> achievements = null;
        try {
            List<Map> list = achievementMapper.qryResultWithPaper(id);
            achievements = new ArrayList<>();
            for (Map map : list){
                SingleAchievement achievement = new SingleAchievement();
                achievement.setUserName(userName);
                achievement.setTotalScore(String.valueOf(map.get("manul_score")));
                achievement.setExamTitle((String)map.get("title"));
                String startTime = String.valueOf(map.get("start_time"));
                startTime = startTime.substring(0,startTime.length() - 2);
                String endTime = String.valueOf(map.get("finish_time"));
                endTime = endTime.substring(0,endTime.length() - 2);
                achievement.setStartTime(startTime);
                achievement.setHandPaperTime(endTime);
                achievements.add(achievement);
            }
        }catch (Exception e){
            System.out.print(e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        dataResult.setData(achievements);
        return dataResult;
    }

    @Override
    public DataResult changePassword(String jobNo, String password, String newPassowrd) {
        DataResult dataResult = new DataResult();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andJobNoEqualTo(jobNo);
        criteria.andPasswordEqualTo(password);
        User user = userMapper.selectByExample(example).get(0);
        UserExample example1 = new UserExample();
        UserExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdEqualTo(user.getId());
        user.setPassword(newPassowrd);
        try {
            int i = userMapper.updateByExampleSelective(user,example1);
            if (i == 1){
                return dataResult;
            }
        }catch (Exception e){
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        return DataResult.fixedError(ERRORCODE.WRONG_USERNAME_OR_PASSWORD);
    }

    //    @Override
//    public int addAccount(User user) {
//        user.setAvatarImgUrl(QexzConst.DEFAULT_AVATAR_IMG_URL);
//        return userMapper.insertAccount(user);
//    }
//
//    @Override
//    public boolean updateAccount(User user) {
//        return userMapper.updateAccountById(user) > 0;
//    }
//
//    @Override
//    public boolean updateAvatarImgUrlById(String avatarImgUrl, int id) {
//        return userMapper.updateAvatarImgUrlById(avatarImgUrl, id) > 0;
//    }
//
//    @Override
//    public User getAccountByUsername(String username) {
//        return userMapper.getAccountByUsername(username);
//    }
//
//    @Override
//    public List<User> getAccountsByStudentIds(List<Integer> studentIds) {
//        return userMapper.getAccountsByIds(studentIds);
//    }
//
//    @Override
//    public Map<String, Object> getAccounts(int pageNum, int pageSize) {
//        Map<String, Object> data = new HashMap<>();
//        int count = userMapper.getCount();
//        if (count == 0) {
//            data.put("pageNum", 0);
//            data.put("pageSize", 0);
//            data.put("totalPageNum", 1);
//            data.put("totalPageSize", 0);
//            data.put("accounts", new ArrayList<>());
//            return data;
//        }
//        int totalPageNum = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
//        if (pageNum > totalPageNum) {
//            data.put("pageNum", 0);
//            data.put("pageSize", 0);
//            data.put("totalPageNum", totalPageNum);
//            data.put("totalPageSize", 0);
//            data.put("accounts", new ArrayList<>());
//            return data;
//        }
//        PageHelper.startPage(pageNum, pageSize);
//        List<User> users = userMapper.getAccounts();
//        data.put("pageNum", pageNum);
//        data.put("pageSize", pageSize);
//        data.put("totalPageNum", totalPageNum);
//        data.put("totalPageSize", count);
//        data.put("accounts", users);
//        return data;
//    }
//
//    @Override
//    public boolean deleteAccount(int id) {
//        return userMapper.deleteAccount(id) > 0;
//    }
//
//    @Override
//    public boolean disabledAccount(int id) {
//        return userMapper.updateState(id, 1) > 0;
//    }
//
//    @Override
//    public boolean abledAccount(int id) {
//        return userMapper.updateState(id, 0) > 0;
//    }
//
//    @Override
//    public List<User> getAccountsByIds(Set<Integer> ids) {
//        return userMapper.getAccountsByIdSets(ids);
//    }
//
//    @Override
//    public User getAccountById(int id) {
//        return userMapper.getAccountById(id);
//    }
}
