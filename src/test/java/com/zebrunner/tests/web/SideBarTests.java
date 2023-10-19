package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.components.SideBarComponent;
import com.zebrunner.projects.enums.MenuItemsEnum;
import com.zebrunner.projects.enums.MenuItemsOptionsEnum;
import com.zebrunner.projects.pages.ProjectsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SideBarTests extends AbstractTest {
    @BeforeTest
    public void signIn(){
        SingInTests signInTests = new SingInTests();
        signInTests.signInTest();
    }

    @Test(testName = "Check url redirects")
    @MethodOwner(owner = "rmiguez")
    public void checkUrlRedirects(){
        WebDriver driver = getDriver();
        ProjectsPage projectsPage = new ProjectsPage(driver);
        SideBarComponent sideBarComponent = projectsPage.getSideBarComponent();
        SoftAssert softAssert = new SoftAssert();
        projectsPage.openURL("https://solvdinternal.zebrunner.com/projects/ALPHA/shared-steps");

        projectsPage.waitForJSToLoad(10);
        for(MenuItemsOptionsEnum options : MenuItemsOptionsEnum.values()){
            sideBarComponent.clickMenuItemOption(options);
            String url = driver.getCurrentUrl();
            softAssert.assertTrue(url.contains("https://solvdinternal.zebrunner.com/projects/ALPHA/"+options.getUrlPart()), "The url: "+url+" does not contain: "+options.getUrlPart());
            pause(1);
        }

        sideBarComponent.clickMenuItem(MenuItemsEnum.TEST_RUNS);
        softAssert.assertEquals(driver.getCurrentUrl(),"https://solvdinternal.zebrunner.com/projects/ALPHA/test-runs", "The redirected url is not as expected");
        softAssert.assertAll();
    }
}