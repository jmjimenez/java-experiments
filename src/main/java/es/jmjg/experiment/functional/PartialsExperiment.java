package es.jmjg.experiment.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialsExperiment {
    private static TriFunction<Integer, Integer, Integer, Integer> add = (a, b, c) -> a + b + c;

    public static Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
        (x) -> (y,z) -> add.apply(x, y, z);
}
