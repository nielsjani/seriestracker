package be.njani.seriestracker.e2e.tests.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(
    value = E2ETestConfig.E2E_TEST_BASE_PACKAGE,
    excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = Configuration.class))
public class E2ETestConfig {

    public static final String E2E_TEST_BASE_PACKAGE = "be.njani.seriestracker.e2e.tests";
}