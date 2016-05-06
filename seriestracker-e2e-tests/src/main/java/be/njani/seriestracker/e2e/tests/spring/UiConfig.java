package be.njani.seriestracker.e2e.tests.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.io.IOException;

@Configuration
public class UiConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            File file = new File("../seriestracker-ui/target/dist/src/");
            registry
                .addResourceHandler("/**")
                .addResourceLocations("file:///" + file.getCanonicalPath() + "/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}