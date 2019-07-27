package com.onlineExam.dao;

import com.onlineExam.model.Relation;
import com.onlineExam.model.example.RelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RelationMapper extends Mapper<Relation>, MySqlMapper<Relation> {
    int countByExample(RelationExample example);

    int deleteByExample(RelationExample example);

    List<Relation> selectByExample(RelationExample example);

    int updateByExampleSelective(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByExample(@Param("record") Relation record, @Param("example") RelationExample example);
}