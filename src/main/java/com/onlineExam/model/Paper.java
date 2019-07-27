package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "paper")
public class Paper {
    @Id
    private Integer id;

    private String title;

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
     * 考试开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 进行状态:0表示未开始,1表示进行中,2表示考试已经结束,3表示该考试已经完成批卷
     */
    private Integer state;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 获取考试开始时间
     *
     * @return start_time - 考试开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置考试开始时间
     *
     * @param startTime 考试开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取考试结束时间
     *
     * @return end_time - 考试结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置考试结束时间
     *
     * @param endTime 考试结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return create_user_id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取进行状态:0表示未开始,1表示进行中,2表示考试已经结束,3表示该考试已经完成批卷
     *
     * @return state - 进行状态:0表示未开始,1表示进行中,2表示考试已经结束,3表示该考试已经完成批卷
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置进行状态:0表示未开始,1表示进行中,2表示考试已经结束,3表示该考试已经完成批卷
     *
     * @param state 进行状态:0表示未开始,1表示进行中,2表示考试已经结束,3表示该考试已经完成批卷
     */
    public void setState(Integer state) {
        this.state = state;
    }
}