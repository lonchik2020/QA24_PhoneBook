package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
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
    public void addNewContactSuccessAllFields(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano")
                .lastName("Ronaldo")
                .phone("5555555" + y)
                .email("cristiano"+ y +"@gmail.com")
                .address("Portugal,Lisbon")
                .description("football player")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessRequiredFields(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano" + y)
                .lastName("Ronaldo")
                .phone("5555555" + y)
                .email("cristiano"+y+"@gmail.com")
                .address("Portugal,Lisbon")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactWrongName(){

    }


    @Test
    public void addNewContactWrongAddress(){

    }

    @Test
    public void addNewContactWrongLastName(){

    }

    @Test
    public void addNewContactWrongPhone(){

    }

    @Test
    public void addNewContactWrongEmail(){

    }

}
