package org.example.Ex06BackPressure;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
    Reactor automatically handles the backpressure.
    System.setProperty("reactor.bufferSize.small", "16");
 */
public class Ex01BackPressureHandling {

    private static final Logger log = LoggerFactory.getLogger(Ex01BackPressureHandling.class);

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        var producer = Flux.generate(
                                   () -> 1,
                                   (state, sink) -> {
                                       log.info("generating {}", state);
                                       sink.next(state);
                                       return ++state;
                                   }
                           )
                           .cast(Integer.class)
                           .subscribeOn(Schedulers.parallel());

        producer
                .publishOn(Schedulers.boundedElastic())
                .map(Ex01BackPressureHandling::timeConsumingTask)
                .subscribe(Util.subscriber());


        Util.sleepSeconds(60);


    }

    private static int timeConsumingTask(int i) {
        Util.sleepSeconds(1);
        return i;
    }

}
