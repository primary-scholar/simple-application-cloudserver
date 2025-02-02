package com.application.cloudserver;

import com.sohu.mrd.framework.server.transport.http.SohuCloudHttpServer;

import java.util.Arrays;

public class CalculateApplication {
    public static void main(String[] args) {
        SohuCloudHttpServer server = SohuCloudHttpServer.create().scanPackageList(Arrays.asList("com.application" +
                ".cloudserver")).port(8083).supportSpring().build();
        server.start();
    }
}
