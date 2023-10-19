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

public class CRUDSuiteTest extends AbstractTest implements IGoTo {
    private static final Logger LOGGER = Logger.getLogger(CRUDSuiteTest.class.getName());
    private static final String SUITE_TITLE = "First Suite";
    private static final String SUITE_EDITED_TITLE = "Edited title";
    private static final String SUITE_DESCRIPTION = "Description";
    private static final String SUITE_EDITED_DESCRIPTION = "Edited description";

    @BeforeTest()
    public void loginAndGoToPage() {
        goToAlpha(getDriver(), TEST_CASES);
    }

    @Test(testName = "Add new suite button", priority = 1)
    @MethodOwner(owner = "anaduo")
    public void testAddNewSuite() {

        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.clickOnAddNewSuiteButton();
        testCasesPage.typeTitle(SUITE_TITLE);
        testCasesPage.typeSuiteDescription(SUITE_DESCRIPTION);
        testCasesPage.clickOnCreateButton();
//        Check the New Suite is created
        testCasesPage.isSuitePresent(SUITE_TITLE);
        String createdSuite = testCasesPage.getSuiteName(SUITE_TITLE);
        String descriptionNewSuite = testCasesPage.getSuiteDescription(SUITE_TITLE);
        LOGGER.info(createdSuite);
        LOGGER.info(descriptionNewSuite);
        Assert.assertEquals(createdSuite, SUITE_TITLE, "Test Suite title does not match the expected value");
        Assert.assertEquals(descriptionNewSuite, SUITE_DESCRIPTION, "Test Suite description does not match the expected value");
    }


    @Test(testName = "Update Suite button", priority = 2)
    @MethodOwner(owner = "anaduo")
    public void testUpdateSuite() {
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        if (testCasesPage.isSuitePresent(SUITE_TITLE)) {
            testCasesPage.clickOnSelectedSuiteEditIcon(SUITE_TITLE);
            testCasesPage.updateSuiteTitle(SUITE_EDITED_TITLE);
            testCasesPage.typeSuiteDescription(SUITE_EDITED_DESCRIPTION);
            testCasesPage.clickOnSaveButton();
//        Check the existing suite is updated
            String updatedSuiteTitle = testCasesPage.getSuiteName(SUITE_EDITED_TITLE);
            LOGGER.info(updatedSuiteTitle);
            Assert.assertEquals(updatedSuiteTitle, SUITE_EDITED_TITLE);
            LOGGER.info("Test Suite was successfully updated");
        } else {
            LOGGER.info("The Suite was not found");
        }
    }

    @Test(testName = "Delete Suite trash icon", priority = 3)
    @MethodOwner(owner = "anaduo")
    public void testDeleteSuite() {
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());
        if (testCasesPage.isSuitePresent(SUITE_EDITED_TITLE)) {
            testCasesPage.clickOnDeleteTrashIcon(SUITE_EDITED_TITLE);
            LOGGER.info(testCasesPage.getToastText());
//        Check the existing suite is deleted
            if (testCasesPage.isSuitePresent(SUITE_EDITED_TITLE)) {
                LOGGER.info("The Suite already exists");
            } else {
                LOGGER.info("The Suite was successfully deleted");
            }
        }
    }
}
