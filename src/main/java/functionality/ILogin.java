package functionality;

import com.zebrunner.carina.utils.R;
import com.zebrunner.singin.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.zebrunner.singin.enums.SingInInputEnum.PASSWORD;
import static com.zebrunner.singin.enums.SingInInputEnum.USER;

public interface ILogin {
     default void login(WebDriver driver){
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.typeIntoInput(USER, R.TESTDATA.get("user"));
        signInPage.typeIntoInput(PASSWORD, R.TESTDATA.get("password"));
        signInPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(e -> !driver.getCurrentUrl().equals("https://solvdinternal.zebrunner.com/signin"));
    }
}
