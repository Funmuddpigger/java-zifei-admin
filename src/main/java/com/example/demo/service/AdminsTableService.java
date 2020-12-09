package com.example.demo.service;

import com.example.demo.entity.AdminsTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
public interface AdminsTableService extends IService<AdminsTable> {

    public int insertAdmin(AdminsTable adminsTable);

    public AdminsTable adminList();

    public int modifyadmin(AdminsTable adminsTable);

}
