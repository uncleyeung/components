package com.uncle.components.monitor.message.api.aspect;

/**
 * @author 杨戬
 * @email yangbo@email.com
 */
public abstract class AbstractMessageMonitorAspect {


    /**
     * 例如:切点为*Consumer的方法
     *
     * @Pointcut("execution (* com.uncle..*Consumer.onMessage(..))")
     */
    protected abstract void pointcut();


}
