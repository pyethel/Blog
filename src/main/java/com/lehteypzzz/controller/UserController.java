package com.lehteypzzz.controller;


import com.lehteypzzz.common.lang.Result;
import com.lehteypzzz.entity.User;
import com.lehteypzzz.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lehteypzzz
 * @since 2020-08-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @RequiresAuthentication
//    @GetMapping("/index")
//    public Result index(){
//        User user = userService.getById(1L);
//        return Result.succ(200,"操作成功",user);
//    }
//
//    @PostMapping("/save")
//    public Result save(@Validated @RequestBody User user){
//        return Result.succ(user);
//    }
}
