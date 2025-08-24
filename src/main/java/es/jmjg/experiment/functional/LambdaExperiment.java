package es.jmjg.experiment.functional;

public class LambdaExperiment {
    public interface MathOperation {
        int operate(int a, int b);
    }

    public static MathOperation add = (a, b) -> a + b;
    public static MathOperation subtract = (a, b) -> a - b;
    public static MathOperation multiply = (a, b) -> a * b;
    public static MathOperation divide = (a, b) -> a / b;

}
