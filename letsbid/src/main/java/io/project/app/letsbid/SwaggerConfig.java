package io.project.app.letsbid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    //http://localhost:9091/swagger-ui.html

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BIDDER API")
                .description("Let's win the bid ")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact(new Contact("Lilit Hovhannisyan", "", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    @Bean
    public Docket personApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true)
                .groupName("BIDDER API")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }

}
