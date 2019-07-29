package com.onlineExam.dao;

import com.onlineExam.model.SignRecord;

import java.util.List;

import com.onlineExam.model.example.SignRecordExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SignRecordMapper extends Mapper<SignRecord>, MySqlMapper<SignRecord> {
    int countByExample(SignRecordExample example);

    int deleteByExample(SignRecordExample example);

    List<SignRecord> selectByExample(SignRecordExample example);

    int updateByExampleSelective(@Param("record") SignRecord record, @Param("example") SignRecordExample example);

    int updateByExample(@Param("record") SignRecord record, @Param("example") SignRecordExample example);
}