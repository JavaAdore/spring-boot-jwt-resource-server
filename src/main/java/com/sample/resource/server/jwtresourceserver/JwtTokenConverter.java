package com.sample.resource.server.jwtresourceserver;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtTokenConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {
    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {

        jwtAccessTokenConverter.setAccessTokenConverter(this);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth2Authentication =  super.extractAuthentication(map);
        auth2Authentication.setDetails(map.get("applicationUserId"));
        return auth2Authentication;
    }
}
