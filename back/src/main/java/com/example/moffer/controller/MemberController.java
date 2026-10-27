package com.example.moffer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.moffer.common.Result;
import com.example.moffer.entity.Course;
import com.example.moffer.entity.Member;
import com.example.moffer.service.CourseService;
import com.example.moffer.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.moffer.common.Result.Success;

import static com.example.moffer.common.Result.Error;

@RequestMapping
@RestController
public class MemberController {
    @Resource
    private MemberService memberService;
    @Resource
    private CourseService courseService;
    @GetMapping("/member")
    public Result list(){
        List<Member> m=memberService.list();
        if(!m.isEmpty())
        return Success(m);
        return Error();
    }
    @GetMapping("/memberOne")
    public Result get(@RequestParam int id){
        Member m=memberService.getById(id);
        if(m!=null&&m.getId()>0)
            return Success(m);
        return Error();
    }
@PostMapping("/member")
    public  Result save(HttpSession s, @RequestBody Member m){
    Long t= (Long) s.getAttribute("member_total");
    Long p= (Long) s.getAttribute("people_total");
    QueryWrapper<Member> w=new QueryWrapper<>();
    w.eq("member_name",m.getMemberName()).eq("member_phone",m.getMemberPhone());
    Member member=memberService.getOne(w);
        if(member==null&&memberService.save(m)){s.setAttribute("member_total",t+1);s.setAttribute("people_total",p+1); return  Success(null);}
        return Error();

}
    @PutMapping("/member")
    public  Result update(@RequestBody Member m){
        QueryWrapper<Member> w=new QueryWrapper<>();
        w.eq("member_name",m.getMemberName()).eq("member_phone",m.getMemberPhone());
        Member member=memberService.getOne(w);
        if((member==null||member.getId()==m.getId())&&memberService.updateById(m)) return  Success(null);
        return Error();
    }
@DeleteMapping("/member")
    public Result delete(HttpSession s,@RequestParam List<Long> ids){
    Long t= (Long) s.getAttribute("member_total");
    Long p= (Long) s.getAttribute("people_total");
        if(memberService.removeByIds(ids)) {s.setAttribute("member_total",t- ids.size());s.setAttribute("people_total",p-ids.size());return Success(null);}
        else return Error();
}

@GetMapping("/memberSearch")
public Result search(@RequestParam int cardId){
    QueryWrapper<Member> w=new QueryWrapper<>();
    w.like("member_account",cardId);
   List <Member> m=memberService.list(w);
        return Success(m);
}

}
