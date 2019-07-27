package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "achievement")
public class Achievement {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 考生主键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 考试主键ID
     */
    @Column(name = "test_id")
    private Integer testId;

    /**
     * 最终分数
     */
    private Integer score;

    /**
     * 电脑自动评判选择题分数
     */
    @Column(name = "auto_score")
    private Integer autoScore;

    /**
     * 人工手动评判分数
     */
    @Column(name = "manul_score")
    private Integer manulScore;

    /**
     * 考试交卷时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 改卷完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 0表示已交卷但是未评卷,1表示已交卷已评卷
     */
    private Integer state;

    /**
     * 考试作答答案json
     */
    @Column(name = "answer_json")
    private String answerJson;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取考生主键ID
     *
     * @return user_id - 考生主键ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置考生主键ID
     *
     * @param userId 考生主键ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取考试主键ID
     *
     * @return test_id - 考试主键ID
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * 设置考试主键ID
     *
     * @param testId 考试主键ID
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * 获取最终分数
     *
     * @return score - 最终分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置最终分数
     *
     * @param score 最终分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取电脑自动评判选择题分数
     *
     * @return auto_score - 电脑自动评判选择题分数
     */
    public Integer getAutoScore() {
        return autoScore;
    }

    /**
     * 设置电脑自动评判选择题分数
     *
     * @param autoScore 电脑自动评判选择题分数
     */
    public void setAutoScore(Integer autoScore) {
        this.autoScore = autoScore;
    }

    /**
     * 获取人工手动评判分数
     *
     * @return manul_score - 人工手动评判分数
     */
    public Integer getManulScore() {
        return manulScore;
    }

    /**
     * 设置人工手动评判分数
     *
     * @param manulScore 人工手动评判分数
     */
    public void setManulScore(Integer manulScore) {
        this.manulScore = manulScore;
    }

    /**
     * 获取考试交卷时间
     *
     * @return create_time - 考试交卷时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置考试交卷时间
     *
     * @param createTime 考试交卷时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取改卷完成时间
     *
     * @return finish_time - 改卷完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置改卷完成时间
     *
     * @param finishTime 改卷完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取0表示已交卷但是未评卷,1表示已交卷已评卷
     *
     * @return state - 0表示已交卷但是未评卷,1表示已交卷已评卷
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0表示已交卷但是未评卷,1表示已交卷已评卷
     *
     * @param state 0表示已交卷但是未评卷,1表示已交卷已评卷
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取考试作答答案json
     *
     * @return answer_json - 考试作答答案json
     */
    public String getAnswerJson() {
        return answerJson;
    }

    /**
     * 设置考试作答答案json
     *
     * @param answerJson 考试作答答案json
     */
    public void setAnswerJson(String answerJson) {
        this.answerJson = answerJson;
    }
}