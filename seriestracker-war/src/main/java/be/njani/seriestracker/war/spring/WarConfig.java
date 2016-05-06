package be.njani.seriestracker.war.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
        value = WarConfig.WAR_BASE_PACKAGE,
        excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class))
@PropertySources({
        @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
//        @PropertySource(value = "file:${PROJECTBEHEER_PROPERTY_FILE_LOCATION}", ignoreResourceNotFound = true)
})
public class WarConfig {

    public static final String WAR_BASE_PACKAGE = "be.njani.seriestracker.war";

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
