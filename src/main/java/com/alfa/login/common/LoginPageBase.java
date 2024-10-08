package com.alfa.login.common;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(long timeout) {
        throw new NotImplementedException();
    }

    public abstract String getLoginPageTitleText();

    public abstract void typeLogin(String login);

    public abstract String getLoginFieldText();

    public abstract void typePassword(String password);

    public abstract String getPasswordFieldText();

    public abstract boolean isPasswordEncrypted();

    public abstract void clickShowPasswordIcon();

    public abstract boolean isShowPasswordIconChecked();

    public abstract void clickConfirmButton();

    public abstract String getErrorLabelText();
}
