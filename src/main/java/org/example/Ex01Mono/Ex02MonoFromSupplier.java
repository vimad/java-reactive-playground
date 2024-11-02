package org.example.Ex01Mono;

import reactor.core.publisher.Mono;

public class Ex02MonoFromSupplier {

    public static void main(String[] args) {
        Mono.fromSupplier(() -> "some compute intensive work that will be delayed until subscribe")
            .subscribe(System.out::println);
    }
}
