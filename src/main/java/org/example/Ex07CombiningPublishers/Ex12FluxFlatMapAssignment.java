package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.assignment.ExternalServiceClient;
import org.example.common.Util;
import reactor.core.publisher.Flux;

/*
    Ensure that the external service is up and running!
 */
public class Ex12FluxFlatMapAssignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        Flux.range(1, 10)
            .flatMap(client::getProduct, 3)
            .subscribe(Util.subscriber());

        Util.sleepSeconds(20);

    }

}
