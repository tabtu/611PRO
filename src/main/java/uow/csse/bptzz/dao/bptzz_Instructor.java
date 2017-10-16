package uow.csse.bptzz.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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

@Entity // This tells Hibernate to make a table out of this class
public class bptzz_Instructor {
    @Id
    private String InstructorID;
    private String FirstName;
    private String LastName;
    @Lob
    private java.sql.Blob ProfilePic;  //need to do more research
    private String Gender;
    private Date DOB;
    private String Address;
    private String Homepage;
    private int YearEnrolled;

    public String getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(String instructorID) {
        InstructorID = instructorID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Blob getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(Blob profilePic) {
        ProfilePic = profilePic;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHomepage() {
        return Homepage;
    }

    public void setHomepage(String homepage) {
        Homepage = homepage;
    }

    public int getYearEnrolled() {
        return YearEnrolled;
    }

    public void setYearEnrolled(int yearEnrolled) {
        YearEnrolled = yearEnrolled;
    }
}
