package com.japrod.sharebox.server.configuration.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		// @formatter:off
		resources.resourceId("sharebox-resources");
		// @formatter:on
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests()
		.antMatchers("/users/register").permitAll()
		.anyRequest().authenticated();
		// @formatter:on
	}

}
