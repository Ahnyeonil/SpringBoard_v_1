package com.ahn.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ahn.board.config.auth.PrincipalDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
// 스프링 시큐리티 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PrincipalDetailService principalDetailService;

	// 스프링2.0 이후 비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //configure(AuthenticationManagerBuilder auth) 이 메소드를 오버라이딩
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// csrf 토큰 해제
			.csrf().disable()
				// URL 별 권한 관리를 설정하는 옵션
				.authorizeRequests()
				// 권한 관리 대상을 지정하는 옵션 - "/" 등 지정된 URL들은 모두 permitAll() 메소드를 통해 전체 열람 권한을 줌.
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
				.anyRequest().authenticated()
			.and()
				// 권한이 없는 사람이 페이지 이동시 로그인 페이지로 이동
				.formLogin()
				// 해당하는 로그인 페이지URL로 이동
				.loginPage("/auth/user/login")
				.loginProcessingUrl("/auth/user/login")
				// loginProcessingUrl() - 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인함.
				// .loginProcessingUrl("/auth/api/v1/user/login")
				// 로그인이 성공하면 해당 URL로 이동
				.defaultSuccessUrl("/");
	}
}
