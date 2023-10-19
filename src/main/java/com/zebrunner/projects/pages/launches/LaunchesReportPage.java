package com.zebrunner.projects.pages.launches;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.projects.components.launches.LaunchReportPageHeaderComponent;
import com.zebrunner.projects.components.launches.TestCardComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.logging.Logger;

public class LaunchesReportPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(LaunchesReportPage.class.getName());

    @FindBy(xpath = "//div[@class='launch-page-header__actions']")
    private LaunchReportPageHeaderComponent launchReportPageHeaderComponent;

    @FindBy(xpath = "(//div[@class='test-details__table-col'])")
    private TestCardComponent testCardComponent;

    @FindBy(xpath = "//div[@role='alert']")
    private ExtendedWebElement urlSuccessMessage;

    public LaunchesReportPage(WebDriver driver) {
        super(driver);
    }

    public LaunchReportPageHeaderComponent getLaunchReportPageHeaderComponent(){
        return launchReportPageHeaderComponent;
    }

    public TestCardComponent getTestCardComponent(){
        return testCardComponent;
    }

    public String getTextClipboard() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(urlSuccessMessage.getBy()));
        LOGGER.info(urlSuccessMessage.getText());
        return urlSuccessMessage.getText();
    }

    public void clickTestCard(){
        testCardComponent.getRootExtendedElement().click();
    }


    public boolean isFileDownloaded() throws InterruptedException {
        Thread.sleep(3000);
        String home = System.getProperty("user.home");
        String downloadPath = "/Downloads/";
        String fileName = "Gatling_API_usage.html";

        File downloadedFile = new File(home + downloadPath + fileName);
        if(downloadedFile.exists()){
            return true;
        }else{
            return false;
        }
    }

}
