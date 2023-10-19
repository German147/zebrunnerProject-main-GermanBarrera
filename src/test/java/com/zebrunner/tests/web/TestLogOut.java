package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.components.HeaderComponents;
import com.zebrunner.projects.pages.ProjectsPage;
import com.zebrunner.singin.enums.SingInInputEnum;
import com.zebrunner.singin.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class TestLogOut extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(TestLogOut.class.getName());
    private static final SoftAssert softAssert = new SoftAssert();


    @Test(testName = "Log out")
    @MethodOwner(owner = "EGarciaSolvd")
    public void testLogOut(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.typeIntoInput(SingInInputEnum.USER,"mja123");
        signInPage.typeIntoInput(SingInInputEnum.PASSWORD,"teamPalmerita1");
        ProjectsPage projectsPage = signInPage.clickLoginButton();
        LOGGER.info("Successful sign in");

        HeaderComponents headerComponents = projectsPage.getHeaderComponents();
        headerComponents.clickUserButton();
        headerComponents.clickLogOutButton();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://solvdinternal.zebrunner.com/signin","The log out failed");
    }
}