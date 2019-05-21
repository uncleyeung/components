package com.uncle.components.monitor.message.api.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 11:18
 */
public class ExceptionUtils {

    /**
     * 获取全部的异常信息
     *
     * @param throwable 异常体
     * @return 异常信息
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
