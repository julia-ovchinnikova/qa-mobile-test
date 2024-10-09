package com.alfa.login.android;

import com.alfa.login.common.LoginPageBase;
import com.alfa.utils.StringByRegexGenerator;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.StringGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.SecureRandom;

public class LoginWithInvalidValuesTest extends AbstractTest {

    private static final String ERROR_MESSAGE = "Введены неверные данные";

    // fails due to a bug
    @Test
    @Description(value = "Check that after entering password 50+ length all invalid/extra characters are omitted, the message 'ExceptValue' is shown")
    @Owner(value = "Julia Ovchinnikova")
    @Issue(value = "PAS-123")
    public void tesEnterPasswordWithInvalidLength() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");

        SecureRandom random = new SecureRandom();
        int loginLength = random.nextInt(51);
        String regex = "[a-zA-Z., \\/_'-]+";
//        String regex = "[a-zA-Z., \\[\\]\\/_'-]+";
        String login = StringByRegexGenerator.getRandomString(regex, loginLength);
        int passwordLength = 50 + random.nextInt(30);
        String password = StringGenerator.generateWord(passwordLength);
        loginPage.typeLogin(login);
        softAssert.assertEquals(loginPage.getLoginFieldText(), login, "Login field text is not as expected!");
        loginPage.typePassword(password);
        String expectedPassword = password.substring(0, 50);
        softAssert.assertEquals(loginPage.getPasswordFieldText(), expectedPassword, "Password field text is not as expected!");
        loginPage.clickConfirmButton();
        softAssert.assertEquals(loginPage.getErrorLabelText(), ERROR_MESSAGE, "Error label text is not as expected!");

        softAssert.assertAll();
    }

    // fails due to a bug
    @Test
    @Description(value = "Check that after entering login with invalid characters all invalid characters are omitted, the message 'ExceptValue' is shown")
    @Owner(value = "Julia Ovchinnikova")
    @Issue(value = "LOG-123")
    public void testEnterInvalidLogin() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");

        SecureRandom random = new SecureRandom();
        int loginLength = random.nextInt(45);
        String regex = "[a-zA-Z., \\/_'-]+";
//        String regex = "[a-zA-Z., \\[\\]\\/_'-]+";
        String validLogin = StringByRegexGenerator.getRandomString(regex, loginLength);
        String login = validLogin.concat("34^%$(");
        int passwordLength = random.nextInt(51);
        String password = StringGenerator.generateWord(passwordLength);

        loginPage.typeLogin(login);
        softAssert.assertEquals(loginPage.getLoginFieldText(), validLogin, "Login field text is not as expected!");
        loginPage.typePassword(password);
        loginPage.clickConfirmButton();
        softAssert.assertEquals(loginPage.getErrorLabelText(), ERROR_MESSAGE, "Error label text is not as expected!");

        softAssert.assertAll();
    }

    //fails due to a bug
    @Test
    @Description(value = "Check that after entering login with valid characters 50+ length all invalid/extra characters are omitted, the message 'ExceptValue' is shown")
    @Owner(value = "Julia Ovchinnikova")
    @Issue(value = "LOG-234")
    public void testEnterLoginWithInvalidLength() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(3), "Login page is not opened!");

        SecureRandom random = new SecureRandom();
        int loginLength = 50 + random.nextInt(30);
        String regex = "[a-zA-Z., \\/_'-]+";
//        String regex = "[a-zA-Z., \\[\\]\\/_'-]+";
        String login = StringByRegexGenerator.getRandomString(regex, loginLength);
        int passwordLength = random.nextInt(51);
        String password = StringGenerator.generateWord(passwordLength);

        loginPage.typeLogin(login);
        String expectedLogin = login.substring(0, 50);
        softAssert.assertEquals(loginPage.getLoginFieldText(), expectedLogin, "Login field text is not as expected!");
        loginPage.typePassword(password);
        softAssert.assertEquals(loginPage.getPasswordFieldText(), password, "Password field text is not as expected!");
        loginPage.clickConfirmButton();
        softAssert.assertEquals(loginPage.getErrorLabelText(), ERROR_MESSAGE, "Error label text is not as expected!");

        softAssert.assertAll();
    }

}
