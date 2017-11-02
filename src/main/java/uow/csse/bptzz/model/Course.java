package uow.csse.bptzz.model;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

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

@Entity(name = "Course")
@Table(name = "bptzz_course")
public class Course {
    @Id
    private String course_id;
    private String courseName;
    private String term;
    private int credits;
    private String textbook;
    private String refTextbook;
    private String courseLink;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="course_department")
    private Department department;

    public String getCourse_id() { return course_id; }
    public void setCourse_id(String courseID) { course_id = courseID; }
    public String getCourseName() { return this.courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getTextbook() { return textbook; }
    public void setTextbook(String textbook) { this.textbook = textbook; }
    public String getRefTextbook() { return refTextbook; }
    public void setRefTextbook(String refTextbook) { this.refTextbook = refTextbook; }
    public String getCourseLink() { return courseLink; }
    public void setCourseLink(String courseLink) { this.courseLink = courseLink; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }
}