package com.onlineExam.service.impl;

import com.onlineExam.common.Common;
import com.onlineExam.dao.SignRecordMapper;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.SignRecord;
import com.onlineExam.model.example.SignRecordExample;
import com.onlineExam.service.SignService;
import com.onlineExam.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService{

    @Autowired
    private SignRecordMapper signRecordMapper;

    @Override
    public SimpleResult sign(Integer id) {
        SimpleResult simpleResult = new SimpleResult();
        try {
            SignRecordExample example = new SignRecordExample();
            SignRecordExample.Criteria criteria = example.createCriteria();
            Date date = new Date();
            String dateTime = DateUtil.DateToString(date,DateUtil.DATETIME);
            String dateStr = dateTime.substring(0,dateTime.indexOf(" "));
            date = DateUtil.StringToDate(dateStr,DateUtil.DATE);
            String timeStr = dateTime.substring(dateTime.indexOf(" ") + 1,dateTime.length());
            if (!isValid(timeStr.replace(":",""))){
                simpleResult.setResMsg("当前时间无法签到");
                simpleResult.setSuccess(false);
                return simpleResult;
            }
            Date time = DateUtil.StringToDate(timeStr,DateUtil.TIME);
            criteria.andUserIdEqualTo(id);
            criteria.andSignDateEqualTo(date);
            List<SignRecord> records = signRecordMapper.selectByExample(example);
            if (records.size() == 0){
                SignRecord record = new SignRecord();
                record.setUserId(id);
                record.setSignDate(date);
                record.setSignTime(time);
                signRecordMapper.insert(record);
                simpleResult.setSuccess(true);
                simpleResult.setResMsg("签到成功！");
            }else {
                simpleResult.setSuccess(false);
                simpleResult.setResMsg("您已经完成签到！");
            }
            return simpleResult;
        }catch (Exception e){
            e.printStackTrace();
            simpleResult.setSuccess(false);
            simpleResult.setResMsg(ERRORCODE.COMMON.errMsg);
            return simpleResult;
        }
    }

    private boolean isValid(String timeNum){
        Integer nowNum = Integer.valueOf(timeNum);
        Integer startNum = Integer.valueOf(Common.startTime.replace(":",""));
        Integer endNum = Integer.valueOf(Common.endTime.replace(":",""));
        return (nowNum >= startNum && nowNum <= endNum);

    }
}
