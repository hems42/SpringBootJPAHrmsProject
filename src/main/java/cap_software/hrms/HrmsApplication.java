package cap_software.hrms;


import cap_software.hrms.bussiness.concretes.UserManager;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.orm.hibernate5.HibernateOperations;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);




     //   EntityManagerFactory factory= Persistence.createEntityManagerFactory("default");





        /*
        *
        * @RunWith(SpringRunner.class)
@ContextConfiguration(classes= Application.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserServicesTests {

@Autowired
private TestEntityManager testEntityManager;

@Autowired
private UserRepository userRepository;

@Test
public void oops() {
    User user = new User();
    user.setUsername("Toshko");
    //EMAIL IS REQUIRED:
    //user.setEmail("OPS");
    this.testEntityManager.persist(user);

    //HERE COMES TE EXCEPTION BECAUSE THE EMAIL FIELD IN TE DATABASE IS REQUIRED :
    this.userRepository.findUserByUsername("Toshko");

    System.out.println();
}
}
        * */




    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cap_software.hrms"))
                .build();
    }

}
/*
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
    }*/