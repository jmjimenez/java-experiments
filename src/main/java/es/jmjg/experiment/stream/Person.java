package es.jmjg.experiment.stream;

public class Person {
    private final String name;
    private final int age;
    private final String jobTitle;
    private final double salary;

    public Person(String name, int age, String jobTitle, double salary) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}