package runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "", features = "src/test/resources/features/ManageToDo.feature", glue = "definitions")
 
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
 
}