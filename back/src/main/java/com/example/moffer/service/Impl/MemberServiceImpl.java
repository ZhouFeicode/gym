package com.example.moffer.service.Impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.moffer.entity.Member;
import com.example.moffer.mapper.MemberMapper;
import com.example.moffer.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
}
