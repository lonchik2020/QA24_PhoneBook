package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);
//        System.out.println(System.currentTimeMillis());
//        int y = (int)(System.currentTimeMillis()/1000)%3600;
//        System.out.println(y);

        User user = new User()
                .withEmail("daniDin"+i+"@gmail.com")
                .withPassword("Dani123456$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isRegistered());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }

    @Test(description = "Bug report #12345 Fixed")
    public void registrationWrongEmail(){
        User user = new User()
                .withEmail("daniDinmail.com")
                .withPassword("Dani123456$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void registrationWrongPassword(){
        User user = new User()
                .withEmail("daniDin@mail.com")
                .withPassword("Dani123456");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void registrationExistsUser(){
        User user = new User()
                .withEmail("krasleo@gmail.com")
                .withPassword("Cristiano7777$!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }

}
