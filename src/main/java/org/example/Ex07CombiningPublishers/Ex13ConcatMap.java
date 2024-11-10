package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.assignment.ExternalServiceClient;
import org.example.common.Util;
import reactor.core.publisher.Flux;

/*
    Ensure that the external service is up and running!
 */
public class Ex13ConcatMap {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        Flux.range(1, 10)
            .concatMap(client::getProduct)
            .subscribe(Util.subscriber());

        Util.sleepSeconds(20);

    }

}
