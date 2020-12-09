package com.example.demo.service.impl;

import com.example.demo.entity.AdminsTable;
import com.example.demo.mapper.AdminsTableMapper;
import com.example.demo.service.AdminsTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@Service
public class AdminsTableServiceImpl extends ServiceImpl<AdminsTableMapper, AdminsTable> implements AdminsTableService {

    @Autowired
    AdminsTableMapper adminsTableMapper;

    @Override
    public int insertAdmin(AdminsTable adminsTable) {
        return adminsTableMapper.insertAdmin(adminsTable);
    }

    @Override
    public AdminsTable adminList() { return adminsTableMapper.adminList(); }

    @Override
    public int modifyadmin(AdminsTable adminsTable) { return adminsTableMapper.modifyadmin(adminsTable); }
}
