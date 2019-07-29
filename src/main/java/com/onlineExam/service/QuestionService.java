package com.onlineExam.service;

import com.onlineExam.dto.ExamPaper;
import com.onlineExam.dto.SimpleResult;

public interface QuestionService {

    SimpleResult addQuestion(String type,String description,String optionA,String optionB,String optionC,String optionD,String singleAnswer,String multipleAnswer,String fillIn,String analysis,String score);
//
//    boolean updateQuestion(Question question);
//
    ExamPaper getQuestions();
//
//    Map<String, Object> getQuestionsByContent(int pageNum, int pageSize, String content);
//
//    Map<String, Object> getQuestionsByProblemsetIdAndContentAndDiffculty(int pageNum, int pageSize,
//                                                                         int problemsetId,
//                                                                         String content,
//                                                                         int diffcult);
//    boolean deleteQuestion(int id);
//
//    Question getQuestionById(int id);
//
//    boolean updateQuestionsStateByContestId(int contestId, int state);
}
