package ru.stq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.goTo().gotoContactsPage();
    Contacts before = app.contact().getContactAll();
    ContactData contact = new ContactData().withContactName("Asya").
            withContactSecondName("Testik").withGroup("test1").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com");
    app.contact().createContact(contact, true);
    Contacts after = app.contact().getContactAll();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
