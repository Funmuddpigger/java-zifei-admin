package com.example.demo.service.impl;

import com.example.demo.entity.UserHistory;
import com.example.demo.mapper.UserHistoryMapper;
import com.example.demo.service.UserHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-11-05
 */
@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory> implements UserHistoryService {

    @Autowired
    UserHistoryMapper userHistoryMapper;

    @Override
    public UserHistory getIpCount(String account,String ip) {
        return userHistoryMapper.getIpCount(account,ip);
    }
}
