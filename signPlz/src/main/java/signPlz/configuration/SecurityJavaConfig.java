package signPlz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter{

	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//			.cors().disable()		//cors방지
//			.csrf().disable()		//csrf방지
//			.formLogin().disable()	//기본 로그인 페이지 없애기
//			.headers().frameOptions().disable();
		  
	        http
	          /*... 중략 ...*/
	            .authorizeRequests()
	            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll() // - (1)
	            /* 중략 */
	            .and()
	            .cors().and()
	            .csrf().disable()
	            .formLogin().disable()
	            .headers().frameOptions().disable();
	    }
	  
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	    
	    
	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();

	        configuration.addAllowedOrigin("*");
	        configuration.addAllowedHeader("*");
	        configuration.addAllowedMethod("*");
	        configuration.setAllowCredentials(false);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }

}
