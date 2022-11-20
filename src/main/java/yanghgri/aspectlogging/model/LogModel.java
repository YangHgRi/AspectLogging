package yanghgri.aspectlogging.model;

import lombok.Data;

/**
 * @author YangHgRi
 */
@Data
public class LogModel {
    /**
     * 接口url
     */
    private String url;
    /**
     * 接口注释
     */
    private String comment;
    /**
     * 服务端
     */
    private String service;
    /**
     * 客户端
     */
    private String client;
    /**
     * 错误日志
     */
    private String errorLog;
    /**
     * 请求参数
     */
    private String requestParam;
    /**
     * 响应
     */
    private String returnValue;
}