package org.example.common;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class DefaultSubscriber<T> implements Subscriber<T> {

    private final String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} received: {}", name, item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error", name,  throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} received complete!", name);
    }
}
