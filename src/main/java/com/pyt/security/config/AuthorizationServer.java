package com.pyt.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@EnableAuthorizationServer
@Configuration

public class AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	@Autowired
	private AuthenticationManager authenticationManager;
@Override
public void configure(AuthorizationServerSecurityConfigurer securityConfig) {
	securityConfig.tokenKeyAccess("permitAll()")
	.checkTokenAccess("isAuthenticated()");
}
@Override
public void configure(ClientDetailsServiceConfigurer client) throws Exception {
	client.inMemory()
	.withClient("clientId")
	.secret("secret")
	.authorizedGrantTypes("authorization_code")
	.scopes("user_info")
	.autoApprove(true);
}
@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoint) {
	endpoint.authenticationManager(authenticationManager);
}
}
