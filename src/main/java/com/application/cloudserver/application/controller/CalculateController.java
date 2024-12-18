package com.application.cloudserver.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.application.cloudserver.api.param.NumberCalculateParam;
import com.application.cloudserver.api.result.NumberCalculateResult;
import com.application.cloudserver.api.result.RpcResult;
import com.application.cloudserver.api.result.RpcResultUtil;
import com.application.cloudserver.application.utils.NumberOperationBuilder;
import com.sohu.mrd.framework.server.transport.http.annotation.CloudController;
import com.sohu.mrd.framework.server.transport.http.annotation.CloudRequestMapping;
import com.sohu.mrd.framework.server.transport.http.dto.SimpleHttpRequest;
import com.sohu.mrd.framework.server.transport.http.dto.SimpleHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@CloudController(value = "api")
public class CalculateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateController.class);

    @CloudRequestMapping(method = "/num/cal")
    public String postMethod(SimpleHttpRequest request, SimpleHttpResponse response) {
        Set<String> keySet = request.getParams().keySet();
        String param = keySet.iterator().next();
        NumberCalculateParam calculateParam = JSONObject.parseObject(param, NumberCalculateParam.class);
        LOGGER.info("post param:{}", JSONObject.toJSONString(calculateParam));
        NumberCalculateResult build = NumberOperationBuilder.build(calculateParam);
        RpcResult<NumberCalculateResult> success = RpcResultUtil.success(build);
        return JSONObject.toJSONString(success);
    }
}
