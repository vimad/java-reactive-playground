package org.example.Ex07CombiningPublishers;

import org.example.Ex07CombiningPublishers.helper.NameGenerator;
import org.example.common.Util;

public class Ex02StartWithUseCase {

    public static void main(String[] args) {


        var nameGenerator = new NameGenerator();

        nameGenerator.generateNames()
                     .take(2)
                     .subscribe(Util.subscriber("sam"));


        nameGenerator.generateNames()
                     .take(2)
                     .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                     .take(3)
                     .subscribe(Util.subscriber("jake"));


    }

}
