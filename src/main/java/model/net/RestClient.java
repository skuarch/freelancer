package model.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * RestFul client, this class use HttpUrlConnection to open a remote connection
 * with the server.
 *
 * @author skuarch
 */
public class RestClient {

    private String stringUrl = null;
    private URL url = null;
    private HttpsURLConnection hurlc = null;
    private OutputStream outputStream = null;
    private BufferedWriter bufferedWriter = null;
    private StringBuilder stringBuilder = null;
    private InputStream inputStream = null;
    private BufferedReader bufferedReader = null;
    private HostnameVerifier allHostsValid = null;

    //==========================================================================
    /**
     * creates a new instance of RestClient.
     *
     * @param stringUrl url
     */
    public RestClient(String stringUrl) {        
        
        this.stringUrl = stringUrl;

    }

    //==========================================================================
    /**
     * start connection.
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void initConnection() throws MalformedURLException, IOException, NoSuchAlgorithmException, KeyManagementException {

        if (stringUrl == null || stringUrl.length() < 1) {
            throw new NullPointerException("stringUrl is null or empty");
        }

        configuireCerts();
        
        url = new URL(stringUrl);
        hurlc = (HttpsURLConnection) url.openConnection();
        hurlc.setHostnameVerifier(allHostsValid);
        //hurlc.setRequestProperty("Content-Type", "application/json");
        //hurlc.setRequestProperty("Accept", "application/json");
        hurlc.setReadTimeout(100000);
        hurlc.setConnectTimeout(100000);
        hurlc.setRequestMethod("POST");
        hurlc.setDoInput(true);
        hurlc.setDoOutput(true);
        hurlc.setUseCaches(false);
        hurlc.setDefaultUseCaches(false);
        hurlc.setRequestProperty("Pragma", "no-cache");
        hurlc.setRequestProperty("Cache-Control", "no-cache");
        hurlc.setRequestProperty("Expires", "-1");

    }

    //==========================================================================
    /**
     * send message to remote server.
     *
     * @param parameters HashMap<String,String>
     * @throws IOException
     */
    public void writeMessage(HashMap<String, Object> parameters) throws IOException {

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        try {

            outputStream = hurlc.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(getQuery(parameters));
            bufferedWriter.flush();

        } catch (IOException e) {
            throw e;
        }

    }

    //==========================================================================
    /**
     * opens an output and receive message.
     *
     * @return String
     * @throws IOException
     */
    public String receiveMessage() throws IOException {

        String tmp;

        try {

            stringBuilder = new StringBuilder();
            inputStream = hurlc.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((tmp = bufferedReader.readLine()) != null) {
                stringBuilder.append(tmp);
            }

        } catch (IOException e) {
            throw e;
        }

        return stringBuilder.toString();

    }

    //==========================================================================
    /**
     * establish connection with remote host.
     *
     * @throws IOException
     */
    public void connect() throws IOException {
        hurlc.connect();
    }

    //==========================================================================
    /**
     * disconnect from remote host.
     *
     * @throws IOException
     */
    public void disconnect() throws IOException {
        hurlc.disconnect();
    }

    //==========================================================================
    /**
     * close all streams.
     */
    public void closeStreams() throws Exception {

        try {
            closeBufferedReader(bufferedReader);
            closeInputStream(inputStream);
            closeOutputStream(outputStream);
            closeBufferedWriter(bufferedWriter);
        } catch (Exception e) {
            throw e;
        }

    }

    //==========================================================================
    /**
     * set property to HttpUrlConnection.
     *
     * @param key String
     * @param value String
     * @throws Exception if hurlc is null
     */
    public void setRequestProperty(String key, String value) throws Exception {

        if (key == null || key.length() < 1) {
            throw new IllegalArgumentException("key is null or empty");
        }

        if (value == null || value.length() < 1) {
            throw new IllegalArgumentException("value is null or empty");
        }

        try {
            if (hurlc != null) {
                hurlc.setRequestProperty(key, value);
            } else {
                throw new Exception("hurlc is null");
            }
        } catch (Exception e) {
            throw e;
        }

    }

    //==========================================================================
    /**
     * creates a string key = value divided by &.
     *
     * @param parameters
     * @return
     */
    private String getQuery(HashMap<String, Object> parameters) {

        StringBuilder sb = new StringBuilder();

        parameters.entrySet().stream().forEach((entrySet) -> {
            String key = entrySet.getKey();
            Object value = entrySet.getValue();
            sb.append(key).append("=").append(value).append("&");
        });

        return sb.toString();

    }

    //==========================================================================
    /**
     * close the inputStream.
     *
     * @param inputStream
     */
    private void closeInputStream(InputStream inputStream) throws Exception {

        try {

            if (inputStream != null) {
                inputStream.close();
            }

        } catch (Exception e) {
            throw e;
        }

    } // end closeInputStream

    //==========================================================================
    /**
     * close outputStream.
     *
     * @param outputStream
     */
    private void closeOutputStream(OutputStream outputStream) throws Exception {

        try {

            if (outputStream != null) {
                outputStream.close();
            }

        } catch (Exception e) {
            throw e;
        }

    } // end closeOutputStream

    //==========================================================================
    /**
     * close the bufferedWriter.
     *
     * @param bufferedWriter
     */
    public static void closeBufferedWriter(BufferedWriter bufferedWriter) throws Exception {

        try {

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

        } catch (Exception e) {
            throw e;
        }

    } // end closeFileWriter        

    //==========================================================================
    /**
     * close BufferedReader.
     *
     * @param bufferedReader
     * @throws Exception
     */
    public static void closeBufferedReader(BufferedReader bufferedReader) throws Exception {

        try {

            if (bufferedReader != null) {
                bufferedReader.close();
            }

        } catch (Exception e) {
            throw e;
        }

    } //closeServerSocket

    //==========================================================================
    private void configuireCerts() throws NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }
}
