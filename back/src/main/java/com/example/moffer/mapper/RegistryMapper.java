package com.example.moffer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.moffer.entity.Registry;
import org.apache.ibatis.annotations.Param;

public interface RegistryMapper extends BaseMapper<Registry> {
    boolean updateCourseTotal(@Param("courseId") int courseId, @Param("add") boolean add);
}
