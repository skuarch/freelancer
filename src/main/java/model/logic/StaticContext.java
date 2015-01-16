package model.logic;

/**
 *
 * @author skuarch
 */
public class StaticContext {
    
    private static String context;
    
    private StaticContext(){
    }
    
    public static void setContext(String ctx){
        context = ctx;
    }

    public static String getContext() {
        return context;
    }
    
}
