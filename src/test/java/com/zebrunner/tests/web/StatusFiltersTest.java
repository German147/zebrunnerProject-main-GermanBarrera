package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.components.LaunchesBarComponent;
import com.zebrunner.projects.enums.FiltersEnum;
import com.zebrunner.projects.enums.MenuItemsOptionsEnum;
import com.zebrunner.projects.pages.launches.LaunchesPage;
import functionality.IGoTo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class StatusFiltersTest extends AbstractTest implements IGoTo {

    private static final Logger log = Logger.getLogger(StatusFiltersTest.class.getName());

    @BeforeTest
    public void signIn() {
        goToAlpha(getDriver(), MenuItemsOptionsEnum.LAUNCHES);
    }

    @Test(testName = "testFilterPassedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterPassed() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();
        launchesBarComponent.clickStatus();
        launchesBarComponent.clickOption(FiltersEnum.PASSED);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=PASSED&page=1");
    }

    @Test(testName = "testFilterFailedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterFailed() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();
        launchesBarComponent.clickStatus();
        launchesBarComponent.clickOption(FiltersEnum.FAILED);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=FAILED&page=1");
    }

    @Test(testName = "testFilterSkippedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterSkipped() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();
        launchesBarComponent.clickStatus();
        launchesBarComponent.clickOption(FiltersEnum.SKIPPED);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=SKIPPED&page=1");
    }

    @Test(testName = "testFilterAbortedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterAborted() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();
        launchesBarComponent.clickStatus();
        launchesBarComponent.clickOption(FiltersEnum.ABORTED);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=ABORTED&page=1");
    }

    @Test(testName = "testFilterInProgressTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterInProgress() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();
        launchesBarComponent.clickStatus();
        launchesBarComponent.clickOption(FiltersEnum.IN_PROGRESS);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=IN_PROGRESS&page=1");
    }
}