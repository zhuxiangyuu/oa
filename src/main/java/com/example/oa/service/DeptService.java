package com.example.oa.service;

import com.example.oa.po.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> queryDeptByOrgId(Integer orgId);
}
