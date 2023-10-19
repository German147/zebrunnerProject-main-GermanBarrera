package com.zebrunner.tests.web.login;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import functionality.ILogin;
import org.testng.annotations.Test;

public class LoginTests implements IAbstractTest, ILogin {

    @Test(description="Just a simple Login Test")
    @MethodOwner(owner = "mleg")
    public void simpleLoginTest(){
        login(getDriver());
    }



}
