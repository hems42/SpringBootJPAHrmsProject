package cap_software.hrms.entities.concretes.contacts;


import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.Sex;

import javax.annotation.Priority;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="PersonelInformations")
public class PersonalInformation implements Serializable {

    @Id
    private  int id;
    //private User userId;


    @Column(name="Name", length = 50, nullable = false)
    private  String name;


    @Column(name="Surname", length = 50, nullable = false)
    private  String surname;

    @Column(name="NationalIdentityNumber", length =11, nullable = false,unique = true)
    private  String nationalIdentityNumber;

    @Column(name="BirhtDay", length = 50, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDay;


    @Column(name="Sex",nullable = false,length = 5)
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex.toString();
    }
}
