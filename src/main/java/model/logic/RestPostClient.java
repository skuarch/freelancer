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
    public static String createFreelancer(HashMap<String, Object> parameters) throws IOException {

        String returnString = null;
        RestClient rc = new RestClient(
                Constants.API_URL
                + Constants.API_VERSION
                + Constants.URI_FREELANCER
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

}
