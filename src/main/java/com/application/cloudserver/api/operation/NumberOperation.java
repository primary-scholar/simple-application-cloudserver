package com.application.cloudserver.api.operation;


import com.application.cloudserver.api.result.NumberSeedResult;

public interface NumberOperation {

    Integer getOperation();

    String getOperationDesc();

    Integer operate(NumberSeedResult first, NumberSeedResult second);

}
