package org.example.Ex05Operators;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Ex02HandleUntilAssignment {

    public static void main(String[] args) {

        Flux.<String>generate(sink -> sink.next(Util.faker().country().name()))
                .handle((item, sink) -> {
                    sink.next(item);
                    if(item.equalsIgnoreCase("canada")){
                        sink.complete();
                    }
                })
                .subscribe(Util.subscriber());


    }

}
