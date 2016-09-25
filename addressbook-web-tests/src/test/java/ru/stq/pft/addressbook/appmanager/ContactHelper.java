package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stq.pft.addressbook.model.ContactData;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
      click(By.linkText("home"));
  }

  public void subminContact() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getContactName());
    type(By.name("lastname"), contactData.getContactSecondName());
    type(By.name("address"), contactData.getContactAddress());
    type(By.name("home"), contactData.getContactHomePhone());
    type(By.name("email"), contactData.getContactEmail());
  }

  public void acceptDeletionContacts() {
    alertAccept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContacts() {
    click(By.name("selected[]"));
  }
}
