package be.njani.seriestracker.infrastructure.spring;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JpaConfig {

    public static final boolean SHOW_SQL = false;
    public static final String HIBERNATE_ENTITY_PACKAGES = "be.njani.seriestracker.domain";
    public static final String FORMAT_SQL = "hibernate.format_sql";

    @Inject
    private Environment environment;

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        factory.setPackagesToScan(HIBERNATE_ENTITY_PACKAGES);
        factory.setJpaProperties(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        PoolConfiguration poolConfiguration = new PoolProperties();
        poolConfiguration.setDriverClassName(environment.getProperty("db.driver"));
        poolConfiguration.setUrl(environment.getProperty("db.url"));
        poolConfiguration.setUsername(environment.getProperty("db.username"));
        poolConfiguration.setPassword(environment.getProperty("db.password"));
        return new org.apache.tomcat.jdbc.pool.DataSource(poolConfiguration);
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(Oracle10gDialect.class.getName());
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(SHOW_SQL);
        return vendorAdapter;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put(FORMAT_SQL, true);
        return properties;
    }
}
