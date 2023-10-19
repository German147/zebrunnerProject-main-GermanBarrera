package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.singin.pages.SignInPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.singin.enums.SingInInputEnum.PASSWORD;
import static com.zebrunner.singin.enums.SingInInputEnum.USER;

import java.time.Duration;
import java.util.logging.Logger;

public class SingInTests extends AbstractTest {
    private static final Logger LOGGER = Logger.getLogger(SingInTests.class.getName());

    @Test(testName = "Singing in")
    @MethodOwner(owner = "rmiguez")
    public void signInTest(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();

        fullFillInputs("mja123", "teamPalmerita1", true, signInPage);
        signInPage.clickLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(e -> !driver.getCurrentUrl().equals("https://solvdinternal.zebrunner.com/signin"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://solvdinternal.zebrunner.com/projects", "The redirected page is not as expected");
        LOGGER.info("Sing in was successful");
    }

    @Test(testName = "Checking input fields functionality")
    @MethodOwner(owner = "rmiguez")
    public void checkingInputFieldsFunctionalityTest(){
        WebDriver driver = getDriver();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();

        Assert.assertFalse(signInPage.isLoginButtonClickable(), "The login button should be disabled by default");
        fullFillInputs("mja123", "teamPalmerita1", true, signInPage);
        fullFillInputs("", "teamPalmerita1", false, signInPage);
        fullFillInputs("mja123", "teamPalmerita1", true, signInPage);
        fullFillInputs("mja123", "", false, signInPage);
    }

    private void fullFillInputs(String user,String password, boolean shouldButtonBeClickable, SignInPage signInPage) {
        Assert.assertEquals(signInPage.typeIntoInput(USER, user), user, "User input is not as expected");
        Assert.assertEquals(signInPage.typeIntoInput(PASSWORD, password), password, "Password is not as expected");
        pause(3);
        if (shouldButtonBeClickable) {
            Assert.assertTrue(signInPage.isLoginButtonClickable(), "The login button should be clickable");
        } else {
            Assert.assertFalse(signInPage.isLoginButtonClickable(), "The login button should be disabled");
        }
    }

    @Test(testName = "Sign in without credentials shouldn't be possible")
    @MethodOwner(owner = "fazcurra")
    private void emptySignxInTest(){
        WebDriver driver =  getDriver();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        fullFillInputs("","",false,signInPage);
        Assert.assertEquals(driver.getCurrentUrl(),"https://solvdinternal.zebrunner.com/signin");
        //sign in button shouldn't be clickable
    }
}