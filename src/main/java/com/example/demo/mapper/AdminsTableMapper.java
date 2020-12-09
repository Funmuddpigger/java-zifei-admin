package com.example.demo.mapper;

import com.example.demo.entity.AdminsTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
public interface AdminsTableMapper extends BaseMapper<AdminsTable> {

    public int insertAdmin(AdminsTable adminsTable);

    public AdminsTable adminList();

    public  int modifyadmin(AdminsTable adminsTable);
}
