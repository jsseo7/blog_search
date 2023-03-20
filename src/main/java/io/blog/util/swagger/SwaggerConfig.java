//package io.blog.util.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import io.swagger.models.Contact;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger.web.UiConfigurationBuilder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration	
//@EnableSwagger2	 
//public class SwaggerConfig extends WebMvcConfigurationSupport {
//
//    @Bean
//    public Docket swagger() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .ignoredParameterTypes(java.sql.Date.class)
//                .forCodeGeneration(true)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                //.apiInfo(apiInfo())
//                .enable(true);
//    }
//
////    private ApiInfo apiInfo(){
////        return new ApiInfoBuilder()
////                .title("블로그 검색 서비스")
////                .description("블로그 검색 API 테스트")
////                .version("1.0")
////                .build();
////    }
//	
//	
////	@Override
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
////		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
////	}
////
////    @Bean
////    public Docket allApi() {
////        return getDocket("전체", Predicates.or(
////                PathSelectors.regex("/*.*")));
////    }
////	
////	@Bean
////    public Docket databaseApi() {
////        return getDocket("데이터베이스", Predicates.or(
////                PathSelectors.regex("/database.*")));
////    }
////    
////    @Bean
////    public Docket searchApi() {
////        return getDocket("검색", Predicates.or(
////                PathSelectors.regex("/search.*")));
////    }
////    
////    public Docket getDocket(String groupName, Predicate<String> predicate) {
////        return new Docket(DocumentationType.SWAGGER_2)
////        		.groupName(groupName)
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.cc.kr"))
////                .paths(predicate)
////                .apis(RequestHandlerSelectors.any())
////                .build();
////    }
////    
////    @Bean
////    public UiConfiguration uiConfig() {
////        return UiConfigurationBuilder.builder()
////                .displayRequestDuration(true)
////                .validatorUrl("")
////                .build();
////    }	
//}