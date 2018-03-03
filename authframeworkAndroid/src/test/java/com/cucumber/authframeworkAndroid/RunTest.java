package com.cucumber.authframeworkAndroid;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, strict = true, features = {

		"src/test/resources/SSNMissing.feature",

}, glue = "com.cucumber.authframeworkAndroid", tags = {

		"@SSNMissing",

}, monochrome = false, plugin = { "pretty", "html:results/html/cucumber.html", "json:results/cucumber.json",
		"junit:results/cucumber.xml" }

)
public class RunTest {

	public RunTest() {

	}
}

