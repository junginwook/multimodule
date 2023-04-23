package dev.be.moduleapi.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http
	) throws Exception {

		return http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
						.requestMatchers(
								HttpMethod.GET,
								"/find",
								"/articles",
								"/articles/search-hashtag"
						).permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(withDefaults())
				.logout(logout -> logout.logoutSuccessUrl("/"))
				.build();
	}
}

