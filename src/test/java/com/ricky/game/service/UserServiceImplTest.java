package com.ricky.game.service;
import com.ricky.game.domain.sys.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private RankingService rankingService;

    @Test
    void login(){
        SysUser ans = userService.login(1003L,"123456");
        System.out.println(ans);

    }
    @Test
    void update(){
        SysUser sysUser=new SysUser();
        sysUser.setUserId(1003L);
        sysUser.setUserName("test1");
        sysUser.setUserPassword("123456");
        sysUser.setUserEmail("234");
        sysUser.setUserInfo("124");
        sysUser.setCreateTime(new Date());
        sysUser.setMoney(100L);
        sysUser.setGrade(1L);
//        sysUser.setCreateTime(new Date());
        userService.updateInfo(sysUser);
    }
    @Test
    void insert(){
        SysUser sysUser=new SysUser();
        sysUser.setUserId(1003L);
        sysUser.setUserName("test5");
        sysUser.setUserPassword("123456");
        sysUser.setUserEmail("234");
        sysUser.setUserInfo("admin");
        sysUser.setCreateTime(new Date());
        sysUser.setMoney(0L);
        sysUser.setGrade(1L);
        userService.register(sysUser);

    }
    @Test
    void updateMoney(){
        userService.updateMoney(1003L,100L);
    }

    @Test
    void updateGrade(){
        userService.updateGrade(1003L);
    }



}