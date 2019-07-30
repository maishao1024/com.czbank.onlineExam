package com.onlineExam.dao;

import com.onlineExam.model.Paper;
import com.onlineExam.model.example.PaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PaperMapper extends Mapper<Paper>, MySqlMapper<Paper> {
    int countByExample(PaperExample example);

    List<Paper> selectByExample(PaperExample example);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);
}