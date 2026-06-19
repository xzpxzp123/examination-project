package com.xzp.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResopnseResult<T> {
//    状态码
    private Integer code;
//    提示信息
    private String msg;
    private String userType;
//    查询到的结果数据
    private T data;
    public ResopnseResult(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public ResopnseResult(Integer code,String userType,T data){
        this.code=code;
        this.data=data;
        this.userType=userType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResopnseResult() {

    }
}
