package cap_software.hrms;



import cap_software.hrms.bussiness.JopSeekerService;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.createRequest.CreatePersonalInformationRequest;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication implements CommandLineRunner {
    @Autowired
    JopSeekerDao jopSeekerDao;

    @Autowired
    JopSeekerService  jopSeekerService;


    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);



    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cap_software.hrms"))
                .build();
    }

    @Override
    public void run(String... args) throws Exception {

     /*   CreateJopSeekerRequest  createJopSeekerRequest=new CreateJopSeekerRequest(
          new CreatePersonalInformationRequest(
                  "ALİ",
                  "YILMAZ",
                  "00000000000",
                  LocalDate.of(1991,8,16),
                  "ERKEK"
          )
        );

        jopSeekerService.createJopSeeker(createJopSeekerRequest);
        System.out.println("kaydedilen kullanıcı  :"+jopSeekerDao
                .getJopSeekerByPersonalInformation_NationalIdentityNumber("00000000000")
                .get().getPersonalInformation().getName());
        */

    }
}