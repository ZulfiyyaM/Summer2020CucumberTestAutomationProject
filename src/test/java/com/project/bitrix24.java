package com.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bitrix24 {
    WebDriver driver;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("login2.nextbasecrm.com");
    }
    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("hr6@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser", Keys.ENTER);
        // driver.findElement(By.cssSelector("input.login-btn")).click(); // plan "B"
        Thread.sleep(3000);
    }
    @Then("user should be able to see the homepage")
    public void user_should_be_able_to_see_the_homepage() {
        String expected = "(128) Portal";
        String actual = driver.findElement(By.linkText("(128) Portal")).getText().trim();
        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        driver.quit();
    }

}
