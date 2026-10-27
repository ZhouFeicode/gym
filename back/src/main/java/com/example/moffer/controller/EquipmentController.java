package com.example.moffer.controller;

import com.example.moffer.common.Result;
import com.example.moffer.entity.Equipment;
import com.example.moffer.service.EquipmentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.moffer.common.Result.Success;

import static com.example.moffer.common.Result.Error;


@RequestMapping
@RestController
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;
    @GetMapping("/eq")
    public Result list(){
        List<Equipment> e=equipmentService.list();
        return Success(e);
    }
    @GetMapping("/eqOne")
    public Result get(@RequestParam int id){
     Equipment e=equipmentService.getById(id);
        return Success(e);
    }
@PostMapping("/eq")
public Result save(HttpSession s, @RequestBody Equipment e){
    Long t= (Long) s.getAttribute("equipment_total");
    Long p= (Long) s.getAttribute("people_total");
    if(equipmentService.save(e)){s.setAttribute("equipment_total",t+1);s.setAttribute("people_total",p+1); return  Success(null);}
    return Error();

}
@PutMapping("/eq")
public Result update(@RequestBody Equipment e){
    if(equipmentService.updateById(e))
        return Success(null);
    return Error();
}
@DeleteMapping("/eq")
public Result delete(HttpSession s,@RequestParam List<Long> ids){
    Long t= (Long) s.getAttribute("employee_total");
    Long p= (Long) s.getAttribute("people_total");
    if(equipmentService.removeByIds(ids)) {s.setAttribute("equipment_total",t-ids.size());s.setAttribute("people_total",p-ids.size());return Success(null);}
    else return Error();
}
}
