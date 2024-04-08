package com.example.demo.Device_Manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Device_Manager.entity.tb_user;

import javax.servlet.http.HttpServletRequest;

/**
* @author Hasee
* @description 针对表【tb_user(用户)】的数据库操作Service
* @createDate 2024-04-08 19:05:21
*/
public interface tb_userService extends IService<tb_user> {


    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    tb_user userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    tb_user getSafetyUser(tb_user originUser);


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

}
