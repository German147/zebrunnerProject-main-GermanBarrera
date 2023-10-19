package functionality;

import com.zebrunner.projects.components.ProjectsComponent;
import com.zebrunner.projects.components.SideBarComponent;
import com.zebrunner.projects.enums.MenuItemsOptionsEnum;
import com.zebrunner.projects.pages.ProjectsPage;
import org.openqa.selenium.WebDriver;

import static com.zebrunner.projects.enums.MenuItemsOptionsEnum.TEST_CASES;

public interface IGoTo extends ILogin{
    default void goToAlpha(WebDriver driver, MenuItemsOptionsEnum menuItemsOptionsEnum){
        login(driver);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        SideBarComponent sideBarComponent = projectsPage.getSideBarComponent();
        ProjectsComponent projectsComponent = projectsPage.getProjectsComponent();
        projectsComponent.clickAlphaTeam();
        if(!menuItemsOptionsEnum.equals(TEST_CASES)){
            sideBarComponent.clickMenuItemOption(menuItemsOptionsEnum);
        }
    }
}
