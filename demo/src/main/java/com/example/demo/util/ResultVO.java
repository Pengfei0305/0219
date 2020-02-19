package com.example.demo.util;
/**
 *
 * @author Pengfei
 * @date 2020-2-18 10:46
 */
public class ResultVO<T> {

    /**
     *
     */
    private Integer code;

    private String msg;

    private T data;


    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(data==null){
            return "ResultVO{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }else
            return "ResultVO{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    ", data=" + data +
                    '}';
    }
}
