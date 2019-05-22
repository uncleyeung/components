/*==============================================================*/
/* Table: MONITOR_MESSAGE_LOG                                  */
/*==============================================================*/
create table MONITOR_MESSAGE_LOG 
(
   ID                   NUMBER(10)           not null,
   MESSAGE_ID           VARCHAR2(48)         not null,
   MESSAGE_BORN_HOST    VARCHAR2(255),
   MESSAGE_TAG          VARCHAR2(255),
   MESSAGE_TOPIC        VARCHAR2(255)        not null,
   MESSAGE_BODY         BLOB                 not null,
   EXCEPTION_INFO       BLOB,
   STATUS               NUMBER(20,0)         not null,
   BUSINESS_ID          VARCHAR2(255)        not null,
   EVENT_CODE           VARCHAR2(32),
   SYSTEM_CODE          VARCHAR2(32),
   MODULE_CODE          VARCHAR2(32),
   ACTION_CODE          VARCHAR2(32),
   REMARK               VARCHAR2(256),
   CREATE_TIME          TIMESTAMP(6)         default SYSDATE not null,
   UPDATE_TIME          TIMESTAMP(6)         default SYSDATE not null,
   VERSION              NUMBER(20)           default 0 not null,
   DEL_STATE            NUMBER(2)            default 10 not null,
   DEF_1                VARCHAR2(16),
   DEF_2                VARCHAR2(16),
   DEF_3                VARCHAR2(16),
   DEF_4                VARCHAR2(16),
   constraint PK_MONITOR_MESSAGE_LOG primary key (ID)
);

comment on table MONITOR_MESSAGE_LOG is
'MONITOR_MESSAGE_LOG(消息预警表)';

comment on column MONITOR_MESSAGE_LOG.MESSAGE_ID is
'消息ID';

comment on column MONITOR_MESSAGE_LOG.MESSAGE_BORN_HOST is
'消息BornHost';

comment on column MONITOR_MESSAGE_LOG.MESSAGE_TAG is
'消息Tag';

comment on column MONITOR_MESSAGE_LOG.MESSAGE_TOPIC is
'消息主题';

comment on column MONITOR_MESSAGE_LOG.MESSAGE_BODY is
'业务数据';

comment on column MONITOR_MESSAGE_LOG.EXCEPTION_INFO is
'异常信息';

comment on column MONITOR_MESSAGE_LOG.STATUS is
'状态(10:成功 11:错误)';

comment on column MONITOR_MESSAGE_LOG.BUSINESS_ID is
'业务数据ID';

comment on column MONITOR_MESSAGE_LOG.EVENT_CODE is
'事件编码';

comment on column MONITOR_MESSAGE_LOG.SYSTEM_CODE is
'系统编号';

comment on column MONITOR_MESSAGE_LOG.MODULE_CODE is
'模块编号';

comment on column MONITOR_MESSAGE_LOG.ACTION_CODE is
'操作编号';

comment on column MONITOR_MESSAGE_LOG.REMARK is
'备注';

comment on column MONITOR_MESSAGE_LOG.CREATE_TIME is
'创建时间';

comment on column MONITOR_MESSAGE_LOG.UPDATE_TIME is
'最后更新时间';

comment on column MONITOR_MESSAGE_LOG.VERSION is
'版本';

comment on column MONITOR_MESSAGE_LOG.DEL_STATE is
'删除状态10正常11删除';

comment on column MONITOR_MESSAGE_LOG.DEF_1 is
'扩展字段1';

comment on column MONITOR_MESSAGE_LOG.DEF_2 is
'扩展字段2';

comment on column MONITOR_MESSAGE_LOG.DEF_3 is
'扩展字段3';

comment on column MONITOR_MESSAGE_LOG.DEF_4 is
'扩展字段4';

/*==============================================================*/
/* Index: 'index_mmw_mi'                                        */
/*==============================================================*/
create index index_mmw_mi on MONITOR_MESSAGE_LOG ( MESSAGE_ID ASC )tablespace chaos_components_index;

/*==============================================================*/
/* Index: 'index_mmw_bi'                                        */
/*==============================================================*/
create index index_mmw_bi on MONITOR_MESSAGE_LOG ( BUSINESS_ID ASC )tablespace chaos_components_index;

/*==============================================================*/
/* seq: 'seq_MONITOR_MESSAGE_LOG'                                        */
/*==============================================================*/
create sequence seq_MONITOR_MESSAGE_LOG increment by 1 start with 1 nomaxvalue nocycle cache 20;