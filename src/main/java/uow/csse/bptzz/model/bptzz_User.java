package uow.csse.bptzz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Create the Entity
 *
 * @author 	Eason Pan
 * @date	2017-10-16
 * @update  Tab Tu on Oct.24 2017
 * @since	1.0
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
    private Long _id;
    @Column(nullable = false, unique = true)
    private String _username;
    @Column(nullable = false)
    private String _password;
    @Column(nullable = false, unique = true)
    private String _email;
    @Column(nullable = true)
    private String _profilePicture;
    @Column(nullable = true,length = 65535,columnDefinition="Text")
    private String _introduction;
    @Column(nullable = false)
    private Long _createTime;
    @Column(nullable = false)
    private Long _lastModifyTime;
    @Column(nullable = true)
    private String _validataCode;

    public bptzz_User() {
        super();
    }
    public bptzz_User(String userName, String passWord, String email) {
        super();
        this._email = email;
        this._password = passWord;
        this._username = userName;
    }
    public Long getId() {
        return _id;
    }
    public void setId(Long id) {
        this._id = id;
    }
    public String getUsername() {
        return _username;
    }
    public void setUsername(String username) {
        this._username = username;
    }
    public String getPassword() {
        return _password;
    }
    public void setPassword(String password) {
        this._password = password;
    }
    public String getEmail() {
        return _email;
    }
    public void setEmail(String email) {
        this._email = email;
    }
    public String getIntroduction() {
        return _introduction;
    }
    public void setIntroduction(String introduction) {
        this._introduction = introduction;
    }
    public Long getCreateTime() {
        return _createTime;
    }
    public void setCreateTime(Long createTime) {
        this._createTime = createTime;
    }
    public Long getLastModifyTime() {
        return _lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this._lastModifyTime = lastModifyTime;
    }
    public String getProfilePicture() {
        return _profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this._profilePicture = profilePicture;
    }
    public String getValidataCode() {
        return _validataCode;
    }
    public void setValidataCode(String validataCode) {
        this._validataCode = validataCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}