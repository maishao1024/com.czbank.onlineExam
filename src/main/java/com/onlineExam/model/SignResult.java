package com.onlineExam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "signresult")
public class SignResult {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 作者ID
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * html源代码
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 文本内容
     */
    @Column(name = "need_sign")
    private Integer needSign;

    /**
     * 发帖时间
     */
    @Column(name = "absent_sign")
    private Integer absentSign;

    /**
     * 帖子最后编辑时间
     */
    @Column(name = "total_sign")
    private Integer totalSign;

    /**
     * 最后一次回复时间
     */
    @Column(name = "sign_percent")
    private String signPercent;

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
     * 获取作者ID
     *
     * @return begin_time - 作者ID
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置作者ID
     *
     * @param beginTime 作者ID
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取html源代码
     *
     * @return end_time - html源代码
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置html源代码
     *
     * @param endTime html源代码
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取文本内容
     *
     * @return need_sign - 文本内容
     */
    public Integer getNeedSign() {
        return needSign;
    }

    /**
     * 设置文本内容
     *
     * @param needSign 文本内容
     */
    public void setNeedSign(Integer needSign) {
        this.needSign = needSign;
    }

    /**
     * 获取发帖时间
     *
     * @return absent_sign - 发帖时间
     */
    public Integer getAbsentSign() {
        return absentSign;
    }

    /**
     * 设置发帖时间
     *
     * @param absentSign 发帖时间
     */
    public void setAbsentSign(Integer absentSign) {
        this.absentSign = absentSign;
    }

    /**
     * 获取帖子最后编辑时间
     *
     * @return total_sign - 帖子最后编辑时间
     */
    public Integer getTotalSign() {
        return totalSign;
    }

    /**
     * 设置帖子最后编辑时间
     *
     * @param totalSign 帖子最后编辑时间
     */
    public void setTotalSign(Integer totalSign) {
        this.totalSign = totalSign;
    }

    /**
     * 获取最后一次回复时间
     *
     * @return sign_percent - 最后一次回复时间
     */
    public String getSignPercent() {
        return signPercent;
    }

    /**
     * 设置最后一次回复时间
     *
     * @param signPercent 最后一次回复时间
     */
    public void setSignPercent(String signPercent) {
        this.signPercent = signPercent;
    }
}