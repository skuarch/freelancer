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
@Table(name = "transaction_type")
@Entity
public class TransactionType {

    @Id
    @Column(name = "transaction_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "transaction_type_name")
    private String name;
    @Column(name = "transaction_type_is_soft_delete")
    private short isSoftDelete = 0;

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

    public short getIsSoftDelete() {
        return isSoftDelete;
    }

    public void setIsSoftDelete(short isSoftDelete) {
        this.isSoftDelete = isSoftDelete;
    }

    @Override
    public String toString() {
        return "id=" + id + " name=" + name + " isSoftDelete=" + isSoftDelete ;
    }
    
}
