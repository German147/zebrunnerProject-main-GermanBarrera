package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.components.launches.LaunchReportPageHeaderComponent;
import com.zebrunner.projects.components.launches.LauncherTableComponent;
import com.zebrunner.projects.components.launches.TestCardComponent;
import com.zebrunner.projects.enums.launches.LaunchesCardOptionsEnum;
import com.zebrunner.projects.enums.launches.LaunchesReportHeaderOptionsEnum;
import com.zebrunner.projects.enums.MenuItemsOptionsEnum;
import com.zebrunner.projects.pages.launches.LaunchesPage;
import com.zebrunner.projects.pages.launches.LaunchesReportPage;
import functionality.IGoTo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShareLaunchesTests extends AbstractTest implements IGoTo {

    //private static final Logger LOGGER = Logger.getLogger(ShareLaunchesTests.class.getName());

    @BeforeTest
    public void signIn(){
        goToAlpha(getDriver(), MenuItemsOptionsEnum.LAUNCHES);
    }


    @Test(testName = "Verify Pop Up Share Launches By Link")
    @MethodOwner(owner = "FacuEstigarribia")
    public void testVerifyPopUpShareLaunchesByLink() throws Exception {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesReportPage launchesReportPage = new LaunchesReportPage(driver);
        LauncherTableComponent launcherTableComponent = launchesPage.getLauncherTableComponent();
        launcherTableComponent.hoverLaunchCard(2);
        launcherTableComponent.clickLaunchCard(2);
        TestCardComponent testCardComponent = launchesReportPage.getTestCardComponent();
        testCardComponent.clickCopyURLBtn(LaunchesCardOptionsEnum.COPY_URL);

        String expectedMessage = "URL was successfully copied";
        assertEquals(launchesReportPage.getTextClipboard(),expectedMessage, "The message is not that expected");
    }

    @Test(testName = "Share launches by Link")
    @MethodOwner(owner = "FacuEstigarribia")
    public void testShareLaunchesByLink() throws Exception{
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesReportPage launchesReportPage = new LaunchesReportPage(driver);
        LauncherTableComponent launcherTableComponent = launchesPage.getLauncherTableComponent();
        launcherTableComponent.hoverLaunchCard(2);
        launcherTableComponent.clickLaunchCard(2);
        TestCardComponent testCardComponent = launchesReportPage.getTestCardComponent();
        testCardComponent.clickLaunchesCard();

        String expectedUrl = "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches/12982/tests/37428?runsState=cGFnZT0x";
        assertEquals(driver.getCurrentUrl(), expectedUrl, "The URL is not that expected.");
    }

    @Test(testName = "Copy Link Launches with Header Component")
    @MethodOwner(owner = "FacuEstigarribia")
    public void testCopyLinkWithHeaderComponent(){
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesReportPage launchesReportPage = new LaunchesReportPage(driver);
        LauncherTableComponent launcherTableComponent = launchesPage.getLauncherTableComponent();
        launcherTableComponent.hoverLaunchCard(2);
        launcherTableComponent.clickLaunchCard(2);
        LaunchReportPageHeaderComponent launchReportPageHeaderComponent = launchesReportPage.getLaunchReportPageHeaderComponent();
        launchReportPageHeaderComponent.clickCopyLinkBtn();

        String expectedUrl = "https://solvdinternal.zebrunner.com/projects/ALPHA/automation-launches/12982?runsState=cGFnZT0x&launchState=dGVzdHM%3D";
        assertEquals(driver.getCurrentUrl(), expectedUrl,"The URL is not that expected");
    }


    @Test(testName = "Test verify pop up message after copy link with header")
    @MethodOwner(owner = "FacuEstigarribia")
    public void testVerifyPopUpCopyLinkWithHeaderComponent() throws Exception {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesReportPage launchesReportPage = new LaunchesReportPage(driver);
        LauncherTableComponent launcherTableComponent = launchesPage.getLauncherTableComponent();
        launcherTableComponent.hoverLaunchCard(2);
        launcherTableComponent.clickLaunchCard(2);
        LaunchReportPageHeaderComponent launchReportPageHeaderComponent = launchesReportPage.getLaunchReportPageHeaderComponent();
        launchReportPageHeaderComponent.clickCopyLinkBtn();

        String expectedMessage = "Link copied to clipboard";
        assertEquals(launchesReportPage.getTextClipboard(), expectedMessage, "The message is not that expected");
    }

    @Test(testName = "Export to HTML test")
    @MethodOwner(owner = "FacuEstigarribia")
    public void testExportToHTML() throws InterruptedException {
        WebDriver driver = getDriver();
        LaunchesPage launchesPage = new LaunchesPage(driver);
        LaunchesReportPage launchesReportPage = new LaunchesReportPage(driver);
        LauncherTableComponent launcherTableComponent = launchesPage.getLauncherTableComponent();
        launcherTableComponent.hoverLaunchCard(2);
        launcherTableComponent.clickLaunchCard(2);
        LaunchReportPageHeaderComponent launchReportPageHeaderComponent = launchesReportPage.getLaunchReportPageHeaderComponent();
        launchReportPageHeaderComponent.clickExportToHTML(LaunchesReportHeaderOptionsEnum.EXPORT_TO_HTML);
        assertEquals(launchesReportPage.isFileDownloaded(), true);
    }


}
