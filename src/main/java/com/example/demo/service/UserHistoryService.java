package com.example.demo.service;

import com.example.demo.entity.UserHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-11-05
 */
public interface UserHistoryService extends IService<UserHistory> {
    UserHistory getIpCount(String account,String ip);
}
