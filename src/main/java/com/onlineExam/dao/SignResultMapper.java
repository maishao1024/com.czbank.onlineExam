package com.onlineExam.dao;

import com.onlineExam.model.SignResult;
import com.onlineExam.model.example.SignResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SignResultMapper extends Mapper<SignResult>, MySqlMapper<SignResult> {
    int countByExample(SignResultExample example);

    int deleteByExample(SignResultExample example);

    List<SignResult> selectByExample(SignResultExample example);

    int updateByExampleSelective(@Param("record") SignResult record, @Param("example") SignResultExample example);

    int updateByExample(@Param("record") SignResult record, @Param("example") SignResultExample example);
}