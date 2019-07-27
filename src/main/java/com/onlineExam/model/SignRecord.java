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

    /**
     * 帖子id
     */
    @Column(name = "sign_time")
    private Date signTime;

    /**
     * 内容
     */
    @Column(name = "current_ip")
    private String currentIp;

    /**
     * 创建时间
     */
    @Column(name = "sequence")
    private Integer sequence;

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

    /**
     * 获取内容
     *
     * @return current_ip - 内容
     */
    public String getCurrentIp() {
        return currentIp;
    }

    /**
     * 设置内容
     *
     * @param currentIp 内容
     */
    public void setCurrentIp(String currentIp) {
        this.currentIp = currentIp;
    }

    /**
     * 获取创建时间
     *
     * @return  sequence - 创建时间
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置创建时间
     *
     * @param sequence 创建时间
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}