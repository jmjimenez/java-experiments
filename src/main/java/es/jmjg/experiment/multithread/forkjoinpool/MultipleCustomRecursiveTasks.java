package es.jmjg.experiment.multithread.forkjoinpool;

public class MultipleCustomRecursiveTasks {
    public void compute() {
        CustomRecursiveTask customRecursiveTaskFirst = new CustomRecursiveTask(new int[] {1, 2, 3, 11});
        CustomRecursiveTask customRecursiveTaskSecond = new CustomRecursiveTask(new int[] {4, 5, 6, 12});
        CustomRecursiveTask customRecursiveTaskLast = new CustomRecursiveTask(new int[] {7, 8, 9, 13});

        customRecursiveTaskFirst.fork();
        customRecursiveTaskSecond.fork();
        customRecursiveTaskLast.fork();

        int result = 0;
        result += customRecursiveTaskLast.join();
        result += customRecursiveTaskSecond.join();
        result += customRecursiveTaskFirst.join();

        System.out.println("Fist task is done:" + customRecursiveTaskFirst.isDone());
        System.out.println("Second task is done:" + customRecursiveTaskSecond.isDone());
        System.out.println("Third task is done:" + customRecursiveTaskLast.isDone());

        System.out.println("Result is " + result);
    }
}
