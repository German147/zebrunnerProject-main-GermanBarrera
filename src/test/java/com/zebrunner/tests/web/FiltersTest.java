package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.pages.launches.LaunchesPage;
import com.zebrunner.projects.pages.ProjectsPage;
import com.zebrunner.projects.pages.TestCasesPage;
import functionality.IGoTo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.zebrunner.projects.enums.MenuItemsOptionsEnum.TEST_CASES;

public class FiltersTest extends AbstractTest implements IGoTo{

    private static final Logger log = Logger.getLogger(FiltersTest.class.getName());

    @BeforeTest()
    public void loginAndGoToPage(){
        goToAlpha(getDriver(), TEST_CASES);
    }

    @Test(testName = "testFilterPassedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterPassed() {
        WebDriver driver = getDriver();
        ProjectsPage homePage = new ProjectsPage(getDriver());
        homePage.open();
        homePage.setUsername().setPassword().clickLogin();
        //sign in
        homePage.clickOnAlphaTeam();
        //get into project.
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnRocketIcon();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        launchesPage.clickOnStatus();
        //filter by status
        launchesPage.filterByPassed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=PASSED&page=1");
    }

    @Test(testName = "testFilterFailedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterFailed() {
        WebDriver driver = getDriver();
        ProjectsPage homePage = new ProjectsPage(getDriver());
        homePage.open();
        homePage.setUsername().setPassword().clickLogin();
        //sign in
        homePage.clickOnAlphaTeam();
        //get into project.
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnRocketIcon();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        launchesPage.clickOnStatus();
        //filter by status
        launchesPage.filterByFailed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=FAILED&page=1");
    }

    @Test(testName = "testFilterSkippedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterSkipped() {
        WebDriver driver = getDriver();
        ProjectsPage homePage = new ProjectsPage(getDriver());
        homePage.open();
        homePage.setUsername().setPassword().clickLogin();
        //sign in
        homePage.clickOnAlphaTeam();
        //get into project.
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnRocketIcon();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        launchesPage.clickOnStatus();
        //filter by status
        launchesPage.filterBySkipped();
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=SKIPPED&page=1");
    }

    @Test(testName = "testFilterAbortedTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterAborted() {
        WebDriver driver = getDriver();
        ProjectsPage homePage = new ProjectsPage(getDriver());
        homePage.open();
        homePage.setUsername().setPassword().clickLogin();
        //sign in
        homePage.clickOnAlphaTeam();
        //get into project.
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnRocketIcon();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        launchesPage.clickOnStatus();
        //filter by status
        launchesPage.filterByAborted();
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=ABORTED&page=1");
    }

    @Test(testName = "testFilterInProgressTests")
    @MethodOwner(owner = "fazcurra")
    public void testFilterInProgress() {
        WebDriver driver = getDriver();
        ProjectsPage homePage = new ProjectsPage(getDriver());
        homePage.open();
        homePage.setUsername().setPassword().clickLogin();
        //sign in
        homePage.clickOnAlphaTeam();
        //get into project.
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnRocketIcon();
        LaunchesPage launchesPage = new LaunchesPage(getDriver());
        launchesPage.clickOnStatus();
        //filter by status
        launchesPage.filterByInProgress();
        Assert.assertEquals(driver.getCurrentUrl(), "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches?status=IN_PROGRESS&page=1");
    }


}
