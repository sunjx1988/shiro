package shiro.service;

import shiro.entity.User;

import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
public interface UserService {

    void changePassword(Long userId, String newPassword); //修改密码

    User findByUsername(String username); //根据用户名查找用户

    Set<String> findRoles(String username);// 根据用户名查找其角色

    Set<String> findPermissions(String username);// 根据用户名查找其权限

}
