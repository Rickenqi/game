package com.ricky.game.service.impl;

import com.ricky.game.dao.SysUserMapper;
import com.ricky.game.dao.SysUserRoleMapper;
import com.ricky.game.domain.sys.SysRanking;
import com.ricky.game.domain.sys.SysUser;
import com.ricky.game.domain.sys.SysUserRole;
import com.ricky.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private RankingServiceImpl rankingService;

    //登录，成功为true，失败为false
    public SysUser login(Long id, String password){
        SysUser sysUser = sysUserMapper.selectByUserId(id);
        System.out.println(sysUser);
        if(sysUser.getUserPassword().equals(password)){
            return sysUser;
        }else {
            return null;
        }
    }

    //注册用户 必须包含所有选项，如金钱=0和等级=1
    public void register(SysUser sysUser){
        sysUserMapper.insertSelective(sysUser);
        Long id=sysUser.getUserId();
        System.out.println(id);
        SysUserRole sysUserRole1 = new SysUserRole();
        sysUserRole1.setUserId(id);
        sysUserRole1.setRoleId(2L);
        SysRanking sysRanking = new SysRanking();
        sysRanking.setUserId(id);
        sysRanking.setUserName(sysUser.getUserName());
        sysRanking.setUserScore(0L);
        // sysUserRoleMapper.insert(sysUserRole1);
        rankingService.insertPoints(sysRanking);
        if(sysUser.getUserInfo().equals("admin")){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(id);
            sysUserRole.setRoleId(1L);
            sysUserRoleMapper.insert(sysUserRole);
        }
    }
    //更新用户信息
    public void updateInfo(SysUser sysUser){

//        String user_info = sysUser.getUserInfo();
        sysUserMapper.updateUser(sysUser);
    }

    //更新金钱，数值为每场得分
    public void updateMoney(Long userId, Long addMoney){
        SysUser sysUser = sysUserMapper.selectByUserId(userId);
        Long money = sysUser.getMoney()+addMoney;
        System.out.println(money);
        sysUserMapper.updateMoney(userId, money);
    }
    //升级，1->2 需要100，2->3需要200，以此类推。等级区间由前端定
    public boolean updateGrade(Long userId){
        SysUser sysUser = sysUserMapper.selectByUserId(userId);
        Long money = sysUser.getMoney();
        Long grade = sysUser.getGrade();
        Long newMoney = money-grade*100;
        if(money>=grade*100){
            Long newGrade = grade+1;
            sysUserMapper.updateMoney(userId,newMoney);
            sysUserMapper.updateGrade(userId,newGrade);
            return true;
        }else {
            return false;
        }

    }
}
