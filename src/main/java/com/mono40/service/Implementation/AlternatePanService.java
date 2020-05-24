package com.mono40.service.Implementation;

import com.mono40.config.ApplicationProperties;
import com.mono40.service.IAlternatePanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class AlternatePanService implements IAlternatePanService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public boolean deleteDevice(Long msisdn) {

        String uri = "/alternate-pan/delete/" + msisdn.toString();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Accept", "*/*");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


        return restTemplate.getForEntity(uri, String.class).getBody().equals("true");

    }
}
