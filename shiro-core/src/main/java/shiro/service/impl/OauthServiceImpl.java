package shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shiro.service.OauthClientService;
import shiro.service.OauthService;

/**
 * Created by sunjx on 2018/3/3.
 */
@Service
public class OauthServiceImpl implements OauthService {

    private Cache cache;

    private static final int EXPIREIN = 3600;

    @Autowired
    public OauthServiceImpl(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("code-cache");
    }

    @Autowired
    private OauthClientService oauthClientService;

    @Override
    @Transactional
    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }

    @Override
    @Transactional
    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }

    @Override
    public boolean checkAuthCode(String authCode) {
        return null != cache.get(authCode);
    }

    @Override
    public boolean checkAccessToken(String accessToken) {
        return null != cache.get(accessToken);
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        return (String) cache.get(authCode).get();
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
        return (String) cache.get(accessToken).get();
    }

    @Override
    public boolean checkClientId(String clientId) {
        return null != oauthClientService.findByClientId(clientId);
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return null != oauthClientService.findByClientSecret(clientSecret);
    }

    @Override
    public long getExpireIn() {
        return EXPIREIN;
    }

}
