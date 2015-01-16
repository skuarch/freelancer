package model.database;

import java.util.ArrayList;
import model.beans.Category;


/**
 *
 * @author skuarch
 */
public class CategoryModel {

    //==========================================================================
    private CategoryModel(){
    }
    
    //==========================================================================
    public static ArrayList<Category> getCategories() throws Exception {
    
        ArrayList<Category> categories;
        
        try {
            
            categories = new DAO().getArrayList(new Category());
            
        } catch (Exception e) {
            throw e;
        }
    
        return categories;        
    }
    
}
