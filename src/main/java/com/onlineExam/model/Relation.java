package com.onlineExam.model;

import javax.persistence.*;

@Table(name = "relation")
public class Relation {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "paper_id")
    private Integer paperId;

    /**
     * 被回复用户id
     */
    @Column(name = "question_id")
    private Integer questionId;

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
     * 获取用户id
     *
     * @return paper_id - 用户id
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * 设置用户id
     *
     * @param paperId 用户id
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * 获取被回复用户id
     *
     * @return question_id - 被回复用户id
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 设置被回复用户id
     *
     * @param questionId 被回复用户id
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}