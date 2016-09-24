package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stq.pft.addressbook.model.ContactData;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactHelper {

  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
      wd.findElement(By.linkText("home")).click();
  }

  public void subminContact() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getContactName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getContactSecondName());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getContactAddress());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contactData.getContactHomePhone());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getContactEmail());
  }

  public void acceptDeletionContacts() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectContacts() {
    wd.findElement(By.name("selected[]")).click();
  }
}
