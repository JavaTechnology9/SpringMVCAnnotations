package com.javatechnology.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Import(value=SpringMVCConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin();*/
		
		/*http.authorizeRequests()
		.antMatchers("/me").authenticated()
		.antMatchers("/admin").authenticated()
		.anyRequest().permitAll()
		.and().formLogin();*/
		
		http.authorizeRequests().antMatchers("/me").hasAuthority("ROLE_USER")
		.antMatchers("/admin").hasAuthority("ROLE_ADMIN")
		.anyRequest().permitAll()
		.and().formLogin();
		/*.and().requiresChannel()
		.antMatchers("/me").requiresSecure();*/
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("test").password("test").authorities("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

}
