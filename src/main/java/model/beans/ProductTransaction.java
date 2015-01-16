package model.beans;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "product_transaction")
public class ProductTransaction {

    @Id
    @Column(name = "product_transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade={CascadeType.ALL})    
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "product_transaction_date", nullable = false)
    @Type(type="timestamp")
    private Timestamp date;
    @Column(name = "product_transaction_message", nullable = false)
    private String message;
    @Column(name = "product_transaction_is_soft_delete", nullable = false)
    private short isSoftDelete = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public short getIsSoftDelete() {
        return isSoftDelete;
    }

    public void setIsSoftDelete(short isSoftDelete) {
        this.isSoftDelete = isSoftDelete;
    }
    
}
