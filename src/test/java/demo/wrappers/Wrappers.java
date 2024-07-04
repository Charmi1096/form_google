package demo.wrappers;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void writeText(ChromeDriver driver, By selector, String textToSend) throws Exception {
        System.out.println("Trying to send text - "+textToSend);
        // Initialize the webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait till the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        // Find the element
        WebElement element = driver.findElement(selector);
        // Clear the element text, if already present and send the text
        element.clear();
        element.sendKeys(textToSend);
        Thread.sleep(2000);
        System.out.println("Success!");
    }
    public static String calculateDateTimeToString(String formatString, long offsetInMs) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Add the offset in milliseconds to the current date and time
        long seconds = offsetInMs / 1000;
        long nanos = (offsetInMs % 1000) * 1000000;
        LocalDateTime newDateTime = now.minus(Duration.ofSeconds(seconds, nanos));

        // Format the new date and time according to the provided format string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
        String formattedDateTime = newDateTime.format(formatter);

        // Print the formatted date and time
        return formattedDateTime;
    }

    public static String calculateEpochTimeToString(int offsetInMs) {
        // Get the current date and time as an Instant
        Instant now = Instant.now();

        // Apply the offset in milliseconds to the current instant
        Instant newInstant = now.plusMillis(offsetInMs);

        // Convert the Instant to epoch time in milliseconds
        long epochMilli = newInstant.toEpochMilli();

        // Return the epoch time as a string
        return String.valueOf(epochMilli);
    }

    public static void clickCheckBox(ChromeDriver driver, By selector) throws Exception {
        System.out.println("Trying to check boxes/ radio buttons");
        // Initialize the webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait till the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        // Click the button
        WebElement element = driver.findElement(selector);
        element.click();
        Thread.sleep(2000);
        System.out.println("Success!");
    }

    public static void selectFromDropdown(ChromeDriver driver, By dropDownSelector, String textToSelect)throws Exception {
        System.out.println("Trying to select from dropdown - "+textToSelect);
        // Find Dropdown
        WebElement dropdownElement = driver.findElement(dropDownSelector);

        // Create a Select instance
        dropdownElement.click();
        Thread.sleep(2000);

        // Select the option by visible text
        driver.findElement(By.xpath("(//div[@data-value='" + textToSelect + "'])[2]")).click();
        Thread.sleep(2000);
        System.out.println("Success!");
    }

    public  static void handleAlert(ChromeDriver driver, Boolean confirm) throws InterruptedException {
        System.out.println("Trying to handle alert");
        // Wait for the alert to be present and switch to it
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        if (confirm) {
            // Accept the alert (click OK)
            alert.accept();
        } else {
            // Dismiss the alert (click Cancel)
            alert.dismiss();
        }
        System.out.println("Success!");
    }

}
