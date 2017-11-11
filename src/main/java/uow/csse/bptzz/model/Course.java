package uow.csse.bptzz.model;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

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
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String term;
    @Column(nullable = false)
    private int credits;
    //used for searching
    private int StartTime;  //using 24 hours format, 0-23, start from at the beginning of an hour, easy to process
    private int EndTime;    //using 24 hours format, 0-23, EndTime > StartTime
    private String Day;     //using multiple choice list, "MONDAY;TUESDAY;WEDNESDAY;THURSDAY;FRIDAY"
    private String textbook;
    private String refTextbook;
    private String courseLink;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="course_department")
    private Department c_department;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
    @OneToMany(mappedBy = "course")
    private Set<Question> questions;

    public Course() {
    }

    public Course(String course_id, String courseName, String term, int credits, Department c_department) {
        this.course_id = course_id;
        this.courseName = courseName;
        this.term = term;
        this.credits = credits;
        this.c_department = c_department;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getStartTime() {
        return StartTime;
    }

    public void setStartTime(int startTime) {
        StartTime = startTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public void setEndTime(int endTime) {
        EndTime = endTime;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String getRefTextbook() {
        return refTextbook;
    }

    public void setRefTextbook(String refTextbook) {
        this.refTextbook = refTextbook;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public Department getC_department() {
        return c_department;
    }

    public void setC_department(Department c_department) {
        this.c_department = c_department;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }
}