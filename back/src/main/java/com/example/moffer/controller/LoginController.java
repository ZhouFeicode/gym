package com.example.moffer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.moffer.common.Result;
import com.example.moffer.entity.Admin;
import com.example.moffer.service.EmployeeService;
import com.example.moffer.service.EquipmentService;
import com.example.moffer.service.MemberService;
import com.example.moffer.service.AdminService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.moffer.common.Result.Success;
import static com.example.moffer.common.Result.Error;

@RequestMapping
@RestController
public class LoginController {
    @Resource
    private AdminService offerService;
    @Resource
    private MemberService memberService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private EquipmentService equipmentService;
    @GetMapping("/login")
    public Result login( HttpSession s,@RequestParam String name,@RequestParam String password){
        QueryWrapper w=new QueryWrapper();
        w.eq("admin_account",name);
        w.eq("admin_password",password);
        Admin admin=offerService.getOne(w);
        if(admin!=null) {putDataInSession(s,admin);return Success(admin);}
        else return Error();
    }

private void putDataInSession(HttpSession s,Admin admin){
        s.setAttribute("ADMIN",admin);
        s.setAttribute("member_total",memberService.count());
    s.setAttribute("employee_total",employeeService.count());
    s.setAttribute("equipment_total",equipmentService.count());
    s.setAttribute("people_total",memberService.count()+ employeeService.count());
}
@GetMapping("/main")
    public  Result Session( HttpSession s){
       Map<String,Object> map=new HashMap<>();
       map.put("member_total",s.getAttribute("member_total"));
    map.put("employee_total",s.getAttribute("employee_total"));
    map.put("equipment_total",s.getAttribute("equipment_total"));
    map.put("people_total",s.getAttribute("people_total"));
    return Success(map);

}
@GetMapping("/status")
    public  Result Status(HttpSession s){
        Object a=s.getAttribute("ADMIN");
if(a!=null)
        return Success(s.getAttribute("ADMIN"));
return Error();
}
@GetMapping("/logout")
    public Result logout(HttpSession s){
        s.removeAttribute("ADMIN");
    s.removeAttribute("employee_total");
    s.removeAttribute("equipment_total");
    s.removeAttribute("member_total");
    s.removeAttribute("people_total");
        return Success(null);
}
}
