package be.njani.seriestracker.domain.war.spring;

import be.njani.seriestracker.domain.api.as.ApiAsConfig;
import be.njani.seriestracker.domain.infrastructure.spring.InfrastructureConfig;
import be.njani.seriestracker.domain.interfaces.spring.InterfacesConfig;
import be.njani.seriestracker.domain.spring.ServiceConfig;
import be.njani.seriestracker.domain.spring.DomainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@Import({
        WarConfig.class,
        ApiAsConfig.class,
        ServiceConfig.class,
        DomainConfig.class,
        InterfacesConfig.class,
        InfrastructureConfig.class
})
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
