package com.example.demo.service;

import com.example.demo.entity.UserTable;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mine
 * @since 2020-10-09
 */
public interface UserTableService extends IService<UserTable> {
    //login in service
    UserTable loginbyaccount(String account,String ip);
    //register in service
    int registerin(UserTable registeruser);
    //ip
    String getIpbyaccount(String account);

    int modify(UserTable modifyuser);
}
