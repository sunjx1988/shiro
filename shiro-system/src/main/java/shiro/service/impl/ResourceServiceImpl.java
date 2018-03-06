package shiro.service.impl;

import org.springframework.stereotype.Service;
import shiro.entity.Resource;
import shiro.service.ResourceService;

import java.util.List;
import java.util.Set;

/**
 * Created by sunjx on 2018/3/4.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        return null;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        return null;
    }
}
