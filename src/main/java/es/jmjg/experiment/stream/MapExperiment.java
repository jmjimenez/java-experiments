package es.jmjg.experiment.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExperiment {

    public List<Integer> timesTwo(List<Integer> list) {
        Function<Integer, Integer> timesTwo = x -> x * 2;

        return list.stream()
            .map(timesTwo)
            .collect(Collectors.toList());
    }

    public List<String> getNames(List<Person> list) {
        return list.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
    }

}