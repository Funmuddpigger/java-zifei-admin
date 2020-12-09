package com.example.demo.service.impl;

import com.example.demo.entity.ServiceTable;
import com.example.demo.mapper.ServiceTableMapper;
import com.example.demo.service.ServiceTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@Service
public class ServiceTableServiceImpl extends ServiceImpl<ServiceTableMapper, ServiceTable> implements ServiceTableService {

}
