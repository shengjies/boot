package com.sj.boot.framework.config.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceContextHolder {
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDateSourceTpe(String dsType){
        log.info("切换到{}数据源", dsType);
        CONTEXT_HOLDER.set(dsType);
    }
    /**
     * 获得数据源的变量
     */
    public static String getDateSoureType()
    {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDateSoureType()
    {
        CONTEXT_HOLDER.remove();
    }
}
