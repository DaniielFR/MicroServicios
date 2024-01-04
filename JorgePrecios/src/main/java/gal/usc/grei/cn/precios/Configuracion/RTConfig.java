package gal.usc.grei.cn.precios.Configuracion;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//https://stackoverflow.com/questions/36151421/could-not-autowire-fieldresttemplate-in-spring-boot-application
@Configuration
public class RTConfig {

    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder){
        return builder.build();
    }
}
