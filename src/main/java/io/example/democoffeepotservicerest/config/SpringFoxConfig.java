package io.example.democoffeepotservicerest.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SpringFoxConfig {

  @Bean
  public Docket swaggerConfiguration() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.example"))
        .paths(PathSelectors.ant("/api/**"))
        .build()
        .apiInfo(apiDetails());
  }

  private ApiInfo apiDetails() {
    return new ApiInfo(
        "Coffee Pot API",
        "Simple API for demonstration purposes",
        "1.1.1",
        "Free to use",
        new springfox.documentation.service.Contact(
            "Cody McCarty", "https://github.com/CodyMcCarty", "codyjmccarty@gmail.com"),
        "API License",
        "https://github.com/CodyMcCarty",
        Collections.emptyList());
  }
}
