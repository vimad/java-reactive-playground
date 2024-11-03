package org.example.Ex05Operators;


import org.example.Ex05Operators.assignment.ExternalServiceClient;
import org.example.common.Util;

/*
    Ensure that the external service is up and running!
 */
public class Ex11Assignment {

    public static void main(String[] args) {


        var client = new ExternalServiceClient();

        for (int i = 1; i < 5; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(3);


    }

}
