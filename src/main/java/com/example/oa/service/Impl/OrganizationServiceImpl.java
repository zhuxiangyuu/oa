package com.example.oa.service.Impl;

import com.example.oa.mapper.AnnounceMapper;
import com.example.oa.mapper.OrganizationMapper;
import com.example.oa.po.Organization;
import com.example.oa.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    OrganizationMapper organizationMapper;
    @Override
    public List<Organization> queryOrganizationList() {
        return organizationMapper.queryOrganizationList();
    }
}
