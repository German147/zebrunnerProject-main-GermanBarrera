package com.zebrunner.projects.pages.launchersPage.componentLaunchers;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.pages.launchersPage.enumLauncher.RepoButtonEnum;
import com.zebrunner.projects.pages.launchersPage.LaunchersPage;
import com.zebrunner.singin.enums.AddGitHubEnum;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddRepoComponent extends AbstractUIObject {

    private final String MAIN_LOCATOR = "//li[@class='vcs-providers__list-item']";
    @FindBy(xpath = MAIN_LOCATOR+"[%s]")
    private ExtendedWebElement menuRepoItems;

    @FindBy(xpath = "//input[@id='%s']")
    private ExtendedWebElement input;

    @FindBy(xpath = "//input[@type='checkbox']")
    private ExtendedWebElement withURLButton;

    @FindBy(id = "url")
    private WebElement urlGit;

    @FindBy(id = "username")
    private WebElement usernameGit;

    @FindBy(id = "token")
    private WebElement tokenGit;

    @FindBy(xpath = "//button[text()='Add']")
    private ExtendedWebElement addButton;

    public LaunchersPage launcher;
    public AddRepoComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverRepoItem(RepoButtonEnum menuItemsEnum){
        menuRepoItems.format(menuItemsEnum.getRepoPosition()).hover();
    }
    public AddRepoComponent clickRepoItem(RepoButtonEnum menuItemsEnum){
        menuRepoItems.format(menuItemsEnum.getRepoPosition()).click();
        return this;
    }
    public AddRepoComponent clickOnWithURLButton() {
      withURLButton.click();
      return this;
    }

    public LaunchersPage clickOnAddButton(){
        addButton.click();
        return new LaunchersPage(getDriver());
    }

    public AddRepoComponent typeIntoGitHubCredentials(AddGitHubEnum field, String text){
        input = input.format(field.getGitCredentials());
        input.type(text);
        pause(1);
        return this;
    }

}
