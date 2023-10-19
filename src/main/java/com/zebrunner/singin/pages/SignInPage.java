package com.zebrunner.singin.pages;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.projects.pages.ProjectsPage;
import com.zebrunner.singin.enums.SingInInputEnum;

public class SignInPage extends AbstractPage{
    @FindBy(xpath = "//input[@id='%s']")
    private ExtendedWebElement input;

    @FindBy(xpath = "//button[text()='Login']")
    private ExtendedWebElement loginButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public void open(){
        //openURL("https://solvdinternal.zebrunner.com/signin");
        openURL(R.CONFIG.get("url"));
    }

    public String typeIntoInput(SingInInputEnum field, String text){
        deleteInput(field);
        input = input.format(field.getId());
        input.type(text);
        pause(3);
        return input.getAttribute("value");
    }

    public void deleteInput(SingInInputEnum field){
        input = input.format(field.getId());
        String value = input.getAttribute("value");
        for(int index= 0 ; index <= value.length(); index++){
            input.sendKeys(Keys.BACK_SPACE);
        }
    }

    public ProjectsPage clickLoginButton(){
        ProjectsPage ProjectsPage = new ProjectsPage(driver);
        loginButton.click();
        return ProjectsPage;
    }

    public boolean isLoginButtonClickable(){
        return loginButton.isClickable();
    }
}
