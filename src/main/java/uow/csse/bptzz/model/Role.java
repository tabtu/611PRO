package uow.csse.bptzz.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Create the Entity
 *
 * @author 	Tab Tu
 * @date	2017-11-01
 * @update  Tab Tu on Nov.1 2017
 * @since	1.0
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

@Entity(name = "Role")
@Table(name = "bptzz_role")
public class Role extends Entitys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;
    @NaturalId
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name) { this.name = name; }

    public Long getRole_id() { return role_id; }
    public void setRole_id(Long id) { this.role_id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }
}
