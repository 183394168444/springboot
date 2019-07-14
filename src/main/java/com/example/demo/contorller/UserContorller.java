package com.example.demo.contorller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: 李林威
 * Date: 2019/7/3
 * Time: 14:47
 * To change this template use File / Settings / File Templates.
 * Description:
 */

@Controller
public class UserContorller {
    @Autowired
    private UserService userService;

    @GetMapping("all")
    public String all(Model model) {
        List<User> users = this.userService.selectUserByName();
        model.addAttribute("users", users);
        return "users";
    }


    /**
     * @Description: 根据id 删除
     * @Author: 李林威
     * @CreateDate: 2019/7/9 14:46
     * @Version: 1.0
     */

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        userService.deleteById(id);
        ModelAndView mav = new ModelAndView("redirect:/all");
        return mav;
    }

    @RequestMapping("Add1")
    public ModelAndView Add1() {
        return new ModelAndView("add");
    }

    /**
     * @Description: 添加
     * @Author: 李林威
     * @CreateDate: 2019/7/9 17:05
     */
    @RequestMapping("AddUser")
    public ModelAndView AddUser(User user) {
        userService.add(user);
        ModelAndView mav = new ModelAndView("redirect:/all");
        return mav;
    }
}