package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ListerBilling;
import com.example.demo.entity.ListerDetail;
import com.example.demo.service.ListerDetailService;
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
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/lister-detail")
public class ListerDetailController {

    @Autowired
    ListerDetailService listerDetailService;

    @RequestMapping(value = "/detail", method = {RequestMethod.GET,RequestMethod.POST})
    public Result detail(@RequestBody JSONObject jsonparam){
        String account = jsonparam.getString("account");
        ListerDetail detail = listerDetailService.detail(account);
        return Result.success(detail);
    }
}
