package Implementation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/sd/feature_files"}, glue = {"Implementation"}, tags = {"@OpenGoogle"})

public class RunTest {

}
