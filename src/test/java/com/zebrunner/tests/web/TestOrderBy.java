package com.zebrunner.tests.web;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.projects.pages.ProjectsPage;
import functionality.ILogin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class TestOrderBy extends AbstractTest implements ILogin {
    private static final Logger LOGGER = Logger.getLogger(TestLogOut.class.getName());
    private static final SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void doLogin(){
        login(getDriver());
    }

    @Test(testName = "Order By Key")
    @MethodOwner(owner = "CCristaldo")
    public void testOrderByKey(){

        WebDriver driver = getDriver();
        ProjectsPage projectsPage = new ProjectsPage(driver);
        List<String> rawData = new ArrayList<>();
        Assert.assertTrue(projectsPage.isOpened());
        //Getting all data as it is (raw)
        projectsPage.getDataKeysLst().forEach(d -> rawData.add(d.getText()));
        //Saving in a temp list and ordering it
        List<String> orderedData = new ArrayList<>(rawData);
        Collections.sort(orderedData);
        rawData.clear();
        //Click to order by key on webpage
        projectsPage.clickOnKeyHeader();
        //Getting ordered data from page
        projectsPage.getDataKeysLst().forEach(d -> rawData.add(d.getText()));
        //Verifying
        softAssert.assertEquals(orderedData,  rawData);
        rawData.clear();
        orderedData.clear();
        //Click to reverse order
        projectsPage.clickOnKeyHeader();
        //Getting inverted data from page
        projectsPage.getDataKeysLst().forEach(d -> rawData.add(d.getText()));
        //Reverting data previously obtained
        List<String> reversedData = new ArrayList<>(rawData);
        //Sorting
        Collections.sort(reversedData);
        //Reversing
        Collections.reverse(reversedData);
        //Verifying
        softAssert.assertEquals(reversedData,  rawData);
        softAssert.assertAll();

    }

}
