package com.techwondoe.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.techwondoe.jwt.JwtTokenFilter;
import com.techwondoe.repositories.UserRepository;


 
@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(
		prePostEnabled = false,
		securedEnabled = false,
		jsr250Enabled = true
		)
public class ApplicationSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	public static final String[] PUBLIC_URLS= {
			"/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};
	
	@Autowired private UserRepository userRepo;
	@Autowired private JwtTokenFilter jwtTokenFilter;
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(
            username -> userRepo.findByEmail(username)
                .orElseThrow(
                    () -> new UsernameNotFoundException("User " + username + " not found.")));
    }
		 
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
        	.disable()
        	.authorizeRequests()
	        .antMatchers(PUBLIC_URLS).permitAll()
			.antMatchers(HttpMethod.GET).permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .exceptionHandling()
	        .authenticationEntryPoint(
	            (request, response, ex) -> {
	                response.sendError(
	                    HttpServletResponse.SC_UNAUTHORIZED,
	                    ex.getMessage()
	                );
	            }
	        )
	        .and()
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
