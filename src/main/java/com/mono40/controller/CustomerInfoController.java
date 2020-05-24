package com.mono40.controller;


import com.mono40.types.CustomerStatus;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

    private Logger logger = Logger.getLogger(CustomerInfoController.class);

    //@Autowired
    //private ICustomerInfoService customerInfoService;

    //@Autowired
    //private IDeviceRepository deviceRepository;

    //@Autowired
    //private IMsisdnActivationCodeRepository msisdnActivationCodeRepository;

    //@Autowired
    //private IAffiliationInformationRepository affiliationInformationRepository;

    //@Autowired
    //private Messages messages;

    @GetMapping("/{msisdn}/status")
    public ResponseEntity getStatus(@RequestHeader(required = false, name = "version") String clientVersion,
                                    @RequestHeader(required = false, name = "os") String os,
                                    @RequestHeader(required = false, name = "device-token") String deviceToken,
                                    @PathVariable Long msisdn) {

        logger.debug("getting customer status");
       // try {
            //CustomerDetail customerDetail = customerInfoService.getCustomerStatus(msisdn);

            //logger.debug("validating msisdn status : " + customerDetail);

         //   Device device = deviceRepository.findFirstByMsisdnAndActiveIsTrueOrderByIdDesc(msisdn);

          //  if (device == null || !device.getAccount().isActive()) {
          //      logger.debug("customer GCS_AFFILIATED_NON_PROFILE");
          //      return ResponseEntity.ok(new CustomerStatus(CustomerStatus.Status.GCS_AFFILIATED_NON_PROFILE));
         //   }

        //    logger.debug("customer GCS_AFFILIATED_PROFILE");

            //String otp = PasswordGenerator.generateRamdonOTP(6);

            //logger.info("Generated otp for number "+msisdn);
            //msisdnActivationCodeRepository.deleteByMsisdn(msisdn);

           // MsisdnActivationCode msisdnActivationCode = new MsisdnActivationCode(msisdn, otp);
            //logger.debug("saving :" + msisdnActivationCode);
           // msisdnActivationCodeRepository.save(msisdnActivationCode);

            return ResponseEntity.ok(new CustomerStatus(CustomerStatus.Status.GCS_AFFILIATED_PROFILE));

      //  } catch (UserNotActivetPagoException e) {
        //    logger.debug("customer GCS_NO_AFFILIATED");
       //     return ResponseEntity.ok(new CustomerStatus(CustomerStatus.Status.GCS_NO_AFFILIATED));

        //} catch (Exception e) {
          //  logger.error("General error", e);
        //    return ResponseEntity.ok(new CustomerStatus(CustomerStatus.Status.GCS_NO_AFFILIATED));
      //  }
    }



}
