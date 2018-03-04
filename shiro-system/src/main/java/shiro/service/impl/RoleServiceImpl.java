package shiro.service.impl;

import org.springframework.stereotype.Service;
import shiro.service.RoleService;

import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Set<String> findRoles(Long... roleIds) {
        return null;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        return null;
    }
}
