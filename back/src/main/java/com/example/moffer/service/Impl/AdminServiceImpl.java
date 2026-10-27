package com.example.moffer.service.Impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.moffer.entity.Admin;
import com.example.moffer.mapper.OfferMapper;
import com.example.moffer.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<OfferMapper,Admin> implements AdminService {
}
