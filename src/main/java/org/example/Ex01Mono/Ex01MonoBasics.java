package org.example.Ex01Mono;

import lombok.extern.slf4j.Slf4j;
import org.example.common.Util;
import reactor.core.publisher.Mono;

@Slf4j
public class Ex01MonoBasics {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> log.info("Subscribed: {}", i),
            e -> log.error("Error ", e),
            () -> log.info("Completed"),
            subscription -> subscription.request(1)
        );

        log.info("*******************************");
        getUsername(1).subscribe(Util.subscriber());
        getUsername(2).subscribe(Util.subscriber());
        getUsername(3).subscribe(Util.subscriber());

    }

    private static Mono<String> getUsername(int i) {
        return switch (i) {
            case 1 -> Mono.just("vinod");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("User not found"));
        };
    }
}
