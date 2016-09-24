package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {

        app.getNavigationHelper().gotoCreateContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Asya", "Kasimova", "Тестовый адрес", "+7 945 111 11 11", "asya.kasimova@a.com"));
        app.getContactHelper().subminContact();
        app.getContactHelper().returnToHomePage();
    }

}
