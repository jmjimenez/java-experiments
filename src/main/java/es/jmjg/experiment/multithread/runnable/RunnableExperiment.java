package es.jmjg.experiment.multithread.runnable;

public class RunnableExperiment {

    public static Thread getRunnableThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable executed");
            }
        });
    }
}
