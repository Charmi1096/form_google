package demo;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;

public class TestCases {
    static ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }
    @Test
    public static void testCase01() throws InterruptedException{
        // 
        // driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        // Thread.sleep(3000);
       
        // 
        // WebElement nameTextBox = driver.findElement(By.xpath("//div[@class='geS5n']/div[2]/div[1]/div[1]/div[1]/div[1]/input"));
        // nameTextBox.sendKeys("Crio Learner");
        // nameTextBox.sendKeys(Keys.ENTER);
        // Thread.sleep(3000);

        // 
        // WebElement whyRUPracticingAutomation = driver.findElement(By.xpath("//div[@class='geS5n']/div[2]/div[1]/div[1]/div[2]/textarea"));
        // whyRUPracticingAutomation.sendKeys("I want to be the best QA Engineer! 1710572021");
        // nameTextBox.sendKeys(Keys.ENTER);
        // Thread.sleep(3000);

        // 
        // WebElement radioButton = driver.findElement(By.xpath("//div[@class='lrKTG']/div[2]/div[3]/div/div/div[2]/div/div/span/div/div[1]"));
        // radioButton.click();
        // Thread.sleep(3000);

        // 
        // List<WebElement> checkBox = driver.findElements(By.xpath("//div[@class='eBFwI'][@role='listitem']"));
        // checkBox.get(0).click();
        // Thread.sleep(3000);
        // checkBox.get(1).click();
        // Thread.sleep(3000);
        // checkBox.get(3).click();
        // Thread.sleep(3000);

        // //6.Provide how you would like to be addressed in the next dropdown//div[@class='MocG8c HZ3kWc mhLiyf OIC90c LMgvRb'][@role='option'][3]
        // WebElement chooseBtn = driver.findElement(By.xpath("//div[@class='ry3kXd'][@role='presentation']"));
        // chooseBtn.click();
        // Thread.sleep(3000);
        // WebElement chooseOption = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf OIC90c LMgvRb'][@role='option'][3]"));
        // chooseOption.click();
        // Thread.sleep(3000);

        // //7.Provided the current date minus 7 days in the next date field, it should be dynamically calculated and not hardcoded.
        System.out.println("Start Test case: Google Form");
        //1.Navigate to this google form
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(8000);
        try {
           //2.Fill in Crio Learner in the 1st text box
           Wrappers.writeText(driver, By.xpath("//div['Xb9hP']/input[@type='text']"), "Crio Learner");
            //3.Write down "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.
            // is variable
            Wrappers.writeText(driver, By.xpath("//textarea[@aria-label='Your answer']"),"I want to be the best QA Engineer! " + Wrappers.calculateEpochTimeToString(0));
            //4.Enter your Automation Testing experience in the next radio button
            Wrappers.clickCheckBox(driver, By.xpath(
                    "(//span[normalize-space(text()) = 'How much experience do you have in Automation Testing?']/ancestor::div[4]//div[@class='AB7Lab Id5V1'])[1]"));
            //5.Select Java, Selenium and TestNG from the next check-box
            Wrappers.clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[1]"));
                    Wrappers.clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[2]"));
                    Wrappers.clickCheckBox(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'Which of the following have you learned in Crio.Do for Automation Testing?']/ancestor::div[4]//div[@class='uHMk6b fsHoPb'])[4]"));
            //6.Provide how you would like to be addressed in the next dropdown
            Wrappers.selectFromDropdown(driver, By.xpath(
                    "//*[normalize-space(text()) = 'How should you be addressed?']/ancestor::div[4]//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"),
                    "Mrs");
            //7.Provided the current date minus 7 days in the next date field
            Wrappers.writeText(driver, By.xpath(
                    "//*[normalize-space(text()) = 'What was the date 7 days ago?']/ancestor::div[4]//input[@class='whsOnd zHQkBf']"),
                    Wrappers.calculateDateTimeToString("dd/MM/YYYY", (long) 6.048e+8));
                        //8.Provide the current time
                        Wrappers.writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[1]"),
                    Wrappers.calculateDateTimeToString("HH", 0));
                    Wrappers.writeText(driver, By.xpath(
                    "(//*[normalize-space(text()) = 'What is the time right now?']/ancestor::div[4]//input[@class='whsOnd zHQkBf'])[2]"),
                    Wrappers.calculateDateTimeToString("mm", 0));
            //9. Try going to another website (amazon.in) and you will find the pop up. Click
            driver.get("https://amazon.in");
            Thread.sleep(2000);
            // on cancel
            Wrappers.handleAlert(driver, false);
            //10. Submit the form
            driver.findElement(By.xpath("//*[normalize-space(text())='Submit']/ancestor::div[1]")).click();
            //11. Print the message upon successful completion
            System.out.println(driver.findElement(By.xpath("//div[@role='heading']/../div[3]")).getText());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failure!");
            return;
        }
        System.out.println("end Test case: Google Form");

    }
    

   


    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}