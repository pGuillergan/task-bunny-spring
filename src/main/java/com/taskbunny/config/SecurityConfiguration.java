package com.taskbunny.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.taskbunny.filters.JwtRequestFilter;
import com.taskbunny.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService myUserDetailsService; 
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(myUserDetailsService);

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and();
//		http.httpBasic().disable();
		http.authorizeRequests()
			.antMatchers("/role").hasAnyRole("PROVIDER","CLIENT")
			.antMatchers("/users").hasAnyRole("CLIENT", "PROVIDER")
			.antMatchers("/users").hasRole("ADMIN")
			//.antMatchers("/tasks").hasAnyRole("CLIENT","ADMIN","PROVIDER")
			.antMatchers("/tasks/**").hasAnyRole("CLIENT","PROVIDER")
			.antMatchers("/task/**").hasAnyRole("PROVIDER","ADMIN")
			.antMatchers("/", "static/css", "static/js").permitAll()
			.and().formLogin();
		
		http.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/authenticate")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/usersregister");
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean()throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	        return source;
	    }

	
	     public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/tasks/**")
	             .allowedOrigins("*")
	             .allowedMethods("PUT", "DELETE","GET","POST")
	             .allowedHeaders("Content-Type")
	             .allowCredentials(false).maxAge(3600);
	     }
	 
}
