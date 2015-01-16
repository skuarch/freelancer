package model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "system_configuration")
public class SystemConfiguration {
 
    @Id
    @Column(name = "system_configuration_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "system_configuration_jdbc" , nullable = false)
    private String jdbc;
    @Column(name = "system_configuration_part_resources" , nullable = false)
    private String pathResources;
    @Column(name = "system_configuration_is_active" , nullable = false)
    private boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJdbc() {
        return jdbc;
    }

    public void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }

    public String getPathResources() {
        return pathResources;
    }

    public void setPathResources(String pathResources) {
        this.pathResources = pathResources;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}