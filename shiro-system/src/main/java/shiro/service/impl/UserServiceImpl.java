package shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import shiro.entity.*;
import shiro.helper.EntityHelper;
import shiro.helper.PasswordHelper;
import shiro.mapper.ResourceMapper;
import shiro.mapper.RoleMapper;
import shiro.mapper.custom.CustomUserMapper;
import shiro.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private CustomUserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    @Transactional
    public void changePassword(Long userId, String newPassword) {
        User user = userMapper.selectByPrimaryKey(userId);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);

        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }

        return null;
    }

    @Override
    public Set<String> findRoles(String username) {

        List<Role> roles = findeRoles(username);

        if(!CollectionUtils.isEmpty(roles)){
            Set<String> roleNames = new HashSet<>(roles.size());
            for (Role r : roles){
                roleNames.add(r.getRole());
            }

            return roleNames;
        }
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        List<Role> roles = findeRoles(username);

        if(!CollectionUtils.isEmpty(roles)){

            //获取resource ids
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < roles.size(); i++) {
                sb.append(roles.get(i).getResourceIds()).append(",");
            }

            List<Long> resourceIdList = EntityHelper.idStringToList(sb.toString(), ",");

            //查询resource list
            ResourceExample resourceExample = new ResourceExample();
            resourceExample.createCriteria().andIdIn(resourceIdList);

            List<Resource> resourceList = resourceMapper.selectByExample(resourceExample);

            //获取permission
            if(!CollectionUtils.isEmpty(resourceList)){
                StringBuffer pnamesSb = new StringBuffer();

                for(Resource r : resourceList){
                    pnamesSb.append(r.getPermission()).append(",");
                }

                String[] pnames = pnamesSb.toString().substring(0,pnamesSb.length()-1).split(",");
                Set<String> permissionNames = new HashSet<>(roles.size());

                for(String p : pnames){
                    permissionNames.add(p);
                }

                return permissionNames;
            }

        }
        return null;
    }

    private List<Role> findeRoles(String username){
        User user ;
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);

        if(!CollectionUtils.isEmpty(list)){
            user = list.get(0);

            if(!StringUtils.isEmpty(user.getRoleIds())){
                List<Long> roleIds = EntityHelper.idStringToList(user.getRoleIds(), ",");

                RoleExample example1 = new RoleExample();
                example.createCriteria().andIdIn(roleIds);

                return roleMapper.selectByExample(example1);
            }

        }


        return null;
    }
}
