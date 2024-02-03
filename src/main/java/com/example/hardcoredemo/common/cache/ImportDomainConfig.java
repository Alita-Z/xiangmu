package com.example.hardcoredemo.common.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Desc:
 * @Author: chenlong
 * @Date: 2021/7/20 17:02
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImportDomainConfig implements Serializable {

    private static final long serialVersionUID = 1;

    private Long id;

    //领域WEB key
    private String domainKey;

    //导入节点编码
    private String systemCode;

    //领域WEB地址
    private String domainUrl;

    //rpc域
    private String rpcDomain;

    // 领域applicatonName，用于注册iris rpc服务
    private String appCode;

}
