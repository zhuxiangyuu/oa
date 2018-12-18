package com.example.oa.service.Impl;

import com.example.oa.mapper.DeptMapper;
import com.example.oa.po.Dept;
import com.example.oa.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    DeptMapper deptMapper;
    @Override
    public List<Dept> queryDeptByOrgId(Integer orgId) {
        return deptMapper.queryDeptByOrgId(orgId);
    }

    @Override
    public Dept queryDeptByUserId(Integer userId) {
        return deptMapper.queryDeptByUserId(userId);
    }
}
