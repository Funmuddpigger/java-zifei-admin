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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-10-09
 */

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
        UserTable one = userTableService.getOne(userwapper);
        Map<String,Object> maps = new HashMap<>();
        String[] arr = { one.getPow1(),one.getPow2(),one.getPow3(),one.getPow4(),one.getPow5()};
        maps.put("pow",arr);
        maps.put("user",one);
        Result getuserOne = Result.success(maps);
        return getuserOne;
    }
    //login
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

    //修改个人信息
    @RequestMapping(value = "/modifyuser", method = {RequestMethod.GET,RequestMethod.POST})
    public Result modifyuser(@RequestBody JSONObject jsonparam) {
        String json = jsonparam.toJSONString();

        JSONObject jsonObject = JSONObject.parseObject(json);
        String account = jsonObject.getString("account");
        String password = jsonObject.getString("password");
        String realname = jsonObject.getString("realname");
        String phone = jsonObject.getString("phone");
        String email = jsonObject.getString("email");
        String pay = jsonObject.getString("pay");
        UserTable modifyuser = new UserTable();
        modifyuser.setUserAccount(account);
        modifyuser.setUserPassword(password);
        modifyuser.setUserRealname(realname);
        modifyuser.setUserPhone(phone);
        modifyuser.setUserEmail(email);
        modifyuser.setUserPay(pay);
        //System.out.println(account + "==========" + password + "===========" + email);
        if (userTableService.modify(modifyuser) >= 1) {
            return Result.success("success", null);
        } else {
            return Result.certificationfail("修改失败");
        }
    }

}
