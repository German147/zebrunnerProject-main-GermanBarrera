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

public class PlatformFiltersTest extends AbstractTest implements IGoTo {
    private static final Logger log = Logger.getLogger(StatusFiltersTest.class.getName());

    @BeforeTest
    public void signIn() {
        goToAlpha(getDriver(), MenuItemsOptionsEnum.LAUNCHES);
    }

    @Test(testName = "testAndroid")
    @MethodOwner(owner = "fazcurra")
    public void testAndroid() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickPlatform();
        launchesBarComponent.clickOption(FiltersEnum.ANDROID);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?platform=android&page=1");
    }

    @Test(testName = "testApi")
    @MethodOwner(owner = "fazcurra")
    public void testApi() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickPlatform();
        launchesBarComponent.clickOption(FiltersEnum.API);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?platform=api&page=1");
    }

    @Test(testName = "testLinux")
    @MethodOwner(owner = "fazcurra")
    public void testLinux() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickPlatform();
        launchesBarComponent.clickOption(FiltersEnum.LINUX);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?platform=linux&page=1");
    }

    @Test(testName = "testMacOS")
    @MethodOwner(owner = "fazcurra")
    public void testMacOs() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickPlatform();
        launchesBarComponent.clickOption(FiltersEnum.MACOS);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?platform=android&page=1");
    }

    @Test(testName = "testNd")
    @MethodOwner(owner = "fazcurra")
    public void testNd() {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesBarComponent launchesBarComponent = launchesPage.getLaunchesBarComponent();

        launchesBarComponent.clickPlatform();
        launchesBarComponent.clickOption(FiltersEnum.ND);
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?platform=android&page=1");
    }
}
