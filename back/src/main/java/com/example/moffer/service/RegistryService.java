package com.example.moffer.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.example.moffer.entity.Registry;

import java.util.List;

public interface RegistryService extends IService<Registry> {
    boolean updateCourseTotal(int courseId,boolean add);

    boolean saveReg(Registry r);//mapper层面向数据库，创建执行sql语句的方法。service层封装这些方法，serviceImpl实现方法，开放接口供controller使用。
    boolean deleteReg(List<Long> ids);
    boolean updateReg(Registry r);
}
