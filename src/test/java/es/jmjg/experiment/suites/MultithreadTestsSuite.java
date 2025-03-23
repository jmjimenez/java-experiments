package es.jmjg.experiment.suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("es.jmjg.experiment.multithread")
@ExcludePackages("es.jmjg.experiment.suites")
public class MultithreadTestsSuite {
}
