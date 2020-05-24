package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IBlockCustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yinfante on 6/26/17.
 */
@Service
public class BlockCustomerService implements IBlockCustomerService {

    Logger logger = LogManager.getLogger(BlockCustomerService.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public boolean blockCustomer(Long msisdn) {

//        try {
//
//            String uri = applicationProperties.getTransaxionAddress() + "/block-pin/" + msisdn.toString();
//
//            logger.debug("calling block user pin :" + uri);
//
//            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//            headers.add("Accept", "*/*");
//
//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//
//            return restTemplate.getForEntity(uri, String.class).getBody().equals("true");
//
//        } catch (Exception e) {
//            logger.error("Error blocking user pin", e);
//        }

        return false;

    }
}
