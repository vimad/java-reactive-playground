package org.example.Ex01Mono;

import lombok.extern.slf4j.Slf4j;
import org.example.Ex01Mono.client.ExternalServiceClient;
import org.example.common.Util;

@Slf4j
public class Ex04NonBlockingIO {

    public static void main(String[] args) {
        ExternalServiceClient externalServiceClient = new ExternalServiceClient();
        for (int i = 1; i <= 5; i++) {
            externalServiceClient.getProductName(i)
                .subscribe(Util.subscriber());
        }

        log.info("starting");
        Util.sleepSeconds(2);
    }
}
