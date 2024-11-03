package org.example.Ex05Operators;

import org.example.common.Util;
import reactor.core.publisher.Flux;

/*
    Similar to error handling.
    Handling empty!
 */
public class Ex07DefaultIfEmpty {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .filter(i -> i > 11)
                .defaultIfEmpty(50)
                .subscribe(Util.subscriber());

    }


}
