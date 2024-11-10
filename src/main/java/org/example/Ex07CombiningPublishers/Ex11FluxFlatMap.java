package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.applications.OrderService;
import org.example.Ex07CombiningPublishers.applications.User;
import org.example.Ex07CombiningPublishers.applications.UserService;
import org.example.common.Util;

/*
    Sequential non-blocking IO calls!
    flatMap is used to flatten the inner publisher / to subscribe to the inner publisher
 */
public class Ex11FluxFlatMap {

    public static void main(String[] args) {

        /*
            Get all the orders from order service!
         */

        UserService.getAllUsers()
                   .map(User::id)
                   .flatMap(OrderService::getUserOrders)
                   .subscribe(Util.subscriber());

        Util.sleepSeconds(5);

    }

}
