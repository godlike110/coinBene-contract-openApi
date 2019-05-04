package com.coinbene.contract.openapi.client.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author wenzhiwei
 * @time 2019-05-04 11:32
 **/
public class ObjectUtils {

    public static Object mapToObject(Map mapObject,Class c) {
        return JSONObject.parseObject(JSON.toJSONString(mapObject),c);
    }

}
