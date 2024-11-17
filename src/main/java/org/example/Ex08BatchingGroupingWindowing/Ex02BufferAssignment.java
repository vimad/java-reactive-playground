package org.example.Ex08BatchingGroupingWindowing;


import org.example.Ex08BatchingGroupingWindowing.assignment.buffer.BookOrder;
import org.example.Ex08BatchingGroupingWindowing.assignment.buffer.RevenueReport;
import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex02BufferAssignment {

    public static void main(String[] args) {

        var allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        orderStream()
                .filter(o -> allowedCategories.contains(o.genre()))
                .buffer(Duration.ofSeconds(5))
                .map(Ex02BufferAssignment::generateReport)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

    private static Flux<BookOrder> orderStream() {
        return Flux.interval(Duration.ofMillis(200))
                   .map(i -> BookOrder.create());
    }

    private static RevenueReport generateReport(List<BookOrder> orders) {
        var revenue = orders.stream()
                            .collect(Collectors.groupingBy(
                                    BookOrder::genre,
                                    Collectors.summingInt(BookOrder::price)
                            ));
        return new RevenueReport(LocalTime.now(), revenue);
    }


}
