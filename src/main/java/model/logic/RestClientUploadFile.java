package model.logic;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import model.net.RestClientMultiPartFile;

/**
 *
 * @author skuarch-lap
 */
public class RestClientUploadFile {

    private RestClientUploadFile() {
    }

    //==========================================================================
    public static String uploadFile(String apiUrl, String version, String uri, HashMap<String, Object> formFields, File file,String fieldNameFile, int readTimeout, int connectTimeout) throws Exception {

        String result = null;
        RestClientMultiPartFile restClientMultiPartFile = null;

        try {

            String url = apiUrl + version + uri;

            restClientMultiPartFile = new RestClientMultiPartFile(
                    url,
                    "POST",
                    StandardCharsets.UTF_8,
                    readTimeout,
                    connectTimeout
            );

            restClientMultiPartFile.configureConnection();
            restClientMultiPartFile.openConnection();

            for (Map.Entry<String, Object> entrySet : formFields.entrySet()) {
                String key = entrySet.getKey();
                Object value = entrySet.getValue();
                restClientMultiPartFile.addFormField(key, String.valueOf(value));
            }

            restClientMultiPartFile.uploadFile(fieldNameFile, file);
            result = restClientMultiPartFile.receiveData();

        } catch (Exception e) {
            throw e;
        } finally {

            if (restClientMultiPartFile != null) {
                restClientMultiPartFile.closeConnection();
            }

        }

        return result;

    }

}
