package com.example.demo.mapper;

import com.example.demo.entity.ListerBilling;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
public interface ListerBillingMapper extends BaseMapper<ListerBilling> {

    public ListerBilling lookbill(String account);
}
