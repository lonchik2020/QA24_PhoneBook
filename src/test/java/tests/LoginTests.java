package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if signOut presents ----> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess1(){
        User user = new User().withEmail("krasleo@gmail.com").withPassword("Cristiano7777$!");

//        user.setEmail("krasleo@gmail.com");
//        user.setPassword("Cristiano7777$!");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void loginSuccess(){
        logger.info("Start test with name 'loginSuccess' ");
        logger.info("Test data--->email:krasleo@gmail.com , password:Cristiano7777$! ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("krasleo@gmail.com", "Cristiano7777$!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check that button 'Sign out' present");

    }

    @Test
    public void loginSuccessModel(){
        logger.info("Test data--->email:krasleo@gmail.com , password:Cristiano7777$! ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("krasleo@gmail.com", "Cristiano7777$!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check that button 'Sign out' present");

    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data--->email:krasleogmail.com , password:Cristiano7777$! ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("krasleogmail.com", "Cristiano7777$!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check that alert 'Wrong email or password' present");
    }


    @Test
    public void loginWrongPassword(){
        logger.info("Test data--->email:krasleo@gmail.com , password:Cristiano777$! ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("krasleo@gmail.com", "Cristiano777$!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check that alert 'Wrong email or password' present");

    }


    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data--->email:kraslleo@gmail.com , password:Cristiano777$! ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("kraslleo@gmail.com", "Cristiano777$!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check that alert 'Wrong email or password' present");

    }

}
