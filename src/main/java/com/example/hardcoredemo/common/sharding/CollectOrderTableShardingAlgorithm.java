package com.example.hardcoredemo.common.sharding;

import com.example.hardcoredemo.common.utils.DateUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;


import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
public class CollectOrderTableShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    private static List<String> getDateRange(Date start, Date end) {
        List<String> result = Lists.newArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String startString = sdf.format(start);
        //定义：ex_collect_order表只能对近六个月的数据进行操作
        for(int i=0; i<7; i++){
            Date endTime = DateUtils.getMouthByParam(end,i);
            String endString = sdf.format(endTime);
            result.add(endString);
            if(startString.equals(endString)){break;}
        }
        return result;
    }

    @Override
    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
        // 返回真实表名集合
        List<String> tableNameList = new ArrayList<>();
        // 逻辑表名
        String logicTableName = complexKeysShardingValue.getLogicTableName();
        // 分片键的值
        Collection<Date> timeValues = (Collection<Date>) complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("ctime");
        // 获取真实表名
        for (Date time : timeValues) {
            String routTable = getRouteTable(logicTableName, time);
            tableNameList.add(routTable);
        }
        return tableNameList;
    }


    private String getRouteTable(String logicTable, Date keyValue) {
        if (keyValue != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
            String formatDate = simpleDateFormat.format(keyValue);
            return logicTable + formatDate;
        }
        return null;
    }

    private Collection<String> getRouteTable(String logicTable, Date lowerEnd, Date upperEnd) {
        Set<String> routTables = new HashSet<>();
        if (lowerEnd != null && upperEnd != null) {
            List<String> rangeNameList = getDateRange(lowerEnd, upperEnd);
            for (String string : rangeNameList) {
                routTables.add(logicTable + string);
            }
        }
        return routTables;
    }

}