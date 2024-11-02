package org.example.Ex01Mono;

import lombok.extern.slf4j.Slf4j;
import org.example.common.Util;
import reactor.core.publisher.Mono;

@Slf4j
public class Ex03Defer {

    public static void main(String[] args) {
        timeConsumingPublisher();
        Mono.defer(Ex03Defer::timeConsumingPublisher);
    }

    public static Mono<String> timeConsumingPublisher() {
        Util.sleepSeconds(2);
        log.info("timeConsumingPublisher finished");
        return Mono.fromSupplier(Ex03Defer::timeConsumingOperation);
    }

    public static String timeConsumingOperation() {
        Util.sleepSeconds(2);
        return "some compute time";
    }
}
