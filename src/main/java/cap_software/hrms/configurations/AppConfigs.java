package cap_software.hrms.configurations;


import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes.CheckValidPersonMernisAdapter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigs {

    @Bean
    public ModelMapper getModelMapper()
    {
        ModelMapper modelMapper= new ModelMapper();



        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;
    }



    @Bean
    public CheckValidPersonService getCheckValidPersonAdapter()
    {
        return new CheckValidPersonMernisAdapter();
    }


}
