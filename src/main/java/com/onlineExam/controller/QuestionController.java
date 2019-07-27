package com.onlineExam.controller;

import com.onlineExam.dto.ExamPaper;
import com.onlineExam.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    private static Log LOG = LogFactory.getLog(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    //获取题目
    @RequestMapping(value="/questions", method= RequestMethod.POST)
    @ResponseBody
    public ExamPaper getQuestions() {
        return questionService.getQuestions();
    }

//    //更新题目信息
//    @RequestMapping(value="/api/updateQuestion", method= RequestMethod.POST)
//    @ResponseBody
//    public DataResult updateQuestion(@RequestBody Question question) {
//        DataResult pageResult = new DataResult();
//        boolean result = questionService.updateQuestion(question);
//        return new DataResult().setData(result);
//    }
//
//    //删除题目信息
//    @DeleteMapping("/api/deleteQuestion/{id}")
//    public DataResult deleteContest(@PathVariable int id) {
//        DataResult pageResult = new DataResult();
//        boolean result = questionService.deleteQuestion(id);
//        return new DataResult().setData(result);
//    }
}
