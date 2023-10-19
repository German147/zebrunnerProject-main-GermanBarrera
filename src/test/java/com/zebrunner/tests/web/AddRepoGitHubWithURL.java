package com.zebrunner.tests.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.projects.pages.ProjectsPage;
import com.zebrunner.projects.pages.launchersPage.LaunchersPage;
import com.zebrunner.projects.pages.launchersPage.componentLaunchers.AddRepoComponent;
import com.zebrunner.projects.pages.launchersPage.enumLauncher.RepoButtonEnum;
import com.zebrunner.singin.enums.AddGitHubEnum;
import functionality.IGoTo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.zebrunner.projects.enums.MenuItemsOptionsEnum.LAUNCHERS;

public class AddRepoGitHubWithURL implements IAbstractTest, IGoTo {
    private static final Logger LOGGER = Logger.getLogger(SingInTests.class.getName());
    ProjectsPage projectsPage = new ProjectsPage(getDriver());

    //here I am creating a commit
    LaunchersPage launcher = new LaunchersPage(getDriver());
    @BeforeTest()
    public void loginAndGoToPage(){
        goToAlpha(getDriver(), LAUNCHERS);
    }
    @Test
    public void RF_testAddGitHubRepoWithURL() {
        launcher.clickOnRepositoryButton();
        AddRepoComponent addRepoComponent = projectsPage.getAddRepoComponent();
        addRepoComponent.clickOnWithURLButton().clickRepoItem(RepoButtonEnum.GITHUB)
                .typeIntoGitHubCredentials(AddGitHubEnum.URL_GIT, R.CONFIG.get("urlGitKey"))
                .typeIntoGitHubCredentials(AddGitHubEnum.USERNAME_GIT, R.CONFIG.get("usernameGit"))
                .typeIntoGitHubCredentials(AddGitHubEnum.TOKEN_GIT_HUB, R.CONFIG.get("tokenGit"))
                .clickOnAddButton();

        Assert.assertTrue(launcher.isRepoConnected(), "The repository was not connected");
    }

}
