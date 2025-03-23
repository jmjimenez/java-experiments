package es.jmjg.experiment.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExperiment {

    public Collection<String> flattenTwoLists(List<String> a, List<String> b) {
        return Arrays.asList(a, b).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<String> flattenListOfLists(List<List<String>> list) {
        return list.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }
}
