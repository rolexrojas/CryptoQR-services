package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.exception.PinBlockedException;
import com.mono40.exception.UserNotActivetPagoException;
import com.mono40.service.ICustomerInfoService;
//import com.mono40.types.CustomerDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import static com.mono40.util.ApplicationConstant.*;
//import static com.mono40.util.ApplicationConstant.ACTIVE;

/**
 * Created by yinfante on 10/19/17.
 */
@Service
public class CustomerInfoService implements ICustomerInfoService {

    private Logger logger = LogManager.getLogger(CustomerInfoService.class);

    @Autowired
    private ApplicationProperties applicationProperties;

 /*   @Override
    public CustomerDetail getCustomerStatus(Long msisdn) throws UserNotActivetPagoException, PinBlockedException {

        logger.info("getting customer status : " + msisdn);

        RestTemplate restTemplate = new RestTemplate();
        CustomerDetail customerDetail = restTemplate.getForObject(applicationProperties.getTransaxionAddress() + "/customer/" + msisdn + "/status", CustomerDetail.class);

        logger.debug("customer : " + customerDetail);

        if (customerDetail == null || !customerDetail.getStatus().equalsIgnoreCase(ACTIVE)) {
            logger.error("UserNotActivetPagoException");
            throw new UserNotActivetPagoException(customerDetail);
        }

        return customerDetail;
    }*/
}
