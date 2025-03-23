package es.jmjg.experiment.multithread.notifytest;

import es.jmjg.experiment.multithread.notify.Account;
import es.jmjg.experiment.multithread.notify.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AccountTest {

    @Test
    void test() {
        final Account account = new Account(1000);
        final Customer customer = new Customer(account);
        final List<Thread> threadList = new ArrayList<>();

        (new Thread(() -> customer.withdraw(1500))).start();
        (new Thread(() -> customer.withdraw(600))).start();

        Assertions.assertEquals(400, account.amount());

        System.out.printf("Current amount in account is %d%n", account.amount());

        for (int i = 0; i < 30; i++) {
            threadList.add(new Thread(() -> customer.deposit(100)));
        }

        threadList.forEach(Thread::start);

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Assertions.assertEquals(1900, account.amount());
    }
}

