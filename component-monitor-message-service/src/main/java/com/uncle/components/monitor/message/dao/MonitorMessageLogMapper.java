package com.uncle.components.monitor.message.dao;

import com.uncle.components.monitor.message.bo.MonitorMessageLogBoWithBLOBs;

public interface MonitorMessageLogMapper {

    int insert(MonitorMessageLogBoWithBLOBs record);

    MonitorMessageLogBoWithBLOBs selectByMessageId(String messageId);

    MonitorMessageLogBoWithBLOBs selectByBusinessId(String businessId);

}