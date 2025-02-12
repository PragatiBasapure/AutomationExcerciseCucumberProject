package org.stepDefination;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	features={"src/test/resources/Features/TestCase01_SignUp.feature",
			  "src/test/resources/Features/TestCase02_Login.feature"
			  },
	glue="org.stepDefination",
	dryRun=false,
	plugin= {"pretty","html:target/cucumber_reports.html"},
	monochrome=true
	
)

public class TestRunnerDemo  extends AbstractTestNGCucumberTests{

}
