package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.applications.OrderService;
import org.example.Ex07CombiningPublishers.applications.UserService;
import org.example.common.Util;

/*
    Sequential non-blocking IO calls!
    flatMap is used to flatten the inner publisher / to subscribe to the inner publisher
    Mono is supposed to be 1 item - what if the flatMap returns multiple items!?
 */
public class Ex10MonoFlatMapMany {

    public static void main(String[] args) {

        /*
            We have username
            get all user orders!
         */

        UserService.getUserId("jake")
                   .flatMapMany(OrderService::getUserOrders)
                   .subscribe(Util.subscriber());


        Util.sleepSeconds(3);
    }

}
