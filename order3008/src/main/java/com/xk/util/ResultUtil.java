package com.xk.util;

import lombok.Data;
import net.sf.json.JSONObject;

@Data
public class ResultUtil {

    private String msg;
    private String code;
    private Object data;

    private ResultUtil(){

    }

    private ResultUtil(Object data){
        this.data = data;
    }

    public static String success(Object data){
        ResultUtil resultUtil = new  ResultUtil(data);
        resultUtil.setCode(CODE_SUCC);
        resultUtil.setMsg(MSG_SUCC);
        resultUtil.setData(data);
        return JSONObject.fromObject(resultUtil).toString();
    }

    public static String fail(){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMsg(MSG_FAIL);
        resultUtil.setCode(CODE_FAIL);
        return  JSONObject.fromObject(resultUtil).toString();
    }

    private static final String CODE_SUCC = "200";
    private static final String CODE_FAIL = "500";

    private static final String MSG_SUCC = "操作成功";
    private static final String MSG_FAIL = "操作失败";

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("data","data");
        System.out.println(ResultUtil.success(json));
    }


}
