package com.mono40.service;

import com.mono40.types.*;

/**
 * Created by yinfante on 2/21/18.
 */
public interface IQueryBalanceService {
    Account[] loadAccounts(Long msisdn);

    CreditCard[] loadCreditCards(Long msisdn);

    Loan[] loadLoan(Long msisdn);

}
