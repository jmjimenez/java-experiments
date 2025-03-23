package es.jmjg.experiment.suites;

import es.jmjg.experiment.unittest.SumTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SumTest.class})
public class SelectedTestsSuite {
}
