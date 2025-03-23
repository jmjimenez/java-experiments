package es.jmjg.experiment.multithread.fixedthreadpool;

class Concurrency implements Runnable {

    private final int i;

    Concurrency(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        // log the start and end of
        // a task for simplicity
        System.out.println(Thread.currentThread().getName() + ": Start task " + i);

        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }

        System.out.println(Thread.currentThread().getName() + ": End task " + i);
    }
}