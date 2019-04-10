package com.sj.boot.framework.aspectj;

import com.sj.boot.framework.aspectj.annotation.DataSource;
import com.sj.boot.framework.config.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.sj.boot.framework.aspectj.annotation.DataSource)")
    public void dsPointCut(){}

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature)point.getSignature();

        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);
        if(dataSource != null){
            DynamicDataSourceContextHolder.setDateSourceTpe(dataSource.value().name());
        }

        try {

            return point.proceed();

        }finally {

            DynamicDataSourceContextHolder.clearDateSoureType();

        }
    }
}
