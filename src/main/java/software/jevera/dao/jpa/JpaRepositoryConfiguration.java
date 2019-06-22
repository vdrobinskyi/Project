package software.jevera.dao.jpa;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.jevera.dao.EmployeeRepository;
import software.jevera.domain.Employee;

import javax.persistence.EntityManagerFactory;

@Configuration
@ConditionalOnProperty(value = "application.datamode", havingValue = "jpa")
public class JpaRepositoryConfiguration {

    @Bean
    public EmployeeRepository jpaEmployeeRepository(EntityManagerFactory entityManagerFactory){

        return new JpaEmployeeRepository(entityManagerFactory);

    }

}
