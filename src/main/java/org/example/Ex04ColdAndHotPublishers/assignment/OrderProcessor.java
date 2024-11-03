package org.example.Ex04ColdAndHotPublishers.assignment;

import reactor.core.publisher.Flux;

public interface OrderProcessor {

    void consume(Order order);

    Flux<String> stream();

}
