package com.ray.lab.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ray.lab.entity.Account;

@Mapper
public interface AccountMapperA {
    int updateDollar(Account account);
    int updateRMB(Account account);
}
