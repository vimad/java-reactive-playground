package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.assignment.ExternalServiceClient;
import org.example.common.Util;

/*
    Ensure that the external service is up and running!
 */
public class Ex08ZipAssignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        for (int i = 1; i < 10; i++) {
            client.getProduct(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(2);

    }

}
