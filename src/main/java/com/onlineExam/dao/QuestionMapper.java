package com.onlineExam.dao;

import com.onlineExam.model.Question;
import com.onlineExam.model.example.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface QuestionMapper extends Mapper<Question>, MySqlMapper<Question> {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    List<Question> selectByExample(QuestionExample example);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);
}