package model.logic;

import java.io.IOException;
import java.util.HashMap;
import model.net.RestClient;

/**
 * wrapper for RestCLient
 *
 * @author skuarch
 */
public class RestPostClient {

    private RestPostClient() {

    }

    //==========================================================================        
    @Deprecated
    public static String createFreelancer(HashMap<String, Object> parameters) throws IOException, Exception {

        String returnString = null;
        RestClient rc = new RestClient(
                Constants.API_URL
                + Constants.API_FIRST_VERSION
                + Constants.URI_FREELANCER_CREATE
        );

        try {
            
            rc.initConnection();
            rc.writeMessage(parameters);
            returnString = rc.receiveMessage();
            rc.connect();

        } catch (IOException e) {
            throw e;
        } finally {
            rc.disconnect();
            rc.closeStreams();
        }

        return returnString;

    }

    //==========================================================================    
    @Deprecated
    public static String sendReceive(HashMap<String, Object> parameters, String uri) throws IOException, Exception {

        String returnString = null;
        RestClient rc = new RestClient(
                Constants.API_URL
                + Constants.API_FIRST_VERSION
                + uri
        );

        try {

            rc.initConnection();
            rc.writeMessage(parameters);
            returnString = rc.receiveMessage();
            rc.connect();

        } catch (IOException e) {
            throw e;
        } finally {
            rc.disconnect();
            rc.closeStreams();
        }

        return returnString;

    }
    
    //==========================================================================        
    public static String sendReceive(HashMap<String, Object> parameters,String apiUrl,String version, String uri) throws IOException, Exception {
        
        String returnString = null;
        RestClient rc = new RestClient(
                apiUrl
                + version
                + uri
        );

        try {

            rc.initConnection();
            rc.writeMessage(parameters);
            returnString = rc.receiveMessage();
            rc.connect();

        } catch (IOException e) {
            throw e;
        } finally {
            rc.disconnect();
            rc.closeStreams();
        }

        return returnString;

    }
    
    //==========================================================================        
    public static String sendReceive(String apiUrl,String version, String uri) throws IOException, Exception {
        
        String returnString = null;
        RestClient rc = new RestClient(
                apiUrl
                + version
                + uri
        );

        try {

            rc.initConnection();            
            returnString = rc.receiveMessage();
            rc.connect();

        } catch (IOException e) {
            throw e;
        } finally {
            rc.disconnect();
            rc.closeStreams();
        }

        return returnString;

    }

}
