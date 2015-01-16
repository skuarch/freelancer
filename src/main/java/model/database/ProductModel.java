package model.database;

import model.beans.Product;

/**
 *
 * @author skuarch
 */
public class ProductModel {

    //==========================================================================
    public static long createProduct(Product product) throws Exception{
        
        if(product == null){
            throw new IllegalArgumentException("product is null");
        }
        
        if(product.getName() == null || product.getName().length() < 1){
            throw new IllegalArgumentException("product name is null or empty");
        }
    
        long id;
        
        try {
            
            id = new DAO().create(product);
            
        } catch (Exception e) {
            throw e;
        }
        
        return id;
        
    }
    
    //==========================================================================
    public static Product getProduct(long id) throws Exception{
    
        Product product = null;
        
        try {
            
            product = new DAO().get(id, new Product());
            
        } catch (Exception e) {
            throw e;
        }
        
        return product;
        
    }
    
}
