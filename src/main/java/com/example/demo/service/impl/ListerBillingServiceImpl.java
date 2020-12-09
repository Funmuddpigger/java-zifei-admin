package com.example.demo.service.impl;

import com.example.demo.entity.ListerBilling;
import com.example.demo.mapper.ListerBillingMapper;
import com.example.demo.service.ListerBillingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
@Service
public class ListerBillingServiceImpl extends ServiceImpl<ListerBillingMapper, ListerBilling> implements ListerBillingService {

    @Autowired
    ListerBillingMapper listerBillingMapper;

    @Override
    public ListerBilling lookbill(String account) { return listerBillingMapper.lookbill(account); }
}
