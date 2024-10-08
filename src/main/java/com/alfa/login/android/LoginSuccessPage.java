package com.alfa.login.android;

import com.alfa.login.common.LoginSuccessPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginSuccessPageBase.class)
public class LoginSuccessPage extends LoginSuccessPageBase {

    @FindBy(css = ".android.widget.TextView[text='Вход в Alfa-Test выполнен']")
    private ExtendedWebElement successfulLoginTitle;

    public LoginSuccessPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(long timeout) {
        return successfulLoginTitle.isElementPresent(timeout);
    }

}
