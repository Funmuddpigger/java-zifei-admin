package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.ServiceTable;
import com.example.demo.entity.UserTable;
import com.example.demo.service.ServiceTableService;
import com.example.demo.service.UserTableService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/service-table")
public class ServiceTableController {

    @Autowired
    UserTableService userTableService;
    @Autowired
    ServiceTableService serviceTableService;

    @RequestMapping(value = "/select/getMonthBill",method = RequestMethod.POST)
    public Result getMonthBill(@RequestBody JSONObject jsonparam){
        QueryWrapper<ServiceTable> monthWrapper = new QueryWrapper<>();
        String json = jsonparam.toJSONString();
        //String字符串转换为Json数组
        JSONObject jsonObject = JSONObject.parseObject(json);
        String year = jsonObject.getString("year");
        String month = jsonObject.getString("month");
        monthWrapper.eq("year",year);
        monthWrapper.eq("month",month);
        return Result.success(serviceTableService.listMaps(monthWrapper));
    }
}
