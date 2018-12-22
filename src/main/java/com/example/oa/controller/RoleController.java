package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.po.Role;
import com.example.oa.po.RoleMenuKey;
import com.example.oa.service.RoleMenuService;
import com.example.oa.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;

    @Resource
    RoleMenuService roleMenuService;

    /**
     * 查询全部的角色列表
     *
     * @return
     */
    @RequestMapping("/queryRoleList")
    @ResponseBody
    public String queryRoleList() {
        return JSON.toJSONString(roleService.queryRoleList());
    }

    /**
     * 分页查询角色列表
     *
     * @param page
     * @param rows
     * @param name
     * @return
     */
    @RequestMapping("/queryRolePage")
    @ResponseBody
    public String queryRolePage(Integer page, Integer rows, String name) {
        List<Role> list = roleService.queryRolePage((page - 1) * rows, rows, name);
        Map<String, Object> map = new HashMap();
        map.put("total", roleService.countRole(name));
        map.put("rows", list);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    /**
     * 验证角色名是否重复
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryRoleByName")
    public Boolean queryUserByLoginname(String name) {
        Role role = roleService.queryRoleByName(name);
        return role == null ? true : false;
    }

    /**
     * 更新角色状态（启用/禁用）
     *
     * @param state
     * @param id
     * @return
     */
    @RequestMapping("/updateRoleState/{state}/{id}")
    public String updateRoleState(@PathVariable Integer state, @PathVariable Integer id) {
        roleService.updateRoleState(state, id);
        return "/system/role/list";
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(Role role) {
        // 添加角色
        roleService.addRole(role);
        // 拿到新增角色的ID
        Integer roleid = roleService.getMaxId();
        // 拿到角色的权限
        String[] ids = role.getNodes().split(",");
        // 循环添加角色权限
        for (String id : ids) {
            RoleMenuKey roleMenuKey = new RoleMenuKey(roleid,Integer.valueOf(id));
            roleMenuService.insert(roleMenuKey);
        }
        return "true";
    }

    /**
     * 更新角色
     *
     * @param role
     * @param id
     * @return
     */
    @RequestMapping("/updateRole/{id}")
    @ResponseBody
    public String updateRole(Role role, @PathVariable Integer id) {
        // 更新角色基本信息
        role.setId(id);
        roleService.updateRole(role);
        // 更新角色菜单表
        // 删除角色原有的权限
        roleMenuService.deleteByRoleId(id);
        // 拿到角色现有的权限
        String [] ids = role.getNodes().split(",");
        // 循环添加角色权限
        for (String menuid : ids) {
            RoleMenuKey roleMenuKey = new RoleMenuKey(role.getId(),Integer.valueOf(menuid));
            roleMenuService.insert(roleMenuKey);
        }
        return "true";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return "/system/role/list";
    }

    /**
     * 根据角色ID查询角色信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryRoleInfoByRoleId")
    public String queryRoleInfoByRoleId(Integer id) {
        return JSON.toJSONString(roleService.queryRoleInfoByRoleId(id));
    }
}
