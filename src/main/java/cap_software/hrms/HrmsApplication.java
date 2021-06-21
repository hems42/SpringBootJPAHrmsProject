package cap_software.hrms;


import cap_software.hrms.bussiness.concretes.UserManager;
import cap_software.hrms.core.mappers.JopSeekerMapper;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes.CheckValidPersonMernisAdapter;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.mapstructExams.*;
import cap_software.hrms.outSourceServices.mernis.IWWKPSPublicSoap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);


        PersonalInformation information= new PersonalInformation();
        information.setSex("ERKEK");
        information.setName("ALİ");
        information.setSurname("YILMAZ");
        information.setNationalIdentityNumber("00000000000");


        JopSeeker jopSeeker= new JopSeeker();
        jopSeeker.setEmail("deneme@gmail.com");
        jopSeeker.setPassword("00055554444");
        jopSeeker.setUserNumber("JBSKR001");
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);


        System.out.println("dto dan gelen : "+ JopSeekerMapper.INSTANCE_JOP_SEEKER_MAPPER.fromJopSeeker(jopSeeker).toString());


    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cap_software.hrms"))
                .build();
    }

}