package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.PostageTable;

import java.util.List;

public interface PostageTableService extends IService<PostageTable> {
    public int addPostage(PostageTable postageTable);

    public List<PostageTable> findAllPostage();

    public int deleteAllPostage();
}
