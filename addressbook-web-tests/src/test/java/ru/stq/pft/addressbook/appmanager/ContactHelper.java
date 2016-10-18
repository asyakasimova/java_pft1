package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    acceptDeletionContacts();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  }

  public void initContactModification(int index) {

    click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 2) +"]/td[8]/a/img"));
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact, boolean b) {
    gotoCreateContactPage();
    fillContactForm(contact, true);
    subminContact();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("./td[1]")).findElement(By.tagName("input")).getAttribute("value"));
      String username = element.findElement(By.xpath("./td[3]")).getText();
      String familyName = element.findElement(By.xpath("./td[2]")).getText();
            contacts.add(new ContactData().withId(id).withContactName(username).withContactSecondName(familyName));
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("./td[1]")).findElement(By.tagName("input")).getAttribute("value"));
      String username = element.findElement(By.xpath("./td[3]")).getText();
      String familyName = element.findElement(By.xpath("./td[2]")).getText();
      String[] phones = element.findElement(By.xpath("./td[6]")).getText().split("\n");
      contactCache.add(new ContactData().withId(id).withContactName(username).withContactSecondName(familyName).withContactHomePhone(phones[0])
              .withContactMobilePhone(phones[1]).withContactWorkPhone(phones[2]));
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withContactName(firstname).withContactSecondName(lastname).withContactHomePhone(home)
            .withContactMobilePhone(mobile).withContactWorkPhone(work);
  }
}
