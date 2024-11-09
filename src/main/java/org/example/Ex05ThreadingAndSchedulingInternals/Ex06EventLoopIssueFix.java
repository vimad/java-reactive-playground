package org.example.Ex05ThreadingAndSchedulingInternals;

import org.example.Ex05ThreadingAndSchedulingInternals.client.ExternalServiceClient;
import org.example.common.Util;

/*
    Ensure that the external service is up and running!
 */
public class Ex06EventLoopIssueFix {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        for (int i = 1; i <= 5; i++) {
            client.getProductName(i)
                  .map(Ex06EventLoopIssueFix::process)
                  .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(20);

    }

    private static String process(String input){
        Util.sleepSeconds(1);
        return input + "-processed";
    }

}
