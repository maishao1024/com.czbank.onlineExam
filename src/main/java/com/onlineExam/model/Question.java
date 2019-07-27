package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "question")
public class Question {
    @Id
    private Integer id;

    /**
     * 题目标题
     */
    private String title;

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
     * 学科ID
     */
    @Column(name = "subject_id")
    private Integer subjectId;

    /**
     * 试卷ID
     */
    @Column(name = "contest_id")
    private Integer contestId;

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

    /**
     * 题目分值
     */
    private Integer score;

    /**
     * 题目难度
     */
    private Integer difficulty;

    /**
     * 0表示未考试题目,1表示已考试题目
     */
    private Integer state;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 答案
     */
    private String answer;

    /**
     * 答案解析
     */
    private String parse;

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
     * 获取题目标题
     *
     * @return title - 题目标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置题目标题
     *
     * @param title 题目标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取学科ID
     *
     * @return subject_id - 学科ID
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置学科ID
     *
     * @param subjectId 学科ID
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取试卷ID
     *
     * @return contest_id - 试卷ID
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * 设置试卷ID
     *
     * @param contestId 试卷ID
     */
    public void setContestId(Integer contestId) {
        this.contestId = contestId;
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
     * 获取题目分值
     *
     * @return score - 题目分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置题目分值
     *
     * @param score 题目分值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取题目难度
     *
     * @return difficulty - 题目难度
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * 设置题目难度
     *
     * @param difficulty 题目难度
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * 获取0表示未考试题目,1表示已考试题目
     *
     * @return state - 0表示未考试题目,1表示已考试题目
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0表示未考试题目,1表示已考试题目
     *
     * @param state 0表示未考试题目,1表示已考试题目
     */
    public void setState(Integer state) {
        this.state = state;
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
     * @return parse - 答案解析
     */
    public String getParse() {
        return parse;
    }

    /**
     * 设置答案解析
     *
     * @param parse 答案解析
     */
    public void setParse(String parse) {
        this.parse = parse;
    }
}