package com.zebrunner.projects.pages.launchersPage;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.singin.enums.AddGitHubEnum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AddRepoPage extends AbstractPage {

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
    private WebElement addButton;

    protected AddRepoPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnWithURLButton() {
        withURLButton.click();
    }

    public void setUrlGit() {
        urlGit.sendKeys(R.CONFIG.get("urlGitKey"));
    }

    public void setUsernameGit() {
        usernameGit.sendKeys(R.CONFIG.get("username"));
    }

    public void setTokenGit() {
        tokenGit.sendKeys(R.CONFIG.get("tokenGit"));
    }

    public LaunchersPage clickOnAddButton(){
        LaunchersPage LaunchersPage = new LaunchersPage(getDriver());
        addButton.click();
        return LaunchersPage;
    }
    
    public void typeIntoGitHubCredentials(AddGitHubEnum field, String text){
        input = input.format(field.getGitCredentials());
        input.type(text);
        pause(1);
    }
}
