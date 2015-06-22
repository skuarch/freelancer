package model.logic;

/**
 *
 * @author skuarch
 */
public class Constants {
    
    public static final short AFFILIATE = 1;
    public static final short COMPANY = 2;
    public static final int INTERVAL_SESSION_CHECK = 60000;
    public static final int INCREASE_COUNTER = 60;
    public static final String PATH_UPLOADS_TMP = "/opt/regaloenclave/uploads/";
    public static final int CONNECTION_TIMEOUT = 2000;
    public static final int READ_TIMEOUT = 2000;
    public static final int MAX_FILE_SIZE_UPLOAD = 1048576; // 1 mb
    
    public static final short PERSON_TYPE_ADMNIN = 1;
    public static final short PERSON_TYPE_AFFILIATE = 2;
    public static final short PERSON_TYPE_FREELANCER = 3;
    public static final short PERSON_TYPE_CASHIER = 4;
    public static final short PERSON_TYPE_RESPONSABLE = 5;
    public static final short PERSON_TYPE_CONTACT = 6;
    public static final short PERSON_TYPE_CONTACT_COMPANY = 7;
    public static final short PERSON_TYPE_PARTNER = 8;
    
    
    public static final String API_URL = "https://192.168.1.12/api-rec";
    public static final String API_FIRST_VERSION = "/v1";
    public static final String URI_AUTHENTICATION = "/authentication";
    
    public static final String URI_FREELANCER_CREATE = "/freelancer/create";    
    public static final String URI_FREELANCER_AUTHENTICATION = "/authentication/freelancer";
    public static final String URI_FREELANCER_GET_AFFILIATES = "/freelancer/get/affiliates";
    public static final String URI_FREELANCER_GET_COMPANIES = "/freelancer/get/companies";
    public static final String URI_FREELANCER_UPDATE = "/freelancer/update";
    public static final String URI_FREELANCER_UPDATE_PASSWORD = "/freelancer/update/password";
    //public static final String URI_FREELANCER_CREATE_AFFILIATE = "/affiliate/create";    
    
    public static final String URI_AFFILIATE_CREATE = "/affiliate/create";
    public static final String URI_AFFILIATE_CREATE_ESTABLISHMENT = "/affiliate/create/establishment";
    public static final String URI_AFFILIATE_UPDATE_PASSWORD = "/affiliate/update/password";
    public static final String URI_AFFILIATE_UPDATE_BASIC_INFORMATION = "/affiliate/update/basic/information";
    public static final String URI_AFFILIATE_UPDATE_TAX_INFORMATION = "/affiliate/update/tax/information";
    public static final String URI_AFFILIATE_UPDATE_BANK_INFORMATION = "/affiliate/update/bank/information";
    public static final String URI_AFFILIATE_UPDATE = "/affiliate/update";
    public static final String URI_AFFILIATE_LIST = "/affiliate/list";
    public static final String URI_AFFILIATE_GET = "/affiliate/get";
    
    public static final String URI_CATEGORY_GET = "/category/get";    
    
    public static final String URI_ESTABLISHMENT_CREATE = "/establishment/create"; 
    public static final String URI_ESTABLISHMENT_GET = "/establishment/get"; 
    public static final String URI_ESTABLISHMENT_UPDATE = "/establishment/update"; 
    
    public static final String URI_RESPONSABLE_UPDATE = "/responsable/update"; 
    public static final String URI_RESPONSABLE_UPDATE_PASSWORD = "/responsable/update/password"; 
    
    public static final String URI_CASHIER_GET = "/cashier/get"; 
    public static final String URI_CASHIER_UPDATE = "/cashier/update"; 
    public static final String URI_CASHIER_UPDATE_PASSWORD = "/cashier/update/password";     
    public static final String URI_CASHIER_CREATE = "/cashier/create";     
    
    public static final String URI_COMPANY_GET = "/company/get";   
    public static final String URI_COMPANY_CREATE = "/company/create";   
    public static final String URI_COMPANY_CREATE_ESTABLISHMENT = "/company/create/establishment";   
    public static final String URI_COMPANY_UPDATE_BASIC_INFORMATION = "/company/update/basic/information";   
    public static final String URI_COMPANY_UPDATE_TAX_INFORMATION = "/company/update/tax/information";
    public static final String URI_COMPANY_UPDATE_BANK_INFORMATION = "/company/update/bank/information";
    public static final String URI_COMPANY_UPDATE_PASSWORD = "/company/update/password";

