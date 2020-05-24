package com.mono40.service.Implementation;

import com.mono40.domain.PayableAccountType;
import com.mono40.service.IPayableAccountTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mono40.repository.IPayableAccountTypeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarielinfante on 11/22/16.
 */
@Service
public class PayableAccountTypeService implements IPayableAccountTypeService {

    private Logger logger = LogManager.getLogger(PayableAccountTypeService.class);

    @Autowired
    private IPayableAccountTypeRepository repository;

    private List<String> accountTypes = new ArrayList<>();


    @Override
    public List<String> getAccountTypes() {

        if (this.accountTypes == null || this.accountTypes.isEmpty()) {
            logger.info("accountTypes empty. Loading now");
            for (PayableAccountType next : repository.findAll()) {
                if (next.isPayable())
                    accountTypes.add(next.getAccountType());
            }
        }

        return accountTypes;
    }
}
