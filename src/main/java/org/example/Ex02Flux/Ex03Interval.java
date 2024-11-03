package org.example.Ex02Flux;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Ex03Interval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
            .map(i -> Util.faker().animal().name())
            .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
