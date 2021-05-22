package cap_software.hrms.entities.concretes.contacts;


import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.JopSeeker;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @OneToOne
    @JoinColumn(name = "UserId",unique = true,nullable = false)
    private User user;

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


    public PersonalInformation() {
    }

    public PersonalInformation(User user, String name, String surname, String nationalIdentityNumber, Date birthDay, String sex) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.nationalIdentityNumber = nationalIdentityNumber;
        this.birthDay = birthDay;
        this.sex = sex;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationalIdentityNumber() {
        return nationalIdentityNumber;
    }

    public void setNationalIdentityNumber(String nationalIdentityNumber) {
        this.nationalIdentityNumber = nationalIdentityNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex.toString();
    }
}
