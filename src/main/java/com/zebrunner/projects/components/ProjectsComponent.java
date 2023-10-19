package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProjectsComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "//div[@class='projects-table__body']" ;

    @FindBy(xpath = MAIN_LOCATOR)
    private ExtendedWebElement projectsTable;

    @FindBy(xpath = MAIN_LOCATOR+"//div[@class='projects-table__row']//a[@class='project-col _name' and contains(text(), 'AlphaTeam')]")
    private ExtendedWebElement alphaTeamBtn;

    public ProjectsComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAlphaTeam(){
        alphaTeamBtn.hover();
        alphaTeamBtn.click();
    }
}
