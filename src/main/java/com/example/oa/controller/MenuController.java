package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.common.Children;
import com.example.oa.po.Menu;
import com.example.oa.po.User;
import com.example.oa.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    MenuService menuService;
    private List<Menu> ls; // 所有顶级权限

    @ResponseBody
    @RequestMapping("/getMenu")
    public String getMenu(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 得到用户的所有权限
        ls = menuService.queryMenuByRoleIdAndPid(user.getRoleid(),0);
        // 定义一个集合装该用户的父节点
        List<Menu> parent = new ArrayList<Menu>();
        // 得到父节点
        for (Menu menu : ls) {
            // 如果是顶级菜单并且可用
            if (menu.getPid() == 0 && menu.getState() == 1) {
                parent.add(menu);
            }
        }
        // 定义一个集合装某个父节点下面的子节点
//        List<Children> la = new ArrayList<Children>();
//        for (Menu menu : parent) {
//            // 定义一个空集合
//            List<Children> lb = new ArrayList<Children>();
//            // 将Menu对象转换为Children
//            Children children = new Children(menu.getId(), menu.getName(), menu.getUrl(), menu.getState(), lb);
//            la.add(children);
//            // 调用方法：
//            gettextd(menu, la, children, lb, user.getRoleid());
//        }
        Menu menu  = new Menu ();
        menu.setId(0);
        Children children = new Children( );
        children.setChildren( new ArrayList<Children>());
        gettextd(menu, null, children, children.getChildren(), user.getRoleid());
        String JSONString = JSON.toJSONString(children.getChildren());
        return JSONString;
    }

    public void gettextd(Menu menu, List<Children> la, Children children, List<Children> lb, Integer roleid) {
        // 得到该父节点下所有的子节点的权限：
        List<Menu> lia = menuService.queryMenuByRoleIdAndPid(roleid, menu.getId());
        if (lia != null) {
            for (Menu menus : lia) {
                List<Children> lc = new ArrayList<Children>();
                Children cb = new Children(menus.getId(), menus.getName(), menus.getUrl(), menus.getState());
                lb.add(cb);
                cb.setChildren(lc);
                // 调用方法：
                gettextd(menus, lb, cb, lc, roleid);
            }
        }
    }
}
