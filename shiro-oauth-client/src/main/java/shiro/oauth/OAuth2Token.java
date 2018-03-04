package shiro.oauth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by sunjx on 2018/3/3.
 */
public class OAuth2Token implements AuthenticationToken {

    private String authCode;
    private String principal;

    public OAuth2Token(String authCode) {
        this.authCode = authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getAuthCode() {
        return authCode;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Object getCredentials() {
        return this.authCode;
    }
}
