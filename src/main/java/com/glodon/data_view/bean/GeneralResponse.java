package com.glodon.data_view.bean;

import java.io.Serializable;

/**
 * @author liuwg-a
 * @date 2019/11/10 11:36
 * @description 统一返回格式
 */
public class GeneralResponse<T> implements Serializable {
    private static final String CODE_SUCCESS = "success";
    private static final long serialVersionUID = -885076632190268901L;
    private String code = CODE_SUCCESS;
    /**
     * 失败时，错误原因的简单英文描述
     */
    private String message;
    /**
     * 执行成功后返回的结果
     */
    private T data;

    public GeneralResponse() {
    }

    public GeneralResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public GeneralResponse(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
