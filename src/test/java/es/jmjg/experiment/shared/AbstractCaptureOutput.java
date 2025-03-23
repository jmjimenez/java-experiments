package es.jmjg.experiment.shared;

import java.util.List;

public abstract class AbstractCaptureOutput {
    protected void assertOutputIs(List<String> expectedOutput) {
    }

    protected void assertOutputIs(String expectedOutput) {
    }

    protected void assertOutputMatches(List<String> expectedOutput) {
    }
}
