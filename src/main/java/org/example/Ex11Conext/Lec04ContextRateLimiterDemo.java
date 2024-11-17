package org.example.Ex11Conext;

import org.example.Ex11Conext.client.ExternalServiceClient;
import org.example.common.Util;
import reactor.util.context.Context;

/*
    Ensure that the external service is up and running!
 */
public class Lec04ContextRateLimiterDemo {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        for (int i = 0; i < 20; i++) {
            client.getBook()
                  .contextWrite(Context.of("user", "mike"))
                  .subscribe(Util.subscriber());
            Util.sleepSeconds(1);
        }

        Util.sleepSeconds(5);

    }

}
