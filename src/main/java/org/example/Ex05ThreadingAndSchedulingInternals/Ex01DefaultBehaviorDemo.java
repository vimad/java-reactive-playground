package org.example.Ex05ThreadingAndSchedulingInternals;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

/*
    By default, the current thread is doing all the work
 */
public class Ex01DefaultBehaviorDemo {

    private static final Logger log = LoggerFactory.getLogger(Ex01DefaultBehaviorDemo.class);

    public static void main(String[] args) {

        var flux = Flux.create(sink -> {
                           for (int i = 1; i < 3; i++) {
                               log.info("generating: {}", i);
                               sink.next(i);
                           }
                           sink.complete();
                       })
                       .doOnNext(v -> log.info("value: {}", v));

        // All will happen in the same thread where subscribe happens
        Runnable runnable = () -> flux.subscribe(Util.subscriber("sub1"));

        Thread.ofPlatform().start(runnable);

    }

}
