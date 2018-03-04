package shiro.service.impl;

import org.springframework.stereotype.Service;
import shiro.entity.User;
import shiro.service.UserService;

import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
