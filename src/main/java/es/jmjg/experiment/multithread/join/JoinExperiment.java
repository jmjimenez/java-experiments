package es.jmjg.experiment.multithread.join;

public class JoinExperiment {
    public void execute(int processingCount) throws InterruptedException {
        Thread t2 = new SampleThread(processingCount);
        t2.start();

        System.out.println("Invoking join");
        t2.join();
        System.out.println("Returned from join");

        System.out.println("Thread is alive " + t2.isAlive());
    }
}
