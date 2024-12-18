package com.application.cloudserver.api.result;

import com.application.cloudserver.api.param.BaseParam;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class NumberCalculateResult extends BaseParam implements Serializable {
    /**
     *
     */
    private Integer operation;
    /**
     *
     */
    private NumberSeedResult first;
    /**
     *
     */
    private NumberSeedResult second;
    /**
     *
     */
    private Integer result;
}
