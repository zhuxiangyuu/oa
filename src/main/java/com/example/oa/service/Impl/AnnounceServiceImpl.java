package com.example.oa.service.Impl;

import com.example.oa.mapper.AnnounceMapper;
import com.example.oa.po.Announce;
import com.example.oa.service.AnnounceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Resource
    AnnounceMapper announceMapper;
    public List<Announce> queryAnnounceList() {
        return announceMapper.queryAnnounceList();
    }
}
