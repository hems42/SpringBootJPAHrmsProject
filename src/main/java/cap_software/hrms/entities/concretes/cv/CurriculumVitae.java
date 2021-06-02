package cap_software.hrms.entities.concretes.cv;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CurriculumVitae")
public class CurriculumVitae {
	
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

	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<School> schools;
	
	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<JopExperincie> jopExperincies;
	
	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<ForeignLanguage> foreignLanguages;
	
	
	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<CandidateUrl> candidateUrls;
	
	
	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Forword> forwords;
	
	
	
	@OneToMany(mappedBy = "vitae",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<KnownProgramingLanguage>  knownProgramingLanguages;
	
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private JopSeeker user;
	
	

	
	
	
}
