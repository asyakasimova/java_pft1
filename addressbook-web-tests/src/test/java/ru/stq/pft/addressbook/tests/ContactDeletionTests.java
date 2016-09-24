package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {


      app.getContactHelper().selectContacts();
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().acceptDeletionContacts();
      app.getContactHelper().returnToHomePage();
    }

}
