package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ListerBilling;
import com.example.demo.service.ListerBillingService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
@RestController
@RequestMapping("/lister-billing")
public class ListerBillingController {

    @Autowired
    ListerBillingService listerBillingService;

    //查看账单
    @RequestMapping(value = "/lookbill",method = {RequestMethod.GET,RequestMethod.POST})
    public Result lookbill(@RequestBody JSONObject jsonparam){
        String account = jsonparam.getString("account");
        ListerBilling listerBilling = listerBillingService.lookbill(account);
        return Result.success(listerBilling);
    }
}
