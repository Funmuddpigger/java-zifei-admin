package com.example.demo.service;

import com.example.demo.entity.ListerDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-10-29
 */
public interface ListerDetailService extends IService<ListerDetail> {

    //查看明细单
    public ListerDetail detail(String account);
}
