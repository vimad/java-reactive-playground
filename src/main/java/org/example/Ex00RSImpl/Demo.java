package org.example.Ex00RSImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.Ex00RSImpl.publisher.PublisherImpl;
import org.example.Ex00RSImpl.subscriber.SubscriberImpl;

import java.time.Duration;

@Slf4j
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);

        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

        log.info("*********************************");
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

        log.info("*********************************");
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

        log.info("*********************************");
        subscriber.getSubscription().request(3);
    }
}
