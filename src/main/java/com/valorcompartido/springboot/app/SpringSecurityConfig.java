package com.valorcompartido.springboot.app;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.concurrent.SuccessCallback;

import com.valorcompartido.springboot.app.auth.handler.loginSuccesHandler;

@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private loginSuccesHandler SuccessHandler;	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**").permitAll()
		.antMatchers("/api/v1/**").hasAnyRole("ADMIN")
		.antMatchers("/deleter/{id}").hasAnyRole("ADMIN")
		.antMatchers("/find/{id}").hasAnyRole("ADMIN")
		.antMatchers("all").hasAnyRole("ADMIN")
		.antMatchers("/uploads/**").hasAnyRole("USER")
		.antMatchers("/index/**").hasAnyRole("ADMIN")
		.antMatchers("/save/**").hasAnyRole("ADMIN")
		.antMatchers("/").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
				.successHandler(SuccessHandler)
				.loginPage("/login")
			
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	/*	.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder user = User.builder().passwordEncoder(password -> encoder.encode(password));
		
		builder.inMemoryAuthentication().withUser(user.username("admin").password("123456").roles("ADMIN"))
		.withUser(user.username("romario").password("123456").roles("USER"));
		
		
		
		
		
	}

}
