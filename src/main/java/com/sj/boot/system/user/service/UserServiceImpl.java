package com.sj.boot.system.user.service;

import com.sj.boot.framework.aspectj.annotation.DataSource;
import com.sj.boot.framework.aspectj.lang.enums.DataSourceType;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public void master() {
        System.out.println("master");
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public void slave() {
        System.out.println("slave");
    }
}
