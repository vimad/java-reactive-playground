package org.example.Ex08BatchingGroupingWindowing;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Ex03Window {


    public static void main(String[] args) {

        eventStream()
                .window(Duration.ofMillis(1800))
                .flatMap(Ex03Window::processEvents)
                .subscribe();


        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                   .map(i -> "event-" + (i + 1));
    }

    private static Mono<Void> processEvents(Flux<String> flux) {
        return flux.doOnNext(e -> System.out.print("*"))
                   .doOnComplete(System.out::println)
                   .then();
    }


}
