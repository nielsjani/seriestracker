package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:test/seriestracker.infrastructure.default.test.properties", ignoreResourceNotFound = false)
})
public class InfrastructureTestPropertiesConfig {
}
