package xin.jerome.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @title: InvokeLogCopy
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2021/7/16 11:08
 */
@Data
@TableName("INVOKE_LOG_COPY")
@Builder
public class InvokeLogCopy extends Model<InvokeLogCopy> {

    private static final long serialVersionUID = -5886012896705137070L;

    /**
     * 雪花算法  id生成策略
     */
    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    /**
     * 能力编码
     */
    @TableField(value = "CAP_CODE")
    private String capCode;

    /**
     * 应用Id
     */
    @TableField(value = "CLIENT_ID")
    private String clientId;

    /**
     * //开发者账号
     */
    @TableField(value = "DEV_USER_NAME")
    private String devUserName;

    /**
     *
     */
    @TableField(value = "APP_BELONG_ENV")
    private Integer appBelongEnv;

    /**
     * //请求参数
     */
    @TableField(value = "REQ_PARAM")
    private String reqParam;

    @TableField(value = "RESP_PARAM")
    private String respParam;//响应参数

    @TableField(value = "INVOKE_START_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date invokeStartTime;//调用开始时间

    @TableField(value = "INVOKE_END_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date invokeEndTime;//调用结束时间

    @TableField(value = "RESPONSE_TIME")
    private Long responseTime;//响应时长 ms

    @TableField(value = "INVOKE_RESULT")
    private Integer invokeResult;//调用结果

    @TableField(value = "INVOKE_IP")
    private String invokeIp;//调用者IP

    @TableField(value = "RESP_TYPE")
    private Integer respType;//响应类型

    @TableField(value = "RESP_STATUS_CODE")
    private Integer respStatusCode;//响应状态码

    @TableField(value = "RESP_EXPLAIN")
    private String respExplain;//响应说明

    @TableField(value = "STATIS_DATE")
    private String statisDate;//统计日期

    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableField(value = "delete_flag")
    private Integer deleteFlag; //标识

    /**
     * 计费模型编号
     */
    @TableField(value = "MET_MODEL_CODE")
    private String metModelCode;

    /**
     * 订阅编号
     */
    @TableField(value = "SUBSCRIBE_NUM")
    private String subscribeNum;


}
