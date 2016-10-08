package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.getNavigationHelper().gotoContactsPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Asya", "Test", "test1", null, "+7 945 111 11 11", "asya.kasimova@a.com");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (ContactData c: after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }

    before.add(contact);
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
