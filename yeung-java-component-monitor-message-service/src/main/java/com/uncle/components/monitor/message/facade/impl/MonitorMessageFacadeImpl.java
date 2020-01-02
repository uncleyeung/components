package com.uncle.components.monitor.message.facade.impl;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.api.facade.MonitorMessageFacade;
import com.uncle.components.monitor.message.consumer.MonitorMessageLogConsumer;
import com.uncle.components.monitor.message.service.MonitorMessageLogService;
import com.uncle.message.api.dto.ReceiveMessageDTO;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 11:41
 */
@Service("monitorMessageFacade")
public class MonitorMessageFacadeImpl implements MonitorMessageFacade {

    @Resource
    private MonitorMessageLogService logService;

    @Resource
    private MonitorMessageLogConsumer monitorMessageLogConsumer;

    @Override
    public void logInfo(MonitorMessageLogDto dto) {
        logService.sendLogInfoMessage(dto);
    }

    @Override
    public void testMessageConsumer() {
        ReceiveMessageDTO receiveMessageDTO = new ReceiveMessageDTO();
        receiveMessageDTO.setMessageId("1");

        receiveMessageDTO.setMessageBody("{\n" +
                "    \"businessId\": \"s5145484121548\",\n" +
                "    \"exceptionInfo\": \"java.lang.ArithmeticException: / by zero\\r\\n\\tat com.uncle.cash.settle.consumer.SettleAccountConfirmConsumer.onMessage(SettleAccountConfirmConsumer.java:46)\\r\\n\\tat com.uncle.cash.settle.consumer.SettleAccountConfirmConsumer.onMessage(SettleAccountConfirmConsumer.java:33)\\r\\n\\tat com.uncle.cash.settle.consumer.SettleAccountConfirmConsumer$$FastClassBySpringCGLIB$$47627f49.invoke(<generated>)\\r\\n\\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\\r\\n\\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:736)\\r\\n\\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)\\r\\n\\tat org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor.invoke(AfterReturningAdviceInterceptor.java:55)\\r\\n\\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)\\r\\n\\tat org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\\r\\n\\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)\\r\\n\\tat org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)\\r\\n\\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)\\r\\n\\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:671)\\r\\n\\tat com.uncle.cash.settle.consumer.SettleAccountConfirmConsumer$$EnhancerBySpringCGLIB$$d628b2ca.onMessage(<generated>)\\r\\n\\tat com.outstanding.framework.plugin.mq.rocketmq.support.DefaultRocketMQListenerContainer$DefaultMessageListenerConcurrently.consumeMessage(DefaultRocketMQListenerContainer.java:206)\\r\\n\\tat org.apache.rocketmq.client.impl.consumer.ConsumeMessageConcurrentlyService.consumeMessageDirectly(ConsumeMessageConcurrentlyService.java:167)\\r\\n\\tat org.apache.rocketmq.client.impl.factory.MQClientInstance.consumeMessageDirectly(MQClientInstance.java:1185)\\r\\n\\tat org.apache.rocketmq.client.impl.ClientRemotingProcessor.consumeMessageDirectly(ClientRemotingProcessor.java:197)\\r\\n\\tat org.apache.rocketmq.client.impl.ClientRemotingProcessor.processRequest(ClientRemotingProcessor.java:75)\\r\\n\\tat org.apache.rocketmq.remoting.netty.NettyRemotingAbstract$1.run(NettyRemotingAbstract.java:182)\\r\\n\\tat org.apache.rocketmq.remoting.netty.RequestTask.run(RequestTask.java:80)\\r\\n\\tat java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)\\r\\n\\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\\r\\n\\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\\r\\n\\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\\r\\n\\tat java.lang.Thread.run(Thread.java:748)\\r\\n\",\n" +
                "    \"messageBody\": \"{\\\"financeConfirmList\\\":[{\\\"workFlowCode\\\":\\\"WORK1108956722889715712\\\",\\\"tradeTotalCount\\\":0},{\\\"workFlowCode\\\":\\\"WORK1108954683094822912\\\",\\\"tradeTotalCount\\\":0},{\\\"workFlowCode\\\":\\\"WORK1108928858958032896\\\",\\\"tradeTotalCount\\\":0}]}\",\n" +
                "    \"messageBornHost\": \"172.17.10.98\",\n" +
                "    \"messageId\": \"3D0EFF3900002AA700000000014E367D\",\n" +
                "    \"messageTopic\": \"CASH_ACCOUNT_FINANCE_CONFIRM_TOPIC\",\n" +
                "    \"notifyType\": \"EMAIL\",\n" +
                "    \"post\": true,\n" +
                "    \"status\": \"SUCCESS\",\n" +
                "    \"target\": [\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\",\n" +
                "        \"xx@email.com\"\n" +
                "    ]\n" +
                "}");
        MessageExt messageExt = new MessageExt();
        messageExt.setReconsumeTimes(1);
        monitorMessageLogConsumer.onMessage(receiveMessageDTO,messageExt);
    }
}
