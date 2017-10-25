package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import uow.csse.bptzz.utils.DateUtils;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-16
 * @update  Tab Tu on Oct.24 2017
 * @since	1.1
 *
 * Database: pro611db
 * Username: bfa57f3b0eddae
 * Password: c759e708
 * Server: ca-cdbr-azure-central-a.cloudapp.net
 */

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bptzz_user")
public class bptzz_User extends Entitys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String profilePicture;

    @Column(length = 65535,columnDefinition="Text")
    private String introduction;

    @Column(nullable = false)
    private Long createTime;

    @Column(nullable = false)
    private Long lastModifyTime;

    private String validataCode;

    //@OneToOne(mappedBy = "bptzz_Student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_student")
    private bptzz_Student student;

    /**
     *
     */
    public bptzz_User() {
        super();
    }
    public bptzz_User(String userName, String passWord, String email) {
        super();
        this.email = email;
        this.password = passWord;
        this.username = userName;
        this.createTime = DateUtils.getCurrentTime();
        this.lastModifyTime = DateUtils.getCurrentTime();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public String getValidataCode() {
        return validataCode;
    }
    public void setValidataCode(String validataCode) {
        this.validataCode = validataCode;
    }

    public bptzz_Student getStudent() { return student; }
    public void setStudent(bptzz_Student student) { this.student = student; }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}