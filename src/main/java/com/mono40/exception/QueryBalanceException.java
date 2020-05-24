package com.mono40.exception;

import com.mono40.types.QueryBalance;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class QueryBalanceException extends NeoAPIException {

    {
        super.setExceptionLevel(ExceptionLevel.ERROR);
    }

    public QueryBalanceException(Exception e, QueryBalance queryBalance) {
        super(e, queryBalance);
    }
}
