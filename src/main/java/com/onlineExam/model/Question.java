package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "question")
public class Question {
    @Id
    private Integer id;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 题目类型,0表示单项选择题,1表示多项选择题,2表示问答题,3表示编程题
     */
    @Column(name = "question_type")
    private Integer questionType;

    /**
     * 选项A
     */
    @Column(name = "option_a")
    private String optionA;

    /**
     * 选项B
     */
    @Column(name = "option_b")
    private String optionB;

    /**
     * 选项C
     */
    @Column(name = "option_c")
    private String optionC;

    /**
     * 选项D
     */
    @Column(name = "option_d")
    private String optionD;

    /**
     * 答案
     */
    private String answer;

    /**
     * 答案解析
     */
    private String analysis;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private Integer score;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取题目内容
     *
     * @return content - 题目内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置题目内容
     *
     * @param content 题目内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取题目类型,0表示单项选择题,1表示多项选择题,2表示问答题,3表示编程题
     *
     * @return question_type - 题目类型,0表示单项选择题,1表示多项选择题,2表示问答题,3表示编程题
     */
    public Integer getQuestionType() {
        return questionType;
    }

    /**
     * 设置题目类型,0表示单项选择题,1表示多项选择题,2表示问答题,3表示编程题
     *
     * @param questionType 题目类型,0表示单项选择题,1表示多项选择题,2表示问答题,3表示编程题
     */
    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    /**
     * 获取选项A
     *
     * @return option_a - 选项A
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * 设置选项A
     *
     * @param optionA 选项A
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
     * 获取选项B
     *
     * @return option_b - 选项B
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * 设置选项B
     *
     * @param optionB 选项B
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
     * 获取选项C
     *
     * @return option_c - 选项C
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * 设置选项C
     *
     * @param optionC 选项C
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    /**
     * 获取选项D
     *
     * @return option_d - 选项D
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * 设置选项D
     *
     * @param optionD 选项D
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取答案解析
     *
     * @return analysis - 答案解析
     */
    public String getAnalysis() {
        return analysis;
    }

    /**
     * 设置答案解析
     *
     * @param analysis 答案解析
     */
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}