package io.blog.util.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@OpenAPIDefinition(info = @Info(title = "블로그 검색 서비스 API 명세서", description = "카카오 OPEN API 기반 블로그 검색 서비스 API 명세서", version = "v1"))
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(swaggerInfo());
	}

	private ApiInfo swaggerInfo() {
		return new ApiInfoBuilder().title("블로그 검색 서비스 API 명세서").description("카카오 OPEN API 기반 블로그 검색 서비스 API 명세서")
				.build();
	}
}