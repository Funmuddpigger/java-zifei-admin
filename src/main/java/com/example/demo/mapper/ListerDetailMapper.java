package com.example.demo.mapper;

import com.example.demo.entity.AdminsTable;
import com.example.demo.entity.ListerDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-10-29
 */
public interface ListerDetailMapper extends BaseMapper<ListerDetail> {

    public ListerDetail detail(String account);
}
