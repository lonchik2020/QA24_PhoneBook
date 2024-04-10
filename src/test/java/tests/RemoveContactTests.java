package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .withEmail("krasleo@gmail.com")
                    .withPassword("Cristiano7777$!"));
        }
       app.getHelperContact().provideContacts();
    }

    @Test
    public void removeFirstContact(){
        //Assert size of list less by one
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);
    }


    @Test
    public void removeAllContacts(){
        //"No contacts here"
        app.getHelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperContact().getMessage(), "No Contacts here!" );

    }

}
