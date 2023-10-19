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

public class BrowserFiltersTest extends AbstractTest implements IGoTo {
    private static final Logger log = Logger.getLogger(StatusFiltersTest.class.getName());

    @BeforeTest
    public void signIn() {
        goToAlpha(getDriver(), MenuItemsOptionsEnum.LAUNCHES);
    }


    @Test(testName = "testChrome")
    @MethodOwner(owner = "fazcurra")
    public void testChrome() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);

        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickBrowser();
        launchesBarComponent.clickOption(FiltersEnum.CHROME);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?browser=chrome&page=1");
    }

    @Test(testName = "testElectron")
    @MethodOwner(owner = "fazcurra")
    public void testElectron() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);

        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickBrowser();
        launchesBarComponent.clickOption(FiltersEnum.ELECTRON);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?browser=electron&page=1");
    }

    @Test(testName = "testNa")
    @MethodOwner(owner = "fazcurra")
    public void testNa() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickBrowser();
        launchesBarComponent.clickOption(FiltersEnum.NA);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?browser=n%2Fa&page=1");
    }

}
