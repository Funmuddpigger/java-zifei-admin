package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.AdminsTable;
import com.example.demo.entity.UserTable;
import com.example.demo.service.AdminsTableService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/admins-table")
public class AdminsTableController {

    @Autowired
    AdminsTableService adminsTableService;

    //增加管理员
    @RequestMapping(value = "/insertadmin", method = {RequestMethod.GET,RequestMethod.POST})
    public Result insertadmin(@RequestBody JSONObject jsonparam) {
        String json = jsonparam.toJSONString();

        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.getString("adminData");
        System.out.println("前端传回的数据" + data);

        JSONArray jsonArray = JSONArray.parseArray(data);
        AdminsTable insertadmin = new AdminsTable();
        for(int i=0; i<jsonArray.size(); i++) {
            JSONObject ob = (JSONObject)jsonArray.get(i);
            System.out.println("jkndajdka" + ob);
            int account = ob.getInteger("account");
            String pass = ob.getString("pass");
            String passconfirm = ob.getString("passconfirm");
            String realname = ob.getString("realname");
            String email = ob.getString("email");
            String opendate = ob.getString("opendate");
            String phone = ob.getString("phone");
            String power = ob.getString("power");

            JSONArray pow = JSONArray.parseArray(power);
            String power1 = (String)pow.get(0);
            String power2 = (String)pow.get(1);
            String power3 = (String)pow.get(2);
            String power4 = (String)pow.get(3);
            String power5 = (String)pow.get(4);

            insertadmin.setAccount(account);
            insertadmin.setPass(pass);
            insertadmin.setPassConfirm(passconfirm);
            insertadmin.setRealname(realname);
            insertadmin.setEmail(email);
            insertadmin.setOpenDate(opendate);
            insertadmin.setPhone(phone);
            insertadmin.setPower1(power1);
            insertadmin.setPower2(power2);
            insertadmin.setPower3(power3);
            insertadmin.setPower4(power4);
            insertadmin.setPower5(power5);
            adminsTableService.insertAdmin(insertadmin);
        }
            return Result.success("success", null);

//          return Result.certificationfail("增加管理员失败");
    }

    //返回管理员列表
    @RequestMapping(value = "/adminList", method = {RequestMethod.GET,RequestMethod.POST})
    public Result adminlist() {
        List<AdminsTable> adminsTables = adminsTableService.list();
        return Result.success(adminsTables);
    }

    //修改信息单
    @RequestMapping(value = "/modifyadmin", method = {RequestMethod.POST})
    public Result modifyadmin(@RequestBody JSONObject jsonparam) {
        String json = jsonparam.toJSONString();

        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.getString("adminData");
        System.out.println("前端传回的数据" + data);

        JSONArray jsonArray = JSONArray.parseArray(data);
        AdminsTable modifyadmin = new AdminsTable();
        for(int i=0; i<jsonArray.size(); i++) {
            JSONObject ob = (JSONObject)jsonArray.get(i);

            int account = ob.getInteger("account");
            String pass = ob.getString("pass");
            String passconfirm = ob.getString("passconfirm");
            String realname = ob.getString("realname");
            String email = ob.getString("email");
            String opendate = ob.getString("opendate");
            String phone = ob.getString("phone");
            String power = ob.getString("power");

            JSONArray pow = JSONArray.parseArray(power);
            String power1 = (String)pow.get(0);
            String power2 = (String)pow.get(1);
            String power3 = (String)pow.get(2);
            String power4 = (String)pow.get(3);
            String power5 = (String)pow.get(4);

            modifyadmin.setAccount(account);
            modifyadmin.setPass(pass);
            modifyadmin.setPassConfirm(passconfirm);
            modifyadmin.setRealname(realname);
            modifyadmin.setEmail(email);
            modifyadmin.setOpenDate(opendate);
            modifyadmin.setPhone(phone);
            modifyadmin.setPower1(power1);
            modifyadmin.setPower2(power2);
            modifyadmin.setPower3(power3);
            modifyadmin.setPower4(power4);
            modifyadmin.setPower5(power5);
            adminsTableService.modifyadmin(modifyadmin);
        }
        return Result.success("success", null);
    }
}
