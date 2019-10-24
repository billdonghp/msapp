package com.multiseafoods.msapp.utils;

import com.multiseafoods.msapp.entity.Result;
import com.multiseafoods.msapp.entity.ResultEnum;

public class ResultUtil {

    public static Result ok(Object obj){
        Result result = new Result();
        result.setData(obj);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static  Result ok(){
        return ok(null);
    }

    public static Result cust(Integer code, String msg, Object obj){
        Result result = new Result();
        result.setData(obj);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        return result;

    }

}
