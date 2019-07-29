package com.onlineExam.service.impl;

import com.onlineExam.dao.QuestionMapper;
import com.onlineExam.dto.ExamPaper;
import com.onlineExam.dto.QuestionItem;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.Question;
import com.onlineExam.model.example.QuestionExample;
import com.onlineExam.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.onlineExam.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class QuestionServiceImpl implements QuestionService {

    private static Log logger = LogFactory.getLog(QuestionServiceImpl.class);

    @Autowired
    private QuestionMapper questionMapper;


    @Override
    public SimpleResult addQuestion(String type, String description, String optionA, String optionB, String optionC, String optionD, String singleAnswer, String multipleAnswer, String fillIn,String analysis,String score) {
        Question question = new Question();
        question.setQuestionType(Integer.valueOf(type));
        question.setContent(description);
        question.setScore(Integer.valueOf(score));
        question.setCreateTime(new Date());
        question.setUpdateTime(new Date());
        question.setAnalysis(analysis);
        switch (type){
            case "3":
                question.setAnswer(fillIn);
                break;
            case "1":
                question.setOptionA("A:" + optionA);
                question.setOptionB("B:" + optionB);
                question.setOptionC("C:" + optionC);
                question.setOptionD("D:" + optionD);
                question.setAnswer(multipleAnswer);
                break;
            case "2":
                question.setOptionA("A:" + optionA);
                question.setOptionB("B:" + optionB);
                question.setOptionC("C:" + optionC);
                question.setOptionD("D:" + optionD);
                question.setAnswer(singleAnswer);
                break;
        }
        try {
            int i = questionMapper.insertSelective(question);
            if (i == 1){
                return new SimpleResult();
            }else {
                return new SimpleResult(ERRORCODE.QUESTION_ADD_FAILURE);
            }
        }catch (Exception e) {
            logger.error("增加题目发生异常",e);
            return new SimpleResult(ERRORCODE.COMMON);
        }
    }

    @Override
    public ExamPaper getQuestions() {
      return  getQuestionItem();
    }

    public ExamPaper getQuestionItem(){
        ExamPaper paper = new ExamPaper();
        paper.setInstId(26);
        paper.setPaperId(2);
        Date date1 = new Date();
        paper.setStartTime(DateUtil.DateToString(date1,DateUtil.DATETIME));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.HOUR,1);
        paper.setEndTime(DateUtil.DateToString(calendar.getTime(),DateUtil.DATETIME));
        List<QuestionItem> items = new ArrayList<>();
        QuestionExample example = new QuestionExample();
        try {
            int i = 1;
            List<Question> questions = questionMapper.selectByExample(example);
            for (Question question : questions) {
                QuestionItem item = new QuestionItem();
                item.setQuestionNo(i ++);
                item.setQuestionType(2);
                item.setQuestionstem(question.getContent());
                List<String> choices = new ArrayList<>();
                choices.add(question.getOptionA());
                choices.add(question.getOptionB());
                choices.add(question.getOptionC());
                choices.add(question.getOptionD());
                item.setChoice(choices);
                items.add(item);
            }
        }catch (Exception e){
            logger.error("题目解析异常",e);
            paper.setRespCode("0");
        }
        paper.setRespCode("1");
        paper.setQuestions(items);
        return paper;
    }

}
