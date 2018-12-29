package com.sample.resource.server.jwtresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class JwtResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtResourceServerApplication.class, args);
	}

	@RequestMapping("/test")
	public String test()
	{
		String applicationUserId = (String)((OAuth2AuthenticationDetails )SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		return "Well it works fine Application user Id = "+ applicationUserId;
	}
}

