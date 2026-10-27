package com.example.moffer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.moffer.common.Result;
import com.example.moffer.entity.Course;
import com.example.moffer.entity.Member;
import com.example.moffer.entity.Registry;
import com.example.moffer.service.CourseService;
import com.example.moffer.service.MemberService;
import com.example.moffer.service.RegistryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.moffer.common.Result.Success;
import static com.example.moffer.common.Result.Error;

@RestController
@RequestMapping
public class RegistryController {
@Resource
    private CourseService courseService;
@Resource
    private MemberService memberService;
@Resource
    private RegistryService registryService;
@GetMapping("/reg")
public Result list(){
return Success(registryService.list());
}
@GetMapping("/regCourse")
    public Result getCourse(@RequestParam int id){
    QueryWrapper<Course> w=new QueryWrapper<>();
    w.eq("course_id",id);
    Course c=courseService.getOne(w);
    if(c!=null&&c.getId()>0) return Success(c);
    return Error();
}
    @GetMapping("/regMember")
    public Result getMember(@RequestParam int id){
        QueryWrapper<Member> w=new QueryWrapper<>();
        w.eq("member_account",id);
Member m=memberService.getOne(w);
if(m!=null&&m.getId()>0) return  Success(m);
return Error();
    }
    //查询要注意返回对象为null时候，判断非null
    @GetMapping("/regOne")
    public Result getReg(@RequestParam int id){
        Registry r=registryService.getById(id);
        if(r!=null&&r.getId()>0) return  Success(r);
        return Error();
    }
    @PostMapping("/reg")
    public Result save(@RequestBody Registry r){

QueryWrapper<Registry> w=new QueryWrapper<>();
w.eq("course_id",r.getCourseId()).eq("member_id",r.getMemberId());
 Registry o=registryService.getOne(w);
        if(o==null&&registryService.saveReg(r)) return  Success(null);
        return Error();
    }
    @PutMapping("/reg")
    public Result update(@RequestBody Registry r){
        QueryWrapper<Registry> w=new QueryWrapper<>();
        w.eq("course_id",r.getCourseId()).eq("member_id",r.getMemberId());
        Registry o=registryService.getOne(w);
        if((o==null||o.getId()==r.getId())&&registryService.updateReg(r)) return  Success(null);
        return Error();
    }
    @DeleteMapping("/reg")
    public Result delete(@RequestParam List<Long> ids){

        if(registryService.deleteReg(ids)) return  Success(null);
        return Error();
    }
    @GetMapping("/regCList")
    public Result listC(){
    QueryWrapper<Course> w=new QueryWrapper<>();
    w.eq("course_status","active");
    return Success(courseService.list(w));

    }

}
