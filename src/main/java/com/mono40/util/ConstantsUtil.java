package com.mono40.util;

public interface ConstantsUtil {

    enum  JWT_TYPE{
        JWT_MAINTENANCE,JWT_ACCIDENT, JWT_CUSTOMER
    }

    enum  OS{
        ANDROID,IOS
    }


    enum EVENT_TYPE {
        MAINTENANCE, CRASH_REPAIRS, ON_DEMAND_REPAIRS
    }

    enum REPAIR_LEVEL{
        MINOR_FIX, MEDIUM_FIX, HARD_FIX, MINOR_REPLACEMENT, MEDIUM_REPLACEMENT, HARD_REPLACEMENT, PART_RECONSTRUCTION
    }

    String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    String MSISDN_REGEX = "^[0-9]{10}$";
    String PASSWORD_REGEX = "\\A(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\\z"; // false, if not is valid regex

    String SIGN_UP = "SIGN_UP";

     String FORMAT_STRING_DATE = "yyyy-MM";
     String FORMAT_DATE_YYYY_MM = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

     String BEGIN_RSA_PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----";
     String BEGIN_RSA_PRIVATE_KEY_END = "-----END RSA PRIVATE KEY-----";
     String ENCRYPTION_ALGORITHM_JWT_QR = "AES/GCM/NoPadding";

     String AES  = "AES";
     String TYP = "typ";
     String ALG = "alg";
     String GCS = "GCS";
     String TPAGO = "tPago";
     String MERCHANT_DESCRIPTION = "merchant-description";
     String KEY_STORE_TYPE = "JCEKS";
     String MAINTENANCE_OUT = "MNT-OUT";
    String TRANSFER_TPAGO_CUSTOMER_CODE = "TRF-IN";
     String CRASHR_OUT = "CRHR-OUT";

}
