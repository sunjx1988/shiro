package shiro.service;

import shiro.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
public interface ResourceService {

    Set<String> findPermissions(Set<Long> resourceIds); //得到资源对应的权限字符串

    List<Resource> findMenus(Set<String> permissions); //根据用户权限得到菜单
}
