package cap_software.hrms.entities.concretes.cv;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Schools")
public class School {

	/*
	Adaylar okudukları okulları sisteme ekleyebilmelidir. (Okul adı, bölüm)
	Bu okullarda hangi yıllarda okuduklarını sisteme girebilmelidir.
	Eğer mezun değilse mezuniyet yılı boş geçilebilmelidir.
	Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" olarak görüntülenmelidir.
    */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id") 
	private int id;
	
	@CreationTimestamp
	@Column(name="AddedDate",nullable = false, updatable = false,insertable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;
	
	@CreationTimestamp
	@Column(name="UpdatedDate",updatable = true,insertable =false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name="CvId")
	private CurriculumVitae vitae;
	
	@Column(name="SchoolName",nullable = false)
	private String schoolName;
	
	@Column(name="Departments",nullable = false)
	private String departmentOfUni;
	
	@Column(name="EducationStartDate")
	private String educationStartYear;
	
	
	@Column(name="Graduatestate",nullable = false)
	private boolean graduateState;
	
	
	@Column(name="GraduateYear")
	private String graduateYear;
	

	
	

	
	
	
	
}
