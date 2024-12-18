package com.application.cloudserver.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.application.cloudserver.api.param.NumberCalculateParam;
import com.application.cloudserver.api.param.NumberOperationParam;
import com.application.cloudserver.api.result.NumberCalculateResult;
import com.application.cloudserver.api.result.NumberSeedResult;
import com.application.cloudserver.api.result.RpcResult;
import com.application.cloudserver.api.result.RpcResultUtil;
import com.application.cloudserver.application.utils.NumberOperationBuilder;
import com.sohu.mrd.framework.server.transport.http.annotation.CloudController;
import com.sohu.mrd.framework.server.transport.http.annotation.CloudRequestMapping;
import com.sohu.mrd.framework.server.transport.http.dto.SimpleHttpRequest;
import com.sohu.mrd.framework.server.transport.http.dto.SimpleHttpResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@CloudController(value = "api")
public class NumberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberController.class);

    @CloudRequestMapping(method = "/num/gen")
    public String getMethod(SimpleHttpRequest request, SimpleHttpResponse response) {
        NumberOperationParam param = build(request, response);
        LOGGER.info("get param:{}", JSONObject.toJSONString(param));
        param.setNumber(param.getNumber() + NumberUtils.INTEGER_ONE);
        NumberSeedResult build = NumberOperationBuilder.build(param);
        RpcResult<NumberSeedResult> success = RpcResultUtil.success(build);
        return JSONObject.toJSONString(success);
    }

    private NumberOperationParam build(SimpleHttpRequest request, SimpleHttpResponse response) {
        NumberOperationParam operationParam = new NumberOperationParam();
        operationParam.setOperation(request.getInt("operation"));
        operationParam.setNumber(request.getInt("number"));
        return operationParam;
    }
}
