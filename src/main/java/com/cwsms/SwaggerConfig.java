package com.cwsms;

import com.cwsms.constants.SwaggerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.cwsms.constants.SwaggerConstants.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact(API_CONTACT_NAME, API_CONTACT_URL, API_CONTACT_EMAIL);

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(API_TITLE,
            API_DESCRIPTION, API_VERSION, API_TERMS_OF_SERVICE_URL,
            DEFAULT_CONTACT, API_LICENSE,
            API_LICENSE_URL, new ArrayList());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO);
    }
}
