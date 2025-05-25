package es.jmjg.experiment.stream;

import java.util.List;

public class ReduceExperiment {

    public Integer sumAll(List<Integer> list) {
        return list.stream()
            .reduce(0, (acc, x) -> acc + x);
    }
}
