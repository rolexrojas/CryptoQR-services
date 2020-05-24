package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IDeviceCheckAppleService;
import com.mono40.types.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceCheckAppleService implements IDeviceCheckAppleService {

    private Logger logger = LogManager.getLogger(DeviceCheckAppleService.class);

    @Autowired
    private ApplicationProperties applicationProperties;
/*
    @Override
    public QueryTwoBitsDeviceCheckResponseType queryTwoBitsDeviceCheck(QueryTwoBitsDeviceCheckType queryTwoBitsDeviceCheckType) {
        logger.info("entering method queryTwoBitsDeviceCheck");
        logger.info("param: "+ queryTwoBitsDeviceCheckType);
        //CALL DEVICE CHECK QUERY BITS
        logger.info("Call endpoint  "+applicationProperties.getQueryTwoBitsUrl());
        BitsDevice restResponse =new RestTemplate().postForObject(applicationProperties.getQueryTwoBitsUrl(),queryTwoBitsDeviceCheckType, BitsDevice.class);
        logger.info("response: "+ restResponse);
        logger.info("exiting method queryTwoBitsDeviceCheck");
        return new  QueryTwoBitsDeviceCheckResponseType(restResponse);
    }

    @Override
    public UpdateTwoBitsDeviceCheckResponseType updateTwoBitsDeviceCheck(UpdateTwoBitsDeviceCheckType updateTwoBitsDeviceCheckType) {
        //CALL DEVICE CHECK UPDATE BITS
        logger.info("entering method updateTwoBitsDeviceCheck");
        logger.info("param: "+ updateTwoBitsDeviceCheckType);
        //CALL DEVICE CHECK QUERY BITS
        logger.info("Call endpoint  "+applicationProperties.getUpdateTwoBitsUrl());
        UpdateTwoBitsDeviceCheckResponseType restResponse = new RestTemplate().postForObject(applicationProperties.getUpdateTwoBitsUrl(),updateTwoBitsDeviceCheckType, UpdateTwoBitsDeviceCheckResponseType.class);
        logger.info("response: "+ restResponse);
        logger.info("exiting method updateTwoBitsDeviceCheck");
        return restResponse;
    }*/
}
