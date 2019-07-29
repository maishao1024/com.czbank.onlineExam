package com.onlineExam.controller;

import com.onlineExam.dto.ExamPaper;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    //上传题目信息
    @RequestMapping(value="/add", method= RequestMethod.POST)
    @ResponseBody
    public SimpleResult addQuestion(HttpServletRequest request) {
        try {
            String type = request.getParameter("type");
            String description = request.getParameter("description");
            String optionA = request.getParameter("optionA");
            String optionB = request.getParameter("optionB");
            String optionC = request.getParameter("optionC");
            String optionD = request.getParameter("optionD");
            String fillIn = request.getParameter("fillIn");
            String radio = request.getParameter("radio");
            String checkBox = request.getParameter("checkBox");
            String analysis = request.getParameter("analysis");
            String score = request.getParameter("score");
            return questionService.addQuestion(type,description,optionA,optionB,optionC,optionD,radio,checkBox,fillIn,analysis,score);
        }catch (Exception e){
            return new SimpleResult(ERRORCODE.COMMON);
        }
    }
}
