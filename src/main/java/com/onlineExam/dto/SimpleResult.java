package com.onlineExam.dto;

import com.onlineExam.exception.ERRORCODE;
import lombok.Data;

@Data
public class SimpleResult {

    private String resMsg;

    private boolean success;

    public SimpleResult(){
        this.success = true;
    }

    public SimpleResult(ERRORCODE errorCode){
        this.success = false;
        this.resMsg = errorCode.errMsg;
    }

}
