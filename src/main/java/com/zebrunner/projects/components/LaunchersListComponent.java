package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaunchersListComponent extends AbstractUIObject {


    @FindBy(xpath="//div[@class='launcher-tree__repo-name']")
    private List<ExtendedWebElement> launchersList;
    @FindBy(xpath = "//div[contains(text(),'jparaducha')]/parent::div//button")
    private ExtendedWebElement cypressTestButton;
    @FindBy(xpath = "//div[contains(text(), 'cypressLauncher')]")
    private ExtendedWebElement cypressLauncher;
    @FindBy(xpath = "//div[contains(text(), 'cypressJulian')]")
    private ExtendedWebElement cypressJulian;
    @FindBy(xpath = "//li[@class='launcher-tree__item _active']//span[@class='launcher-tree__item-new-launcher-text'][normalize-space()='Add new launcher']") //Mejorar este locator
    private ExtendedWebElement addNewLauncherDemoButton;


    public LaunchersListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getLaunchersList() {
        return launchersList;
    }

    public void clickAddNewLauncherDemoButton() {
        addNewLauncherDemoButton.click();
    }

    public void openCypressJulianLauncher(){
        cypressTestButton.click();
        cypressLauncher.click();
        cypressJulian.click();
    }



}
