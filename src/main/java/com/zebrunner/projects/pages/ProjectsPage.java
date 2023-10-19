package com.zebrunner.projects.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.projects.components.HeaderComponents;
import com.zebrunner.projects.components.ProjectsComponent;
import com.zebrunner.projects.pages.launchersPage.componentLaunchers.AddRepoComponent;
import com.zebrunner.projects.components.SideBarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='sidebar-wrapper']")
    private SideBarComponent sideBarComponent;
    @FindBy(xpath = "//div[@class='header-wrapper']")
    private HeaderComponents headerComponents;
    @FindBy(xpath = "//div[@class='projects-table__body']")
    private ProjectsComponent projectsComponent;
    @FindBy(xpath = "//a[contains(text(),'AlphaTeam')]")
    private ExtendedWebElement alphaTeamButton;
    @FindBy(id = "accessKey")
    private ExtendedWebElement username;
    @FindBy(id = "password")
    private ExtendedWebElement password;
    @FindBy(css = "div.signin-form__login-button-wrapper")
    private ExtendedWebElement login;
    @FindBy(xpath = "(//div[@class='add-repo']//div)[1]")
    private AddRepoComponent addRepoComponentPage;
    @FindBy(xpath = "//H1[@class='page-header h1'][text()='Projects']")
    private ExtendedWebElement lblProjects;

    @FindBy(xpath = "//DIV[@data-title='Key']")
    private ExtendedWebElement dataKeys;


    @FindBy(css = "._key > .MuiButtonBase-root")
    private ExtendedWebElement keyHeader;


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsComponent getProjectsComponent(){
        return projectsComponent;
    }

    public SideBarComponent getSideBarComponent(){
        return sideBarComponent;
    }
    public HeaderComponents getHeaderComponents(){return headerComponents;}
    public AddRepoComponent getAddRepoComponent(){
        return addRepoComponentPage;
    }
    public TestCasesPage clickOnAlphaTeam() {
        TestCasesPage TestCasesPage = new TestCasesPage(driver);
        alphaTeamButton.click();
        return TestCasesPage;
    }
    public ProjectsPage setUsername(){
        username.type("mja123");
        return this;
    }

    public ProjectsPage setPassword(){
        password.type("teamPalmerita1");
        return this;
    }

    public ProjectsPage clickLogin(){
        login.click();
        return this;
    }

    public Boolean isOpened(){
        return lblProjects.isPresent();
    }

    public void clickOnKeyHeader(){
        keyHeader.click();
    }

    public List<ExtendedWebElement> getDataKeysLst(){
        return findExtendedWebElements(dataKeys.getBy());
    }

}
