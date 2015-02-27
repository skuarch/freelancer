package model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @Column(name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "warehouse_name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    @Basic(optional = false)
    private Address_anteriror address;

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

    public Address_anteriror getAddress() {
        return address;
    }

    public void setAddress(Address_anteriror address) {
        this.address = address;
    }
}
