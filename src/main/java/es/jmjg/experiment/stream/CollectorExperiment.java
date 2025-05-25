package es.jmjg.experiment.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorExperiment {

    public String joinAll(List<String> list) {
        return list.stream()
            .collect(Collectors.joining(", "));
    }

    public Map<String, Double> calculateAverageSalary(List<Person> list) {
        return list.stream()
            .collect(Collectors.groupingBy(Person::getJobTitle))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                    .stream()
                    .mapToDouble(Person::getSalary)
                    .average()
                    .orElse(-2)
            ));
    }

}
