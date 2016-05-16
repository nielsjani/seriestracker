package be.njani.seriestracker.domain.api.as;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        value = ApiAsConfig.API_AS_BASE_PACKAGE,
        excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class))
public class ApiAsConfig {

    public static final String API_AS_BASE_PACKAGE = "be.njani.seriestracker.api.as";
}

