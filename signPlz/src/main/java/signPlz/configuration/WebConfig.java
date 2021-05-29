package signPlz.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import kr.eut.security.filter.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
    	 .allowedOrigins("*")
    	 .allowedHeaders("*")
    	 .allowedMethods("*");
    }
    
    private static final String[] EXCLUDE_PATHS = {
            "/**"
    };

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
						.addPathPatterns("/**")
						.excludePathPatterns("/v2/api/signin")
						.excludePathPatterns("/swagger-ui.html")
						.excludePathPatterns("/webjars/springfox-swagger-ui/**")
						.excludePathPatterns("/resources/**")
						.excludePathPatterns("/WEB-INF/**");
    }
    
    
    }

