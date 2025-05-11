package es.jmjg.experiment.functional;

import java.util.function.BiFunction;

public class BiFunctionExperiment {
    public static BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

    public static BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;

    public static BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;

    public static BiFunction<Integer, Integer, Integer> subtract = (x, y) -> x - y;

    public static Integer process2And3(BiFunction<Integer, Integer, Integer> f) {
        return f.apply(2, 3);
    }
    
}
