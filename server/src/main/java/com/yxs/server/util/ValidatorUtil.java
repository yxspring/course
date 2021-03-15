package com.yxs.server.util;

import com.yxs.server.exception.ValidatorException;
import org.springframework.util.StringUtils;

public class ValidatorUtil {
    /*
    * 非空校验
    * */
    public static void require(String str,String fieldName){
        if (StringUtils.isEmpty(str)){
            throw  new ValidatorException(fieldName+"不能为空！");
        }
    }

    /*
    * 长度校验
    * */
    public  static void length(String str,String fieldName,int min,int max){
        if (StringUtils.isEmpty(str)){
           return;
        }
        int length=0;
        if (!StringUtils.isEmpty(str)){
            length=str.length();
        }
        if (length<min||length>max){
            throw new ValidatorException(fieldName+"长度在"+min+"~"+max+"之间！");
        }
    }

}
