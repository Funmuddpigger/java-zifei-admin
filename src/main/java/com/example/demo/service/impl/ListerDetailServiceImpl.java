package com.example.demo.service.impl;

import com.example.demo.entity.ListerDetail;
import com.example.demo.mapper.ListerDetailMapper;
import com.example.demo.service.ListerDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-29
 */
@Service
public class ListerDetailServiceImpl extends ServiceImpl<ListerDetailMapper, ListerDetail> implements ListerDetailService {

    @Autowired
    ListerDetailMapper listerDetailMapper;

    @Override
    public ListerDetail detail(String account) { return listerDetailMapper.detail(account); }
}
