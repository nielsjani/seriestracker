package be.njani.seriestracker.domain;

import be.njani.seriestracker.domain.infrastructure.spring.InfrastructureConfig;
import be.njani.seriestracker.domain.interfaces.spring.InterfacesConfig;
import be.njani.seriestracker.domain.spring.DomainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import spring.InfrastructureTestPropertiesConfig;
import test.RollingBackIntegrationTest;

import javax.inject.Inject;

@ContextConfiguration(classes = {
    DomainConfig.class,
    InterfacesConfig.class,
    InfrastructureTestPropertiesConfig.class,
    InfrastructureConfig.class
})
public abstract class DomainIntegrationTest extends RollingBackIntegrationTest {

    @Inject
    protected ApplicationContext context;
}
