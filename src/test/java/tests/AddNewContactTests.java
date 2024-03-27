package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .withEmail("krasleo@gmail.com")
                    .withPassword("Cristiano7777$!"));
        }
    }

    @Test
    public void addNewContactSuccess(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano")
                .lastName("Ronaldo")
                .phone("5555555")
                .email("cristiano"+y+"@gmail.com")
                .address("Portugal,Lisbon")
                .description("football player")
                .build();


        app.getHelperContact().clickAddButton();
        app.getHelperContact().fillContactForm();
        //app.getHelperContact().clickSaveButton();

    }

}
