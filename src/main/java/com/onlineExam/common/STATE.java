package com.onlineExam.common;

import org.apache.commons.lang3.StringUtils;

public enum STATE {

    WAIT_EXAM(1,"待考"),
    EXAMING(2,"在考"),
    EXAMED(3,"完成考试");

    public  String msg;
    public  int code;

    STATE(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsg(int code){
        for (STATE state : STATE.values()){
            if (code == state.code){
                return state.msg;
            }
        }
        return StringUtils.EMPTY;
    }
}
