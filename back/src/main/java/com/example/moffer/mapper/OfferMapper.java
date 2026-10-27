package com.example.moffer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.moffer.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;


@Mapper
public interface OfferMapper extends BaseMapper<Admin>{
}
