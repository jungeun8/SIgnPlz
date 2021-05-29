package signPlz.configuration;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {      
	
	// Swagger ui 페이지에 노출할 내용 커스텀
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"signPlz API",
				"signPlz API 가이드 문서로서 \n API사용시 필요한 권한과 파라미터 정보를 작성하였습니다. ",
				"SV1",
				"signPlz",
				"signPlz Developer JungEun & InHyuk",
				" 홈페이지",
				"/main/signPlz"
				);
		return apiInfo;
	}
	
    @Bean
    public Docket api() {
    	/*
        ParameterBuilder aParameterBuilder = new ParameterBuilder(); // 토큰입력을 위한 header 파라미터 추가
        aParameterBuilder.name("Authorization") //헤더 이름
                .description("Access Tocken") //설명
                .modelRef(new ModelRef("string"))
                .parameterType("header") 
                .required(false)
                .build();  
        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());
        
        return new Docket(DocumentationType.SWAGGER_2) 
        	.globalOperationParameters(aParameters) // header 파라미터 추가
          .select()                                 
          .apis(RequestHandlerSelectors.any())             
          .paths(PathSelectors.any())                         
          .build(); 
        */
    	
    	// ======= header token 전역처리를 위함 ========
        return new Docket(DocumentationType.SWAGGER_2)
        	.apiInfo(apiInfo()) // api 커스터마이징
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(Arrays.asList(apiKey()));

        }

        private ApiKey apiKey() {
            return new ApiKey("Authorization", "Authorization", "header");
        }
}
