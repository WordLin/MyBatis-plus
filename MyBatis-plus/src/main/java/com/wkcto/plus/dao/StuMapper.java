package com.wkcto.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wkcto.entity.Stu;

import java.util.List;

public interface StuMapper extends BaseMapper<Stu> {
    public int insertStu(Stu stu);
    public Stu selectStuById(Integer id);
    public List<Stu> selectStuByName(String name);
}
