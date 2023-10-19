package com.zebrunner.projects.pages.launches;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.projects.components.launches.LauncherTableComponent;
import com.zebrunner.projects.components.LaunchesBarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaunchesPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='launch-card ']")
    private LauncherTableComponent launcherTableComponent;
    @FindBy(xpath = "//span[text()='Launcher']")
    private ExtendedWebElement launcherButton;
    @FindBy(xpath = "//div[@class='launches-filter__control-wrapper']")
    private LaunchesBarComponent launchesBarComponent;

    @FindBy(xpath = "//div[contains(@class, 'launches-filter__control-wrapper')]//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Status')]")
    private ExtendedWebElement statusFilterButton;

    @FindBy(xpath = "//div[contains(@class, 'launches-filter__control-wrapper')]//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Browser')]")
    private ExtendedWebElement browserFilterButton;

    @FindBy(xpath = "//div[contains(@class, 'launches-filter__control-wrapper')]//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Platform')]")
    private ExtendedWebElement platformFilterButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='Passed']")
    private ExtendedWebElement passedButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='Failed']")
    private ExtendedWebElement failedButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='Skipped']")
    private ExtendedWebElement skippedButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='Aborted']")
    private ExtendedWebElement abortedButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='In Progress']")
    private ExtendedWebElement inProgressButton;

    public LaunchesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnStatus() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        statusFilterButton.click();
    }

    public void filterByPassed() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(e -> passedButton.isClickable());
        passedButton.click();
    }

    public void filterByFailed() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(e -> failedButton.isClickable());
        failedButton.click();
    }

    public void filterBySkipped() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(e -> skippedButton.isClickable());
        skippedButton.click();
    }

    public void filterByAborted() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(e -> abortedButton.isClickable());
        abortedButton.click();
    }

    public void filterByInProgress() {
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(e -> inProgressButton.isClickable());
        inProgressButton.click();
    }

    public LauncherTableComponent getLauncherTableComponent() {
        return launcherTableComponent;
    }

    public LaunchesBarComponent getLaunchesBarComponent() {
        return launchesBarComponent;
    }
}