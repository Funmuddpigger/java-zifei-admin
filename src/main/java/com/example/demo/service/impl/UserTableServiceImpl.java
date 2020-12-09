package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.demo.entity.ServiceTable;
import com.example.demo.entity.UserHistory;
import com.example.demo.entity.UserTable;
import com.example.demo.mapper.UserHistoryMapper;
import com.example.demo.mapper.UserTableMapper;
import com.example.demo.service.UserHistoryService;
import com.example.demo.service.UserTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.utils.GetMacAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-09
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable> implements UserTableService {

    @Autowired
    UserTableMapper userTableMapper;
    @Autowired
    UserHistoryMapper userHistoryMapper;

    @Override
    public UserTable loginbyaccount(String account,String ip) {
        String userThisip = null;
        UserHistory userHistory = new UserHistory();
        UserTable user = new UserTable();
        userHistory.setUserAccount(account);
        userHistory.setUserThisip(ip);
        userHistoryMapper.insert(userHistory);

        QueryWrapper<UserHistory> userHWrapper = new QueryWrapper<>();
        QueryWrapper<UserTable> userWrapper = new QueryWrapper<>();
        userHWrapper.eq("user_account",account);
        userWrapper.eq("user_account",account);

        user.setUserIpok("true");
        userTableMapper.update(user,userWrapper);

        List<UserHistory> userHistories = userHistoryMapper.selectList(userHWrapper);
        //判断
        UserHistory ipCount = userHistoryMapper.getIpCount(account,ip);
        if(ipCount != null){
            userThisip = ipCount.getUserThisip();
            //System.out.println(userThisip);
            //插入ip到常用ip
            user.setUserAlwaysip(userThisip);
            userTableMapper.update(user,userWrapper);
        }else{
            String userAlwaysip = userTableMapper.selectOne(userWrapper).getUserAlwaysip();
            if(userAlwaysip != null && userAlwaysip.length() != 0){
                if( !ip.equals(userAlwaysip)){
                    user.setUserIpok("false");
                    userTableMapper.update(user,userWrapper);
                    return userTableMapper.loginbyaccount(account);
                }

            }
        }
        return userTableMapper.loginbyaccount(account);
    }

    @Override
    public int registerin(UserTable registeruser) {
        return userTableMapper.registerin(registeruser);
    }

    @Override
    public String getIpbyaccount(String account) {
        return userTableMapper.getIpbyaccount(account);
    }

    @Override
    public int modify(UserTable modifyuser) { return userTableMapper.modify(modifyuser); }


}
