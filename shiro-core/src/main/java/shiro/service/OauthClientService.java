package shiro.service;

import shiro.entity.Oauth2Client;

import java.util.List;


public interface OauthClientService {

    Oauth2Client createClient(Oauth2Client client);

    Oauth2Client updateClient(Oauth2Client client);

    void deleteClient(Long clientId);

    Oauth2Client findOne(Long clientId);

    List<Oauth2Client> findAll();

    Oauth2Client findByClientId(String clientId);

    Oauth2Client findByClientSecret(String clientSecret);

}
