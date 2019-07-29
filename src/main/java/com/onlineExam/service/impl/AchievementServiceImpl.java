package com.onlineExam.service.impl;

import com.onlineExam.dao.AchievementMapper;
import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.UserResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.User;
import com.onlineExam.model.example.UserExample;
import com.onlineExam.service.AchievementService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AchievementServiceImpl implements AchievementService{

    private static Logger logger = LoggerFactory.getLogger(AchievementServiceImpl.class);

    @Autowired
    private AchievementMapper achievementMapper;


    @Override
    public DataResult getAchievements(String jobNo, String userName, String title) {
        DataResult dataResult = new DataResult();
        try {
            if (StringUtils.isNotEmpty(jobNo)) {
               jobNo = "%" + jobNo + "%";
            }
            if (StringUtils.isNotEmpty(userName)) {
               userName = "%" + userName + "%";
            }
            if (StringUtils.isNotEmpty(title)) {
                title = "%" + title + "%";
            }
            List<Map> maps = achievementMapper.qryAchievementsSpecial(jobNo,userName,title);
            List<UserResult> results = new ArrayList<>();
            for (Map map : maps){
                UserResult userResult = new UserResult();
                userResult.setId(String.valueOf(map.get("job_no")));
                userResult.setUserName(String.valueOf(map.get("username")));
                userResult.setEmail(String.valueOf(map.get("title")));
                userResult.setDepartment(String.valueOf(map.get("score")));
                results.add(userResult);
            }
            dataResult.setData(results);
            return dataResult;
        }catch (Exception e){
            logger.error("获取成绩异常",e);
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
    }
}
