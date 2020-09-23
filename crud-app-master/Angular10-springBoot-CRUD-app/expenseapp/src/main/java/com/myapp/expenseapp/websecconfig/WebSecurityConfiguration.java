package com.myapp.expenseapp.websecconfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/*import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;*/
import org.springframework.web.bind.annotation.CrossOrigin;

import com.myapp.expenseapp.jwt.AuthEntryPointJwt;
import com.myapp.expenseapp.jwt.AuthTokenFilter;
import com.myapp.expenseapp.service.UserDetailsServiceImpl;



@CrossOrigin("http://localhost:4200")
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**", "/api/v1/").permitAll()
			.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);	
}

	
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.cors();
		http.csrf().disable();
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

			//	authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
			//	.and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("expenseuser").password("{noop}expensepassword").roles("*");
	}*/
/*
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	 // @Override
	   //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     //  auth.inMemoryAuthentication().withUser("a").password("a").roles("USER");
	 // }
	  // @Override
	   protected void configure(HttpSecurity http) throws Exception {
	     //  	http	
	    //   			.authorizeRequests()
	    //   			.antMatchers("expenses/")
	    //          	.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
	    //          	.anyRequest().authenticated()
	     //         	.and().httpBasic();
	       	http.cors(); //.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
			http.csrf().disable();//.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/expenses/");
	   }
}

*/
	

/*@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
	    http.cors();//configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.csrf().disable();//.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/expenses/");
					//.permitAll().anyRequest();
				//	.authenticated().and()
				//	.httpBasic();
		}*/

}

