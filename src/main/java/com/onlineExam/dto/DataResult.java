package com.onlineExam.dto;

import com.onlineExam.exception.ERRORCODE;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class DataResult extends HashMap<String, Object> {

    public static final String COMMON_ERROR = "接口调用出错";

    public static final String MESSAGE = "message";
    public static final String SUCCESS = "success";
    public static final String DATA = "data";
    public static final String CODE = "code";

    private static final Map<ERRORCODE, DataResult> map = new HashMap<>();

    public static DataResult fixedError(ERRORCODE ERRORCODE) {
        if (map.get(ERRORCODE) == null) {
            synchronized (DataResult.class) {
                map.computeIfAbsent(ERRORCODE, e -> new DataResult().setState(e));
            }
        }
        return map.get(ERRORCODE);
    }

    public DataResult() {
        put(MESSAGE, "");
        put(SUCCESS, false);
    }

    public DataResult setState(ERRORCODE ERRORCODE) {
        put(MESSAGE, ERRORCODE.errMsg);
        put(CODE, ERRORCODE.code);
        put(SUCCESS, false);
        return this;
    }

    private DataResult setCode(int code) {
        put(CODE, code);
        return this;
    }

    public DataResult setMessage(String msg) {
        setSuccess(false);
        put(MESSAGE, msg);
        return this;
    }


    public DataResult setSuccess(boolean ret) {
        put(SUCCESS, ret);
        return this;
    }

    public DataResult setData(Object obj) {
        setSuccess(true);
        put(DATA, obj);
        return this;
    }

}