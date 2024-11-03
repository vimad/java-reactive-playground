package org.example.Ex02Flux;

import lombok.extern.slf4j.Slf4j;
import org.example.common.Util;
import reactor.core.publisher.Flux;

@Slf4j
public class Ex05Generate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            // can not emit more than one value at once but this will invoke again and again until it is completed or canceled
            // synchronousSink.next(2);
            // synchronousSink.complete();
        }).take(4)
            .subscribe(Util.subscriber());

        manageStateWithGenerate();
    }

    private static void manageStateWithGenerate() {
        log.info("ManageStateWithGenerate............");
        Flux.generate(
            () -> 0,
            (count, synchronousSink) ->{
                String country = Util.faker().country().name();
                synchronousSink.next(country);
                count += 1;
                if (count == 10 || country.equals("Sri Lanka")) {
                    synchronousSink.complete();
                }
                return count;
            },
            count -> System.out.println(count)
            )
            .subscribe(Util.subscriber());
    }
}
