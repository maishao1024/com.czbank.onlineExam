package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "signrecord")
public class SignRecord {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "sign_date")
    private Date signDate;

    /**
     * 帖子id
     */
    @Column(name = "sign_time")
    private Date signTime;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return sign_date
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * @param signDate
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * 获取帖子id
     *
     * @return sign_time - 帖子id
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * 设置帖子id
     *
     * @param signTime 帖子id
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}