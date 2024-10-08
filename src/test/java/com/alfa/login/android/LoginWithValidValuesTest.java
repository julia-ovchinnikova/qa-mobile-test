package com.alfa.login.android;

import com.alfa.login.common.LoginPageBase;
import com.alfa.login.common.LoginSuccessPageBase;
import com.alfa.utils.StringByRegexGenerator;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.StringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.SecureRandom;

public class LoginWithValidValuesTest extends AbstractTest {

    @Test
    public void testEnterAllowedValuesForLoginAndPassword() {
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
    public void testSuccessfulLogin() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");
        softAssert.assertEquals(loginPage.getLoginPageTitleText(), "Вход в Alfa-Test", "Login page title text is not as expected!");

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
