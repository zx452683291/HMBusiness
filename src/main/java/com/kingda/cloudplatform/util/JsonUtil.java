package com.kingda.cloudplatform.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author Constanline
 * @description
 * @date 2019/10/21
 */
public class JsonUtil {
    /**
     * 将JSON字符串转成POJO类实例
     *
     * @param text
     * @param clazz
     * @return 返回text转化的POJO实例
     * @author Constanline
     * @date 2019/10/21
     */
    public static <T> T getObject(String text, Class<T> clazz) {
        return JSONObject.parseObject(text, clazz);
    }

    /**
     * 将POJO类实例转成JSON字符串
     *
     * @param obj
     * @return 返回POJO转化的JSON字符串
     * @author Constanline
     * @date 2019/10/21
     */
    public static <T> String getJson(T obj){
        return JSONObject.toJSONString(obj);
    }

    /**
     * List<T>转JSONArray 
     *
     * @param list
     * @return 返回List<T>转成的JSONArray
     * @author Constanline
     * @date 2019/10/21
     */
    public static <T> String listToJson(List<T> list) {
        return JSON.toJSONString(list);
    }


    /**
     * 转JSONArray转List<T>
     *
     * @param text
     * @param clazz
     * @return 返回JSONArray转成的List<T>
     * @author Constanline
     * @date 2019/10/21
     */
    public static <T> List<T> jsonToList(String text, Class<T> clazz) {
        return (List<T>) JSONArray.parseArray(text, clazz);
    }
}
