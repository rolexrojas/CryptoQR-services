package com.mono40.util;


import com.mono40.config.ApplicationProperties;
import com.mono40.domain.CarServiceInformation;
import com.mono40.domain.Maintenance;
import com.mono40.types.TokenModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.cloudinary.json.JSONObject;
import sun.applet.Main;

import java.util.*;

import static com.mono40.util.ConstantsUtil.*;

@Component
public class JwtManager {

    private Logger log = LogManager.getLogger(JwtManager.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    private final static int ACCOUNT_ID_INDEX = 0;
    private final static int ARRAY_LENGTH = 1;

    public String generateJwtPayload(Long accountId) {
        return accountId.toString();
    }

    public String generateToken(Long accountId) {
        String jwtPayLoad = generateJwtPayload(accountId);

        // TODO what exactly
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.MINUTE, applicationProperties.getTimeExpirationToken());

        return Jwts.builder()
                .setSubject(jwtPayLoad)
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, applicationProperties.getSecret().getBytes())
                .compact();
    }

    public String generateEmailKey(Long accountId) {

        return Jwts.builder()
                .setSubject(accountId.toString())
                .signWith(SignatureAlgorithm.HS256, applicationProperties.getSecret().getBytes())
                .compact();
    }

    public Long parseGeneratedEmailKey(String generatedMailKey) {

        String parsedToken = parseToken(generatedMailKey);

        return new Long(parsedToken);
    }

    private String parseToken(String token) {
        return Jwts.parser().setSigningKey(applicationProperties.getSecret().getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public TokenModel parseTokenToModel(String token) {

        token = token.replace("Bearer ", "");

        String parseToken = parseToken(token);

        String[] split = parseToken.split(":");

        if (split.length != ARRAY_LENGTH)
            return null;

        Long accountId = Long.valueOf(split[ACCOUNT_ID_INDEX]);

        return new TokenModel(accountId);
    }


    public boolean validToken(String authToken) throws JwtException {
        parseToken(authToken);
        return true;
    }

    //La parte donde se genera el payload con la informacion
    public static String generateJwtPayloadQR(Date expirationDate, JWT_TYPE jwtType, String ... appleDevKeyId){
        JSONObject json = new JSONObject();
        json.put(Claims.ISSUER, "CRYPTOQRSERVICES");
        json.put(Claims.ID, UUID.randomUUID());
        json.put(Claims.ISSUED_AT, new Date());
        json.put(Claims.EXPIRATION, expirationDate);
        json.put(Claims.AUDIENCE, "CRYPTOQRSERVICES");
        json.put(Claims.SUBJECT, "MANTENIMIENTO DE VEHICULOS");
        if(jwtType.equals(JWT_TYPE.JWT_MAINTENANCE)){
            json.put(MERCHANT_DESCRIPTION, "MANTENIMIENTO DE VEHICULOS");
        }
        return json.toString();
    }

    public static String generateJwtPayloadQR(JWT_TYPE jwt_type, String Id, CarServiceInformation carService , Maintenance mantenimiento, String eventKey){
        JSONObject json = new JSONObject();
        json.put(Claims.ID, Id + eventKey);
        json.put(Claims.ISSUER, "CRYPTOQRSERVICES");
        json.put(Claims.ISSUED_AT, new Date());
        json.put(Claims.SUBJECT, binaryLine(mantenimiento));

        return json.toString();
    }

    private static String AddOne(String entrada){
        return entrada.concat("1");
    }

    private static String AddCero(String entrada){
        return entrada.concat("0");
    }


    private Map<String, Object> generateJwtHeaderQR(){
        Map<String, Object> mapHeader = new HashMap<>();
        mapHeader.put(TYP, SignatureAlgorithm.ES256);
        mapHeader.put(ALG,applicationProperties.getJwtQrAlgorithmSign());
        return mapHeader;
    }


    public String generateJWTQr(JWT_TYPE jwtType, String ... attribustesValues) {

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.MINUTE, applicationProperties.getTimeExpirationTokenQr());

        return Jwts.builder()
                .setHeader(generateJwtHeaderQR())
                .setSubject(generateJwtPayloadQR(calendar.getTime(),jwtType,attribustesValues))
                .signWith(SignatureAlgorithm.HS256, applicationProperties.getJwtQrSignKey())
                .setExpiration(calendar.getTime())
                .compact();
    }

    private static String binaryLine(Maintenance mantenimiento){
        String binaryLine = "";
        if(mantenimiento.isOilChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isOilFilterChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isTransmissionFluidChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isBrakeFluidChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isSteeringFluidChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isCoolantFluidChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isWipeWaterCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isBatteryWaterChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isRadiatorHosesCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isHeaterHosesCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isAirCondHosesCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isAirFilterChange()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isTirePressureCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isTireWearCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isWipersCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isHeadLampAlignmentCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isSeatBeltCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        if(mantenimiento.isParkingBreakCheck()){
            binaryLine = AddOne(binaryLine);
        }else{
            binaryLine = AddCero(binaryLine);
        }

        System.out.println("\nDisplaying Binary Line => " + binaryLine);
        return binaryLine;

    }


}
