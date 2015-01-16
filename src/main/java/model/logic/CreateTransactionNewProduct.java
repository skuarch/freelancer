package model.logic;

import java.sql.Timestamp;
import java.util.concurrent.Callable;
import model.beans.Product;
import model.beans.ProductTransaction;
import model.beans.TransactionType;
import model.beans.User;
import model.database.DAO;
import model.database.TransactionTypeModel;

/**
 *
 * @author skuarch
 */
public class CreateTransactionNewProduct implements Callable<Long> {

    private Product product = null;
    private User user = null;
    
    //==========================================================================
    public CreateTransactionNewProduct(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    //==========================================================================
    @Override
    public Long call() throws Exception {

        if(product == null || user == null){
            throw new IllegalArgumentException("illegal argument");
        }
        
        long id;
        TransactionType tt = null;
        ProductTransaction pt = null;

        try {

            tt = TransactionTypeModel.getTransactionTypeNewProduct();            

            pt = new ProductTransaction();
            pt.setDate(new Timestamp(System.currentTimeMillis()));
            pt.setMessage("product created");
            pt.setProduct(product);
            pt.setTransactionType(tt);
            pt.setUser(user);

            id = new DAO().create(pt);
            
        } catch (Exception e) {
            throw e;
        }

        return id;

    }

}
