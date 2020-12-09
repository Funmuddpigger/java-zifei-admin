package com.example.demo;

import com.example.demo.entity.UserTable;
import com.example.demo.service.UserTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserTableService userTableService;

    @Test
    void contextLoads() {
    }
    @Test
    void login(){
       // UserTable loginbyaccount = userTableService.loginbyaccount("1840217149");
       // System.out.println(loginbyaccount);
    }
}
