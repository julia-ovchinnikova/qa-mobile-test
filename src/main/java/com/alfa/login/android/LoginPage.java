package com.alfa.login.android;

import com.alfa.login.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//*[@resource-id='com.alfabank.qapp:id/tvTitle']")
    private ExtendedWebElement loginPageTitle;

    @FindBy(id = "com.alfabank.qapp:id/etUsername")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//*[@resource-id='com.alfabank.qapp:id/etPassword']")
    private ExtendedWebElement passwordField;

    @FindBy(css = "[resource-id='com.alfabank.qapp:id/text_input_end_icon']")
    private ExtendedWebElement showPasswordIcon;

    @FindBy(xpath = "//*[@resource-id='com.alfabank.qapp:id/btnConfirm']")
    private ExtendedWebElement confirmButton;

    @FindBy(css = ".android.widget.ProgressBar")
    private ExtendedWebElement progressBar;

    @FindBy(xpath = "//*[@resource-id='com.alfabank.qapp:id/tvError']")
    private ExtendedWebElement errorLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(long timeout) {
        return loginPageTitle.isElementPresent(timeout);
    }

    @Override
    public String getLoginPageTitleText() {
        return loginPageTitle.getText();
    }

    @Override
    public void typeLogin(String login) {
        loginField.type(login);
    }

    @Override
    public String getLoginFieldText() {
        return loginField.getText();
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public String getPasswordFieldText() {
        return passwordField.getText();
    }

    @Override
    public boolean isPasswordEncrypted() {
        return Boolean.parseBoolean(passwordField.getAttribute("password"));
    }

    @Override
    public void clickShowPasswordIcon() {
        showPasswordIcon.click();
    }

    @Override
    public boolean isShowPasswordIconChecked() {
        return Boolean.parseBoolean(showPasswordIcon.getAttribute("checked"));
    }

    @Override
    public void clickConfirmButton() {
        confirmButton.click();
        waitUntil(ExpectedConditions.invisibilityOf(progressBar.getElement()), 5);
    }

    @Override
    public String getErrorLabelText() {
        return errorLabel.getText();
    }

}
