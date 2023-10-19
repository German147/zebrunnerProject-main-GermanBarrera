package com.zebrunner.tests.web.testrepository;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.testrepository.TestCasesPage;
import functionality.IGoTo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.zebrunner.projects.enums.MenuItemsOptionsEnum.TEST_CASES;

public class CRUDTestCasesTest extends AbstractTest implements IGoTo {
    private static final Logger LOGGER = Logger.getLogger(CRUDTestCasesTest.class.getName());
    private static final String CASE_TITLE = "Test Case One";
    private static final String SUITE_TITLE = "Second Suite";

    @BeforeTest()
    public void loginAndGoToPage() {
        goToAlpha(getDriver(), TEST_CASES);
    }

    @Test(testName = "Add new test case button", priority = 1)
    @MethodOwner(owner = "anaduo")
    public void testAddNewTestCase() {

        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnAddTestCaseButton();
        testCasesPage.typeTitle(CASE_TITLE);
        testCasesPage.clickOnCreateButton();
//        Check the New Test Case is created in an existing Suite
        testCasesPage.isSuitePresent(SUITE_TITLE);
        String createdTestCase = testCasesPage.getTestCaseName(SUITE_TITLE);
        LOGGER.info(createdTestCase);
        Assert.assertEquals(createdTestCase, CASE_TITLE, "The test case title does not match the expected value");
    }
}
