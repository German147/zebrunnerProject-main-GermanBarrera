package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.EnvironmentTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class LauncherInfoComponent extends AbstractUIObject {

    public LauncherInfoComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//button[contains(@Class,'secondary  css-1obwva5')]")
    private ExtendedWebElement editButton;
    @FindBy(css = "span.selected-launcher__button-text")
    private List<ExtendedWebElement> addVarsAndCapabilitiesButtons;
    @FindBy(id = "select-undefined")
    private List<ExtendedWebElement> newVariableType;
    @FindBy(css = "li.css-19vrvbx")
    private List<ExtendedWebElement> variableTypes;
    @FindBy(xpath = "//input[contains(@Class,'css-1o6z5ng')]")
    private List<ExtendedWebElement> newDefaultValue;
    @FindBy(css="div.input-container>div>div>input")
    private List<ExtendedWebElement> inputContainers;
    @FindBy(xpath="//div[@class='custom-vars-add__col _action']")
    private List<ExtendedWebElement> deleteButtons;
    @FindBy(css = "div.selected-launcher__section-body-row > button")
    private List<ExtendedWebElement> bottomButtons;

    @FindBy(xpath = "//input[@id = 'name']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath = "//input[@id = 'branch']")
    private ExtendedWebElement branchDropDown;

//    @FindBy(css = "ul.css-tm4als>li")
//    private List<ExtendedWebElement> branchList;

    @FindBy(xpath = "//input[@id = 'dockerImage']")
    private ExtendedWebElement dockerImageDropDown;

//    @FindBy(xpath = "ul.css-tm4als>li")
//    private List<ExtendedWebElement> dockerImageList;

    @FindBy(xpath = "//input[@id = 'launchCommand']")
    private ExtendedWebElement launchCommandInput;

    @FindBy(xpath = "//div[@class='provider-capability-select']")
    private ExtendedWebElement operatingSystemButton;

    @FindBy(xpath = "//div[@class='platform-select-modal__os-item-text']")
    private List<ExtendedWebElement> operatingSystemList;

    @FindBy(xpath = "//div[@class='provider-capability-select__input-icon platform-capability-select__input-icon _left ']")
    private ExtendedWebElement deviceTypeButton;

    @FindBy(xpath = "//li[@class='device-select-modal__item ']")
    private List<ExtendedWebElement> deviceTypeList;

    @FindBy(xpath ="//span[@class='selected-launcher__section-header-title']")
    private ExtendedWebElement emailOpenButton;

    @FindBy(xpath = "//input[@id = 'emails']")
    private ExtendedWebElement emailInput;

    //@FindBy(css = "li.css-19vrvbx")
    //private List<ExtendedWebElement> envType;

    @FindBy(xpath = "//h2[@class='selected-launcher__title']")
    private ExtendedWebElement launcheTitle;


    public void clickEditButton(){
        editButton.click();
    }

    public void addEnvVariable(String name, EnvironmentTypeEnum type, String value){

        addVarsAndCapabilitiesButtons.get(0).click();
        newDefaultValue.get(newDefaultValue.size()-2).type(name);
        newVariableType.get(newVariableType.size()-1).click();
        driver.findElements(By.cssSelector("li.css-19vrvbx")).get(type.getPosition()).click();
        //envType.get(type.getPosition()).click();
        newDefaultValue.get(newDefaultValue.size()-1).type(value);

        bottomButtons.get(2).click();
    }

    public void insertInfoNewLauncher(String name, String launchCommand,String email) {
        nameInput.type(name);
        branchDropDown.click();
        pause(2);
        driver.findElements(By.cssSelector("ul.css-tm4als>li")).get(0).click();
        dockerImageDropDown.click();
        pause(2);
        driver.findElements(By.cssSelector("ul.css-tm4als>li")).get(4).click();
        launchCommandInput.type(launchCommand);
        operatingSystemButton.click();
        operatingSystemList.get(1).click();
        deviceTypeButton.click();
        deviceTypeList.get(0).click();
        emailOpenButton.click();
        emailInput.type(email);

        bottomButtons.get(1).click();
    }

    public boolean isEnvVariablePresent(String name, String value){
        return inputContainers.get(0).getAttribute("value").contains(name + "=" + value);
    }

    public void removeLastEnvVariable(){

        clickEditButton();
        deleteButtons.get(deleteButtons.size()-1).click();

        bottomButtons.get(2).click();

    }

    public ExtendedWebElement getLauncheTitle() {
        return launcheTitle;
    }
}
