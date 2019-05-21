package com.uncle.components.monitor.message.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @Author 杨戬
 * @email yangbo@email.com
 * @Date  2019/3/22 11:18
 */
@Slf4j
public class SplitUtil {


    /**
     * @param str 要截取的字符串
     * @param count 要截取的字节数(utf-8中汉字:3字节)
     * @return String[]
     */
    public static String[] substringByBytes(String str, int count) {
        String returnedStr1 = "";
        String returnedStr2 = "";

        if (StringUtils.isNotBlank(str) && count > 0) {
            int currentIndex = 0;
            char[] strCharArray = str.toCharArray();
            int strCharArrayLength = strCharArray.length;
            // 遍历每一个字符
            for (int i = 0; i < strCharArrayLength; i++) {
                String strEle = String.valueOf(strCharArray[i]);
                byte[] b = null;
                try {
                    b = strEle.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    log.warn("substringByBytes with error:" + e.getMessage());
                }
                // 如果当前位置+当前字符>规定长度，则放到返回数组的第二个元素中
                if ((currentIndex + b.length) > count) {
                    returnedStr2 = returnedStr2 + strCharArray[i];
                } else {
                    returnedStr1 = returnedStr1 + strCharArray[i];
                }
                currentIndex = currentIndex + b.length;
            }
        }

        return new String[] { returnedStr1, returnedStr2 };
    }
}
