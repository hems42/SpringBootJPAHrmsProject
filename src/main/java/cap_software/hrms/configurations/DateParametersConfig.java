package cap_software.hrms.configurations;

import cap_software.hrms.entities.concretes.utils.DateParametres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class DateParametersConfig {

    @Bean
    public DateParametres getDateParameters()
    {
        var date= new Date();

        return new DateParametres(date,date);
    }
}
