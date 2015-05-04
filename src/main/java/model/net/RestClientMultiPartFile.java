package model.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 *
 * @author skuarch-lap
 */
public class RestClientMultiPartFile {

    private final String stringUrl;
    private final String method;
    private final Charset charset;
    private final int readTimeout;
    private final int connectTimeout;
    private final String boundary;
    private static final String LINE_FEED = "\r\n";
    private final StringBuilder stringBuilder;
    private URL url = null;
    private HttpURLConnection hurlc = null;
    private OutputStream outputStream = null;
    private PrintWriter printWriter = null;
    private BufferedReader bufferedReader = null;

    //==========================================================================
    public RestClientMultiPartFile(String stringUrl, String method, Charset charset, int readTimeout, int connectTimeout) {
        this.stringUrl = stringUrl;
        this.method = method;
        this.charset = charset;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
        this.boundary = "===" + System.currentTimeMillis() + "===";
        this.stringBuilder = new StringBuilder();
    }

    //==========================================================================
    public void configureConnection() throws IOException {

        if (stringUrl == null || stringUrl.length() < 1) {
            throw new NullPointerException("stringUrl is null or empty");
        }

        if (method == null || method.length() < 1) {
            throw new NullPointerException("method is null or empty");
        }

        if (readTimeout < 1000) {
            throw new NullPointerException("read timeout is too short");
        }

        if (connectTimeout < 1000) {
            throw new NullPointerException("connection timeout is too short");
        }

        try {

            url = new URL(stringUrl);
            hurlc = (HttpURLConnection) url.openConnection();
            hurlc.setUseCaches(false);
            hurlc.setDoOutput(true); // indicates POST method
            hurlc.setDoInput(true);
            hurlc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            hurlc.setRequestProperty("User-Agent", "CodeJava Agent");
            hurlc.setRequestProperty("Test", "Bonjour");
            outputStream = hurlc.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);

        } catch (IOException e) {
            throw e;
        }
    }

    //==========================================================================
    public void openConnection() throws IOException {

        try {
            outputStream = hurlc.getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        } catch (IOException e) {
            closeOutputStream(outputStream);
            closePrintWriter();
            throw e;
        }

    }

    //==========================================================================
    public void addHeaderField(String key, String value) {
        printWriter.append(key + ": " + value).append(LINE_FEED);
        printWriter.flush();
    }

    //==========================================================================
    public void addFormField(String key, String value) {
        printWriter.append("--" + boundary).append(LINE_FEED);
        printWriter.append("Content-Disposition: form-data; name=\"" + key + "\"").append(LINE_FEED);
        printWriter.append("Content-Type: text/plain; charset=" + charset).append(LINE_FEED);
        printWriter.append(LINE_FEED);
        printWriter.append(value).append(LINE_FEED);
        printWriter.flush();
    }

    //==========================================================================
    public void uploadFile(String fieldName, File file) throws IOException {
        
        String fileName = null;
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        try {

            fileName = file.getName();
            printWriter.append("--" + boundary).append(LINE_FEED);
            printWriter.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            printWriter.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            printWriter.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
            printWriter.append(LINE_FEED);
            printWriter.flush();

            fileInputStream = new FileInputStream(file);
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            printWriter.append(LINE_FEED);
            printWriter.flush();

        } catch (IOException e) {
            throw e;
        } finally {
            closeInputStream(fileInputStream);
        }

    }

    //==========================================================================
    public String receiveData() throws IOException {

        int status;
        String line;

        try {

            printWriter.append(LINE_FEED).flush();
            printWriter.append("--" + boundary + "--").append(LINE_FEED);
            closePrintWriter();

            // checks server's status code first
            status = hurlc.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                bufferedReader = new BufferedReader(new InputStreamReader(
                        hurlc.getInputStream()));

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

            } else {
                throw new IOException("Server returned non-OK status: " + status);
            }

        } catch (IOException e) {
            throw e;
        } finally {
            closeBufferedReader();
            closeOutputStream(outputStream);
            disconnectHttpUrlConnection();
        }

        return stringBuilder.toString();

    }

    //==========================================================================
    public void closeConnection() {

        try {
            closeBufferedReader();
            closeOutputStream(outputStream);
            disconnectHttpUrlConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //==========================================================================
    /**
     * close the inputStream.
     *
     * @param inputStream
     */
    private void closeInputStream(InputStream inputStream) throws IOException {

        try {

            if (inputStream != null) {
                inputStream.close();
            }

        } catch (IOException e) {
            throw e;
        }

    } // end closeInputStream

    //==========================================================================
    /**
     * close outputStream.
     *
     * @param outputStream
     */
    private void closeOutputStream(OutputStream outputStream) throws IOException {

        try {

            if (outputStream != null) {
                outputStream.close();
            }

        } catch (IOException e) {
            throw e;
        }

    } // end closeOutputStream    

    //==========================================================================
    /**
     * close printWriter.
     *
     */
    private void closePrintWriter() throws IOException {

        if (printWriter != null) {
            printWriter.close();
        }

    } // end closePrintWriter

    //==========================================================================
    /**
     * close bufferedReader
     *
     * @throws IOException
     */
    private void closeBufferedReader() throws IOException {

        if (bufferedReader != null) {
            bufferedReader.close();
        }

    } // end closeBufferedReader

    //==========================================================================
    /**
     * disconnect HttpUrlConnection.
     *
     * @throws IOException
     */
    private void disconnectHttpUrlConnection() throws IOException {

        if (hurlc != null) {
            hurlc.disconnect();
        }

    } // end disconnectHttpUrlConnection

}
