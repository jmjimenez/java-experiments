package es.jmjg.experiment.functional;

import java.util.function.Function;

public class CompositionExperiment {

    public static Function<Integer, Integer> addOne = x -> x + 1;
    public static Function<Integer, Integer> multiplyByTwo = x -> x * 2;

    public static Function<Integer, Integer> addOneAndMultiplyByTwo = addOne.andThen(multiplyByTwo);
    public static Function<Integer, Integer> multiplyByTwoAndAddOne = addOne.compose(multiplyByTwo);
}
