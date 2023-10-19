package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.components.HeaderComponents;
import com.zebrunner.projects.enums.ProjectMenuItems;
import com.zebrunner.projects.pages.ProjectsPage;
import com.zebrunner.singin.pages.SignInPage;
import functionality.ILogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class TestProjectMenu extends AbstractTest implements ILogin {
    private static final Logger LOGGER = Logger.getLogger(TestProjectMenu.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "TestAlphaOption")
    @MethodOwner(owner = "EGarciaSolvd")
    public void testAlphaOption(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        ProjectsPage projectsPage = signInPage.clickLoginButton();
        LOGGER.info("Successful sign in");

        HeaderComponents headerComponents = projectsPage.getHeaderComponents();
        headerComponents.clickProjectsButton();
        headerComponents.clickProject(ProjectMenuItems.ALPHA_BUTTON);

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://solvdinternal.zebrunner.com/projects/ALPHA/test-cases",
                "Incorrect page.");
    }
    @Test(testName = "TestBetaOption")
    @MethodOwner(owner = "EGarciaSolvd")
    public void testBetaOption(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        ProjectsPage projectsPage = signInPage.clickLoginButton();
        LOGGER.info("Successful sign in");

        HeaderComponents headerComponents = projectsPage.getHeaderComponents();
        headerComponents.clickProjectsButton();
        headerComponents.clickProject(ProjectMenuItems.BETA_BUTTON);

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://solvdinternal.zebrunner.com/projects/BETA/test-cases",
                "Incorrect page.");
    }
    @Test(testName = "TestDefaultOption")
    @MethodOwner(owner = "EGarciaSolvd")
    public void testDefaultOption(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        ProjectsPage projectsPage = signInPage.clickLoginButton();
        LOGGER.info("Successful sign in");

        HeaderComponents headerComponents = projectsPage.getHeaderComponents();
        headerComponents.clickProjectsButton();
        headerComponents.clickProject(ProjectMenuItems.DEFAULT_BUTTON);

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://solvdinternal.zebrunner.com/projects/DEF/test-cases",
                "Incorrect page.");
    }
    @Test(testName = "TestViewAllOption")
    @MethodOwner(owner = "EGarciaSolvd")
    public void testViewOption(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        ProjectsPage projectsPage = signInPage.clickLoginButton();
        LOGGER.info("Successful sign in");

        HeaderComponents headerComponents = projectsPage.getHeaderComponents();
        headerComponents.clickProjectsButton();
        headerComponents.clickViewAllProjects();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://solvdinternal.zebrunner.com/projects/ALPHA/test-cases",
                "Incorrect page.");
    }
}
