package com.itany.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.exception.UserNotFoundException;
import com.itany.mapper.UserMapper;
import com.itany.mapper.UserRoleMapper;
import com.itany.pojo.ManagerUser;
import com.itany.pojo.Role;
import com.itany.pojo.UserRole;
import com.itany.service.UserService;
import com.itany.vo.ManagerUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:02
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Transactional(readOnly = true)
    public ManagerUser login(ManagerUser managerUser) throws UserNotFoundException {

        ManagerUser returnManagerUser = userMapper.selectByUsernameAndPassword(managerUser);

        //shiro 登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(managerUser.getUsername(),managerUser.getPassword());
        subject.login(token);



        if(null == returnManagerUser){
            throw new UserNotFoundException("用户名或者密码错误");
        }

        return returnManagerUser;
    }

    @Override
    public PageInfo<ManagerUser> findByConditions(ManagerUserVO managerUserVO) {

        PageHelper.startPage(managerUserVO.getPage(),managerUserVO.getRows());
        List<ManagerUser> userList = userMapper.selectByConditions(managerUserVO);
        System.out.println(userList);
        PageInfo<ManagerUser> userInfo = new PageInfo<>(userList);
        return userInfo;
    }

    @Override
    public void addUser(ManagerUserVO managerUserVO) {

        String[] roleIds = managerUserVO.getIds()
                .substring(0,managerUserVO.getIds().length()-1)
                .split(",");

        userMapper.insertManagerUser(managerUserVO);

        for(int i = 0;i<roleIds.length;i++){
            int roleId = Integer.parseInt(roleIds[i]);

            Role role = new Role().setId(roleId);
            UserRole userRole = new UserRole().setRole(role).setManagerUser(managerUserVO);
            userRoleMapper.insertUserRole(userRole);
        }

    }

    @Override
    public void modifyByConditions(ManagerUserVO managerUserVO) {
        System.out.println("id:"+managerUserVO.getId());

        String[] roleIds = managerUserVO.getIds()
                .substring(0,managerUserVO.getIds().length()-1)
                .split(",");

        userMapper.updateManagerUser(managerUserVO);

        userRoleMapper.deleteByUserId(managerUserVO.getId());

        for(int i = 0;i<roleIds.length;i++){
            int roleId = Integer.parseInt(roleIds[i]);

            Role role = new Role().setId(roleId);
            UserRole userRole = new UserRole().setRole(role).setManagerUser(managerUserVO);
            userRoleMapper.insertUserRole(userRole);
        }

        System.out.println("over.....................................");

    }
}
