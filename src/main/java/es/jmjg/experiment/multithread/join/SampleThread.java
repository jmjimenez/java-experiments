package es.jmjg.experiment.multithread.join;

class SampleThread extends Thread {
    public int processingCount = 0;

    SampleThread(int processingCount) {
        this.processingCount = processingCount;
        System.out.println("Thread Created");
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                //noinspection BusyWait
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
            System.out.println("Inside Thread " + this.getName() + ", processingCount = " + processingCount);
        }
        System.out.println("Thread " + this.getName() + " exiting");
    }
}