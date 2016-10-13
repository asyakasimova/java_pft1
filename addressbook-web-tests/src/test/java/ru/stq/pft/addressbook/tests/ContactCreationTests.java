package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.goTo().gotoContactsPage();
    Set<ContactData> before = app.getContactHelper().getContactAll();
    ContactData contact = new ContactData().withContactName("Asya").
            withContactSecondName("Testik").withGroup("test1").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com");
    app.getContactHelper().createContact(contact, true);
    Set<ContactData> after = app.getContactHelper().getContactAll();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
