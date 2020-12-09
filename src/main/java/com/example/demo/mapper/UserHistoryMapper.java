package com.example.demo.mapper;

import com.example.demo.entity.UserHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-11-05
 */
public interface UserHistoryMapper extends BaseMapper<UserHistory> {
    public UserHistory getIpCount(String account,String ip);
}
