package org.example.Ex08BatchingGroupingWindowing;

import org.example.Ex08BatchingGroupingWindowing.assignment.window.FileWriter;
import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex04WindowAssignment {

    public static void main(String[] args) {

        var counter = new AtomicInteger(0);
        var fileNameFormat = "src/main/resources/sec10/file%d.txt";

        eventStream()
                .window(Duration.ofMillis(1800)) // just for demo
                .flatMap(flux -> FileWriter.create(flux, Path.of(fileNameFormat.formatted(counter.incrementAndGet()))))
                .subscribe();


        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                   .map(i -> "event-" + (i + 1));
    }

}
