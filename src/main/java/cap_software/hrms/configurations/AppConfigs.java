package cap_software.hrms.configurations;

import cap_software.hrms.core.mappers.JopSeekerMapper;
import cap_software.hrms.core.mappers.PersonalInformationMapper;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes.CheckValidPersonMernisAdapter;
import cap_software.hrms.entities.mapstructExams.ParentMapper;
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


    @Bean
    public ParentMapper getParentMapper()
    {
        return ParentMapper.INSTANCE_PARENT_MAPPER;
    }

    @Bean
    public PersonalInformationMapper getPersonalInformationMapper()
    {
        return PersonalInformationMapper.INSTANCE_PERSONAL_INFORMATION_MAPPER;
    }

    @Bean
    public JopSeekerMapper getJopSeekerMapper()
    {
        return JopSeekerMapper.INSTANCE_JOP_SEEKER_MAPPER;
    }
}
