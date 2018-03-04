package shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import shiro.entity.Oauth2Client;
import shiro.entity.Oauth2ClientExample;
import shiro.mapper.custom.CustomOauth2ClientMapper;
import shiro.service.OauthClientService;

import java.util.List;
import java.util.UUID;

/**
 * Created by sunjx on 2018/3/3.
 */
@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired
    private CustomOauth2ClientMapper oauth2ClientMapper;

    @Override
    @Transactional
    public Oauth2Client createClient(Oauth2Client client) {
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        oauth2ClientMapper.insert(client);
        return client;
    }

    @Override
    @Transactional
    public Oauth2Client updateClient(Oauth2Client client) {
        oauth2ClientMapper.updateByPrimaryKey(client);
        return client;
    }

    @Override
    @Transactional
    public void deleteClient(Long clientId) {
        oauth2ClientMapper.deleteByPrimaryKey(clientId);
    }

    @Override
    public Oauth2Client findOne(Long clientId) {
        return oauth2ClientMapper.selectByPrimaryKey(clientId);
    }

    @Override
    public List<Oauth2Client> findAll() {
        return oauth2ClientMapper.selectByExample(null);
    }

    @Override
    public Oauth2Client findByClientId(String clientId) {
        Oauth2ClientExample example = new Oauth2ClientExample();
        example.createCriteria().andClientIdEqualTo(clientId);
        List<Oauth2Client> oauth2Clients = oauth2ClientMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(oauth2Clients)){
            return oauth2Clients.get(0);
        }
        return null;
    }

    @Override
    public Oauth2Client findByClientSecret(String clientSecret) {
        Oauth2ClientExample example = new Oauth2ClientExample();
        example.createCriteria().andClientSecretEqualTo(clientSecret);
        List<Oauth2Client> oauth2Clients = oauth2ClientMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(oauth2Clients)){
            return oauth2Clients.get(0);
        }
        return null;
    }
}
