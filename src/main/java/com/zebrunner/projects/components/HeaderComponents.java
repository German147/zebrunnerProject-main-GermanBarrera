package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.ProjectMenuItems;
import com.zebrunner.projects.pages.DocumentationPage;
import com.zebrunner.singin.pages.SignInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderComponents extends AbstractUIObject {
    private static final String HEADER_LOCATOR= "//div[@class='header-wrapper']";
    @FindBy(xpath = "//a[contains(@class,'header-item__link')]")
    private ExtendedWebElement documentationButton;
    @FindBy(xpath = HEADER_LOCATOR + "//button[@id='basic-button']")
    private ExtendedWebElement userButton;
    @FindBy(xpath = HEADER_LOCATOR + "//a[contains(@href,'/signin')]")
    private ExtendedWebElement logOutButton;
    @FindBy(xpath = HEADER_LOCATOR + "//button[text()='Projects']")
    private ExtendedWebElement projectButton;
    @FindBy(xpath = "//li/a[contains(@href,[%s])]")
    private ExtendedWebElement button;
    @FindBy(xpath = "//a[text()='View all Projects']")
    private ExtendedWebElement viewAllProjectButton;

    public HeaderComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    //Methods for working on userButton
    public void clickUserButton(){
        selectAndClickOption(userButton);
    }
    public SignInPage clickLogOutButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(logOutButton.getElement()).click();
        return new SignInPage(driver);
    }

//    Methods for working on documentationButton
    public DocumentationPage clickDocumentationButton(){
        selectAndClickOption(documentationButton);
        return new DocumentationPage(driver);
    }
    //Methods for working on projectButton
    public void clickProjectsButton(){
        selectAndClickOption(projectButton);
    }
    public void clickProject(ProjectMenuItems option){
        Actions actions = new Actions(driver);
        actions.moveToElement(button.format(option.getLocator()).getElement()).click();
    }
    public void clickViewAllProjects(){
        selectAndClickOption(viewAllProjectButton);
    }


    //Helper Methods
    private void selectAndClickOption(ExtendedWebElement option){
        option.click();
    }
}