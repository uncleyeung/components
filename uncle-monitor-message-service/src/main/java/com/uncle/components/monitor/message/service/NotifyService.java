package com.uncle.components.monitor.message.service;

import java.util.concurrent.Future;

/**
 * @author 杨戬
 * @className 通知信息服务
 * @email yangb@chaosource.com
 * @date 2019/3/22 14:47
 */
public interface NotifyService<T> {

    /**
     * 通知服务:异步
     *
     * @param template 模板
     * @return boolbean
     */
    boolean notify(T template);

    /**
     * 通知服务:异步
     *
     * @param template 模板
     * @return boolbean
     */
    Future<Boolean> notifyAsync(T template);
}
