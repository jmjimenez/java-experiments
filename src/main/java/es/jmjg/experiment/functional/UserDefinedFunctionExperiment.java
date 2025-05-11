package es.jmjg.experiment.functional;

public class UserDefinedFunctionExperiment {
     public final NoArgFunction<Integer> getRandomNumber;

     public UserDefinedFunctionExperiment() {
         getRandomNumber = getRandomNumber(100);
     }

     public UserDefinedFunctionExperiment(Integer range) {
         getRandomNumber = getRandomNumber(range);
     }

    public final TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

    public final NoArgFunction<Integer> getRandomNumber(Integer range) {
        return () -> (int) (Math.random() * range);
    }

}
