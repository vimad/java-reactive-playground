package org.example.Ex04ColdAndHotPublishers;

import org.example.Ex02Flux.helper.NameGenerator;
import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Ex01ColdPublisher {

    private static final Logger log = LoggerFactory.getLogger(Ex01ColdPublisher.class);

    public static void main(String[] args) {

        var flux = Flux.create(fluxSink -> {
            log.info("invoked");
            for (int i = 0; i < 3; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });


        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));


        System.out.println("*******************************************");
        var generator = new NameGenerator();
        var flux2 = Flux.create(generator);
        flux2.subscribe(Util.subscriber("sub3"));
        flux2.subscribe(Util.subscriber("sub4"));

        // somewhere else!
        for (int i = 0; i < 10; i++) {
            generator.generate();
        }

    }

}
