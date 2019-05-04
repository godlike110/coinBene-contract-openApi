package com.coinbene.contract.openapi.client.utils;

import com.alibaba.fastjson.JSONObject;
import com.coinbene.contract.openapi.client.security.HmacSHA256Signer;
import com.google.common.collect.Maps;
import okhttp3.Request;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author wenzhiwei
 * @time 2019-05-04 10:39
 **/
public class SignUtils {

    public static JSONObject createRequestObject(Map<String,Object> params, String path, long timeStamp, String apiId,String secret) {

        TreeMap<String,Object> paramMap = Maps.newTreeMap();

        JSONObject object = new JSONObject();
        object.put("apiid",apiId);
        object.put("timestamp",timeStamp);

        paramMap.put("TIMESTAMP",timeStamp);
        paramMap.put("APIID",apiId.toUpperCase());
        paramMap.put("REQUESTURI",path.toUpperCase());

        for(String p:params.keySet()) {
            object.put(p,params.get(p));
            paramMap.put(p.toUpperCase(),String.valueOf(params.get(p)).toUpperCase());
        }

        StringBuffer sb = new StringBuffer();

        Iterator<String> keyIterator =  paramMap.keySet().iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            sb.append(key).append("=").append(paramMap.get(key)).append("&");
        }

        String preString = sb.toString().substring(0,sb.toString().length()-1);

        String sign = HmacSHA256Signer.sha256_HMAC(preString,secret);

        object.put("sign",sign);

        return object;

    }
}
