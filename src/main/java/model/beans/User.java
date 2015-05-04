package model.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author skuarch
 */
public class User implements Serializable {

    private long id;
    private String name;
    private String lastName;
    private String fullName;
    private String email;
    private String emailMD5;
    private String password;
    private byte isSoftDeleted = 0;
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
