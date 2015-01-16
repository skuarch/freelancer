package model.database;

import model.beans.TransactionType;

/**
 *
 * @author skuarch
 */
public class TransactionTypeModel {

    //==========================================================================
    private TransactionTypeModel() {
    }
 
    //==========================================================================
    public static TransactionType getTransactionTypeNewProduct(){
        
        TransactionType tt = new TransactionType();
        tt.setId(1);
        tt.setName("product creation");
        
        return tt;
        
    }
    
}