package com.example.moffer.service.Impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.moffer.entity.Course;
import com.example.moffer.mapper.CourseMapper;
import com.example.moffer.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
