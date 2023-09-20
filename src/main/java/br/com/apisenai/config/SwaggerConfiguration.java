package br.com.apisenai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infosApi());
    }

    private Contact getContato() {
        return new Contact("Arthur, Amanda, Gustavo e Leonardo",
                "br.com.apisenai",
                "email@email.com");
    }

    private ApiInfo infosApi() {
        return new ApiInfoBuilder().version("1.0")
                .title("Fan Club Register API")
                .description(
                        "API desenvolvida com finalidades academicas. O contexto proposto pelo grupo foi o cadastro e adesão de novos membros para um fã clube de um time de e-esports")
                .contact(this.getContato())
                .termsOfServiceUrl("Termo de uso: Open Source")
                .license("Licenciada para SENAI")
                .licenseUrl("senai.edu.br").build();
    }
}
