package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="biodata")
@Data
public class Biodata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "pob")
    private String pob;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "identity_no")
    private String identityNo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number1")
    private String phoneNumber1;

    @Column(name = "phone_number2")
    private String phoneNumber2;

    @Column(name = "parent_phone_number")
    private String parentPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "job_vacancies_id")
    private JobVacancies jobVacancies;
}
