package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.goTo().gotoContactsPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/checkbox.png");
    ContactData contact = new ContactData().withContactName("Asya").
            withContactSecondName("Testik").withGroup("test1").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11")
            .withContactEmail("asya.kasimova@a.com").withPhoto(photo);
    app.contact().createContact(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

/*  @Test
  public void TestCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/checkbox.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  } */


}
