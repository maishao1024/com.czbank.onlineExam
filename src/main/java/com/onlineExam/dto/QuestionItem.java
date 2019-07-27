package com.onlineExam.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionItem {

    private String questionstem;

    private Integer questionType;

    private List<String> choice;
}
