package com.alfa.login.android;

import com.alfa.login.common.LoginPageBase;
import com.alfa.login.common.LoginSuccessPageBase;
import com.alfa.utils.StringByRegexGenerator;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.StringGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.SecureRandom;

public class LoginWithValidValuesTest extends AbstractTest {

    @Test
    @Description(value = "Check that after entering valid values for login and password user is not authenticated as the values don't match the required for authentication")
    @Owner(value = "Julia Ovchinnikova")
    public void testEnterValidValuesForLoginAndPassword() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");

        SecureRandom random = new SecureRandom();
        int loginLength = random.nextInt(51);
        String regex = "[a-zA-Z., \\/_'-]+";
//        String regex = "[a-zA-Z., \\[\\]\\/_'-]+";
        String login = StringByRegexGenerator.getRandomString(regex, loginLength);
        int passwordLength = random.nextInt(51);
        String password = StringGenerator.generateWord(passwordLength);

        loginPage.typeLogin(login);
        softAssert.assertEquals(loginPage.getLoginFieldText(), login, "Login field text is not as expected!");
        loginPage.typePassword(password);
        softAssert.assertEquals(loginPage.getPasswordFieldText(), password, "Password field text is not as expected!");
        loginPage.clickConfirmButton();
        softAssert.assertEquals(loginPage.getErrorLabelText(), "Введены неверные данные", "Error label text is not as expected!");

        softAssert.assertAll();
    }

    @Test
    @Description(value = "Check that user is authenticated after entering the valid credentials")
    @Owner(value = "Julia Ovchinnikova")
    public void testSuccessfulLogin() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");
        String validLogin = "Login";
        String validPassword = "Password";

        loginPage.typeLogin(validLogin);
        softAssert.assertEquals(loginPage.getLoginFieldText(), validLogin, "Login field text is not as expected!");
        loginPage.typePassword(validPassword);
        softAssert.assertEquals(loginPage.getPasswordFieldText(), validPassword, "Password field text is not as expected!");
        loginPage.clickConfirmButton();

        LoginSuccessPageBase loginSuccessPageBase = initPage(getDriver(), LoginSuccessPageBase.class);
        Assert.assertTrue(loginSuccessPageBase.isPageOpened(3), "Login success page is not opened!");

        softAssert.assertAll();
    }

    @Test
    @Description(value = "Check that password is hidden after clicking show password icon odd number of times/ shown after clinking even number of times")
    @Owner(value = "Julia Ovchinnikova")
    public void testHideAndShowPassword() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");

        SecureRandom random = new SecureRandom();
        int passwordLength = random.nextInt(51);
        String password = StringGenerator.generateWord(passwordLength);
        loginPage.typePassword(password);
        softAssert.assertFalse(loginPage.isShowPasswordIconChecked(), "Show password icon is unexpectedly checked after entering password!");
        softAssert.assertTrue(loginPage.isPasswordEncrypted(), "Password is not hidden after entering!");
        loginPage.clickShowPasswordIcon();
        softAssert.assertTrue(loginPage.isShowPasswordIconChecked(), "Show password icon is not checked after clicking first time!");
        softAssert.assertFalse(loginPage.isPasswordEncrypted(), "Password is unexpectedly hidden after clicking show password icon first time!");
        softAssert.assertEquals(loginPage.getPasswordFieldText(), password, "Password field text is not as expected!");

        loginPage.clickShowPasswordIcon();
        softAssert.assertFalse(loginPage.isShowPasswordIconChecked(), "Show password icon is unexpectedly checked after clicking second time!");
        softAssert.assertTrue(loginPage.isPasswordEncrypted(), "Password is not hidden after clicking show password icon second time!");

        softAssert.assertAll();
    }

}
