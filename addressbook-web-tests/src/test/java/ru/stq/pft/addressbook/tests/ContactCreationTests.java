package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.getNavigationHelper().gotoContactsPage();
    app.getNavigationHelper().gotoCreateContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Asya", "Kasimova", "test1", "Тестовый адрес", "+7 945 111 11 11", "asya.kasimova@a.com"), true);
    app.getContactHelper().subminContact();
    app.getContactHelper().returnToHomePage();
  }

}
