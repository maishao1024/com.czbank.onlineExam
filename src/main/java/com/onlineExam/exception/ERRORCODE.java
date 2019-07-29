package com.onlineExam.exception;

public enum ERRORCODE {

    SUCESS("服务器端成功", 0000),
    COMMON("服务器端出错", 3000),
    WRONG_USERNAME_OR_PASSWORD("账号或密码错误", 3001),
    WRONG_USERNAME("该账号不存在", 3002),
    WRONG_PASSWORD("密码错误", 3003),
    UPLOAD_FILE_FAILURE("上传文件失败", 3004),
    AREADY_EXIST_USERNAME("该账号已经存在了", 3007),
    QUESTION_ADD_FAILURE("服务器题目增加失败,请联系管理员", 3008),
    PAPER_FAILURE("试卷提交失败,请联系管理员", 3009);

    public final String errMsg;
    public final int code;

    ERRORCODE(String errMsg, int code) {
        this.errMsg = errMsg;
        this.code = code;
    }
}
