package org.example.Ex06BackPressure;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Ex03MultipleSubscribers {

    private static final Logger log = LoggerFactory.getLogger(Ex03MultipleSubscribers.class);

    public static void main(String[] args) {

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
                .limitRate(5)
                .publishOn(Schedulers.boundedElastic())
                .map(Ex03MultipleSubscribers::timeConsumingTask)
                .subscribe(Util.subscriber("sub1"));

        producer
                .take(100)
                .publishOn(Schedulers.boundedElastic())
                .subscribe(Util.subscriber("sub2"));


        Util.sleepSeconds(60);

    }

    private static int timeConsumingTask(int i) {
        Util.sleepSeconds(1);
        return i;
    }

}
