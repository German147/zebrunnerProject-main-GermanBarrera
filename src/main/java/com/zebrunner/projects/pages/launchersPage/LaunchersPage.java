package com.zebrunner.projects.pages.launchersPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.projects.components.LauncherInfoComponent;
import com.zebrunner.projects.components.LaunchersListComponent;
import com.zebrunner.projects.enums.EnvironmentTypeEnum;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LaunchersPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Repository']//..//..//button")
    private ExtendedWebElement repositoryButton;
    @FindBy(css = "ul.launcher-tree")
    private LaunchersListComponent launchersListComponent;

    @FindBy(css= "div.selected-launcher__wrapper")
    private LauncherInfoComponent launcherInfoComponent;

    @FindBy(xpath = "//span[text()='Repo is connected.']")
    private ExtendedWebElement connectedMessage;



    public LaunchersPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLauncher(String launcherName) {
        for (ExtendedWebElement launcher : launchersListComponent.getLaunchersList())
            if (launcher.getText().contains(launcherName)) {
                launcher.click();
                break;
            }
    }

    public AddRepoPage clickOnRepositoryButton() {
        repositoryButton.click();
        return new AddRepoPage(driver);
    }

    public boolean isRepoConnected() {
        return connectedMessage.isElementPresent();
    }
public LaunchersListComponent getLaunchersListComponent(){
        return launchersListComponent;
    }
    public LauncherInfoComponent getLauncherInfoComponent() {
        return launcherInfoComponent;
    }

    public void addEnvVariable(String name,EnvironmentTypeEnum type, String defaultValue){
        launcherInfoComponent.clickEditButton();
        launcherInfoComponent.addEnvVariable(name,type, defaultValue);
    }


}
