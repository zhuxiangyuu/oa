package com.example.oa.service.Impl;

import com.example.oa.mapper.CachetMapper;
import com.example.oa.service.CachetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CachetServiceImpl implements CachetService {
    @Resource
    CachetMapper cachetmapper;

}
