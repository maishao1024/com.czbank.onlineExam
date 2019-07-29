package com.onlineExam.service.impl;

import com.onlineExam.dao.AchievementMapper;
import com.onlineExam.dao.UserMapper;
import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.dto.SingleAchievement;
import com.onlineExam.dto.UserResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.User;
import com.onlineExam.model.example.UserExample;
import com.onlineExam.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public DataResult deleteUser(String jobNo) {
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andJobNoEqualTo(jobNo);
            userMapper.deleteByExample(userExample);
            return getUserList("","","");
        }catch (Exception e){
            logger.info("删除用户发生异常",e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
    }

    @Override
    public DataResult getUserList(String jobNo, String userName, String department) {
        try {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotEmpty(jobNo)) {
                criteria.andJobNoLike("%" + jobNo + "%");
            }
            if (StringUtils.isNotEmpty(userName)) {
                criteria.andUsernameLike("%" + userName + "%");
            }
            if (StringUtils.isNotEmpty(department)) {
                criteria.andDepartmentLike("%" + department + "%");
            }
            criteria.andLevelEqualTo(1);
            example.setOrderByClause("job_no");
            List<User> users = userMapper.selectByExample(example);
            List<UserResult> results = new ArrayList<>();
            for (User user : users){
                UserResult result = new UserResult();
                result.setId(user.getJobNo());
                result.setUserName(user.getUsername());
                result.setEmail(user.getEmail());
                result.setDepartment(user.getDepartment());
                results.add(result);
            }
            DataResult dataResult = new DataResult();
            dataResult.setData(results);
            return dataResult;
        }catch (Exception e){
            logger.info("获取用户列表发生异常",e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }

    }

    @Override
    public SimpleResult register(String jobNo, String userName, String passWord) {
        try {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andJobNoEqualTo(jobNo);
            List<User> users = userMapper.selectByExample(example);
            if (users.size() != 0){
                return new SimpleResult(ERRORCODE.AREADY_EXIST_USERNAME);
            }else {
                User user = new User();
                user.setJobNo(jobNo);
                user.setUsername(userName);
                user.setPassword(passWord);
                user.setLevel(1);
                userMapper.insertSelective(user);
                return new SimpleResult();
            }
        }catch (Exception e){
            logger.info("注册异常",e);
            return new SimpleResult(ERRORCODE.COMMON);
        }
    }

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
            logger.info("更新用户信息发生异常",e);
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
            logger.info("用户认证发生异常",e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        if (user.size() == 1){
            if (StringUtils.equals(password,user.get(0).getPassword())){
                dataResult.setData(user);
                return dataResult;
            }else {
                logger.info("用户认证错误,jobNo={}",jobNo);
                return DataResult.fixedError(ERRORCODE.WRONG_PASSWORD);
            }
        }
        return DataResult.fixedError(ERRORCODE.WRONG_USERNAME_OR_PASSWORD);
    }

    @Override
    public DataResult getMyAchievement(Integer id, String userName,String title) {
        DataResult dataResult = new DataResult();
        List<SingleAchievement> achievements;
        try {
            if (title != null){
                title = '%' + title + '%';
            }
            List<Map> list = achievementMapper.qryResultWithPaper(id,title);
            achievements = new ArrayList<>();
            for (Map map : list){
                SingleAchievement achievement = new SingleAchievement();
                achievement.setUserName(userName);
                achievement.setTotalScore(String.valueOf(map.get("score")));
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
            logger.info("获取成绩异常",e);
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
            logger.info("修改密码异常",e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
        return DataResult.fixedError(ERRORCODE.WRONG_USERNAME_OR_PASSWORD);
    }

}
