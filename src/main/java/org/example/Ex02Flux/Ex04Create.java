package org.example.Ex02Flux;

import lombok.extern.slf4j.Slf4j;
import org.example.Ex00RSImpl.subscriber.SubscriberImpl;
import org.example.Ex02Flux.helper.NameGenerator;
import org.example.common.Util;
import reactor.core.publisher.Flux;

@Slf4j
public class Ex04Create {

    public static void main(String[] args) {

        // FluxSync is thread safe

        createFunctionExample();

        createCustomGeneratorWhereItemsCanEmit();

        fluxSinkWillNotStopEmittingEvenSubscriptionIsCancelledBySubscriber();

        useFluxSyncForOnDemandEmitting();
    }

    private static void useFluxSyncForOnDemandEmitting() {
        log.info("Starting FluxSyncForOnDemandEmitting");
        SubscriberImpl subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(request -> {
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    String name = Util.faker().name().firstName();
                    log.info("Emitting on demand item {}", name);
                    fluxSink.next(name);
                }
            });
        }).subscribe(subscriber);

        subscriber.getSubscription().request(2);
    }

    private static void createFunctionExample() {
        log.info("Create function example");
        Flux.create(fluxSInk -> {
            log.info("Will not invoked if not subscribe");
            fluxSInk.next(1);
            fluxSInk.next(2);
            fluxSInk.complete();
        });
    }

    private static void fluxSinkWillNotStopEmittingEvenSubscriptionIsCancelledBySubscriber() {
        log.info("Flux sink will not stop emitting even subscription. The all emmit items will be queued and subscriber need to get the items");
        SubscriberImpl subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 2; i++) {
                Util.sleepSeconds(1);
                String name = Util.faker().name().firstName();
                log.info("Emitting item {}", name);
                fluxSink.next(name);
            }
        }).subscribe(subscriber);

        subscriber.getSubscription().cancel();
    }

    private static void createCustomGeneratorWhereItemsCanEmit() {
        log.info("Create custom generator will emit items programmatically");
        NameGenerator emitter = new NameGenerator();
        Flux.create(emitter)
            .subscribe(Util.subscriber());
        for (int i = 0; i < 3; i++) {
            emitter.generate();
        }
    }
}
