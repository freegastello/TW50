package ru.user.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Value("${myapp.queries.users-query}")
	private String usersQuery;

	@Value("${myapp.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
				jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.passwordEncoder(new BCryptPasswordEncoder())
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user/other").hasAuthority("USER")
				.antMatchers("/admin/**").hasAuthority("ADMIN")
//				.antMatchers("/users/**").access("hasRole('ADMIN') and hasRole('USER')")
				.anyRequest().authenticated()
			.and()
				.logout()
				.permitAll()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.invalidateHttpSession(true)
			.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/admin/users")
//				.successHandler("USER") @Bean
				.usernameParameter("login")
				.passwordParameter("password")
			.and()
				.csrf().disable()
		;
	}
}
