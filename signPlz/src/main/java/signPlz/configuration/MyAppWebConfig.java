package signPlz.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("signPlz")
public class MyAppWebConfig extends WebMvcConfigurerAdapter {
	 @Override
     public void addResourceHandlers(final ResourceHandlerRegistry registry) {  
		    registry.addResourceHandler("/resources/**")
            .addResourceLocations("/resources/", "file:resources/");
		    registry.addResourceHandler("/store/**")
            .addResourceLocations("/store/", "file:store/");
     }

}
