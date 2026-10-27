package com.example.moffer.service.Impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.moffer.entity.Employee;
import com.example.moffer.mapper.EmployeeMapper;
import com.example.moffer.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
