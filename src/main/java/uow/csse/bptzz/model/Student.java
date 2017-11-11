package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-16
 * @update  Tab Tu on Nov.1 2017
 * @since	1.1
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

@Entity(name = "Student")
@Table(name = "bptzz_student")
public class Student extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;
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
    private int yearEnrolled;
    private float overallGPA;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="student_department")
    private Department department;

    public Long getStudentid() { return student_id; }
    public void setStudentid(Long studentid) { this.student_id = studentid; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstName) { this.firstname = firstName; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastName) { lastName = lastName; }
    public Boolean getGender() { return gender; }
    public void setGender(Boolean gender) { this.gender = gender; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getHomepage() { return homepage; }
    public void setHomepage(String homepage) { this.homepage = homepage; }
    public int getYearenrolled() { return yearEnrolled; }
    public void setYearenrolled(int yearenrolled) { this.yearEnrolled = yearenrolled; }
    public float getOverallGPA() { return overallGPA; }
    public void setOverallGPA(float overallGPA) { this.overallGPA = overallGPA; }
    public Department getDepartment() { return department; }
    public void setDeptid(Department department) { this.department = department; }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }
}