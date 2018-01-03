package serenitylabs.tutorials.vetclinic;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenLookingForAPetStore {

    @Test
    public void should_find_pet_stores(){
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://duckduckgo.com");
        firefox.findElement(By.id("search_form_input_homepage")).sendKeys("pet store");
        firefox.findElement(By.id("search_button_homepage")).click();
        assertThat(firefox.getTitle(), equalTo("pet store at DuckDuckGo"));
        firefox.quit();
    }
}
