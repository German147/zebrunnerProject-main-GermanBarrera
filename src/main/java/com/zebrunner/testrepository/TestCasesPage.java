package com.zebrunner.testrepository;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static functionality.JS.scrollToElement;

public class TestCasesPage extends AbstractPage {
    private static final String BUTTON_LOCATOR = "//button[normalize-space()=";
    @FindBy(xpath = "//div[contains(@class,'repository__control-panel')]//button[contains(@type,'button')]")
    private ExtendedWebElement addNewSuiteButton;
    @FindBy(xpath = "//input[@id='name']")
    private ExtendedWebElement titleInput;
    @FindBy(xpath = ("(//textarea[@id='description'])"))
    private ExtendedWebElement suiteDescriptionInput;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private ExtendedWebElement toast;
    @FindBy(xpath = BUTTON_LOCATOR + "'Create']")
    private ExtendedWebElement createButton;

    @FindBy(xpath = BUTTON_LOCATOR + "'Save']")
    private ExtendedWebElement saveButton;
    @FindBy(xpath = BUTTON_LOCATOR + "'Delete']")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//span[normalize-space()='case']")
    private ExtendedWebElement addTestCaseButton;
    @FindBy(xpath = "(//p[contains(text(),'Test Case One')])")
    private ExtendedWebElement testCaseName;
    @FindBy(xpath = "//button[@aria-label='Edit']//*[name()='svg']")
    private ExtendedWebElement editSuiteIcon;
    @FindBy(xpath = "//button[@aria-label='Delete']")
    private ExtendedWebElement suiteTrashIcon;
    @FindBy(xpath = "//span[normalize-space()='%s']")
    private ExtendedWebElement suiteName;

    @FindBy(xpath = "//p[@class='repository-virtuoso-item-suite__title']")
    private ExtendedWebElement suiteDescriptionShortCut;
    @FindBy(xpath = "//p[@class='repository-virtuoso-item-description']") //
    private ExtendedWebElement suiteDescription;

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddNewSuiteButton() {
        addNewSuiteButton.click();
    }

    public void clickOnAddTestCaseButton() {
        addTestCaseButton.click();
    }

    public void typeTitle(String title) {
        titleInput.type(title);
    }

    public void updateSuiteTitle(String updatedTitle) {
        clearInput(titleInput);
        typeTitle(updatedTitle);
    }

    public void typeSuiteDescription(String description) {
        clearInput(suiteDescriptionInput);
        suiteDescriptionInput.type(description);
    }

    public void clickOnCreateButton() {
        createButton.click();
    }


    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public String getToastText() {
        return toast.getText();
    }

    public String clickOnSelectedSuiteEditIcon(String name) {
        suiteName.format(name).click();
        editSuiteIcon.click();
        return suiteName.format(name).getText();
    }

    public void clickOnDeleteTrashIcon(String name) {
        suiteName.format(name).click();
        scrollToElement(driver, suiteTrashIcon);
        suiteTrashIcon.click();
        clickOnDeleteButton();
    }

    public boolean isSuitePresent(String name) {
        return suiteName.format(name).isElementPresent();
    }

    public String getSuiteName(String name) {
        return suiteName.format(name).getText();
    }

    public String getSuiteDescription(String name) {
        suiteName.format(name).click();
        return suiteDescription.getText();
    }

    public String getTestCaseName(String name) {
        return testCaseName.getText();
    }

    //Help clean input box before typing in
    public void clearInput(ExtendedWebElement element) {
        int stop = element.getAttribute("value").length();
        for (int i = 0; i < stop; i++) {
            element.sendKeys(Keys.ARROW_LEFT);
            element.sendKeys(Keys.DELETE);
        }
    }
}
