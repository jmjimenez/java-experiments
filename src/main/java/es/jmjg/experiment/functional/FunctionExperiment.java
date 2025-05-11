package es.jmjg.experiment.functional;

import java.util.function.Function;

public class FunctionExperiment {
    private static Integer triple(Integer x) {
        return x * 3;
    }

    private static Integer sum(Integer x, Integer y) {
        return x + y;
    }

    private static Integer sum(Integer x, Integer y, Integer z) {
        return x + y + z;
    }

    public Function<Integer, Integer> returnTripleFunction() {
        return t -> triple(t);
    }

    public Function<Integer, Integer> returnSumFunction(Integer y) {
        return t -> sum(t, y);
    }

    public Function<Integer, Integer> returnSumFunction(Integer y, Integer z) {
        return t -> sum(t, y, z);
    }

    public Function<Integer, Integer> process(Integer x, Function<Integer, Integer> f) {
        return t -> f.apply(t) * x;
    }
}