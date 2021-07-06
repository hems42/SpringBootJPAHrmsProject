package cap_software.hrms.bussiness;

import cap_software.hrms.core.constants.Messages;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.core.dtoConvertors.JopSeekerDtoConvertor;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.testSupport.TestSupportJopSeekerService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JopSeekerServiceTest extends TestSupportJopSeekerService {


    private  JopSeekerDao jopSeekerDao;
    private  JopSeekerDtoConvertor convertorJopSeeker;
    private JopSeekerService  jopSeekerService;

    @BeforeEach
    void setUp() {
        jopSeekerDao= mock(JopSeekerDao.class);
        convertorJopSeeker=mock(JopSeekerDtoConvertor.class);
        jopSeekerService=new JopSeekerService(jopSeekerDao,convertorJopSeeker);
    }

    @Test
    void testCreateJopSeeker_whenCreateJopSeeker_itShouldReturn_SuccessDataResultJopSeekerDto() {



        CreateJopSeekerRequest jopSeekerRequest=generateCreateJopSeekerRequest();

        JopSeekerDto jopSeekerDto=generateJopSeekerDto();

        DataResult<JopSeekerDto>  successDateResult=new SuccessDataResult<>(jopSeekerDto, Messages.KULLANICI_EKLEME_BASARILI);

        DataResult<JopSeekerDto> jopSeekerDtoResult=jopSeekerService.createJopSeeker(jopSeekerRequest);












        when(jopSeekerService.createJopSeeker(jopSeekerRequest)).thenReturn(jopSeekerDtoResult);



        assertEquals(jopSeekerDtoResult,successDateResult);
    }

    @Test
    void getJopSeekerById() {
    }

    @Test
    void getAllJobSeekers() {
    }

    @Test
    void deleteJopSeekerById() {
    }

    @Test
    void updateJopSeekerById() {
    }

    @Test
    void updateJopSeekerPersonalInformationById() {
    }

    @Test
    void updateActiveJopSeekerById() {
    }
}