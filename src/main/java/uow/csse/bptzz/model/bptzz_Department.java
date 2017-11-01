package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-8
 * @update  Tab Tu on Oct.24 2017
 * @since	1.1
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

/*
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bptzz_department")
public class bptzz_Department extends Entitys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer deptID) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
*/