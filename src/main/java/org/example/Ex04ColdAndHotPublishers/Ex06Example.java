package org.example.Ex04ColdAndHotPublishers;

import org.example.Ex04ColdAndHotPublishers.assignment.ExternalServiceClient;
import org.example.Ex04ColdAndHotPublishers.assignment.InventoryService;
import org.example.Ex04ColdAndHotPublishers.assignment.RevenueService;
import org.example.common.Util;

/*
    Ensure that the external service is up and running!
 */
public class Ex06Example {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var inventoryService = new InventoryService();
        var revenueService = new RevenueService();

        client.orderStream().subscribe(inventoryService::consume);
        client.orderStream().subscribe(revenueService::consume);

        inventoryService.stream()
                        .subscribe(Util.subscriber("inventory"));

        revenueService.stream()
                        .subscribe(Util.subscriber("revenue"));


        Util.sleepSeconds(30);

    }

}
