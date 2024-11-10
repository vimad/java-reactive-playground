package org.example.Ex07CombiningPublishers;


import org.example.Ex07CombiningPublishers.helper.Kayak;
import org.example.common.Util;

public class Ex06MergeUseCase {

    public static void main(String[] args) {

        Kayak.getFlights()
                .subscribe(Util.subscriber());


        Util.sleepSeconds(3);


    }

}
