package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = true)
  public void testContactModification() {
    app.goTo().gotoContactsPage();
    if (! app.contact().isThereAGroup()) {
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
    Set<ContactData> before = app.contact().getContactAll();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withContactName("Asya2").withContactSecondName("Kasimova3").
            withContactAddress("Тестовый адрес").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().getContactAll();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
