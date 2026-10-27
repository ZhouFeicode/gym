package com.example.moffer.common;

import lombok.Data;

@Data
public class Result {
private String msg;
private int code;
private Object data;
public static Result Success(String msg){
    Result r=new Result();
    r.setMsg(msg);
    r.setCode(200);
    r.setData(null);
return r;
}
public static Result Success(Object data){
        Result r=new Result();
        r.setMsg("成功");
        r.setCode(200);
        r.setData(data);
        return r;
    }
public static Result Error(){
    Result r=new Result();
    r.setMsg("失败");
    r.setCode(400);
    r.setData(null);
    return r;
}
    public static Result Error(int code,String msg){
        Result r=new Result();
        r.setMsg(msg);
        r.setCode(code);
        r.setData(null);
        return r;
    }

}
