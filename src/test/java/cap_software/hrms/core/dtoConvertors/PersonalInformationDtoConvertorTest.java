package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.contacts.PersonalInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonalInformationDtoConvertorTest {

    private PersonalInformationDtoConvertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new PersonalInformationDtoConvertor();
    }


    @Test
    void testConvert_itShouldReturnPersonalInformationDto() {


        PersonalInformation personalInformation = new PersonalInformation
                (0,
                        "ALİ",
                        "YILMAZ",
                        "00000000000",
                        LocalDate.of(1991, 8, 16),
                        "ERKEK",
                        null,
                        null,
                        null
                );

        PersonalInformationDto personalInformationDto = new PersonalInformationDto
                (
                        0,
                        "ALİ",
                        "YILMAZ",
                        "00000000000",
                        LocalDate.of(1991, 8, 16),
                        "ERKEK",
                        null,
                        null
                );


        PersonalInformationDto personalInformationDtoResult = convertor.convert(personalInformation);


        assertEquals(personalInformationDtoResult.getId(), personalInformationDto.getId());
        assertEquals(personalInformationDtoResult.getBirthOfDate(), personalInformationDto.getBirthOfDate());
        assertEquals(personalInformationDtoResult.getName(), personalInformationDto.getName());
        assertEquals(personalInformationDtoResult.getSurname(), personalInformationDto.getSurname());
        assertEquals(personalInformationDtoResult.getSex(), personalInformationDto.getSex());


    }

    @Test
    void testConvert_itShouldReturnPersonalInformation() {


        PersonalInformation personalInformation = new PersonalInformation
                (0,
                        "ALİ",
                        "YILMAZ",
                        "00000000000",
                        LocalDate.of(1991, 8, 16),
                        "ERKEK",
                        null,
                        null,
                        null
                );

        PersonalInformationDto personalInformationDto = new PersonalInformationDto
                (
                        0,
                        "ALİ",
                        "YILMAZ",
                        "00000000000",
                        LocalDate.of(1991, 8, 16),
                        "ERKEK",
                        null,
                        null
                );


        PersonalInformation personalInformationResult = convertor.convert(personalInformationDto);


        assertEquals(personalInformationResult.getId(), personalInformation.getId());
        assertEquals(personalInformationResult.getBirthOfDate(), personalInformation.getBirthOfDate());
        assertEquals(personalInformationResult.getName(), personalInformation.getName());
        assertEquals(personalInformationResult.getSurname(), personalInformation.getSurname());
        assertEquals(personalInformationResult.getSex(), personalInformation.getSex());
    }
}