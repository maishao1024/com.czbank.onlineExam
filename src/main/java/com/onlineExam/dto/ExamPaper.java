package com.onlineExam.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExamPaper {

    private String respCode;

    private Integer instId;

    private Integer paperId;

    private String startTime;

    private String endTime;

    List<QuestionItem> questions;
}
