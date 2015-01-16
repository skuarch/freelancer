package model.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name ="user")
@NamedQueries({
    @NamedQuery(name = "getUserByEmail", query = "from User u where u.email = :email and password = :password"),
    @NamedQuery(name = "getUserByEmailMD5", query = "from User u where u.emailMD5 = :email and password = :password")
})
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private long id;
    @Column(name = "user_name", nullable = false, columnDefinition = "varchar(128)")
    private String name;
    @Column(name = "user_last_name", nullable = false, columnDefinition = "varchar(128)")
    private String lastName;
    @Column(name = "user_full_name", nullable = false, columnDefinition = "varchar(256)")
    private String fullName;
    @Column(name = "user_email", nullable = false,columnDefinition = "varchar(128)")
    private String email;    
    @Column(name = "user_email_md5", nullable = false,columnDefinition = "varchar(32)")
    private String emailMD5;    
    @Column(name = "user_password", nullable = false, columnDefinition = "varchar(32)")
    private String password;
    @Column(name = "user_is_soft_deleted", nullable = false, columnDefinition = "int default 0")
    private byte isSoftDeleted = 0;
    @Column(name = "user_last_session", nullable = false)
    @Type(type="date")
    private Date lastSession;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }

    public Date getLastSession() {
        return lastSession;
    }

    public void setLastSession(Date lastSession) {
        this.lastSession = lastSession;
    }

    public String getEmailMD5() {
        return emailMD5;
    }

    public void setEmailMD5(String emailMD5) {
        this.emailMD5 = emailMD5;
    }
    
}
