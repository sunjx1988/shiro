package shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import shiro.entity.Resource;
import shiro.entity.ResourceExample;
import shiro.entity.Role;
import shiro.entity.RoleExample;
import shiro.helper.EntityHelper;
import shiro.mapper.ResourceMapper;
import shiro.mapper.RoleMapper;
import shiro.service.RoleService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Set<String> findRoles(Long... roleIds) {
        List<Role> list = findRoleList(roleIds);

        if(!CollectionUtils.isEmpty(list)){
            Set<String> roleNames = new HashSet<String>(list.size());
            for(Role r : list){
                roleNames.add(r.getRole());
            }
            return roleNames;
        }
        return null;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        List<Role> roleList = findRoleList(roleIds);


        if(!CollectionUtils.isEmpty(roleList)){
            StringBuffer sb = new StringBuffer();
            for(Role r : roleList){
                sb.append(r.getResourceIds());
                sb.append(",");
            }

            List<Long> resourceIds = EntityHelper.idStringToList(sb.toString(),",");

            ResourceExample resourceExample = new ResourceExample();
            resourceExample.createCriteria().andIdIn(resourceIds);
            List<Resource> resourceList = resourceMapper.selectByExample(resourceExample);

            if(!CollectionUtils.isEmpty(resourceIds)){
                StringBuffer stringBuffer = new StringBuffer();

                for(Resource r : resourceList){
                    stringBuffer.append(r.getPermission()).append(",");
                }

                String[] permissionNameArray = stringBuffer.toString().split(",");

                Set<String> set = new HashSet<>();
                for(String s : permissionNameArray){
                    if(!StringUtils.isEmpty(s)){
                        set.add(s);
                    }
                }

                return set;
            }
        }




        return null;
    }


    private List<Role> findRoleList(Long... roleIds){
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIn(Arrays.asList(roleIds));
        return roleMapper.selectByExample(roleExample);
    }
}
