package com.example.moffer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.moffer.common.Result;
import com.example.moffer.entity.Employee;
import com.example.moffer.entity.Member;
import com.example.moffer.mapper.EmployeeMapper;
import com.example.moffer.service.EmployeeService;
import com.sun.net.httpserver.Authenticator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.moffer.common.Result.Success;
import static com.example.moffer.common.Result.Error;

@RequestMapping
@RestController
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @GetMapping("/employee/list")
    public Result list(){
       return Success(employeeService.list());
    }
@PostMapping("/employee")
    public  Result save(HttpSession s, @RequestBody Employee data){
    Long t= (Long) s.getAttribute("employee_total");
    Long p= (Long) s.getAttribute("people_total");
    QueryWrapper<Employee> w=new QueryWrapper<>();
    w.eq("employee_name",data.getEmployeeName()).eq("employee_phone",data.getEmployeePhone());
    Employee e=employeeService.getOne(w);
    if(e==null&&employeeService.save(data)){s.setAttribute("employee_total",t+1);s.setAttribute("people_total",p+1); return  Success(null);}
    return Error();

}
    @PutMapping("/employee")
    public  Result update(@RequestBody Employee data){
        QueryWrapper<Employee> w=new QueryWrapper<>();
        w.eq("employee_name",data.getEmployeeName()).eq("employee_phone",data.getEmployeePhone());
        Employee e=employeeService.getOne(w);
        if((e==null||e.getId()==data.getId())&&employeeService.updateById(data))return Success(null);
        else return Error();
    }
    @DeleteMapping("/employee")
    public  Result remove(HttpSession s,@RequestParam List<Long> data){
        Long t= (Long) s.getAttribute("employee_total");
        Long p= (Long) s.getAttribute("people_total");
        if(employeeService.removeByIds(data)) {s.setAttribute("employee_total",t-data.size());s.setAttribute("people_total",p-data.size());return Success(null);}
        else return Error();
    }

}