    public static short getAFFILIATE() {
        return AFFILIATE;
    }
    
    public static short getAffiliate(){
        return AFFILIATE;
    }

    public static short getCOMPANY() {
        return COMPANY;
    }
    
    public static short getCompany() {
        return COMPANY;
    }

    public static int getINTERVAL_SESSION_CHECK() {
        return INTERVAL_SESSION_CHECK;
    }
    
    public static int getIntervalSessionCheck() {
        return INTERVAL_SESSION_CHECK;
    }

    public static int getINCREASE_COUNTER() {
        return INCREASE_COUNTER;
    }
    
    public static int getIncreaseCounter() {
        return INCREASE_COUNTER;
    }

    public static String getAPI_URL() {
        return API_URL;
    }

    public static String getAPI_FIRST_VERSION() {
        return API_FIRST_VERSION;
    }

    public static String getURI_AUTHENTICATION() {
        return URI_AUTHENTICATION;
    }

    public static String getURI_FREELANCER_CREATE() {
        return URI_FREELANCER_CREATE;
    }

    public static String getURI_FREELANCER_AUTHENTICATION() {
        return URI_FREELANCER_AUTHENTICATION;
    }

    public static String getURI_FREELANCER_GET_AFFILIATES() {
        return URI_FREELANCER_GET_AFFILIATES;
    }

    public static String getURI_FREELANCER_GET_COMPANIES() {
        return URI_FREELANCER_GET_COMPANIES;
    }

    public static String getURI_FREELANCER_UPDATE() {
        return URI_FREELANCER_UPDATE;
    }

    public static String getURI_FREELANCER_UPDATE_PASSWORD() {
        return URI_FREELANCER_UPDATE_PASSWORD;
    }

    public static String getURI_AFFILIATE_CREATE() {
        return URI_AFFILIATE_CREATE;
    }

    public static String getURI_AFFILIATE_CREATE_ESTABLISHMENT() {
        return URI_AFFILIATE_CREATE_ESTABLISHMENT;
    }

    public static String getURI_AFFILIATE_UPDATE() {
        return URI_AFFILIATE_UPDATE;
    }

    public static String getURI_AFFILIATE_LIST() {
        return URI_AFFILIATE_LIST;
    }

    public static String getURI_AFFILIATE_GET() {
        return URI_AFFILIATE_GET;
    }

    public static String getURI_CATEGORY_GET() {
        return URI_CATEGORY_GET;
    }

    public static String getURI_ESTABLISHMENT_CREATE() {
        return URI_ESTABLISHMENT_CREATE;
    }

    public static String getURI_ESTABLISHMENT_GET() {
        return URI_ESTABLISHMENT_GET;
    }

    public static String getURI_ESTABLISHMENT_UPDATE() {
        return URI_ESTABLISHMENT_UPDATE;
    }

    public static String getURI_RESPONSABLE_UPDATE() {
        return URI_RESPONSABLE_UPDATE;
    }

    public static String getURI_CASHIER_GET() {
        return URI_CASHIER_GET;
    }

    public static String getURI_CASHIER_UPDATE() {
        return URI_CASHIER_UPDATE;
    }

    public static String getURI_CASHIER_UPDATE_PASSWORD() {
        return URI_CASHIER_UPDATE_PASSWORD;
    }

    public static String getURI_CASHIER_CREATE() {
        return URI_CASHIER_CREATE;
    }

    public static String getURI_COMPANY_CREATE() {
        return URI_COMPANY_CREATE;
    }

    public static String getURI_COMPANY_CREATE_ESTABLISHMENT() {
        return URI_COMPANY_CREATE_ESTABLISHMENT;
    }

    public static int getMAX_FILE_SIZE_UPLOAD() {
        return MAX_FILE_SIZE_UPLOAD;
    }
    
    public static int getMaxFileSizeUpload() {
        return MAX_FILE_SIZE_UPLOAD;
    }
    
    
    
}
