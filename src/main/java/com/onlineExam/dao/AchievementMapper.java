package com.onlineExam.dao;

import com.onlineExam.model.Achievement;
import com.onlineExam.model.example.AchievementExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AchievementMapper extends Mapper<Achievement>, MySqlMapper<Achievement> {

    List<Map> qryAchievementsSpecial(@Param("jobNo")String jobNo,@Param("userName")String userName,@Param("title")String title);

    List<Map> qryResultWithPaper(@Param("userId")Integer id,@Param("title")String title);

    int countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    List<Achievement> selectByExample(AchievementExample example);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);
}