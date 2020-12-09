package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.PostageTable;

import java.util.List;

public interface PostageTableMapper extends BaseMapper<PostageTable> {
      public int addPostage(PostageTable postageTable);

      public List<PostageTable> findAllPostage();



      public int deleteAllPostage();



}
