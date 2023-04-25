package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"@target/failedrerun.txt"},
        glue= {"steps","hooks"},
		plugin = { "pretty", "html:target/cucumber-reports" }
		,monochrome=true)
public class Rerun {

	 Rerun() {
		// TODO Auto-generated method stub
		
	}

	
	
}
