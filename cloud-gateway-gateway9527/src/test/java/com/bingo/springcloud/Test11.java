package com.bingo.springcloud;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.StringUtils;

/**
 * @author:yaobin
 * @date:2021/4/1,16:26
 */

public class Test11 {
//    @MockBean
    
    
    @Test
    public void test1(){
        String str = "xxaxas=wafeaw";
        int i = str.indexOf(61);
        System.out.println(i);
        
        
    }
    
    @Test
    public void test2(){
        String text = "Path=/payment/get/**";

        int eqIdx = text.indexOf(61);
        String[] args = StringUtils.tokenizeToStringArray(text.substring(eqIdx + 1), ",");
        System.out.println(JSONUtil.toJsonStr(args));
    }
    
}
