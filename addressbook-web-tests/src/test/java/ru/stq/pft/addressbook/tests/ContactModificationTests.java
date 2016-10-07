package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactsPage();
    if (! app.getContactHelper().isThereAGroup()) {
      app.getContactHelper().createContact(new ContactData("Asya", "Kasimova", "test1", null, "+7 945 111 11 11", "asya.kasimova@a.com"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Asya2", "Kasimova", null, "Тестовый адрес", "+7 945 111 11 11", "asya.kasimova@a.com"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
