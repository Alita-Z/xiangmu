package com.example.hardcoredemo.common.sharding;

import com.github.pagehelper.PageHelper;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.transaction.annotation.Transactional;

public class ShardingServiceImpl implements ShardingService{

    /**
     * 分布式事务XA:适用于单机多数据源
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void transactionalXA(){
        //手动开启xa事务
        TransactionTypeHolder.set(TransactionType.XA);
        //路由主库
        HintManager.getInstance().setPrimaryRouteOnly();
        //查询
        PageHelper.startPage(1,1);
        return;
    }

    /**
     * 分布式事务BASE
     */
//    @Transactional(rollbackFor = RuntimeException.class)
//    @ShardingTransactionType(TransactionType.BASE)
//    public void transactionalBASE(){
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setMasterRouteOnly();
//        return;
//    }
}
