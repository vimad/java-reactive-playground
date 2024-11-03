package org.example.Ex02Flux;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class EX01Basics {

    public static void main(String[] args) {
        Flux.just("vinod", "Madubashana")
            .subscribe(Util.subscriber());

        Flux.range(1, 3)
            .log()
            .subscribe(Util.subscriber());
    }
}
