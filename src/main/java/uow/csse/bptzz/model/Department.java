package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-8
 * @update  Tab Tu on Nov.1 2017
 * @since	1.1
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

    public Department(String name) { this.name = name; }

    public Integer getDepartment_id() { return department_id; }
    public void setDepartment_id(Integer deptID) { this.department_id = deptID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }
}