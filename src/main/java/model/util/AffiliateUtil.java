package model.util;

import java.io.File;
import java.util.HashMap;
import model.logic.Constants;
import model.logic.RestClientUploadFile;
import model.logic.RestPostClient;

/**
 *
 * @author skuarch-lap
 */
public class AffiliateUtil {

    //==========================================================================
    private AffiliateUtil(){
    
    }
    
    //==========================================================================
    public static String sendParameters(HashMap<String, Object> parameters, String uri) throws Exception {

        String response = null;

        try {
            response = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    uri);

        } catch (Exception e) {
            throw e;
        }

        return response;

    }

    //==========================================================================
    public static String sendParametersAndUploadFile(HashMap<String, Object> parameters, String uri ,File file, String fieldName) throws Exception {

        String response = null;

        try {

            response = RestClientUploadFile.uploadFile(
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    uri,
                    parameters,
                    file,
                    fieldName, //name of the field
                    Constants.READ_TIMEOUT,
                    Constants.CONNECTION_TIMEOUT);

        } catch (Exception e) {
            throw e;
        }

        return response;

    }
    
    
}
