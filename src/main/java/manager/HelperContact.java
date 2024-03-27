package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void clickAddButton() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm() {
        //type(By.xpath("//input[@placeholder='Name']"),);
    }
}
