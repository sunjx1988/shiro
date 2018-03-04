package shiro.controller.exhandler;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by sunjx on 2018/3/3.
 */
public class OAuth2AuthenticationException extends AuthenticationException {

    public OAuth2AuthenticationException(Throwable cause) {
        super(cause);
    }
}
