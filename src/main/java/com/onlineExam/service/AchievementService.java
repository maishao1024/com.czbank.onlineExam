package com.onlineExam.service;

import com.onlineExam.dto.DataResult;

public interface AchievementService {

    DataResult getAchievements(String jobNo,String userName,String achievement);
}
