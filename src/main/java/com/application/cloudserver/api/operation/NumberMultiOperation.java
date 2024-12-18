package com.application.cloudserver.api.operation;

import com.application.cloudserver.api.result.NumberSeedResult;
import org.apache.commons.lang3.math.NumberUtils;

public class NumberMultiOperation implements NumberOperation {

    @Override
    public Integer getOperation() {
        return NumberUtils.INTEGER_TWO;
    }

    @Override
    public String getOperationDesc() {
        return "乘法";
    }

    @Override
    public Integer operate(NumberSeedResult first, NumberSeedResult second) {
        return first.getNumber() * second.getNumber();
    }
}
