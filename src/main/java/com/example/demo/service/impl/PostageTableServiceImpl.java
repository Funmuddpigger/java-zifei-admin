package com.example.demo.service.impl;

import com.example.demo.entity.PostageTable;
import com.example.demo.mapper.PostageTableMapper;
import com.example.demo.service.PostageTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
@Service
public class PostageTableServiceImpl extends ServiceImpl<PostageTableMapper, PostageTable> implements PostageTableService {
    @Autowired
    private PostageTableMapper postageTableMapper;

    @Override
    public int addPostage(PostageTable postageTable) {
        return postageTableMapper.addPostage(postageTable);
    }

    @Override
    public List<PostageTable> findAllPostage() {
        return postageTableMapper.findAllPostage();

    }

    @Override
    public int deleteAllPostage() {
        return postageTableMapper.deleteAllPostage();
    }



}
