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
@Table(name="JopExperiences")
public class JopExperincie {

	/*
	
	Adaylar iş tecübelerini girebilmelidir. (İş yeri adı, pozisyon)
Bu tecrübelerini hangi yıllarda yaptıklarını sisteme girebilmelidir.
Eğer hala çalışıyorsa işten ayrılma yılı boş geçilebilmelidir.
Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam ediyor" olarak görüntülenmelidir.

	
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

	
	
}
