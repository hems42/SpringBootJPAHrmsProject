package cap_software.hrms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.property.access.spi.PropertyAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);




    }

    @Component
    public class MyFancyComponent {
        @PersistenceContext
        private EntityManager entityManager;

        public void doSomethingFancy() {
            // public SessionFactory API
            final SessionFactory sf = entityManager
                    .unwrap( Session.class ).getSessionFactory();


            // public SessionFactoryImplementor SPI
            final SessionFactoryImplementor sfi = entityManager
                    .unwrap( SessionImplementor.class ).getFactory();
        }
    }

}
