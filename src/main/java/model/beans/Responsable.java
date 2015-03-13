package model.beans;

/**
 *
 * @author skuarch
 */
public class Responsable {
    
    private long id;
    private String password; 
    private Person person;
    private byte softDeleted;
    
    public Responsable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public byte getSoftDeleted() {
        return softDeleted;
    }

    public void setSoftDeleted(byte softDeleted) {
        this.softDeleted = softDeleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "id= " + id + " password=" + password + " isSoftDeleted=" + softDeleted + " person=" + person;
    }
    
    
    
}