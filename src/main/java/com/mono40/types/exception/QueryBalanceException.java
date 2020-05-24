package com.mono40.types.exception;

import com.mono40.types.QueryBalance;

public class QueryBalanceException extends NeoAPIException {

    {
        super.setExceptionLevel(ExceptionLevel.ERROR);
    }

    public QueryBalanceException(Exception e, QueryBalance queryBalance) {
        super(e, queryBalance);
    }
}
