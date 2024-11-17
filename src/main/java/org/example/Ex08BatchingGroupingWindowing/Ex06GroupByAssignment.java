package org.example.Ex08BatchingGroupingWindowing;

import org.example.Ex08BatchingGroupingWindowing.assignment.groupby.OrderProcessingService;
import org.example.Ex08BatchingGroupingWindowing.assignment.groupby.PurchaseOrder;
import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Ex06GroupByAssignment {

    public static void main(String[] args) {
        
        orderStream()
                .filter(OrderProcessingService.canProcess())
                .groupBy(PurchaseOrder::category)
                .flatMap(gf -> gf.transform(OrderProcessingService.getProcessor(gf.key())))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

    private static Flux<PurchaseOrder> orderStream(){
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> PurchaseOrder.create());
    }


}
