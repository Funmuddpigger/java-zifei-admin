package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PostageTable;
import com.example.demo.service.PostageTableService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/postage",method = {RequestMethod.GET,RequestMethod.POST})
public class PostageTableController {
      @Autowired
      private PostageTableService postageTableService;
      PostageTable postageTable = new PostageTable();

      @RequestMapping(value = "/addPostage",method = {RequestMethod.POST})
       public Result addPostage(@RequestBody JSONObject jsonParams){
          System.out.println(jsonParams);
          String json = jsonParams.toJSONString();
          JSONObject jsonObject = JSONObject.parseObject(json);

              String  postageName  = jsonObject.getString("postageName");
              String monthlyRent   =jsonObject.getString("monthlyRent");
              String hourly_rent   =jsonObject.getString("hourlyRent");
              String postage_description=jsonObject.getString("postageDescription");
              postageTable.setPostageName(postageName);
              postageTable.setMonthlyRent(monthlyRent);
              postageTable.setHourlyRent(hourly_rent);
              postageTable.setPostageDescription(postage_description);
        //  }
          postageTableService.addPostage(postageTable);

          return Result.success("插入成功!");
      }



    @RequestMapping(value = "/updatePostage",method = {RequestMethod.POST})
    public Result updatePostage(@RequestBody JSONObject jsonParams){

        String json = jsonParams.toJSONString();
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray data = jsonObject.getJSONArray("data");
        for (int i=0;i<data.size();i++){
            JSONObject object = data.getJSONObject(i);
            String  postageName  = object.getString("postageName");
            String monthlyRent   =object.getString("monthlyRent");
            String hourly_rent   =object.getString("hourlyRent");
            String postage_description   =object.getString("postageDescription");
            postageTable.setPostageName(postageName);
            postageTable.setMonthlyRent(monthlyRent);
            postageTable.setHourlyRent(hourly_rent);
            postageTable.setPostageDescription(postage_description);

        }
        postageTableService.updateById(postageTable);

        return Result.success("更新成功!");
    }
    @RequestMapping(value = "/deletePostage",method = {RequestMethod.POST})
    public Result deletePostage(@RequestBody JSONObject jsonParams) {

        String postageName = jsonParams.getString("postageName");


        postageTableService.removeById(postageName);

       return Result.success("删除[ "+postageName+" ]成功!");


    }


    //删除所有
    @RequestMapping(value = "/delteAllPostage", method = {RequestMethod.POST})
   public Result delteAllPostage(@RequestBody JSONObject jsonParams){
       String json = jsonParams.toJSONString();
       JSONObject jsonObject = JSONObject.parseObject(json);
       String cleanAll = jsonObject.getString("clean");
       if (cleanAll.equals("clean")){
           postageTableService.deleteAllPostage();
           return Result.success("删除所有成功!");
       }else {
           System.out.println("指令输入异常!");
           return Result.serverfail("指令输入异常!");
       }
   }

    @RequestMapping("/findAllPostage")
      public Result findAllPostage(){
        List<PostageTable> allPostage = postageTableService.findAllPostage();
        return Result.success("查询成功!",allPostage);
      }


}
