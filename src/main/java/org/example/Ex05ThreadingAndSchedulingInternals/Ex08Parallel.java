package org.example.Ex05ThreadingAndSchedulingInternals;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
    Often times you really do not need this!
    - prefer non-blocking IO for network calls
 */
public class Ex08Parallel {

    private static final Logger log = LoggerFactory.getLogger(Ex08Parallel.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .map(Ex08Parallel::process)
             //   .sequential()
                .map(i -> i + "a")
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static int process(int i){
        log.info("time consuming task {}", i);
        Util.sleepSeconds(1);
        return i * 2;
    }

}
