package onem.seya.springboot_tutorial.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = SwaggerConfig.BASE_PACKAGE)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String BASE_PACKAGE = "onem.seya.springboot_tutorial.controller";

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot tutorial document api")
                .description(
                        "An API for keeping track of your apis.   Don't forget to take it for a spin by clicking on the **Try it out** button next to each operation!")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket customImplementation(){

        /**
         * ignored controller method parameter types so that the framework does not generate swagger model
         */

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api/v1")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

}
