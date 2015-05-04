package model.util;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author skuarch-lap
 */
public class FileUtil {
    
    //==========================================================================
    private FileUtil(){
    }
    
    //==========================================================================
    public static File transferFileWithOtherName(MultipartFile multipartFile, String path, String prefixFileName) throws Exception {

        File file = null;

        try {
            if (multipartFile != null) {
                String extension = FileUtil.getFileExtesion(multipartFile.getOriginalFilename());
                String fileName = prefixFileName + extension;
                file = FileUtil.transferFile(multipartFile, path, fileName);                
            }
        } catch (Exception e) {
            throw e;
        }

        return file;

    }

    
    //==========================================================================
    public static File transferFile(MultipartFile multipartFile, String path, String fileName) throws Exception {

        if (multipartFile == null) {
            throw new IllegalArgumentException("multiPartFile is null");
        }
        
        if (path == null || path.length() < 1) {
            throw new IllegalArgumentException("path is null");
        }
        
        if (fileName == null || fileName.length() < 1) {
            throw new IllegalArgumentException("fileName is null");
        }

        File file;

        try {            
            
            file = new File(path + fileName);
            multipartFile.transferTo(file);

        } catch (IOException | IllegalStateException e) {
            throw e;
        }

        return file;

    }

    //==========================================================================
    public static String getFileExtesion(String fileName) {

        if (fileName == null || fileName.length() < 1) {
            throw new IllegalArgumentException("fileName is null");
        }

        String extension = "";
        
        try {

            if (fileName.contains(".")) {                
                int i = fileName.lastIndexOf('.');
                int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

                if (i > p) {
                    extension = ".";
                    extension += fileName.substring(i + 1);
                }
            }

        } catch (Exception e) {
            throw e;
        }

        return extension;

    }

    //==========================================================================
    public static void deleteFile(File file) {

        if (file != null) {
            file.delete();
        }

    }
    
}
