package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = true)
  public void testContactModification() {
    app.goTo().gotoContactsPage();
    if (! app.getContactHelper().isThereAGroup()) {
      app.getContactHelper().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withContactName("Asya2").withContactSecondName("Kasimova3").
            withContactAddress("Тестовый адрес").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
