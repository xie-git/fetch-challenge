package com.fetchchallenge.fetchchallenge.steps;

import com.fetchchallenge.fetchchallenge.FetchchallengeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = FetchchallengeApplication.class)
public class CucumberSpringConfiguration {
}
