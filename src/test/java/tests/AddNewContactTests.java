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
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("")
                .lastName("Ronaldo")
                .phone("5555555" + y)
                .email("cristiano"+y+"@gmail.com")
                .address("Portugal,Lisbon")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertFalse(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertFalse(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }


    @Test
    public void addNewContactWrongAddress(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano" + y)
                .lastName("Ronaldo")
                .phone("5555555" + y)
                .email("cristiano"+y+"@gmail.com")
                .address("")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
    }

    @Test
    public void addNewContactWrongLastName(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano" + y)
                .lastName("")
                .phone("5555555" + y)
                .email("cristiano"+y+"@gmail.com")
                .address("Portugal,Lisbon")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
    }

    @Test
    public void addNewContactWrongPhone(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano" + y)
                .lastName("Ronaldo")
                .phone("")
                .email("cristiano"+y+"@gmail.com")
                .address("Portugal,Lisbon")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

    }

    @Test
    public void addNewContactWrongEmail(){
        int y = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Cristiano" + y)
                .lastName("Ronaldo")
                .phone("5555555" + y)
                .email("")
                .address("Portugal,Lisbon")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

    }

}
