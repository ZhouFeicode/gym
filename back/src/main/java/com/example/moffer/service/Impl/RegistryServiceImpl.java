package com.example.moffer.service.Impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.moffer.entity.Registry;
import com.example.moffer.mapper.RegistryMapper;
import com.example.moffer.service.CourseService;
import com.example.moffer.service.RegistryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistryServiceImpl extends ServiceImpl<RegistryMapper, Registry> implements RegistryService {
@Resource
private RegistryMapper registryMapper;
public boolean updateCourseTotal(int courseId,boolean add){
    return registryMapper.updateCourseTotal(courseId,add);
}
@Transactional
    public boolean saveReg(Registry r){
if(updateCourseTotal(r.getCourseId(),true)&&registryMapper.insert(r)>0) return true;
else return false;
}
    @Transactional
    public boolean deleteReg(List<Long> ids) {
        for (int i = 0; i < ids.size(); i++) {
            updateCourseTotal(registryMapper.selectById(ids.get(i)).getCourseId(), false) ;
            registryMapper.deleteById(ids.get(i)) ;
        }
return true;
    }
    @Transactional
    public  boolean updateReg(Registry r){
    int oldCourseId=registryMapper.selectById(r.getId()).getCourseId();
    int newCourseId=r.getCourseId();
if(newCourseId!=oldCourseId) {
    updateCourseTotal(oldCourseId, false);
    updateCourseTotal(newCourseId, true);
}

        registryMapper.updateById(r);
return true;

    }
}
