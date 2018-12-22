package com.example.oa.controller;

import com.alibaba.fastjson.JSON;
import com.example.oa.common.Children;
import com.example.oa.po.Menu;
import com.example.oa.po.User;
import com.example.oa.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 左侧菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMenu/{roleid}")
    public String getMenu(@PathVariable Integer roleid) {
        Menu menu  = new Menu ();
        menu.setId(0);
        Children children = new Children( );
        children.setChildren( new ArrayList<Children>());
        gettextd(menu,  children, children.getChildren(), roleid);
        String JSONString = JSON.toJSONString(children.getChildren());
        return JSONString;
    }

    @ResponseBody
    @RequestMapping("/getCheckMenuByRoleid")
    public String getCheckMenuByRoleid(Integer roleid){
        List<Integer> list = menuService.getCheckMenuByRoleid(roleid);
       String JSONString =  JSON.toJSONString(list);
        return JSONString;
    }
    /**
     * 遍历所有的菜单
     * @param menu
     * @param children
     * @param lb
     * @param roleid
     */
    public void gettextd(Menu menu,  Children children, List<Children> lb, Integer roleid) {
        // 得到某个父类菜单下所有的子菜单
        List<Menu> lia = menuService.queryMenuByRoleIdAndPid(roleid, menu.getId());
        // 如果有子菜单
        if (lia != null) {
            // 循环子菜单
            for (Menu menus : lia) {
                // 创建一个新的集合，用于存放下一级菜单（如果有下一级）
                List<Children> lc = new ArrayList<Children>();
                // 创建一个菜单
                Children cb = new Children(menus.getId(), menus.getName(), menus.getUrl(), menus.getState(),lc);
                // 将该菜单放入树中
                lb.add(cb);
                // 如果有下一级，递归
                gettextd(menus, cb, lc, roleid);
            }
        }
    }
}
