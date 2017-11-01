package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-16
 * @since	1.0
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

/*
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bptzz_student")
public class bptzz_Student extends Entitys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long studentid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private String profilepic;
    //@Lob
    //private java.sql.Blob ProfilePic;  //need to do more research

    private Boolean gender;

    private Date dob;

    private String address;

    private String homepage;

    @Column(nullable = false)
    private int yearenrolled;

    private float overallGPA;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="student_department")
    private bptzz_Department department;

    public Long getStudentid() {
        return studentid;
    }
    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastName) {
        lastName = lastName;
    }
    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getHomepage() {
        return homepage;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public int getYearenrolled() {
        return yearenrolled;
    }
    public void setYearenrolled(int yearenrolled) {
        this.yearenrolled = yearenrolled;
    }
    public float getOverallGPA() {
        return overallGPA;
    }
    public void setOverallGPA(float overallGPA) {
        this.overallGPA = overallGPA;
    }
    public bptzz_Department getDepartment() {
        return department;
    }
    public void setDeptid(bptzz_Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
*/