package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UserHistory;
import com.example.demo.entity.UserTable;
import com.example.demo.service.UserHistoryService;
import com.example.demo.service.UserTableService;
import com.example.demo.utils.GetMacAddress;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-10-09
 */
//@Controller
@RestController
@RequestMapping(value = "/user",produces = "application/json;utf-8")
public class UserTableController {

    @Autowired
    UserTableService userTableService;
    @Autowired
    UserHistoryService userHistoryService;

    @RequestMapping(value = "/getuser/getone",method = RequestMethod.POST)
    public Result getOneUser(@RequestBody JSONObject jsonParam){
        String json = jsonParam.toJSONString();

        JSONObject jsonObject = JSONObject.parseObject(json);
        String account = jsonObject.getString("account");
        QueryWrapper<UserTable> userwapper = new QueryWrapper<>();
        userwapper.eq("user_account",account);

        Result getuserOne = Result.success( userTableService.getOne(userwapper));
        return getuserOne;
    }
    //登录
    @Async
    @RequestMapping(value = "/getuser/loginin",method = {RequestMethod.GET,RequestMethod.POST})
    public Result loginin(@RequestBody JSONObject jsonparam,HttpServletRequest request){
        GetMacAddress remoterequest = new GetMacAddress();
        String ipAddress = remoterequest.getIpAddress(request);

        String account = jsonparam.getString("account");
        String password = jsonparam.getString("password");

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        //System.out.println(account+"======="+password);
        UserTable loginuser = userTableService.loginbyaccount(account, ipAddress);
        if(loginuser!= null){
            if(loginuser.getUserPassword().equals(md5Password)){
                return Result.success(loginuser);
            }else{
                return Result.authorizationfail("password worse");
            }
        }else{
            return Result.authorizationfail("no this account");
        }
    }
    //获取所有用户
    @RequestMapping(value = "/getuser/getalluser",method = {RequestMethod.GET,RequestMethod.POST})
    public Result getuser(){
        List<UserTable> userTables = userTableService.list();
        return Result.success(userTables);
    }
    //注册
    @RequestMapping(value = "/insertuser/registerin",method = {RequestMethod.GET,RequestMethod.POST})
    public Result registerin(@RequestBody JSONObject jsonparam) {
        String account = jsonparam.getString("account");
        String password = jsonparam.getString("password");
        String phone = jsonparam.getString("phone");
        String email = jsonparam.getString("email");
        UserTable registeruser = new UserTable();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        registeruser.setUserAccount(account);
        registeruser.setUserPassword(md5Password);
        registeruser.setUserPhone(phone);
        registeruser.setUserEmail(email);
        System.out.println(account + "==========" + password + "===========" + email);
        if (userTableService.registerin(registeruser) >= 1) {
            return Result.success("success", null);
        } else {
            return Result.certificationfail("注册失败");
        }

    }

}
