package cap_software.hrms.configurations;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes.CheckValidPersonMernisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigs {


    @Bean
    public CheckValidPersonService getCheckValidPersonAdapter()
    {
        return new CheckValidPersonMernisAdapter();
    }

}
