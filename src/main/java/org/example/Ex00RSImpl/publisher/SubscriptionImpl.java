package org.example.Ex00RSImpl.publisher;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class SubscriptionImpl implements Subscription {

    public static final int MAX_ITEMS = 10;
    private int count = 0;

    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;

    private final Faker faker = Faker.instance();

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long l) {
        if (isCancelled) {
            return;
        }
        log.info("subscriber has requested {} items", l);
        for (int i = 0; i < l && count < MAX_ITEMS; i++) {
            count++;
            subscriber.onNext(faker.book().title());
        }
        if (count == MAX_ITEMS) {
            log.info("subscriber has reached max items");
            subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscriber has canceled");
        this.isCancelled = true;
    }
}
