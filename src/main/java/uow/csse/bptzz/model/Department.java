package uow.csse.bptzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-8
 * @update  Tab Tu on Nov.17 2017
 * @since	1.2
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

@Entity(name = "Department")
@Table(name = "bptzz_department")
public class Department extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer department_id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "s_department", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Student> students;
    @OneToMany(mappedBy = "c_department", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Course> courses;

    public Department() {

    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}