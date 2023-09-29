package com.fetchchallenge.fetchchallenge;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.fetchchallenge.fetchchallenge.steps",
        plugin = {"pretty"}
)
public class CucumberRunnerTest {
}