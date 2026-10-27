package com.example.moffer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.moffer.common.Result;
import com.example.moffer.entity.Course;
import com.example.moffer.entity.Employee;
import com.example.moffer.entity.Member;
import com.example.moffer.entity.Registry;
import com.example.moffer.service.CourseService;
import com.example.moffer.service.EmployeeService;
import com.example.moffer.service.Impl.EmailServiceImpl;
import com.example.moffer.service.Impl.EmployeeServiceImpl;
import com.example.moffer.service.MemberService;
import com.example.moffer.service.RegistryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.moffer.common.Result.Success;
import static com.example.moffer.common.Result.Error;

@RestController
@RequestMapping
public class CourseController {
    @Resource
    private EmailServiceImpl emailService;
    @Resource
    private CourseService courseService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RegistryService registryService;
    @Resource
    private MemberService memberService;
@GetMapping("/course")
    public Result list(){
return Success(courseService.list());
}
    @GetMapping("/courseOne")
    public Result get(@RequestParam int id){
    Course c=courseService.getById(id);
    if(c.getId()>0) return Success(c);
    return Error();
    }
    @PostMapping("/course")
    public Result save(@RequestBody Course c){
if(courseService.save(c)) return  Success(null);
return Error();
    }
    @PutMapping("/course")
    public  Result update(@RequestBody Course c){
if(courseService.updateById(c)) return  Success(null);
 return Error();
    }
    @DeleteMapping("/course")
    public Result delete(@RequestParam List<Long> ids){
if(courseService.removeByIds(ids)) return Success(null);
return Error();
    }
    @GetMapping("/employee")
    public Result getName(){
   return Success(employeeService.list());

    }
    @GetMapping("employeeName")
    public Result getEmployeeName(@RequestParam int id){
    QueryWrapper<Employee> w=new QueryWrapper<>();
    w.eq("employee_account",id);
    Employee e=employeeService.getOne(w);
    if(e.getId()>0)
        return Success(e);
    return Error();

    }
    @GetMapping("/email")
    public  Result email(@RequestParam List<String> to,@RequestParam String subject,@RequestParam String text){
if(emailService.email(to, subject, text))return Success(null);
return Error();

    }
    @GetMapping("/memberIds")
    public  Result getMemberIds(@RequestParam int id){
    QueryWrapper<Registry> w=new QueryWrapper<>();
    w.eq("course_id",id).eq("type","ordered");
return Success(registryService.list(w));
    }
    @GetMapping("memberEmail")
    public  Result getMemberEmail(@RequestParam List<Long> ids){
    List<Member> l=new ArrayList<>();
 for(int i=0;i<ids.size();i++){
     QueryWrapper<Member> q=new QueryWrapper<>();
     q.eq("member_account",ids.get((i)));
     Member m=memberService.getOne(q);
     l.add(m);
 }
 return Success(l);
    }

}
