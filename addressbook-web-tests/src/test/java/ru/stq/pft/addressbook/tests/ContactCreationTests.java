package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.goTo().gotoContactsPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData().withContactName("Asya").
            withContactSecondName("Testik").withGroup("test1").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com");
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
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
