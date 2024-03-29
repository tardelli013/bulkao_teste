package com.firstdata.iteiris.bulkao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket detailsApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.firstdata.iteiris.bulkao.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build());

        return docket;
    }

    private ApiInfoBuilder infoApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Bulkao");
        apiInfoBuilder.description("Bulkao API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.licenseUrl("https://iteris.com.br");

        return apiInfoBuilder;
    }

}
