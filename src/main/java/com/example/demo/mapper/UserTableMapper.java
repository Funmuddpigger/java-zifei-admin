package com.example.demo.mapper;

import com.example.demo.entity.UserTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mine
 * @since 2020-10-09
 */
public interface UserTableMapper extends BaseMapper<UserTable> {
    //login in
    public UserTable loginbyaccount(String  account);
    //register in
    public int registerin(UserTable registeruser);
    //ip
    public String getIpbyaccount(String account);

    public int modify(UserTable modifyuser);

}
