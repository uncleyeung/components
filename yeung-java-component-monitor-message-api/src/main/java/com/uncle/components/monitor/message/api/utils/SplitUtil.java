package com.uncle.components.monitor.message.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Author 杨戬
 * @email yangbo@email.com
 * @Date  2019/3/22 11:18
 */
@Slf4j
public class SplitUtil {

    private SplitUtil() {
    }

    /**
     * @param str 要截取的字符串
     * @param count 要截取的字节数(utf-8中汉字:3字节)
     * @return String[]
     */
    public static String[] substringByBytes(String str, int count) {
        StringBuilder returnedStr1 = new StringBuilder();
        StringBuilder returnedStr2 = new StringBuilder();

        if (StringUtils.isNotBlank(str) && count > 0) {
            int currentIndex = 0;
            char[] strCharArray = str.toCharArray();
            // 遍历每一个字符
            for (char c : strCharArray) {
                String strEle = String.valueOf(c);
                byte[] b = null;
                b = strEle.getBytes(StandardCharsets.UTF_8);
                // 如果当前位置+当前字符>规定长度，则放到返回数组的第二个元素中
                if ((currentIndex + b.length) > count) {
                    returnedStr2.append(c);
                } else {
                    returnedStr1.append(c);
                }
                currentIndex = currentIndex + b.length;
            }
        }

        return new String[] {returnedStr1.toString(), returnedStr2.toString()};
    }
}
