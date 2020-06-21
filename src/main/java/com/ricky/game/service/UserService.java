package com.ricky.game.service;
import com.ricky.game.domain.sys.SysRole;
import com.ricky.game.domain.sys.SysUser;

public interface UserService {

    SysUser login(Long id,String password);

    void register(SysUser sysUser);

    void updateInfo(SysUser sysUser);

    void updateMoney(Long userId, Long addMoney);

    boolean updateGrade(Long userId);
}
