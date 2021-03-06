package be.njani.seriestracker.domain.war.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        value = WarConfig.WAR_BASE_PACKAGE,
        excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class))
@PropertySources({
        @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
})
public class WarConfig {

    public static final String WAR_BASE_PACKAGE = "be.njani.seriestracker.war";

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
