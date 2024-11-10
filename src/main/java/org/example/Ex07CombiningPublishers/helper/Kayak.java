package org.example.Ex07CombiningPublishers.helper;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Kayak {

    public static Flux<Flight> getFlights() {
        return Flux.merge(
                           AmericanAirlines.getFlights(),
                           Emirates.getFlights(),
                           Qatar.getFlights()
                   )
                   .take(Duration.ofSeconds(2));
    }

}
