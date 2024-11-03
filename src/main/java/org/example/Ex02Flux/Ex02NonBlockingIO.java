package org.example.Ex02Flux;

import org.example.Ex02Flux.client.ExternalServiceClient;
import org.example.common.Util;

public class Ex02NonBlockingIO {

    public static void main(String[] args) {
        ExternalServiceClient client = new ExternalServiceClient();
        client.getNames()
            .subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }
}
