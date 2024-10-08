package com.alfa.login.ios;

import com.alfa.login.common.LoginSuccessPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginSuccessPageBase.class)
public class LoginSuccessPage extends LoginSuccessPageBase {
    public LoginSuccessPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }
}
