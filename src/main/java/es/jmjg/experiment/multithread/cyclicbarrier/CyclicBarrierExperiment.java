package es.jmjg.experiment.multithread.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExperiment {
    private final Integer parties = 3;

    public void execute() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(
            parties,
            () -> System.out.println("All " + parties +  " tasks are completed")
        );

        List<Thread> tasks = new ArrayList<>();

        for (int i = 1; i <= parties; i++) {
            tasks.add(new Thread(new CyclicBarrierTask("T" + i, cyclicBarrier)));
        }
        for (int i = 0; i < parties; i++) {
            if (!cyclicBarrier.isBroken()) {
                tasks.get(i).start();
            } else {
                System.out.println("CyclicBarrier is broken");
            }
        }
    }
}
