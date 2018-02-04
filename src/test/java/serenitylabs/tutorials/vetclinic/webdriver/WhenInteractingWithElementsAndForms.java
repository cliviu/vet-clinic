package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void entering_a_field_value() {

        // TODO: Enter 'Town Hall' into the 'From' field
        WebElement display_origin = driver.findElement(By.id("display_origin"));
        display_origin.sendKeys("Town Hall");
        String displayedValue = display_origin.getAttribute("value");
        assertThat(displayedValue, equalTo("Town Hall"));
    }


    @Test
    public void click_on_a_button() {
        // TODO: Click on the View Trip button
        WebElement viewTripButton = driver.findElement(By.id("btnTripPlannerSubmit"));
        viewTripButton.click();
        String title = driver.findElement(By.cssSelector(".plan_trip")).getText();
        assertThat(title, is("Plan Your Trip"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox
        WebElement plannerRemember = driver.findElement(By.id("chkPlannerRemember"));
        plannerRemember.click();
        Boolean rememberMeChoice = plannerRemember.isSelected();
        assertThat(rememberMeChoice, is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        // TODO: Choose the 'Leave After' option and make sure it is the one selected
        //WebElement leaveAfter = driver.findElement(By.id("itdTripDateTimeDep"));
        WebElement leaveAfter = driver.findElement(By.cssSelector("[value='dep']"));
        leaveAfter.click();
        assertThat(leaveAfter.isSelected(), is(true));

        WebElement arriveBefore = driver.findElement(By.id("itdTripDateTimeArr"));
        assertThat(arriveBefore.isSelected(),is(false));

        String leaveOrArrivePreference = arriveBefore.getAttribute("value");
        assertThat(leaveOrArrivePreference, is("arr"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm
        Select timeList = new Select(driver.findElement(By.id("itdTimeHour")));
        timeList.selectByVisibleText("12");

        String selectedHour = timeList.getFirstSelectedOption().getAttribute("value");

        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
