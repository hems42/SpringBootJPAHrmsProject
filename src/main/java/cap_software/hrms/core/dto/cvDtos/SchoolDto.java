package cap_software.hrms.core.dto.cvDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
	
	/*
	Adaylar okudukları okulları sisteme ekleyebilmelidir. (Okul adı, bölüm)
	Bu okullarda hangi yıllarda okuduklarını sisteme girebilmelidir.
	Eğer mezun değilse mezuniyet yılı boş geçilebilmelidir.
	Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" olarak görüntülenmelidir.
    */
	
	private String schoolName;
	private  String department;
	private String educationStartYear;
	private boolean graduatestate;	
	private String graduateYear;
	
	
	
	
	
	
	


}
