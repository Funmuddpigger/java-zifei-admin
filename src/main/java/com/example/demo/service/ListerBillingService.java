package com.example.demo.service;

import com.example.demo.entity.ListerBilling;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
public interface ListerBillingService extends IService<ListerBilling> {
    //查看账单
    ListerBilling lookbill(String account);
}
