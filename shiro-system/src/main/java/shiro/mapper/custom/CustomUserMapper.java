package shiro.mapper.custom;

import shiro.mapper.UserMapper;

import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
public interface CustomUserMapper extends UserMapper {

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
