package es.jmjg.experiment.multithread.synchronize;

public class ThreadMessenger extends Thread {
    private String msg;
    Messenger sender;

    ThreadMessenger(String msg, Messenger sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public void run() {

        this.sender.sendMessage(this.msg);
    }
}