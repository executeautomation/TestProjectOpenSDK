package com.test;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;


public class Login {

    @BeforeTest
    public void testStart() {

        ChromeDriver driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withProjectName("My First Project")
                .withToken("U--LKi5tve35kNidu4uRp5IzAWrhL7PNVp3jEn4Y55U1")
                .withJobName("FirstJob")
                .build(ChromeDriver.class);

        driver.navigate().to("https://example.testproject.io/web/");

        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
        driver.findElement(By.cssSelector("#login")).click();

        boolean passed = driver.findElement(By.cssSelector("#logout")).isDisplayed();
        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
