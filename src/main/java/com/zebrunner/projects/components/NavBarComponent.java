package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavBarComponent extends AbstractUIObject {
    private static final String MAIN_LOCATOR = "//div[@class='header-wrapper']";

    @FindBy(xpath = MAIN_LOCATOR+"//img[@alt='logo']")
    private ExtendedWebElement zebrunnerLogo;
    @FindBy(xpath = MAIN_LOCATOR+"//div[@class='projects-dropdown']/button")
    private ExtendedWebElement projectsButton;
    @FindBy(xpath = "//ul[contains(@class,'MuiList')]//div[@class='project-item__name']")
    private ExtendedWebElement projectTeamName;
    @FindBy(xpath = "//ul[contains(@class,'MuiList')]//div[@class='project-item__shortname']")
    private ExtendedWebElement projectTeamShortName;
    @FindBy(xpath = "//ul[contains(@class,'MuiList')]//img")
    private ExtendedWebElement projectTeamImage;
    @FindBy(xpath = "(//ul[contains(@class,'MuiList')]//li)[last()]/a")
    private ExtendedWebElement viewAllProjectsButton;
    @FindBy(className = "header-item__link")
    private ExtendedWebElement docsButton;
    @FindBy(id = "basic-button")
    private ExtendedWebElement solvdButton;
    protected NavBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
