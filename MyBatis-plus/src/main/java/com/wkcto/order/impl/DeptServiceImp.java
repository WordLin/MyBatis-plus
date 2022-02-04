package com.wkcto.order.impl;

import com.wkcto.order.entity.Dept;
import com.wkcto.order.mapper.DeptMapper;
import com.wkcto.order.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WordLin
 * @since 2022-02-04
 */
@Service
public class DeptServiceImp extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
