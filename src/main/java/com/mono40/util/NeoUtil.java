package com.mono40.util;

import org.apache.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NeoUtil {

    private static Logger logger = Logger.getLogger(NeoUtil.class);

    private NeoUtil() {
    }


    public static Date formatingDateString(String dateString, String dateFormat) throws Exception{
        logger.info("Entering in formatingDateString");
        logger.info("dateString "+dateString);

        DateFormat df = new SimpleDateFormat(dateFormat);
        try {

            Date date =  df.parse(dateString);

            logger.info("date format = "+date);

            return date;
        } catch (ParseException e) {
            logger.error("Error formating the string to date ",e);
            throw new Exception();
        }finally {
            logger.info("Exiting ");
        }
    }

    public static String formatDateToString(Date dateTransaction, String stringFormat){
        logger.info("Entering in formatDateToString");
        logger.info("dateTransaction =" + dateTransaction);
        logger.info("stringFormat =" + stringFormat);

        DateFormat df = new SimpleDateFormat(stringFormat);

        String dateFormated = df.format(dateTransaction);

        logger.info("dateFormated = "+dateFormated);
        return dateFormated;
    }

    public static Long generateTimeUnixFormat() {
        return System.currentTimeMillis();
    }

    public static String encodedToBase64(byte [] arrayByte){
        logger.info("encodedToBase64...");
        String encoded = DatatypeConverter.printBase64Binary(arrayByte);
        logger.info("converterBase64...end");
        return encoded;
    }

    public static byte[] decodedToBase64(String textBase64){
        logger.info("decodedToBase64...");
        byte[] decoded = DatatypeConverter.parseBase64Binary(textBase64);
        logger.info("decodedToBase64...end");
        return decoded;
    }

    public static String readFormatedPublicKey(byte[] textByte){
        logger.info("entering readFormatedPublicKey...");
        String publicKeyPEM = new String(textByte);
        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----\n", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");
        logger.info("exiting readFormatedPublicKey..");
        return publicKeyPEM;
    }
}
