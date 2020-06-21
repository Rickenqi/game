package com.ricky.game.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ricky.game.domain.LoginUser;
import com.ricky.game.domain.sys.SysUser;
import com.ricky.game.service.UserService;
import com.ricky.game.utils.result.Result;
import com.ricky.game.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    UserService userService;

    private Gson GSON = new GsonBuilder().create();

    @PostMapping("/toLogin")
    String userLogin(@RequestBody LoginUser user) {
        SysUser permit = userService.login(user.getUserId(), user.getUserPassword());
        Result result;
        if (permit != null) {
            result = Result.success(permit);
        } else {
            result = Result.failure(ResultCode.USER_LOGIN_ERROR,user);
        }
        return GSON.toJson(result);
    }

    @PostMapping("/users/register")
    String postUserInfo(@RequestBody SysUser user) {
        Result result;
        try {
            userService.register(user);
            result = Result.success(user);
            return GSON.toJson(result);
        } catch (DataAccessException e) {
            result = Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
            return GSON.toJson(result);
        }
    }

    @PutMapping("/users/{id}")
    String putUserInfo(@PathVariable("id") String id, @RequestBody SysUser user) {
        Result result;
        try {
            userService.updateInfo(user);
            result = Result.success(user);
            return GSON.toJson(result);
        } catch (DataAccessException e) {
            result = Result.failure(ResultCode.DATA_IS_WRONG);
            return GSON.toJson(result);
        }
    }

//    @GetMapping("/users/{id}")
//    String getUserInfo(@PathVariable("id") String id) {
//        Result result;
//        try {
//
//        }
//    }
}
