package com.alfa.login.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

public abstract class LoginSuccessPageBase extends AbstractPage {
    public LoginSuccessPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(long timeout) {
        throw new NotImplementedException();
    }
}
