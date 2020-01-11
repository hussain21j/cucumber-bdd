import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.bdd.stepdef"
)

/**
 * This runner class is the Junit test runner for all the feature files, this is identified by the @Runwith(Cucumber.class)
 * Remember the runner class should have the default name format as specified in spring for any Test class like <*Test> or <Test*> or <*TestCase>
 * else you have to do configure in surefire plugin refer https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#includes
 *
 * cucumber options points to the the directory where the feature files are present
 * and glue points to the directory where step definitions are present
 */
public class TestRunner {
}
