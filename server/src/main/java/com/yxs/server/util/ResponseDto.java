package com.yxs.server.util;

public class ResponseDto<T> {
    /*
    * 业务上的成功或者失败
    * */
    private boolean success=true;
    /*
    * 返回码
    * */
    private String code;
    /*
    * 返回信息
    * */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    /*
    * 返回泛型数据，自定义类型
    * */
    private T content;

}
