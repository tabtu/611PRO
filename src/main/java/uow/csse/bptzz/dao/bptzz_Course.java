package uow.csse.bptzz.dao;


import javax.persistence.Entity;
import javax.persistence.Id;

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
public class bptzz_Course {
    @Id
    private String CourseID;
    private String CourseName;
    private String Term;
    private int    Credits;
    private String Textbook;
    private String RefTextbook;
    private String CourseLink;
    private String DeptID;

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public String getTextbook() {
        return Textbook;
    }

    public void setTextbook(String textbook) {
        Textbook = textbook;
    }

    public String getRefTextbook() {
        return RefTextbook;
    }

    public void setRefTextbook(String refTextbook) {
        RefTextbook = refTextbook;
    }

    public String getCourseLink() {
        return CourseLink;
    }

    public void setCourseLink(String courseLink) {
        CourseLink = courseLink;
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = deptID;
    }
}
