package be.njani.seriestracker.interfaces.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        value = InterfacesConfig.INTERFACES_BASE_PACKAGE,
        excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class))
//TODO: @Import(CacheConfig.class)
public class InterfacesConfig {

    public static final String INTERFACES_BASE_PACKAGE = "be.njani.seriestracker.interfaces";

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
