package com.onlineExam.dto;

import com.onlineExam.exception.QexzWebError;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class PageResult extends HashMap<String, Object> {

    @Deprecated
    public static final String COMMON_ERROR = "接口调用出错";

    public static final String MESSAGE = "message";
    public static final String SUCCESS = "success";
    public static final String DATA = "data";
    public static final String CODE = "code";

    public static final PageResult BLANK_SUCCESS = new PageResult().setSuccess(true);

    private static final Map<QexzWebError, PageResult> map = new HashMap<>();

    public static PageResult fixedError(QexzWebError qexzWebError) {
        if (map.get(qexzWebError) == null) {
            synchronized (PageResult.class) {
                map.computeIfAbsent(qexzWebError, e -> new PageResult().setState(e));
            }
        }
        return map.get(qexzWebError);
    }

    public PageResult() {
        put(MESSAGE, "");
        put(SUCCESS, false);
    }

    public PageResult setState(QexzWebError qexzWebError) {
        put(MESSAGE, qexzWebError.errMsg);
        put(CODE, qexzWebError.code);
        put(SUCCESS, false);
        return this;
    }

    private PageResult setCode(int code) {
        put(CODE, code);
        return this;
    }

    public PageResult setMessage(String msg) {
        setSuccess(false);
        put(MESSAGE, msg);
        return this;
    }

    public PageResult setSuccess(boolean ret) {
        put(SUCCESS, ret);
        return this;
    }

    public PageResult setData(Object obj) {
        setSuccess(true);
        put(DATA, obj);
        return this;
    }

}