package com.onlineExam.service.impl;

import com.onlineExam.common.STATE;
import com.onlineExam.dao.AchievementMapper;
import com.onlineExam.dao.PaperMapper;
import com.onlineExam.dao.QuestionMapper;
import com.onlineExam.dto.DataResult;
import com.onlineExam.dto.PaperResult;
import com.onlineExam.dto.SimpleResult;
import com.onlineExam.exception.ERRORCODE;
import com.onlineExam.model.Achievement;
import com.onlineExam.model.Paper;
import com.onlineExam.model.Question;
import com.onlineExam.model.example.PaperExample;
import com.onlineExam.model.example.QuestionExample;
import com.onlineExam.service.PaperService;
import com.onlineExam.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService{

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public DataResult paperHistory(String title) {
        PaperExample example = new PaperExample();
        PaperExample.Criteria criteria = example.createCriteria();
        try {
            if (StringUtils.isNotEmpty(title)){
                title = '%' + title + '%';
                criteria.andTitleLike(title);
            }
            example.setOrderByClause("create_time desc");
            List<Paper> papers = paperMapper.selectByExample(example);
            List<PaperResult> results = new ArrayList<>();
            for (Paper paper : papers){
                PaperResult result = new PaperResult();
                result.setStartTime(DateUtil.DateToString(paper.getStartTime(),DateUtil.DATETIME));
                result.setEndTime(DateUtil.DateToString(paper.getEndTime(),DateUtil.DATETIME));
                result.setTitle(paper.getTitle());
                result.setState(STATE.getMsg(paper.getState()));
                results.add(result);
            }
            DataResult dataResult = new DataResult();
            dataResult.setData(results);
            return dataResult;
        }catch (Exception e){
            return DataResult.fixedError(ERRORCODE.COMMON);
        }
    }

    @Override
    public SimpleResult submitPaper(String userId,String paperId, String answer, String questionNos) {
        try {
            questionNos = questionNos.substring(0,questionNos.length() - 1);
            String[] questions = questionNos.split("&");
            List<Integer> array = new ArrayList<>();
            for (int i = 0;i < questions.length;i ++){
                array.add(Integer.valueOf(questions[i]));
            }
            int right = 0;
            QuestionExample example = new QuestionExample();
            QuestionExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(array);
            List<Question> actualQuestion = questionMapper.selectByExample(example);
            String[] personAnswer = answer.split("&");
            if (actualQuestion.size() != personAnswer.length){
                return new SimpleResult(ERRORCODE.PAPER_FAILURE);
            }else {
                for (int i = 0;i < array.size(); i++){
                    Question question = findQuestionById(array.get(i),actualQuestion);
                    if (question.getQuestionType() == 1){
                        System.out.print(question.getContent());
                    }else {
                        if (StringUtils.equals(question.getAnswer(),personAnswer[i].substring(0,personAnswer[i].length() - 1))){
                            right ++;
                        }
                    }
                }
            }
            Achievement achievement = new Achievement();
            achievement.setAnswerJson(answer.replace("%",""));
            achievement.setUserId(Integer.valueOf(userId));
            achievement.setTestId(Integer.valueOf(paperId));
            achievement.setScore(getScore(right,personAnswer.length));
            achievement.setFinishTime(new Date());
            achievement.setState(1);
            achievement.setManulScore(0);
            achievementMapper.insertSelective(achievement);
        }catch (Exception e){
            return new SimpleResult(ERRORCODE.COMMON);
        }
        return new SimpleResult();
    }

    private Question findQuestionById(int id,List<Question> questions){
        for (Question question : questions){
            if (question.getId() == id){
                return question;
            }
        }
        return null;
    }

    private Integer getScore(Integer a,Integer b){
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        BigDecimal answer = bigDecimal.divide(bigDecimal1,2,BigDecimal.ROUND_HALF_UP);
        return answer.multiply(new BigDecimal(100)).intValue();
    }
}
