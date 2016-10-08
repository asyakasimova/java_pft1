package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
      click(By.linkText("home"));
  }

  public void subminContact() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {


    type(By.name("firstname"), contactData.getContactName());
    type(By.name("lastname"), contactData.getContactSecondName());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address"), contactData.getContactAddress());
    type(By.name("home"), contactData.getContactHomePhone());
    type(By.name("email"), contactData.getContactEmail());
  }

  public void gotoCreateContactPage() {
    click(By.linkText("add new"));
  }

  public void acceptDeletionContacts() {
    alertAccept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContacts(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification(int index) {

    click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 2) +"]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact, boolean b) {
    gotoCreateContactPage();
    fillContactForm(contact, true);
    subminContact();
    returnToHomePage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("./td[1]")).findElement(By.tagName("input")).getAttribute("value"));
      String username = element.findElement(By.xpath("./td[3]")).getText();
      String familyName = element.findElement(By.xpath("./td[2]")).getText();
      ContactData contact = new ContactData(id, username, familyName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
