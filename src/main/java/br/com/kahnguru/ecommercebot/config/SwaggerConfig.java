package br.com.kahnguru.ecommercebot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce Bot API")
                        .description("Bot para minerar dados de um produto," +
                                " sendo possível gerar um relatório com histórico" +
                                "de variação de preços que pode ser feito download")
                        .version("v0.0.1")
                );
    }
}
