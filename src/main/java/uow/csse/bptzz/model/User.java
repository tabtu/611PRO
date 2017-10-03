package uow.csse.bptzz.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * User Model
 *
 * @author 	Lian
 * @date	2016年5月18日
 * @since	1.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User [id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", name=" + name +
                ", birth=" + birth + "]";
    }
}