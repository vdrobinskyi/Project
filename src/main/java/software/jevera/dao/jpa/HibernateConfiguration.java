package software.jevera.dao.jpa;


import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.jevera.domain.Employee;
import software.jevera.domain.Position;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(value = "application.datamode",havingValue = "jpa")
public class HibernateConfiguration {

    @Bean
    public EntityManagerFactory createEntityManagerFactory(DataSourceProperties dataSourceProperties){

        Map<String, Object> properties = new HashMap<>();

        properties.put(AvailableSettings.LOADED_CLASSES, Arrays.asList(Employee.class, Position.class));
        properties.put(AvailableSettings.JPA_JDBC_DRIVER, dataSourceProperties.getDriverClassName());
        properties.put(AvailableSettings.URL, dataSourceProperties.getUrl());
        properties.put(AvailableSettings.USER, dataSourceProperties.getUsername());
        properties.put(AvailableSettings.PASS, dataSourceProperties.getPassword());
        properties.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, SpringPhysicalNamingStrategy.class.getCanonicalName());

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("search", properties);

        return entityManagerFactory;
    }

}
