package com.example.demo.utils;

public class CResponse {
    public int code = 200;
    public String msg = "成功";
    public Object data = null;

    public CResponse(int code) {
        this.code = code;
    }

    public CResponse(String msg) {
        this.msg = msg;
    }

    public CResponse(Object data) {
        this.data = data;
    }

    public CResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CResponse error(){

        return new CResponse(500,"失败");
    }

    public static CResponse error(String msg){

        return new CResponse(500,msg);
    }


    public static CResponse error(int code, String message){

        return new CResponse(code, message);
    }

    public static CResponse succeed(){

        return new CResponse(200,"成功");
    }

    public static CResponse succeed(int code, String message){

        return new CResponse(code, message);
    }

    public static CResponse succeed(int code, String message, Object data){

        return new CResponse(code, message, data);
    }


    public static CResponse succeed(Object data){
        return new CResponse(200, "成功", data);
    }

    public static CResponse succeed(String msg){
        return new CResponse(200, msg);
    }
}
