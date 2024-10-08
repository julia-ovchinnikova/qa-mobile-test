package com.alfa.login.ios;

import com.alfa.login.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(long timeout) {
        throw new NotImplementedException();
    }

    @Override
    public String getLoginPageTitleText() {
        throw new NotImplementedException();
    }

    @Override
    public void typeLogin(String login) {
        throw new NotImplementedException();
    }

    @Override
    public String getLoginFieldText() {
        throw new NotImplementedException();
    }

    @Override
    public void typePassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public String getPasswordFieldText() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPasswordEncrypted() {
        throw new NotImplementedException();
    }

    @Override
    public void clickShowPasswordIcon() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isShowPasswordIconChecked() {
        throw new NotImplementedException();
    }

    @Override
    public void clickConfirmButton() {
        throw new NotImplementedException();
    }

    @Override
    public String getErrorLabelText() {
        throw new NotImplementedException();
    }
}
