package org.example.Ex04ColdAndHotPublishers;

import org.example.Ex02Flux.helper.NameGenerator;
import org.example.common.Util;
import reactor.core.publisher.Flux;

/*
    To fix the issue we faced in sec04/Lec02FluxCreateRefactor
 */
public class Ex05FluxCreateIssueFix {

    public static void main(String[] args) {

        var generator = new NameGenerator();
        var flux = Flux.create(generator).share();
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));

        // somewhere else!
        for (int i = 0; i < 10; i++) {
            generator.generate();
        }

    }

}
