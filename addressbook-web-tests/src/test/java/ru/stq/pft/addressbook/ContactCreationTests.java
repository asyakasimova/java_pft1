package ru.stq.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {

        app.gotoCreateContactPage();
        app.fillContactForm(new ContactData("Asya", "Kasimova", "Тестовый адрес", "+7 945 111 11 11", "asya.kasimova@a.com"));
        app.subminContact();
        app.returnToHomePage();
    }

}
