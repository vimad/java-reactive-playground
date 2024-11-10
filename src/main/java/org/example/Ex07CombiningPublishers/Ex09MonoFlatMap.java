package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.applications.PaymentService;
import org.example.Ex07CombiningPublishers.applications.UserService;
import org.example.common.Util;

/*
    Sequential non-blocking IO calls!
    flatMap is used to flatten the inner publisher / to subscribe to the inner publisher
 */
public class Ex09MonoFlatMap {

    public static void main(String[] args) {

        /*
            We have username.
            Get user account balance
         */

        UserService.getUserId("mike")
                   .flatMap(PaymentService::getUserBalance)
                   .subscribe(Util.subscriber());

    }

}
