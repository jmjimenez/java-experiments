package es.jmjg.experiment.functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClosureExperimentTest {
    @Test
    void returnGreeter_ShouldReturnNestedFunctionWithClosure() {
        ClosureExperiment experiment = new ClosureExperiment("John");
        NoArgFunction<NoArgFunction<String>> greeterFactory = experiment.returnGreeter();
        NoArgFunction<String> greeterJohn = greeterFactory.apply();
        
        assertEquals("Hello John", greeterJohn.apply(), "Greeter should return hello message with captured name");
        
        // Test with different name to verify closure behavior
        ClosureExperiment experiment2 = new ClosureExperiment("Jane");
        NoArgFunction<NoArgFunction<String>> greeterFactory2 = experiment2.returnGreeter();
        NoArgFunction<String> greeterJane = greeterFactory2.apply();
        
        assertEquals("Hello Jane", greeterJane.apply(), "Second greeter should return hello message with different captured name");
        assertEquals("Hello John", greeterJohn.apply(), "First greeter should still use originally captured name");
    }

    @Test
    void returnGreeterWithNickname_ShouldReturnNestedFunctionWithClosureIncludingNickname() {
        ClosureExperiment experiment = new ClosureExperiment("John");
        NoArgFunction<NoArgFunction<String>> greeterFactory = experiment.returnGreeterWithNickname();
        NoArgFunction<String> greeterJohn = greeterFactory.apply();

        experiment.setNickname("Johnny");
        assertEquals("Hello John (Johnny)", greeterJohn.apply(), "Greeter should return hello message with captured name and nickname");
        
        // Test nickname change to verify closure behavior
        experiment.setNickname("J");
        assertEquals("Hello John (J)", greeterJohn.apply(), "Greeter should reflect nickname changes");
        
        // Test with different name and nickname to verify closure behavior
        ClosureExperiment experiment2 = new ClosureExperiment("Jane");
        experiment2.setNickname("Janey");
        NoArgFunction<NoArgFunction<String>> greeterFactory2 = experiment2.returnGreeterWithNickname();
        NoArgFunction<String> greeterJane = greeterFactory2.apply();
        
        assertEquals("Hello Jane (Janey)", greeterJane.apply(), "Second greeter should return hello message with different captured name and nickname");
        assertEquals("Hello John (J)", greeterJohn.apply(), "First greeter should still use originally captured name and updated nickname");
    }

    @Test
    void returnGreeterWithOriginalNickname_ShouldReturnNestedFunctionWithClosureIncludingOriginalNickname() {
        ClosureExperiment experiment = new ClosureExperiment("John", "Johnny");
        NoArgFunction<NoArgFunction<String>> greeterFactory = experiment.returnGreeterWithOriginalNickname();
        NoArgFunction<String> greeterJohn = greeterFactory.apply();

        assertEquals("Hello John (Johnny)", greeterJohn.apply(), "Greeter should return hello message with captured name and original nickname");
        
        // Test nickname change to verify closure behavior
        experiment.setNickname("J");
        assertEquals("Hello John (Johnny)", greeterJohn.apply(), "Greeter should maintain original nickname despite changes");
        
        // Test with different name and nickname to verify closure behavior
        ClosureExperiment experiment2 = new ClosureExperiment("Jane", "Janey");
        NoArgFunction<NoArgFunction<String>> greeterFactory2 = experiment2.returnGreeterWithOriginalNickname();
        NoArgFunction<String> greeterJane = greeterFactory2.apply();
        
        assertEquals("Hello Jane (Janey)", greeterJane.apply(), "Second greeter should return hello message with different captured name and nickname");
        assertEquals("Hello John (Johnny)", greeterJohn.apply(), "First greeter should still use originally captured name and original nickname");
    }
} 