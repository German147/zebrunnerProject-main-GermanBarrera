package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.enums.EnvironmentTypeEnum;
import com.zebrunner.projects.pages.launchersPage.LaunchersPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import functionality.IGoTo;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

import static com.zebrunner.projects.enums.MenuItemsOptionsEnum.LAUNCHERS;


public class LaunchersTests extends AbstractTest implements IGoTo {


    private static final Logger LOGGER = Logger.getLogger(LaunchersTests.class.getName());
    private WebDriver driver = getDriver();

    @BeforeTest()
    public void loginAndGoToPage(){
        goToAlpha(driver, LAUNCHERS);
    }

    @Test(testName = "testAddNewEnvironmentVariable")
    @MethodOwner(owner = "jparaducha")
    public void testAddDeleteNewEnvironmentVariable(){

        LaunchersPage launchersPage = new LaunchersPage(driver);
        launchersPage.getLaunchersListComponent().openCypressJulianLauncher();
        launchersPage.addEnvVariable("testVariableName", EnvironmentTypeEnum.STRING,"testVariableValue");
        Assert.assertTrue(launchersPage.getLauncherInfoComponent().isEnvVariablePresent("testVariableName", "testVariableValue"), "new variable wasn't added");

        launchersPage.getLauncherInfoComponent().removeLastEnvVariable();
        Assert.assertFalse(launchersPage.getLauncherInfoComponent().isEnvVariablePresent("testVariableName", "testVariableValue"), "env variable wasn't removed");
    }

    @Test(testName = "testAddNewLauncher")
    @MethodOwner(owner = "jschirmer")
    public void testAddNewLauncher(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launchers/66");
        LaunchersPage launchersPage = new LaunchersPage(getDriver());
        launchersPage.clickOnLauncher("jparaducha/cypressTest");
        launchersPage.getLaunchersListComponent().clickAddNewLauncherDemoButton();
        launchersPage.getLauncherInfoComponent().insertInfoNewLauncher("TestName","mvn clean test --Dsuite=${SuiteName}","demo@solvd.com");
        Assert.assertTrue(launchersPage.getLauncherInfoComponent().getLauncheTitle().getText().equals("TestName"), "new launcher wasn't added");
    }

}
