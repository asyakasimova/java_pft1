package ru.stq.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {

        gotoCreateContactPage();
        fillContactForm(new ContactData("Asya", "Kasimova", "Тестовый адрес", "+7 945 111 11 11", "asya.kasimova@a.com"));
        subminContact();
        returnToHomePage();
    }

}
