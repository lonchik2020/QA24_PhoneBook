package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
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

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password){
        logger.info("Start test with name 'loginSuccess' ");
        logger.info("Test data--->email: " +email+ " & password: " +password);
        app.getHelperUser().openLoginRegistrationForm();
        //app.getHelperUser().fillLoginRegistrationForm("krasleo@gmail.com", "Cristiano7777$!");
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check that button 'Sign out' present");
    }



    @Test(dataProvider = "loginModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user){
        logger.info("Test data--->" + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check that button 'Sign out' present");

    }

    @Test(dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user){
        logger.info("Test data--->" + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check that button 'Sign out' present");

    }

    @Test(groups = {"smoke"})
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
