package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features = { "classpath:features" }, glue = {"classpath:stepDefinitions"}, plugin = { "pretty", "json:target/jsonReports/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true) 

public class TestRunner extends AbstractTestNGCucumberTests {
	
}