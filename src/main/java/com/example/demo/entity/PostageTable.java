package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PostageTable {

    @TableId("postage_name")
    private String postageName;

    private String monthlyRent;

    private String hourlyRent;

    private String postageDescription;

}
